package com.lawencon.tiketboot.controller;

import java.util.Base64;

public abstract class BaseController {

	public String[] authUser(String auth) {
		byte[] decodedBytes = Base64.getDecoder().decode(auth);
		String decodedString = new String(decodedBytes);
		String[] authArr = decodedString.split(":");
		return authArr;
	}
}
