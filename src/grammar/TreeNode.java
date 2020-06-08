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
}

class ArrayAttr {
	private int low;
	private int up;
	private Class childTypeClass;
}

class ProcAttr {
	private int op;
	private int val;
	private Var varkind;
	private Class type;
}

class ExpAttr {
	
}