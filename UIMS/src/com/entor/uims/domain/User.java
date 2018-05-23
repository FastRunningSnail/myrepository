package com.entor.uims.domain;

import java.sql.Timestamp;

/**
 * 用户实体类，映射user_inf表
 * 
 * @author Administrator
 *
 */
public class User {
	private Integer id;// id
	private String loginName;// 登录名
	private String password;// 密码
	private String realName;// 姓名
	private Integer authority;// 权限代码
	private Timestamp createDate;// 创建事件

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}