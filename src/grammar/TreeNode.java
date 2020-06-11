package grammar;



import grammar.NonTerminals.NodeKind;
import grammar.NonTerminals.Var;
/**
 * 
 * @author yqh
 *
 */
public class TreeNode {
	private TreeNode[] child = new TreeNode[3];
	private TreeNode sibling;
	private int lineno;
	private NodeKind kind;
	private int idnum;
	private String[] name;
	private int[] table;
	private String type_name;
	private ArrayAttr arrayAttr;
	private ProcAttr procAttr;
	private ExpAttr expAttr;
	
	public TreeNode[] getChild() {
		return child;
	}
	public void setChild(TreeNode[] child) {
		this.child = child;
	}
	public TreeNode getSibling() {
		return sibling;
	}
	public void setSibling(TreeNode sibling) {
		this.sibling = sibling;
	}
	public int getLineno() {
		return lineno;
	}
	public void setLineno(int lineno) {
		this.lineno = lineno;
	}
	public NodeKind getKind() {
		return kind;
	}
	public void setKind(NodeKind kind) {
		this.kind = kind;
	}
	public int getIdnum() {
		return idnum;
	}
	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public int[] getTable() {
		return table;
	}
	public void setTable(int[] table) {
		this.table = table;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public ArrayAttr getArrayAttr() {
		return arrayAttr;
	}
	public void setArrayAttr(ArrayAttr arrayAttr) {
		this.arrayAttr = arrayAttr;
	}
	public ProcAttr getProcAttr() {
		return procAttr;
	}
	public void setProcAttr(ProcAttr procAttr) {
		this.procAttr = procAttr;
	}
	public ExpAttr getExpAttr() {
		return expAttr;
	}
	public void setExpAttr(ExpAttr expAttr) {
		this.expAttr = expAttr;
	}
	
}

class ArrayAttr {
	private int low;
	private int up;
	private Class childTypeClass;
	
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public Class getChildTypeClass() {
		return childTypeClass;
	}
	public void setChildTypeClass(Class childTypeClass) {
		this.childTypeClass = childTypeClass;
	}
}

class ProcAttr {
	private int paramt;

	public int getParamt() {
		return paramt;
	}

	public void setParamt(int paramt) {
		this.paramt = paramt;
	}
	
}

class ExpAttr {
	private int op;
	private int val;
	private Var varkind;
	private Class type;
	
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Var getVarkind() {
		return varkind;
	}
	public void setVarkind(Var varkind) {
		this.varkind = varkind;
	}
	public Class getType() {
		return type;
	}
	public void setType(Class type) {
		this.type = type;
	}
}