package com.servlet.collect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CollectService;
@WebServlet(name="DeleteCyclopediaById",urlPatterns={"/DeleteCyclopediaById"})
public class DeleteCyclopediaById extends HttpServlet {

	/**
	 * 管理后台通过文章id删除文章
	 */
	private static final long serialVersionUID = -7286801364475585212L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	Integer id = Integer.parseInt(request.getParameter("id"));//文章id
   
	CollectService  collectService  = new CollectService();
	
	try {
	int msg = collectService.deleteCyclopediaById(id);
		if(1==msg){
			response.getWriter().print(0);//删除成功		
			}
	} catch (Exception e) {
		response.getWriter().print(1);//删除失败
	}
	}
	
}
