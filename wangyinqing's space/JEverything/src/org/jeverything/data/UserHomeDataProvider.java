package org.jeverything.data;

import java.io.File;

import org.jeverything.converter.File2StringConverter;
import org.jeverything.converter.IDataConverter;

/**
 * @author wangyinqing
 *
 */
public class UserHomeDataProvider {
	
	public UserHomeDataProvider(){
		
	}
	
	public Object[][] provide(){
		File file = new File("/Users/wangyinqing/Downloads/aa");
		IDataConverter<File[], String[][]> c = new File2StringConverter();
		String[][] s = c.convert(new File[]{file});
		return s;
	}
	
	public static void main(String[] args){
		File file = new File("/Users/wangyinqing/Downloads/aa");
		IDataConverter<File[], String[][]> c = new File2StringConverter();
		String[][] s = c.convert(new File[]{file});
		System.out.println(s[0][1]);
	}

}
