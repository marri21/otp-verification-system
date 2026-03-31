package com.otp.service;

import java.util.Random;

public class OtpService {
  
	public static String generateOtp() {
		return String.valueOf(100000+new Random().nextInt(900000));
	}
}
