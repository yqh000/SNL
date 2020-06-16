package grammar;

import grammar.NonTerminals.NodeKind;
import lexical.SNLConstants;
import lexical.Token;

public class Process {
	private int [][]LL1Table;
	private UtilLL1 ul = new UtilLL1();
	private TreeNode prok = new TreeNode();
	private TreeNode currentP = new TreeNode();
	private Token token;
	//未完成
	public void process21() {
		ul.push(0,SNLConstants.INTC);
		
	}
	//是否需要先把nodekind=StmtK，kind才能赋值RecordK？,是否需要加上saveP属性？
	public void process22() {
		ul.push(0,SNLConstants.END1);
		ul.push(1,NonTerminals.FieldDecList);
		ul.push(0,SNLConstants.RECORD);
		TreeNode saveP=new TreeNode(NodeKind.StmtK);
		saveP.setKind(NodeKind.RecordK);
		saveP.setChild(new TreeNode[1]);
		saveP.getChild()[0]=new TreeNode();
		ul.pushPa(saveP.getChild()[0]);		
	}	
	//未完成,temp保存地址？
	public void process23() {
		ul.push(1,NonTerminals.FieldDecMore);
		ul.push(0,SNLConstants.SEMI);
		ul.push(1,NonTerminals.IdList);
		ul.push(1,NonTerminals.BaseType);
		currentP=ul.popPa();
		//temp
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());			
	}
	//需不需要t.setkind?
	public void process24() {
		ul.push(1,NonTerminals.FieldDecMore);
		ul.push(0,SNLConstants.SEMI);
		ul.push(1,NonTerminals.IdList);
		ul.push(1,NonTerminals.ArrayType);
		currentP=ul.popPa();
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());		
	}
	//有疑问,回复节点？
	public void process25() {
		currentP=ul.popPa();		
	}
	public void process26() {
		ul.push(1,NonTerminals.FieldDecList);		
	}
	//有疑问，是否和process3一样？
	public void process27() {
		ul.push(1,NonTerminals.IdMore);
		ul.push(0,SNLConstants.ID);
		TreeNode p  = prok.getChild()[0];
		p.idnumcount();
		p.getName().add(token.getSem());
	}
	public void process28() {
		
	}
	public void process29() {
		ul.push(1,NonTerminals.IdList);
		ul.push(0,SNLConstants.COMMA);		
	}
	public void process30() {
		
	}
	public void process31() {
		ul.push(1,NonTerminals.VarDec);		
	}
	//是否和process7一样？
	public void process32() {
		ul.push(1,NonTerminals.VarDecList);
		ul.push(0,SNLConstants.VAR);	
		currentP=ul.popPa();
		currentP.setKind(NodeKind.VarK);
		currentP.setChild(new TreeNode[1]);
		currentP.getChild()[0]=new TreeNode();
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());
		ul.pushPa(currentP.getChild()[0]);		
	}
	//需不需要t.setkind?
	public void process33() {
		ul.push(1,NonTerminals.VarDecMore);
		ul.push(0,SNLConstants.SEMI);
		ul.push(1,NonTerminals.VarIdList);
		ul.push(1,NonTerminals.TypeDef);
		currentP=ul.popPa();
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());
	}
	//未完成，弹出栈中指向下一个变量声明的指针?
	public void process34() {
		ul.popPa();
		
	}	
	public void process35() {
		ul.push(1,NonTerminals.VarDecList);		
	}
	//是否和process27，process3一样？
	public void process36() {
		ul.push(1,NonTerminals.VarIdMore);
		ul.push(0,SNLConstants.ID);
		TreeNode p  = prok.getChild()[0];
		p.idnumcount();
		p.getName().add(token.getSem());
	}
	public void process37() {
	
	}
	public void process38() {
		ul.push(1,NonTerminals.VarIdList);
		ul.push(0,SNLConstants.COMMA);		
	}
	public void process39() {
	
	}
	public void process40() {
		ul.push(1,NonTerminals.ProcDeclaration);
		
	}
	
}

