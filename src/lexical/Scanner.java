package lexical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lexical.SNLConstants.State;
/**
 * 源程序字符遍历
 * @author yqh
 *
 */
public class Scanner {	
	/**
	 * BufferedReader的缓存空间
	 */
	public static final int BUFLEN = 256;
	private BufferedReader br = null;
	/**
	 * 记录当前读取的字符个数
	 */
	private int count = 0;	
	/**
	 * 记录当前行数
	 */
	private int rowcount = 1;	
	/**
	 * 当前单词中未处理的字符
	 */
	private String tokenString;
	/**
	 * Token列表
	 */
	private List<Token> tl = new ArrayList<Token>();	
	/**
	 * 构造函数
	 * @param data 读取文件路径名
	 */
	public Scanner(String data) {
		File f = new File(data);
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br=new BufferedReader(fr,BUFLEN);
		try {
			br.mark((int) f.length());	//在开头位置标记，用于回退时从此处skip
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public List<Token> getTl() {
		return tl;
	}
	public void setTl(List<Token> tl) {
		this.tl = tl;
	}
	/**
	 * 流中获取下一个字符
	 * @return	获得的字符ASCLL码，遇到文件末尾，没有字符返回时返回-1
	 * @throws IOException
	 */
	public int getNextChar() throws IOException {
		count++;
		int c = br.read();
		if (c=='\n') {	//Windows中\r\n表示回车+换行,读取到\n光标所在行数会+1
			rowcount++;
		}
		return c;
	}
	/**
	 * 让读取光标退回一个字符，在文件末尾使用ungetNextChar()会IOException
	 * @throws IOException
	 */
	public void ungetNextChar() throws IOException {
		br.reset();
		count--;
		br.skip(count);
		if (br.read()=='\n') 	//Windows中\r\n表示回车+换行,读取到\n说明此次回退到了上一行，行数-1
			rowcount--;
		br.reset();				//判断完是否跨行返回后恢复到需要返回的位置
		br.skip(count);

	}
	/**
	 * 关闭流
	 */
	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查找保留字
	 * @param s 要检查的标识符
	 * @return 保留字对应的常数，若不是保留字则返回null
	 */
	public Integer reservedLookup(String s) {
		return SNLConstants.reservedmap.get(s);
	}
	/**
	 * 取得单词列表
	 * @throws IOException 
	 */
	public void getTokenlist() throws IOException {
		State state = State.START;
		int ch=-1;
		
		while (true) {
			switch(state) {
			case START:
				ch = getNextChar();
				tokenString = new String();		//识别新单词，保存新的字符串
				while (ch=='\r'||ch=='\n'||ch==' ') 
					ch = getNextChar();
				if (ch==-1||ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||ch==';'
						||ch=='['||ch==']'||ch=='='||ch=='<'||ch==',') {
					state=State.DONE;
				}
				else if (ch>='a'&&ch<='z') {
					state=State.INID;
				}
				else if (ch>='0'&&ch<='9') {
					state=State.INNUM;
				}
				else if (ch=='\'') {
					state=State.INCHAR;
				}
				else if (ch=='{') {
					state=State.INCOMMENT;
				}
				else if (ch==':') {
					state=State.INASSIGN;
				}
				else if (ch=='.') {
					state=State.INRANGE;
				}else {
					state=State.ERROR;
				}
				break;
			case INASSIGN:
				ch = getNextChar();
				if (ch!='=') {
					ungetNextChar();
					tl.add(new Token(rowcount,SNLConstants.COLON,null));
				}else {
					tl.add(new Token(rowcount,SNLConstants.ASSIGN,null));
				}
				state=State.START;
				break;
			case INCOMMENT:
				while ((ch=getNextChar())!=-1&&ch!='}')
					;
				state=State.START;
				break;
			case INNUM:
				tokenString=tokenString+String.valueOf((char)ch);
				while ((ch=getNextChar())>='0'&&ch<='9') {
					tokenString=tokenString+String.valueOf((char)ch);
				}
				ungetNextChar();
				tl.add(new Token(rowcount,SNLConstants.INTC,tokenString));
				state=State.START;
				break;
			case INID:
				tokenString=tokenString+String.valueOf((char)ch);
				while (((ch=getNextChar())>='0'&&ch<='9')||(ch>='a'&&ch<='z')) {
					tokenString=tokenString+String.valueOf((char)ch);
				}
				ungetNextChar();
				Integer x = reservedLookup(tokenString);
				if(x==null)
					tl.add(new Token(rowcount,SNLConstants.ID,tokenString));
				else {
					tl.add(new Token(rowcount,x,null));
				}
				state=State.START;
				break;
			case INCHAR:
				ch = getNextChar();
				if ((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')) {
					tokenString=String.valueOf((char)ch);
					if((ch=getNextChar())=='\'') {
						tl.add(new Token(rowcount,SNLConstants.CHARC,tokenString));
						state=State.START;
					}
					else {
						ungetNextChar();
						state=State.ERROR;
					}
				}else {
					ungetNextChar();
					state=State.ERROR;
				}
				break;
			case INRANGE:
				ch = getNextChar();
				if (ch!='.') {
					if (ch!=-1)		//在文件末尾使用ungetNextChar()会IOException
						ungetNextChar();
					tl.add(new Token(rowcount,SNLConstants.DOT,null));
				}else {
					tl.add(new Token(rowcount,SNLConstants.UNDERANGE,null));
				}
				state=State.START;
				break;
			case DONE:
				switch(ch) {
				case '+':
					tl.add(new Token(rowcount,SNLConstants.PLUS,null));
					break;
				case '-':
					tl.add(new Token(rowcount,SNLConstants.MINUS,null));
					break;
				case '*':
					tl.add(new Token(rowcount,SNLConstants.TIMES,null));
					break;
				case '/':
					tl.add(new Token(rowcount,SNLConstants.OVER,null));
					break;
				case '(':
					tl.add(new Token(rowcount,SNLConstants.LPAREN,null));
					break;
				case ')':
					tl.add(new Token(rowcount,SNLConstants.RPAREN,null));
					break;
				case ';':
					tl.add(new Token(rowcount,SNLConstants.SEMI,null));
					break;
				case '[':
					tl.add(new Token(rowcount,SNLConstants.LMIDPAREN,null));
					break;
				case ']':
					tl.add(new Token(rowcount,SNLConstants.RMIDPAREN,null));
					break;
				case '=':
					tl.add(new Token(rowcount,SNLConstants.EQ,null));
					break;
				case '<':
					tl.add(new Token(rowcount,SNLConstants.LT,null));
					break;
				case ',':
					tl.add(new Token(rowcount,SNLConstants.COMMA,null));
					break;
				case -1:
					tl.add(new Token(rowcount,SNLConstants.ENDFILE,null));
					return;
				}
				state=State.START;
				break;
			case ERROR:
				tl.add(new Token(rowcount,SNLConstants.ERROR,null));
				state=State.START;
				break;
			}
		}		
	}
	
	//测试
	public static void main(String[] args) throws IOException {
		Scanner a = new Scanner("C:/Users/8/eclipse-workspace/SNL/src/input.txt");
		
		int c;
		a.getTokenlist();
		Util.printTokenlist(a.getTl());
		Util.ListToFile(a.getTl(), "C:/Users/8/eclipse-workspace/SNL/src/tokenlist.txt");
		
		a.close();
	}

}
