package com.kokcuemre.spring.security.jwt.constant;

public class SecurityConstants {
	public static final String SECRET = "EmreKOKCU";
	public static final long EXPIRATION_TIME = 300_000; // 5 minute
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/user";
}
