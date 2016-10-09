package jvm.classload;


public class ByteUtils {
	public static int bytes2Int(byte[] b,int start,int len){
		int sum = 0;
		int end = start + len;
		for(int i=start;i<end;i++){
			int n = ((int)b[i]) & 0xff;
			n <<= (--len) * 8;
			sum = n + sum;
		}
		return sum;
	}
	public static byte[] int2Bytes(int value,int len){
		byte[] b = new byte[len];
		for(int i =0;i<len;i++){
			b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
		}
		return b;
	}
	public static String bytes2String(byte[] b,int start,int len){
		return new String(b,start,len);
	}
	public static byte[] string2Bytes(String str){
		return str.getBytes();
	}
	public static byte[] bytesReplace(byte[] originalByte,int offset,int len,byte[] replaceBytes){
		byte[] newBytes = new byte[originalByte.length + (replaceBytes.length - len)];
		System.arraycopy(originalByte, 0, newBytes, 0, offset);
		System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
		System.arraycopy(originalByte, offset + len, newBytes, offset + replaceBytes.length, originalByte.length - offset - len);
		return newBytes;
	}
	public static void main(String[] args) {
		byte[] in = int2Bytes(5, 8);
		for(int i=0;i<in.length;i++){
			System.out.println(in[i]);
		}
		
		String by = bytes2String(in, 0, 4);
		System.out.println(by);
		
	}
}
