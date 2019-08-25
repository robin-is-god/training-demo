package com.spdb.training.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ���������
 * @author wanglw2
 *
 */
public class StringUtils {
	public static boolean empty(String str){
		return str==null || str.trim().length()==0;
	}
	
	public static List<String> getStringXmlBody(String soap,String rgex) {
	        List<String> list = new ArrayList<String>();  
	        Pattern pattern = Pattern.compile(rgex);// 匹配的模式  
	        Matcher m = pattern.matcher(soap);  
	        while (m.find()) {  
	            int i = 1;  
	            list.add(m.group(i));  
	            i++;  
	        }  
	        return list;  
	    }  
	public static void main(String[] args) {
//		String fileToString = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" + 
//				"<rspService>\r\n" + 
//				"    <rspHeader>\r\n" + 
//				"        <tranCode>OR01</tranCode>\r\n" + 
//				"        <transDate>20195922</transDate>\r\n" + 
//				"        <retCode>0000</retCode>\r\n" + 
//				"        <retMsg>交易成功</retMsg>\r\n" + 
//				"    </rspHeader>\r\n" + 
//				"    <body>\r\n" + 
//				"        <nums>10</nums>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00010000</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00010001</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00010002</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00010003</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100004</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100005</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100006</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100007</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100008</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"        <row>\r\n" + 
//				"            <itemCode>00100009</itemCode>\r\n" + 
//				"            <qty>10000</qty>\r\n" + 
//				"        </row>\r\n" + 
//				"    </body>\r\n" + 
//				"</rspService>";
//		fileToString = fileToString.replaceAll(" ", "");
//		fileToString = fileToString.replaceAll("\r\n", "");
//		System.out.println(fileToString);
//		String rgex = "<itemCode>(.*?)</itemCode>";
//		List<String> list = getStringXmlBody(fileToString, rgex);
//		System.out.println(list.toString());
		String string = "00010004";
		System.out.println(string.substring(7));
		Random random = new Random();
		System.out.println("" + random.nextInt(4-0));
	}
}
