package com.servlet.cyclopedia;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/**
 * 管理后台更新一条数据
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CyclopediaService;
@WebServlet(name="UpdateCyclopedia",urlPatterns={"/UpdateCyclopedia"})
public class UpdateCyclopedia extends HttpServlet {

	private static final long serialVersionUID = -8883573834431602891L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}
    @Override
    protected void doPost(HttpServletRequest reqquest, HttpServletResponse response) throws ServletException, IOException {
       
    	reqquest.setCharacterEncoding("utf-8");
    	
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("application/json");
    	
    	Integer id	= Integer.parseInt(reqquest.getParameter("id"));//获取文章id
    	
        CyclopediaService  cyclopediaService  = new CyclopediaService();
         
         
         try {
        	 cyclopediaService.updataCyclopedia(id);
             response.getWriter().print(0);//修改成功			
		} catch (Exception e){
             e.printStackTrace();
             response.getWriter().print(1);//修改失败
		}
         
         
    }

} 
