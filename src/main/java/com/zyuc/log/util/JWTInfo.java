package com.zyuc.log.util;

import java.io.Serializable;

public class JWTInfo implements Serializable, IJWTInfo {
	private String userid;
	private String username;
	private String netuserid;

	public JWTInfo(String userid, String netuserid, String username) {
		this.userid = userid;
		this.username = username;
		this.netuserid = netuserid;
	}
	@Override
	public String getUserId() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String getNetUserId() {
		return netuserid;
	}

	public void setNetuserid(String netuserid) {
		this.netuserid = netuserid;
	}

	@Override
	public String getUserName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		JWTInfo jwtInfo = (JWTInfo) o;
		return netuserid != null ? netuserid.equals(jwtInfo.netuserid) : jwtInfo.netuserid == null;

	}
}
