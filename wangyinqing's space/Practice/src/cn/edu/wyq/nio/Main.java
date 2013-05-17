package cn.edu.wyq.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(10);
		bb.put(toByte('H')).put(toByte('e')).put(toByte('l')).put(toByte('l')).put(toByte('o'));
		printInfo(bb);
		bb.flip();
		System.out.println((char)bb.get());
		printInfo(bb);
	}

	public static byte toByte(char c){
		return (byte)c;
	}
	
	public static void printInfo(Buffer buffer){
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
	}
	
}
