package com.zhidisoft.blog.admin.util;

public class RandomUtil {

	public static int randomInt() {
		// Math.random() 10;
		int result = (int) (Math.random() * 11) + 1;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(randomInt());
	}
}
