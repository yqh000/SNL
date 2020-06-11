package grammar;
/**
 * 符号类
 * @author yqh
 *
 */
public class Symbols {
	/**
	 * 是终极符还是非终极符，0代表终极符，1代表非终极符
	 */
	private int type;
	/**
	 * 该终极符或非终极符代表的编号
	 */
	private int item;
	
	public Symbols() {

	}
	public Symbols(int type,int item) {
		this.type=type;
		this.item=item;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	
}
