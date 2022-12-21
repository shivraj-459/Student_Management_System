package com.commons.service;

import java.util.Random;

public class RandomString {
	
	
	
	public static String generateUuid() {
		
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		
		Random rnd = new Random();
		
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
		
		for (int i = 0; i < 5; i++) {
		    sb.append(chars[rnd.nextInt(chars.length)]);
		}
		return sb.toString();
		
	}

}
