package com.zyuc.log.util;

public interface IJWTInfo {
	   /**
     * 获取用户ID
     * @return
     */
    String getUserId();
    /**
     * 获取用户NetUserid
     * @return
     */
    String getNetUserId();

    /**
     * 获取用户名
     * @return
     */
    String getUserName();
}
