package lexical;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 工具类
 * @author yqh
 *
 */
public class Util {
	/**
	 * 打印Token列表，格式参考printToken(Token token)
	 * @param tl Token列表
	 */
	public static void printTokenlist(List<Token> tl) {
		for (Token token : tl) {
			printToken(token);
		}
	}
	/**
	 * 打印Token，打印格式为：单词行数,大写词法信息(,语义信息)		（词法信息以大写string形式打印，列表中以int类型保存）
	 * @param token	要打印的Token
	 */
	public static void printToken(Token token) {
		System.out.print(token.getLineshow()+","+SNLConstants.tokentypemap.get(token.getLextype()));
		if (token.getSem()!=null) {
			System.out.print(","+token.getSem());
		}
		System.out.println();
	}
	/**
	 * 将列表中的Token存入文件，会覆盖掉文件原有内容
	 * @param tl Token列表
	 * @param data 要保存的文件路径
	 */
	public static void ListToFile(List<Token> tl, String data) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(data));
			for (Token token : tl) {
				bw.write(token.getLineshow()+","+token.getLextype());
				if (token.getSem()!=null) 
					bw.write(","+token.getSem());
				bw.newLine();
			}
			
		    bw.flush();
		    bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
