package com.capgemini.omnichannel.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import com.capgemini.omnichannel.security.dto.TokenInfo;

public class SecurityUtils {

	
	public static TokenInfo createTokeninfoFromJws(Jws<Claims> jwsClaims){
		
		TokenInfo result=null;
		
		if(jwsClaims!=null){
			result= new TokenInfo();
			result.setSubject(jwsClaims.getBody().getSubject());
		}
		
		return result;
		
	}
}
