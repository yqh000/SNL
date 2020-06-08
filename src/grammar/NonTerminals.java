package grammar;

import java.util.HashMap;
import java.util.Map;

public interface NonTerminals {
	/**
	 * 非终极符
	 */
	int Program=1,     ProgramHead=2,   ProgramName=3,    DeclarePart=4, TypeDecpart=5,
	TypeDec=6,     TypeDecList=7,   TypeDecMore=8,    TypeId=9,      TypeDef=10,
	BaseType=11,    StructureType=12, ArrayType=13,      Low=14,         Top=15,
	RecType=16,     FieldDecList=17,  FieldDecMore=18,   IdList=19,      IdMore=20,
	VarDecpart=21,  VarDec=22,        VarDecList=23,     VarDecMore=24,  VarIdList=25,   VarIdMore=26,
	ProcDecpart=27, ProcDec=28,       ProcDecMore=29,    ProcName=30,    ParamList=31,   ProcDeclaration=32 ,
	ParamDecList=33,ParamMore=34,     Param=35,          FormList=36,    FidMore=37,
	ProcDecPart=38, ProcBody=39,      ProgramBody=40,    StmList=41,     StmMore=42,     Stm=43,
	AssCall=44,     AssignmentRest=45,ConditionalStm=46, LoopStm=47,     InputStm=48,
	Invar=49,		 OutputStm=50,     ReturnStm=51,      CallStmRest=52, ActParamList=53,
	ActParamMore=54,RelExp=55,        OtherRelE=56,      Exp=57,         OtherTerm=58,
	Term=59,        OtherFactor=60,   Factor=61,         Variable=62,    VariMore=63,    FieldVar=64,
	FieldVarMore=65,CmpOp=66,         AddOp=67,          MultOp=68 ;
	/**
	 * 保留字查找表
	 */
	Map<String, Integer> vntypemap=new HashMap<String, Integer>() {
		{
		put("Program",Program);
		put("ProgramHead",ProgramHead);
		put("ProgramName",ProgramName);
		put("DeclarePart",DeclarePart);
		put("TypeDecpart",TypeDecpart);
		put("TypeDec",TypeDec);
		put("TypeDecList",TypeDecList);
		put("TypeDecMore",TypeDecMore);
		put("TypeId",TypeId);
		put("TypeDef",TypeDef);//10
		put("BaseType",BaseType);
		put("StructureType",StructureType);
		put("ArrayType",ArrayType);
		put("Low",Low);
		put("Top",Top);
		put("RecType",RecType);
		put("FieldDecList",FieldDecList);
		put("FieldDecMore",FieldDecMore);
		put("IdList",IdList);
		put("IdMore",IdMore);//20
		put("VarDecpart",VarDecpart);
		put("VarDec",VarDec);
		put("VarDecList",VarDecList);		
		put("VarDecMore",VarDecMore);
		put("VarIdList",VarIdList);
		put("VarIdMore",VarIdMore);		
		put("ProcDecpart",ProcDecpart);
		put("ProcDec",ProcDec);
		put("ProcDecMore",ProcDecMore);				
		put("ProcName",ProcName);//30
		put("ParamList",ParamList);
		put("ProcDeclaration",ProcDeclaration);
		put("ParamDecList",ParamDecList);
		put("ParamMore",ParamMore);
		put("Param",Param);
		put("FormList",FormList);
		put("FidMore",FidMore);
		put("ProcDecPart",ProcDecPart);
		put("ProcBody",ProcBody);
		put("ProgramBody",ProgramBody);//40
		put("StmList",StmList);
		put("StmMore",StmMore);
		put("Stm",Stm);
		put("AssCall",AssCall);
		put("AssignmentRest",AssignmentRest);
		put("ConditionalStm",ConditionalStm);
		put("LoopStm",LoopStm);
		put("InputStm",InputStm);
		put("Invar",Invar);
		put("OutputStm",OutputStm);//50
		put("ReturnStm",ReturnStm);
		put("CallStmRest",CallStmRest);
		put("ActParamList",ActParamList);
		put("ActParamMore",ActParamMore);
		put("RelExp",RelExp);
		put("OtherRelE",OtherRelE);
		put("Exp",Exp);
		put("OtherTerm",OtherTerm);
		put("Term",Term);
		put("OtherFactor",OtherFactor);//60
		put("Factor",Factor);
		put("Variable",Variable);
		put("VariMore",VariMore);
		put("FieldVar",FieldVar);
		put("FieldVarMore",FieldVarMore);
		put("CmpOp",CmpOp);
		put("AddOp",AddOp);
		put("MultOp",MultOp);
		}
	};
	/**
	 * token类型查找表
	 */
	Map<Integer, String> vntypemap2=new HashMap<Integer, String>() {
		{
		put(Program,"Program");
		put(ProgramHead,"ProgramHead");
		put(ProgramName,"ProgramName");
		put(DeclarePart,"DeclarePart");
		put(TypeDecpart,"TypeDecpart");
		put(TypeDec,"TypeDec");
		put(TypeDecList,"TypeDecList");
		put(TypeDecMore,"TypeDecMore");
		put(TypeId,"TypeId");
		put(TypeDef,"TypeDef");//10
		put(BaseType,"BaseType");
		put(StructureType,"StructureType");
		put(ArrayType,"ArrayType");
		put(Low,"Low");
		put(Top,"Top");
		put(RecType,"RecType");
		put(FieldDecList,"FieldDecList");
		put(FieldDecMore,"FieldDecMore");
		put(IdList,"IdList");
		put(IdMore,"IdMore");//20
		put(VarDecpart,"VarDecpart");
		put(VarDec,"VarDec");
		put(VarDecList,"VarDecList");		
		put(VarDecMore,"VarDecMore");
		put(VarIdList,"VarIdList");
		put(VarIdMore,"VarIdMore");		
		put(ProcDecpart,"ProcDecpart");
		put(ProcDec,"ProcDec");
		put(ProcDecMore,"ProcDecMore");				
		put(ProcName,"ProcName");//30
		put(ParamList,"ParamList");
		put(ProcDeclaration,"ProcDeclaration");
		put(ParamDecList,"ParamDecList");
		put(ParamMore,"ParamMore");
		put(Param,"Param");
		put(FormList,"FormList");
		put(FidMore,"FidMore");
		put(ProcDecPart,"ProcDecPart");
		put(ProcBody,"ProcBody");
		put(ProgramBody,"ProgramBody");//40
		put(StmList,"StmList");
		put(StmMore,"StmMore");
		put(Stm,"Stm");
		put(AssCall,"AssCall");
		put(AssignmentRest,"AssignmentRest");
		put(ConditionalStm,"ConditionalStm");
		put(LoopStm,"LoopStm");
		put(InputStm,"InputStm");
		put(Invar,"Invar");
		put(OutputStm,"OutputStm");//50
		put(ReturnStm,"ReturnStm");
		put(CallStmRest,"CallStmRest");
		put(ActParamList,"ActParamList");
		put(ActParamMore,"ActParamMore");
		put(RelExp,"RelExp");
		put(OtherRelE,"OtherRelE");
		put(Exp,"Exp");
		put(OtherTerm,"OtherTerm");
		put(Term,"Term");
		put(OtherFactor,"OtherFactor");//60
		put(Factor,"Factor");
		put(Variable,"Variable");
		put(VariMore,"VariMore");
		put(FieldVar,"FieldVar");
		put(FieldVarMore,"FieldVarMore");
		put(CmpOp,"CmpOp");
		put(AddOp,"AddOp");
		put(MultOp,"MultOp");
		}
	};
	
	public enum NodeKind{
		/**
		 * 记录语法树节点类型
		 */
		ProK,PheadK,TypeK, VarK, ProcDecK, StmLK, DecK, StmtK, ExpK,
		/**
		 * 记录语法树节点的声明类型，当 nodekind = DecK 时有效
		 */
		ArrayK,CharK,IntegerK,RecordK,IdK,
		/**
		 * 记录语法树节点的语句类型，当 nodekind = StmtK 时有效
		 */
		IfK,WhileK,AssignK,ReadK,WriteK,CallK,ReturnK,
		/**
		 * 记录语法树节点的表达式类型，当 nodekind=ExpK 时有效，也包含IdK
		 */
		OpK,ConstK
	}
	
	public enum ParamType{
		/**
		 * 值参
		 */
		valparamtype,
		/**
		 * 变参
		 */
		varparamtype
	}
	
	public enum Var{
		/**
		 * 标志符变量
		 */
		IdV,
		/**
		 * 数组成员变量
		 */
		ArrayMembV,
		/**
		 * 域成员变量
		 */
		FieldMembV
	}
}
