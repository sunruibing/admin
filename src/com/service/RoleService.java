package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.po.Role;
import com.util.DBUtil;

/**
 * 管理登陆
 * @author Administrator
 *
 */
public class RoleService {
    
	// 根据手机号查询用户
	public Role queryRoleByPhone(String phone) throws SQLException {
		
		String sql = "select id,phone,password,name from role where phone = " + phone + "";// SQL语句
		DBUtil dbUtil = new DBUtil(sql);

		
		Role role = new Role();

		ResultSet result = null;
		try {
			
			result = dbUtil.pst.executeQuery();// 执行语句，得到结果集
			
			while (result.next()) {// 遍历结果
			 
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