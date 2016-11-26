package com.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Role;
import com.service.RoleService;
import com.util.StringUtil;


@WebServlet(name="AdminLogin",urlPatterns={"/adminLogin"})
public class AdminLogin extends HttpServlet {
	
	private static final long serialVersionUID = -4697804910426531143L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String phone = request.getParameter("phone");//��ȡ�û���
		String password = StringUtil.MD5Encode(request.getParameter("password"));//��ȡ����
		
		try {
			if ((phone != null && password != null) && (!phone.isEmpty() && !password.isEmpty())) {//����Ϊ����֤
				
				RoleService roleService = new RoleService();
				    Role DBrole =   roleService.queryRoleByPhone(phone);
				
				if (password.equals(DBrole.getPassword())) {//�ж������Ƿ���ȷ
					
					DBrole.setPassword("");//�������
					
					response.getWriter().print(new Gson().toJson(DBrole));//success;
					
				} else {
					response.getWriter().print(1);// �������;
				}
			} else {
				response.getWriter().print(1);// �ֻ��Ż����벻��Ϊ��;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(2);// �쳣����;
		}
	}
}
