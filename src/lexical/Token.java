package lexical;

public class Token {
	/**
	 * 行数
	 */
	private int lineshow;
	/**
	 * 词法信息
	 */
	private int lextype;
	/**
	 * 语义信息
	 */
	private String sem;
	
	public Token() {
	}
	/**
	 * 
	 * @param lineshow 行数
	 * @param lextype 词法信息
	 * @param sem 语义信息
	 */
	public Token(int lineshow,int lextype,String sem) {
		this.lineshow=lineshow;
		this.lextype=lextype;
		this.sem=sem;
	}
	public int getLineshow() {
		return lineshow;
	}

	public void setLineshow(int lineshow) {
		this.lineshow = lineshow;
	}

	public int getLextype() {
		return lextype;
	}

	public void setLextype(int lextype) {
		this.lextype = lextype;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public static void main(String[] args) {
		
	}
}