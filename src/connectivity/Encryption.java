/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectivity;

/**
 *
 * @author HP
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword=null;
		MessageDigest messageDigest=MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte []encrypt=messageDigest.digest();
		StringBuilder sb=new StringBuilder();
		for(byte b:encrypt) {
			sb.append(b);
		}
		encryptedPassword=sb.toString();
		//System.out.println("Encrypted password "+encryptedPassword);
		return encryptedPassword;
	}
}
