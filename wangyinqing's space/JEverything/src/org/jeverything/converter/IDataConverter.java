package org.jeverything.converter;

/**
 * @author wangyinqing
 *
 * @param <S>
 * @param <D>
 */
public interface IDataConverter<S,D> {
	
	public D convert(S source);

}
