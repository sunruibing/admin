package com.servlet.cylopedia;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
/**
 * 管理后台添加文章
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Cyclopedia;
import com.service.CyclopediaService;
import com.util.DateUtil;
@WebServlet(name="AddCylopedia",urlPatterns={"/AddCylopedia"})
public class AddCylopedia extends HttpServlet {

	private static final long serialVersionUID = -7607821866418974601L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		String icon = request.getParameter("url1");//文章图片
		String cover = request.getParameter("url2");//缩略图
		String title = request.getParameter("title");//文章标题
		String content = request.getParameter("note");//文章内容
		
		Cyclopedia cyclopedia = new Cyclopedia();
		CyclopediaService  cyclopediaService  = new CyclopediaService();
		try {
			cyclopedia.setIcon(icon);
			cyclopedia.setCover(cover);
			cyclopedia.setTitle(title);
			cyclopedia.setContent(content);
			cyclopedia.setTime(DateUtil.DateToString(new Date()));
			cyclopediaService.insertCyclopedia(cyclopedia);
            
			response.getWriter().print(0);//添加成功
		} catch (Exception e) {
			response.getWriter().print(1);//添加失敗
		}
	}
}
