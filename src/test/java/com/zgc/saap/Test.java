package com.zgc.saap;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Test {
	public static void main(String[] args) {
		System.out.println(new SimpleHash("MD5", "123456", "1", 2).toHex());
	}
}
