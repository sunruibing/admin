package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.po.Role;
import com.util.DBUtil;

/**
 * �����½
 * @author Administrator
 *
 */
public class RoleService {
    
	// �����ֻ��Ų�ѯ�û�
	public Role queryRoleByPhone(String phone) throws SQLException {
		
		String sql = "select id,phone,password,name from role where phone = " + phone + "";// SQL���
		DBUtil dbUtil = new DBUtil(sql);

		
		Role role = new Role();

		ResultSet result = null;
		try {
			
			result = dbUtil.pst.executeQuery();// ִ����䣬�õ������
			
			while (result.next()) {// �������
			 
				Integer id = result.getInt("id");
				String DBphone = result.getString("phone");
				String password = result.getString("password");
				String name = result.getString("name");

				role.setId(id);
				role.setPhone(DBphone);
				role.setPassword(password);
				role.setName(name);

				return role;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return role;
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return role;
	}
}