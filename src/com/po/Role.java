package com.po;
/**
 * 管理后台角色登录
 * @author Administrator
 *
 */
public class Role {
    
	private Integer id;//角色id
	
	private String phone;//角色手机号
	
	private String password;//角色密码
	
	private String name;//角色昵称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", phone=" + phone + ", password=" + password + ", name=" + name + "]";
	}
	
}
