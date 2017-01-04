package com.bestpay.posp.utils.recombin;

import lombok.extern.slf4j.Slf4j;

/** 
 * <p>Utility class for xs:hexbinary.</p>
 */
@Slf4j
public class HexBinary {
	/** Creates a clone of the given byte array.
	 */
	public static byte[] getClone(byte[] pHexBinary) {
		byte[] result = new byte[pHexBinary.length];
		System.arraycopy(pHexBinary, 0, result, 0, pHexBinary.length);
		return result;
	}

	/** 
	 * Converts the string <code>pValue</code> into an
	 * array of hex bytes.
	 */
	public static byte[] decode(String pValue) {
		if ((pValue.length() % 2) != 0) {
			throw new IllegalArgumentException("A HexBinary string must have even length.");
		}
		byte[] result = new byte[pValue.length() / 2];
		int j = 0;
		for (int i = 0;  i < pValue.length();  ) {
			byte b;
			char c = pValue.charAt(i++);
			char d = pValue.charAt(i++);
			if (c >= '0'  &&  c <= '9') {
				b = (byte) ((c - '0') << 4);
			} else if (c >= 'A'  &&  c <= 'F') {
				b = (byte) ((c - 'A' + 10) << 4);
			} else if (c >= 'a'  &&  c <= 'f') {
				b = (byte) ((c - 'a' + 10) << 4);
			} else {
				throw new IllegalArgumentException("Invalid hex digit: " + c);
			}
			if (d >= '0'  &&  d <= '9') {
				b += (byte) (d - '0');
			} else if (d >= 'A'  &&  d <= 'F') {
				b += (byte) (d - 'A' + 10);
			} else if (d >= 'a'  &&  d <= 'f') {
				b += (byte) (d - 'a' + 10);
			} else {
				throw new IllegalArgumentException("Invalid hex digit: " + d);
			}
			result[j++] = b;
		}
		return result;
	}

	/** 
	 * Converts the byte array <code>pHexBinary</code> into
	 * a string.
	 */
	public static String encode(byte[] pHexBinary) {
		StringBuffer result = new StringBuffer();
		for (int i = 0;  i < pHexBinary.length;  i++) {
			byte b = pHexBinary[i];
			byte c = (byte) ((b & 0xf0) >> 4);
			if (c <= 9) {
				result.append((char) ('0' + c));
			} else {
				result.append((char) ('A' + c - 10));
			}
			c = (byte) (b & 0x0f);
			if (c <= 9) {
				result.append((char) ('0' + c));
			} else {
				result.append((char) ('A' + c - 10));
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		String a = "12";
		log.debug(encode(a.getBytes()));
		String  ab ="00000000000100000000000001560000000000015611041501112233447C00000603A00002";
		log.debug("::::::::::["+HexBinary.encode(ab.getBytes())+"]");
	}
}