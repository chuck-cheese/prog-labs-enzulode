package com.enzulode.natives;

public class NativeMethods
{
	static {
		System.loadLibrary("NativeMethods");
	}
	public static native int hashcode(Object object);

}
