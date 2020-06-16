package grammar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import grammar.NonTerminals.NodeKind;
import lexical.SNLConstants;
import lexical.Token;
import lexical.Util;
import sun.print.resources.serviceui;

public class Zparse {
	/**
	 * LL1分析表
	 */
	private int [][]LL1Table;
	private UtilLL1 ul = new UtilLL1();
	private TreeNode prok = new TreeNode();
	private TreeNode currentP = new TreeNode();
	private Token token;
	/**
	 * 获取LL(1)分析表
	 * @returnLL(1)分析表
	 */
	public int[][] getLL1Table(){
	return this.LL1Table;
}
	/**
	 * 获取分析表中单个值
	 * @param i 行
	 * @param j 列
	 * @return 值
	 */
	public int getLL1(int i,int j) {
		return this.LL1Table[i][j];
	}
	/**
	 * 创建 LL1 分析表
	 */
	public void CreatLL1Tabble() {
		LL1Table=new int[69][42];
		//从1开始编号，一共104个产生式,Token种类42个
		//LL1Table[/非终极符][/Predict元素]={/编号};
		
		LL1Table[NonTerminals.Program][SNLConstants.PROGRAM]=1;
		
		LL1Table[NonTerminals.ProgramHead][SNLConstants.PROGRAM]=2;
		
		LL1Table[NonTerminals.ProgramName][SNLConstants.ID]=3;
		
		LL1Table[NonTerminals.DeclarePart][SNLConstants.TYPE]=4;	
		LL1Table[NonTerminals.DeclarePart][SNLConstants.PROCEDURE]=4;
		LL1Table[NonTerminals.DeclarePart][SNLConstants.VAR]=4;		
		LL1Table[NonTerminals.DeclarePart][SNLConstants.BEGIN1 ]=4;
		
		LL1Table[NonTerminals.TypeDecpart][SNLConstants.VAR]=5;	
		LL1Table[NonTerminals.TypeDecpart][SNLConstants.PROCEDURE]=5;
		LL1Table[NonTerminals.TypeDecpart][SNLConstants.BEGIN1 ]=5;
		
		LL1Table[NonTerminals.TypeDecpart][SNLConstants.TYPE]=6;
		
		LL1Table[NonTerminals.TypeDec][SNLConstants.TYPE]=7;
		
		LL1Table[NonTerminals.TypeDecList][SNLConstants.ID]=8;
		
		LL1Table[NonTerminals.TypeDecMore][SNLConstants.VAR]=9;
		LL1Table[NonTerminals.TypeDecMore][SNLConstants.PROCEDURE]=9;
		LL1Table[NonTerminals.TypeDecMore][SNLConstants.BEGIN1]=9;
		
		LL1Table[NonTerminals.TypeDecMore][SNLConstants.ID]=10;
		
		LL1Table[NonTerminals.TypeId][SNLConstants.ID]=11;
		
		LL1Table[NonTerminals.TypeDef][SNLConstants.INTEGER]=12;
		LL1Table[NonTerminals.TypeDef][SNLConstants.CHAR1]=12;
		
		LL1Table[NonTerminals.TypeDef][SNLConstants.ARRAY]=13;
		LL1Table[NonTerminals.TypeDef][SNLConstants.RECORD]=13;
		
		LL1Table[NonTerminals.TypeDef][SNLConstants.ID]=14;
		
		LL1Table[NonTerminals.BaseType][SNLConstants.INTEGER]=15;
		
		LL1Table[NonTerminals.BaseType][SNLConstants.CHAR1]=16;
		
		LL1Table[NonTerminals.StructureType][SNLConstants.ARRAY]=17;
		
		LL1Table[NonTerminals.StructureType][SNLConstants.RECORD]=18;
		
		LL1Table[NonTerminals.ArrayType][SNLConstants.ARRAY]=19;
		
		LL1Table[NonTerminals.Low][SNLConstants.INTC]=20;
		
		LL1Table[NonTerminals.Top][SNLConstants.INTC]=21;
		
		LL1Table[NonTerminals.RecType][SNLConstants.RECORD]=22;
		
		LL1Table[NonTerminals.FieldDecList][SNLConstants.INTEGER]=23;
		LL1Table[NonTerminals.FieldDecList][SNLConstants.CHAR1]=23;
		
		LL1Table[NonTerminals.FieldDecList][SNLConstants.ARRAY]=24;
		
		LL1Table[NonTerminals.FieldDecMore][SNLConstants.END1]=25;
		
		LL1Table[NonTerminals.FieldDecMore][SNLConstants.INTEGER]=26;
		LL1Table[NonTerminals.FieldDecMore][SNLConstants.CHAR1]=26;
		LL1Table[NonTerminals.FieldDecMore][SNLConstants.ARRAY]=26;
		
		LL1Table[NonTerminals.IdList][SNLConstants.ID]=27;
		
		LL1Table[NonTerminals.IdMore][SNLConstants.SEMI]=28;
		
		LL1Table[NonTerminals.IdMore][SNLConstants.COMMA]=29;
		
		LL1Table[NonTerminals.VarDecpart][SNLConstants.PROCEDURE]=30;
		LL1Table[NonTerminals.VarDecpart][SNLConstants.BEGIN1]=30;
		
		LL1Table[NonTerminals.VarDecpart][SNLConstants.VAR ]=31;
		
		LL1Table[NonTerminals.VarDec][SNLConstants.VAR ]=32;
		
		LL1Table[NonTerminals.VarDecList][SNLConstants.INTEGER]=33;
		LL1Table[NonTerminals.VarDecList][SNLConstants.CHAR1]=33;
		LL1Table[NonTerminals.VarDecList][SNLConstants.ARRAY]=33;
		LL1Table[NonTerminals.VarDecList][SNLConstants.RECORD]=33;
		LL1Table[NonTerminals.VarDecList][SNLConstants.ID]=33;
		
		LL1Table[NonTerminals.VarDecMore][SNLConstants.PROCEDURE ]=34;
		LL1Table[NonTerminals.VarDecMore][SNLConstants.BEGIN1]=34;
		
		LL1Table[NonTerminals.VarDecMore][SNLConstants.INTEGER]=35;
		LL1Table[NonTerminals.VarDecMore][SNLConstants.CHAR1]=35;
		LL1Table[NonTerminals.VarDecMore][SNLConstants.ARRAY]=35;
		LL1Table[NonTerminals.VarDecMore][SNLConstants.RECORD]=35;
		LL1Table[NonTerminals.VarDecMore][SNLConstants.ID]=35;
		
		LL1Table[NonTerminals.VarIdList][SNLConstants.ID ]=36;
		
		LL1Table[NonTerminals.VarIdMore][SNLConstants.SEMI]=37;
		
		LL1Table[NonTerminals.VarIdMore][SNLConstants.COMMA ]=38;
		
		LL1Table[NonTerminals.ProcDecpart][SNLConstants.BEGIN1]=39;
		
		LL1Table[NonTerminals.ProcDecpart][SNLConstants.PROCEDURE]=40;
		
		LL1Table[NonTerminals.ProcDec][SNLConstants.PROCEDURE]=41;
		
		LL1Table[NonTerminals.ProcDecMore][SNLConstants.BEGIN1]=42;
		
		LL1Table[NonTerminals.ProcDecMore][SNLConstants.PROCEDURE ]=43;
		
		LL1Table[NonTerminals.ProcName][SNLConstants.ID]=44;
		
		LL1Table[NonTerminals.ParamList][SNLConstants.RPAREN]=45;
		
		LL1Table[NonTerminals.ParamList][SNLConstants.INTEGER]=46;
		LL1Table[NonTerminals.ParamList][SNLConstants.CHAR1]=46;
		LL1Table[NonTerminals.ParamList][SNLConstants.ARRAY]=46;
		LL1Table[NonTerminals.ParamList][SNLConstants.RECORD]=46;
		LL1Table[NonTerminals.ParamList][SNLConstants.ID]=46;
		LL1Table[NonTerminals.ParamList][SNLConstants.VAR]=46;
		
		LL1Table[NonTerminals.ParamDecList][SNLConstants.INTEGER]=47;
		LL1Table[NonTerminals.ParamDecList][SNLConstants.CHAR1]=47;
		LL1Table[NonTerminals.ParamDecList][SNLConstants.ARRAY]=47;
		LL1Table[NonTerminals.ParamDecList][SNLConstants.RECORD]=47;
		LL1Table[NonTerminals.ParamDecList][SNLConstants.ID]=47;
		LL1Table[NonTerminals.ParamDecList][SNLConstants.VAR]=47;
		
		LL1Table[NonTerminals.ParamMore][SNLConstants.RPAREN]=48;//),书上写(
		
		LL1Table[NonTerminals.ParamMore][SNLConstants.SEMI]=49;
		
		LL1Table[NonTerminals.Param][SNLConstants.INTEGER]=50;
		LL1Table[NonTerminals.Param][SNLConstants.CHAR1]=50;
		LL1Table[NonTerminals.Param][SNLConstants.ARRAY]=50;
		LL1Table[NonTerminals.Param][SNLConstants.RECORD]=50;
		LL1Table[NonTerminals.Param][SNLConstants.ID ]=50;
		
		LL1Table[NonTerminals.Param][SNLConstants.VAR ]=51;
		
		LL1Table[NonTerminals.FormList][SNLConstants.ID]=52;
		
		LL1Table[NonTerminals.FidMore][SNLConstants.SEMI]=53;
		LL1Table[NonTerminals.FidMore][SNLConstants.RPAREN]=53;

		
		LL1Table[NonTerminals.FidMore][SNLConstants.COMMA ]=54;
		
		LL1Table[NonTerminals.ProcDecPart][SNLConstants.TYPE]=55;
		LL1Table[NonTerminals.ProcDecPart][SNLConstants.VAR]=55;
		LL1Table[NonTerminals.ProcDecPart][SNLConstants.PROCEDURE]=55;
		LL1Table[NonTerminals.ProcDecPart][SNLConstants.BEGIN1 ]=55;
		
		LL1Table[NonTerminals.ProcBody][SNLConstants.BEGIN1 ]=56;
		
		LL1Table[NonTerminals.ProgramBody][SNLConstants.BEGIN1 ]=57;
		
		LL1Table[NonTerminals.StmList][SNLConstants.ID]=58;
		LL1Table[NonTerminals.StmList][SNLConstants.IF]=58;
		LL1Table[NonTerminals.StmList][SNLConstants.WHILE]=58;
		LL1Table[NonTerminals.StmList][SNLConstants.RETURN1]=58;
		LL1Table[NonTerminals.StmList][SNLConstants.READ]=58;
		LL1Table[NonTerminals.StmList][SNLConstants.WRITE]=58;
		
		LL1Table[NonTerminals.StmMore][SNLConstants.ELSE ]=59;
		LL1Table[NonTerminals.StmMore][SNLConstants.FI ]=59;
		LL1Table[NonTerminals.StmMore][SNLConstants.END1 ]=59;
		LL1Table[NonTerminals.StmMore][SNLConstants.ENDWH  ]=59;
		
		LL1Table[NonTerminals.StmMore][SNLConstants.SEMI]=60;
		
		LL1Table[NonTerminals.Stm][SNLConstants.IF ]=61;

		
		LL1Table[NonTerminals.Stm][SNLConstants.WHILE ]=62;
		
		LL1Table[NonTerminals.Stm][SNLConstants.READ ]=63;
		
		LL1Table[NonTerminals.Stm][SNLConstants.WRITE ]=64;
		
		LL1Table[NonTerminals.Stm][SNLConstants.RETURN1]=65;
		
		LL1Table[NonTerminals.Stm][SNLConstants.ID]=66;
		
		LL1Table[NonTerminals.AssCall][SNLConstants.ASSIGN ]=67;//书上为:=
		LL1Table[NonTerminals.AssCall][SNLConstants.LMIDPAREN ]=67;
		LL1Table[NonTerminals.AssCall][SNLConstants.DOT ]=67;
		
		LL1Table[NonTerminals.AssCall][SNLConstants.LPAREN ]=68;
		
		LL1Table[NonTerminals.AssignmentRest][SNLConstants.LMIDPAREN ]=69;
		LL1Table[NonTerminals.AssignmentRest][SNLConstants.DOT ]=69;
		LL1Table[NonTerminals.AssignmentRest][SNLConstants.ASSIGN  ]=69;
		
		LL1Table[NonTerminals.ConditionalStm][SNLConstants.IF ]=70;
		
		LL1Table[NonTerminals.LoopStm][SNLConstants.WHILE ]=71;
		
		LL1Table[NonTerminals.InputStm][SNLConstants.READ ]=72;
		
		
		LL1Table[NonTerminals.Invar][SNLConstants.ID]=73;
		
		LL1Table[NonTerminals.OutputStm][SNLConstants.WRITE ]=74;
		
		LL1Table[NonTerminals.ReturnStm][SNLConstants.RETURN1]=75;
		
		LL1Table[NonTerminals.CallStmRest][SNLConstants.LPAREN ]=76;
		
		LL1Table[NonTerminals.ActParamList][SNLConstants.RPAREN ]=77;
		
		LL1Table[NonTerminals.ActParamList][SNLConstants.LPAREN ]=78;
		LL1Table[NonTerminals.ActParamList][SNLConstants.INTC ]=78;
		LL1Table[NonTerminals.ActParamList][SNLConstants.ID ]=78;
		
		LL1Table[NonTerminals.ActParamMore][SNLConstants.RPAREN]=79;
		
		LL1Table[NonTerminals.ActParamMore][SNLConstants.COMMA ]=80;
		
		LL1Table[NonTerminals.RelExp][SNLConstants.LPAREN ]=81;
		LL1Table[NonTerminals.RelExp][SNLConstants.INTC]=81;
		LL1Table[NonTerminals.RelExp][SNLConstants.ID]=81;
		
		LL1Table[NonTerminals.OtherRelE][SNLConstants.LT]=82;
		LL1Table[NonTerminals.OtherRelE][SNLConstants.EQ]=82;
		
		LL1Table[NonTerminals.Exp][SNLConstants.LPAREN ]=83;
		LL1Table[NonTerminals.Exp][SNLConstants.INTC]=83;
		LL1Table[NonTerminals.Exp][SNLConstants.ID]=83;
		
		LL1Table[NonTerminals.OtherTerm][SNLConstants.LT ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.EQ  ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.RMIDPAREN ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.THEN ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.ELSE ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.FI ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.RPAREN ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.END1]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.SEMI ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.COMMA ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.DO  ]=84;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.ENDWH  ]=84;
		
		LL1Table[NonTerminals.OtherTerm][SNLConstants.PLUS ]=85;
		LL1Table[NonTerminals.OtherTerm][SNLConstants.MINUS ]=85;
		
		LL1Table[NonTerminals.Term][SNLConstants.LPAREN ]=86;
		LL1Table[NonTerminals.Term][SNLConstants.INTC ]=86;
		LL1Table[NonTerminals.Term][SNLConstants.ID]=86;
		
		LL1Table[NonTerminals.OtherFactor][SNLConstants.PLUS ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.MINUS ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.LT ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.EQ ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.RMIDPAREN ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.THEN ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.ELSE  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.FI  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.DO  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.ENDWH  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.RPAREN  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.END1  ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.SEMI   ]=87;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.COMMA   ]=87;
		
		
		LL1Table[NonTerminals.OtherFactor][SNLConstants.TIMES ]=88;
		LL1Table[NonTerminals.OtherFactor][SNLConstants.OVER ]=88;
		
		LL1Table[NonTerminals.Factor][SNLConstants.LPAREN ]=89;
		
		LL1Table[NonTerminals.Factor][SNLConstants.INTC ]=90;
		
		LL1Table[NonTerminals.Factor][SNLConstants.ID ]=91;

		
		LL1Table[NonTerminals.Variable][SNLConstants.ID ]=92;
		
		LL1Table[NonTerminals.VariMore][SNLConstants.ASSIGN ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.TIMES ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.OVER ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.PLUS ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.MINUS ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.LT ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.EQ ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.THEN ]=93;		
		LL1Table[NonTerminals.VariMore][SNLConstants.ELSE ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.FI ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.DO ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.ENDWH ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.RPAREN ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.END1 ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.SEMI  ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.COMMA ]=93;
		LL1Table[NonTerminals.VariMore][SNLConstants.RMIDPAREN  ]=93;//书中没有]
		
		LL1Table[NonTerminals.VariMore][SNLConstants.LMIDPAREN ]=94;
		
		LL1Table[NonTerminals.VariMore][SNLConstants.DOT]=95;
		
		LL1Table[NonTerminals.FieldVar][SNLConstants.ID]=96;
		
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.ASSIGN]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.TIMES]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.OVER]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.PLUS]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.MINUS]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.LT]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.EQ]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.THEN]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.ELSE]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.FI]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.DO]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.ENDWH]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.RPAREN]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.END1]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.SEMI]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.COMMA]=97;
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.RMIDPAREN]=97;
		
		
		LL1Table[NonTerminals.FieldVarMore][SNLConstants.LMIDPAREN ]=98;
		
		LL1Table[NonTerminals.CmpOp][SNLConstants.LT ]=99;
		
		LL1Table[NonTerminals.CmpOp][SNLConstants.EQ ]=100;
		
		LL1Table[NonTerminals.AddOp][SNLConstants.PLUS ]=101;
		
		LL1Table[NonTerminals.AddOp][SNLConstants.MINUS ]=102;
		
		LL1Table[NonTerminals.MultOp][SNLConstants.TIMES ]=103;
		
		LL1Table[NonTerminals.MultOp][SNLConstants.OVER ]=104;
		
	}
	/**
	 * LL(1)语法分析主函数
	 */
	public TreeNode parse() {
		prok.setNodekind(NodeKind.ProK);
		prok.setChild(new TreeNode[3]);
		prok.getChild()[0]=new TreeNode();
		prok.getChild()[1]=new TreeNode();
		prok.getChild()[2]=new TreeNode();
		ul.pushPa(prok.getChild()[2]);
		ul.pushPa(prok.getChild()[1]);
		ul.pushPa(prok.getChild()[0]);
		CreatLL1Tabble();
		ul.setData("C:/Users/8/eclipse-workspace/SNL/src/tokenlist.txt");
		ul.push(1, NonTerminals.Program);
		token=ul.readNextToken();
		prok.setLineno(token.getLineshow());
		while (!ul.getSymbols().isEmpty()) {
			if (ul.readStackflag()==0) {
				if (ul.readStackitem()==token.getLextype()) {
					ul.pop();
					token=ul.readNextToken();
				} else {
					System.out.println("出现非期望单词错误，错误行数："+token.getLineshow());
					return prok;
				}
			} else {
				int pnum=LL1Table[ul.readStackitem()][token.getLextype()];
				ul.pop();
				predict(pnum);
			}
		}
		if (token.getLextype()!=SNLConstants.ENDFILE) {
			System.out.println("出现文件提前结束错误，错误行数："+token.getLineshow());
		} else {

		}
		return prok;
	}
	/**
	 * 根据产生式编号选择一个要执行的函数。若产生式编号为 m，则选择函数 process m ( )。
	 * @param num 已选择的产生式编号
	 */
	public void predict(int num) {
		if (num<=0||num>104) {	//没有正确的产生式可选，非期望单词错，出错信息写入列表文件
			return;
		}
		Zparse p = new Zparse();
		Class cl = this.getClass();
		//通过反射机制调用process方法
		try {
			Method m = cl.getMethod("process"+num, null);
			try {
				m.invoke(this, null);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 对于给定的操作符，此函数返回操作符的优先级，乘法运算符 > 加法运算符 > 关系运算符 > 栈底标识 END
	 * @param op 操作符的词法类型
	 * @return 返回操作符的优先级,返回值越大所给操作符的优先级越高
	 */
	public int priosity(int op) {
		int pri;
		if (op==SNLConstants.ENDFILE) {
			pri=0;
		} else if (op==SNLConstants.LT||op==SNLConstants.EQ) {	// < =
			pri=1;
		} else if (op==SNLConstants.PLUS||op==SNLConstants.MINUS) {	// + -
			pri=2;
		}  else if (op==SNLConstants.TIMES||op==SNLConstants.OVER) {	// * /
			pri=3;
		} else {
			pri=-1;
		}
		return pri;
	}
	
	public void process1() {
		ul.push(1, NonTerminals.ProgramBody);
		ul.push(1, NonTerminals.DeclarePart);
		ul.push(1, NonTerminals.ProgramHead);
	}
	public void process2() {
		ul.push(1, NonTerminals.ProgramName);
		ul.push(0, SNLConstants.PROGRAM);
		ul.popPa().setKind(NodeKind.PheadK);
	}
	public void process3() {
		ul.push(0, SNLConstants.ID);
		TreeNode p = prok.getChild()[0];
		p.idnumcount();
		p.getName().add(token.getSem());
	}
	public void process4() {
		ul.push(1, NonTerminals.ProcDecpart);
		ul.push(1, NonTerminals.VarDecpart);
		ul.push(1, NonTerminals.TypeDecpart);
	}
	public void process5() {
		
	}
	public void process6() {
		ul.push(1, NonTerminals.TypeDec);
	}
	public void process7() {
		ul.push(1, NonTerminals.TypeDecList);
		ul.push(0, SNLConstants.TYPE);
		currentP=ul.popPa();
		currentP.setKind(NodeKind.TypeK);
		currentP.setChild(new TreeNode[1]);
		currentP.getChild()[0]=new TreeNode();
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());
		ul.pushPa(currentP.getChild()[0]);
	}
	public void process8() {
		ul.push(1, NonTerminals.TypeDecMore);
		ul.push(0, SNLConstants.SEMI);
		ul.push(1, NonTerminals.TypeDef);
		ul.push(0, SNLConstants.EQ);
		ul.push(1, NonTerminals.TypeId);
		currentP=ul.popPa();
		currentP.setKind(NodeKind.TypeK);
		currentP.setSibling(new TreeNode());
		ul.pushPa(currentP.getSibling());
	}
	public void process9() {
		ul.popPa();
	}
	public void process10() {
		ul.push(1, NonTerminals.TypeDecList);
	}
	public static void main(String[] args) {
		Zparse a=new Zparse();
		/*a.CreatLL1Tabble();
		//把非0的打印出来
		for(int i=1;i<69;i++){
			for(int j=0;j<42;j++) {
				if(a.getLL1(i,j)!=0)
				System.out.print("["+NonTerminals.vntypemap2.get(i)+"]"+"["+SNLConstants.tokentypemap.get(j)+"]="+a.getLL1(i,j)+" ");
				}
				System.out.print("\n");
			}*/
		/*UtilLL1 u = new UtilLL1();
		Token x;
		u.setData("C:/Users/8/eclipse-workspace/SNL/src/tokenlist.txt");
		while ((x=a.readNextToken())!=null) {
			Util.printToken(x);
		}
		a.predict(1);
		a.predict(2);*/
		a.parse();
		
		//u.close();
	}


}
