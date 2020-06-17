package grammar;



import java.util.ArrayList;
import java.util.List;

import grammar.NonTerminals.NodeKind;
import grammar.NonTerminals.Var;
/**
 * 
 * @author yqh
 *
 */
public class TreeNode {
	/**
	 * 子语法树节点
	 */
	private TreeNode[] child;
	/**
	 * 兄弟语法树节点
	 */
	private TreeNode sibling;
	/**
	 * 记录源程序行号
	 */
	private int lineno;
	/**
	 * 记录语法树节点类型，取值 ProK, PheadK, TypeK, VarK, ProcDecK, StmLK, DecK, StmtK, ExpK
	 */
	private NodeKind nodekind;
	/**
	 * 记录语法树节点的具体类型
	 */
	private NodeKind kind;
	/**
	 * 记录一个节点中的标志符的个数
	 */
	private int idnum;
	/**
	 * 字符串数组，数组成员是节点中的标志符的名字
	 */
	private List<String> name = new ArrayList<String>();
	/**
	 * 数组成员是节点中的各个标志符在符号表中的入口
	 */
	private int[] table;
	/**
	 * 记录类型名，当节点为声明类型，且类型是由类型标志符表示时有效
	 */
	private String type_name;
	/**
	 * 记录数组类型的属性
	 */
	private ArrayAttr arrayAttr;
	/**
	 * 记录过程的属性
	 */
	private ProcAttr procAttr;
	/**
	 * 记录表达式的属性
	 */
	private ExpAttr expAttr;
	
	public TreeNode() {
		
	}
	public TreeNode(NodeKind n) {
		this.nodekind=n;
	}
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
	public NodeKind getNodekind() {
		return nodekind;
	}
	public void setNodekind(NodeKind nodekind) {
		this.nodekind = nodekind;
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
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
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
	/**
	 * 此节点标识符个数＋1
	 */
	public void idnumcount() {
		idnum++;
	}
}

class ArrayAttr {
	private int low;
	private int up;
	private NodeKind childTypeClass;
	
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
	public NodeKind getChildTypeClass() {
		return childTypeClass;
	}
	public void setChildTypeClass(NodeKind childTypeClass) {
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