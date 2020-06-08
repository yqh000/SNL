package lexical;

import java.util.HashMap;
import java.util.Map;


/**
 * 常数设置
 * @author yqh
 *
 */
public interface SNLConstants {
		/**
		 * Token种类
		 */
		 /* 簿记单词符号 */
		 int ENDFILE = 0,ERROR = 1;
		 /* 保留字 */
		 int PROGRAM = 2,PROCEDURE = 3,TYPE = 4,VAR = 5,IF = 6,THEN = 7,ELSE = 8,FI = 9,
			 WHILE = 10,DO = 11,ENDWH = 12,BEGIN1 = 13,END1 = 14,READ = 15,WRITE = 16,
		     ARRAY = 17,OF = 18,RECORD = 19,RETURN1 = 20; 
		 //类型
		 int INTEGER = 21,CHAR1 = 22;
		 /* 多字符单词符号 */
		 int ID = 23,INTC = 24,CHARC = 25;
		 /*特殊符号 */
		 int ASSIGN = 26,EQ = 27,LT = 28,PLUS = 29,MINUS = 30,TIMES = 31,OVER = 32,
			 LPAREN = 33,RPAREN = 34,DOT = 35,COLON = 36,SEMI = 37,COMMA = 38,
			 LMIDPAREN = 39,RMIDPAREN = 40,UNDERANGE = 41;
	/**
	 * 保留字查找表
	 */
	Map<String, Integer> reservedmap=new HashMap<String, Integer>() {
		{
		put("program",PROGRAM);
		put("type",TYPE);
		put("var",VAR);
		put("procedure",PROCEDURE);
		put("begin",BEGIN1);
		put("end",END1);
		put("array",ARRAY);
		put("of",OF);
		put("record",RECORD);
		put("if",IF);
		put("then",THEN);
		put("else",ELSE);
		put("fi",FI);
		put("while",WHILE);
		put("do",DO);
		put("endwh",ENDWH);
		put("read",READ);
		put("write",WRITE);
		put("return",RETURN1);
		put("integer",INTEGER);
		put("char",CHAR1);
		}
	};
	/**
	 * token类型查找表
	 */
	Map<Integer, String> tokentypemap=new HashMap<Integer, String>() {
		{
		put(ENDFILE,"ENDFILE");
		put(ERROR,"ERROR");
		put(PROGRAM,"PROGRAM");
		put(PROCEDURE,"PROCEDURE");
		put(TYPE,"TYPE");
		put(VAR,"VAR");
		put(IF,"IF");
		put(THEN,"THEN");
		put(ELSE,"ELSE");
		put(FI,"FI");
		put(WHILE,"WHILE");
		put(DO,"DO");
		put(ENDWH,"ENDWH");
		put(BEGIN1,"BEGIN1");
		put(END1,"END1");
		put(READ,"READ");
		put(WRITE,"WRITE");
		put(ARRAY,"ARRAY");
		put(OF,"OF");
		put(RECORD,"RECORD");
		put(RETURN1,"RETURN1");
		put(INTEGER,"INTEGER");
		put(CHAR1,"CHAR1");
		put(ID,"ID");
		put(INTC,"INTC");
		put(CHARC,"CHARC");
		put(ASSIGN,"ASSIGN");
		put(EQ,"EQ");
		put(LT,"LT");
		put(PLUS,"PLUS");
		put(MINUS,"MINUS");
		put(TIMES,"TIMES");
		put(OVER,"OVER");
		put(LPAREN,"LPAREN");
		put(RPAREN,"RPAREN");
		put(DOT,"DOT");
		put(COLON,"COLON");
		put(SEMI,"SEMI");
		put(COMMA,"COMMA");
		put(LMIDPAREN,"LMIDPAREN");
		put(RMIDPAREN,"RMIDPAREN");
		put(UNDERANGE,"UNDERANGE");
		}
	};
	/**
	 * DFA 的状态
	 * @author yqh
	 *
	 */
	public enum State {
		/**
		 * 开始状态
		 */
		START,		
		/**
		 * 赋值状态
		 */
		INASSIGN,	
		/**
		 * 注释状态
		 */
		INCOMMENT,	
		/**
		 * 数字状态
		 */
		INNUM,		
		/**
		 * 标识符状态
		 */
		INID,		
		/**
		 * 字符标志状态
		 */
		INCHAR,		
		/**
		 * 数组下标界限状态
		 */
		INRANGE,	
		/**
		 * 完成状态
		 */
		DONE,
		/**
		 * 错误状态
		 */
		ERROR
	}
}
