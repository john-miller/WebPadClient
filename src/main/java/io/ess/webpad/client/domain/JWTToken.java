package io.ess.webpad.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTToken {
	
	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("expires_in")
	private long expiresIn;
	
	@JsonProperty("scope")
	private String scope;
	
	@JsonProperty("jti")
	private String jti;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getJti() {
		return jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	@Override
	public String toString() {
		return "JWTToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expiresIn=" + expiresIn
				+ ", scope=" + scope + ", jti=" + jti + "]";
	}
	
	

}
