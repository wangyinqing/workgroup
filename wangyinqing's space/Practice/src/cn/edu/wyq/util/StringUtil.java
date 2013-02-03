package cn.edu.wyq.util;

import java.util.Collection;
import java.util.Iterator;

public class StringUtil {
	
	public static <E>String combine2String(Collection<E> c, String delimiter){
		if(c == null){
			return null;
		}else{
			Iterator<E> iter = c.iterator();
			StringBuilder sb = new StringBuilder();
			while(iter.hasNext()){
				E e = iter.next();
				sb.append(e);
				if(iter.hasNext())
					sb.append(delimiter);
			}
			return sb.toString();
		}
	}

}
