package grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import lexical.Token;

public class UtilLL1 {
	/**
	 * 符号栈
	 */
	private Stack<Symbols> symbols = new Stack<Symbols>();
	/**
	 * 语法树栈
	 */
	private Stack<TreeNode> pa = new Stack<TreeNode>();
	/**
	 * 操作符栈
	 */
	private Stack<TreeNode> op = new Stack<TreeNode>();
	/**
	 * 操作数栈
	 */
	private Stack<TreeNode> num = new Stack<TreeNode>();
	/**
	 * 文件地址
	 */
	private String data = new String();
	private BufferedReader br = null;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
		File f = new File(data);
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br=new BufferedReader(fr);
	}
	
	public Stack<Symbols> getSymbols() {
		return symbols;
	}
	public void setSymbols(Stack<Symbols> symbols) {
		this.symbols = symbols;
	}
	/**
	 * 符号栈压栈
	 * @param i 标志是终极符还是非终极符,0代表终极符，1代表非终极符
	 * @param item 当前终极符或者非终极符
	 */
	public void push(int i,int item) {
		symbols.push(new Symbols(i,item));
	}
	/**
	 * 符号栈弹栈
	 * @return 栈顶端符号
	 */
	public Symbols pop() {
		return symbols.pop();
	}
	/**
	 * 语法树栈压栈
	 * @param node 语法树节点
	 */
	public void pushPa(TreeNode node) {
		pa.push(node);
	}
	/**
	 * 语法树栈弹栈
	 * @return 栈顶语法树节点
	 */
	public TreeNode popPa() {
		return pa.pop();
	}
	/**
	 * 读符号栈栈顶标志
	 * @return 符号栈栈顶标志
	 */
	public int readStackflag() {
		return symbols.peek().getType();
	}
	/**
	 * 读符号栈栈顶符号
	 * @return 符号栈栈顶符号
	 */
	public int readStackitem() {
		return symbols.peek().getItem();
	}
	/**
	 * 操作符栈压栈
	 * @param item 操作符
	 */
	public void pushOp(TreeNode item) {
		op.push(item);
	}
	/**
	 * 操作符栈弹栈
	 * @return 栈顶操作符
	 */
	public TreeNode popOp() {
		return op.pop();
	}
	/**
	 * 
	 * @return
	 */
	public TreeNode readOpStack() {
		return op.peek();
	}
	/**
	 * 操作数栈压栈
	 * @param item 操作数
	 */
	public void pushNum(TreeNode item) {
		num.push(item);
	}
	/**
	 * 操作数栈弹栈
	 * @return 栈顶操作数
	 */
	public TreeNode popNum() {
		return num.pop();
	}
	/**
	 * 从文件中读出下一个 token
	 * @return 下一个 token，若到达文件末尾返回null
	 */
	public Token readNextToken() {
		String t = null;
		try {
			t=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (t==null) {
			return null;
		}else {
			String[] list=t.split(",");
			if (list.length==2) {
				return new Token(Integer.parseInt(list[0]), Integer.parseInt(list[1]), null);
			}else if (list.length==3) {
				return new Token(Integer.parseInt(list[0]), Integer.parseInt(list[1]), list[2]);
			}
			return null;
		}
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
}
