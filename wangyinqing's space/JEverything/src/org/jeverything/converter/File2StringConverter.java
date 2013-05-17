/**
 * 
 */
package org.jeverything.converter;

import java.io.File;

 /**
 * @author wangyinqing
 *
 */
public class File2StringConverter implements IDataConverter<File[], String[][]> {

	@Override
	public String[][] convert(File[] source) {
		int length = source.length;
		String[][] s = new String[length][2];
		for (int i = 0; i < length; i++){
			s[i][0] = source[i].getName();
			s[i][1] = source[i].getAbsolutePath();
		}
		return s;
	}

}
