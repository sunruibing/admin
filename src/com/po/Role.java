package com.po;
/**
 * �����̨��ɫ��¼
 * @author Administrator
 *
 */
public class Role {
    
	private Integer id;//��ɫid
	
	private String phone;//��ɫ�ֻ���
	
	private String password;//��ɫ����
	
	private String name;//��ɫ�ǳ�

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
