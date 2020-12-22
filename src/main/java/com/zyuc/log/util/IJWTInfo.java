package com.zyuc.log.util;

public interface IJWTInfo {
	   /**
     * 获取用户ID
     * @return
     */
    String getUserid();
    /**
     * 获取用户NetUserid
     * @return
     */
    String getNetUserid();

    /**
     * 获取用户名
     * @return
     */
    String getUserName();
}
