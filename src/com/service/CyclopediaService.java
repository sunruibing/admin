package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.po.Cyclopedia;
import com.util.DBUtil;



/**
 * 百科模块
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
public class CyclopediaService {
	
    
	//根据分类id查询品格与安全、营养保健、育儿知识列表
	public List<Cyclopedia> queryCylopediaList(Integer categoryId) throws SQLException{
		
		String sql = "SELECT id,icon,title,content,time FROM cyclopedia WHERE category_id = "+categoryId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		List<Cyclopedia> list = new ArrayList<Cyclopedia>();

		ResultSet result = null;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				Integer id = result.getInt("id");
				String icon = result.getString("icon");
				String title = result.getString("title");
				String content = result.getString("content");
				String time = result.getString("time");
				
				Cyclopedia cyclopedia = new Cyclopedia();
				cyclopedia.setId(id);
				cyclopedia.setIcon(icon);
				cyclopedia.setTitle(title);
				cyclopedia.setContent(content.substring(0, content.length()>20?20:content.length()));//截取部分文章内容
				cyclopedia.setTime(time);
				
				list.add(cyclopedia);
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
	//根据文章id查询内容详情
	public Cyclopedia queryCyclopediaById(Integer cyclopediaId) throws SQLException{
		
		String sql = "SELECT icon,title,content,time FROM cyclopedia WHERE id = "+cyclopediaId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		Cyclopedia cyclopedia = new Cyclopedia();
		
		ResultSet result = null;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				cyclopedia.setIcon(result.getString("icon"));
				cyclopedia.setTitle(result.getString("title"));
				cyclopedia.setContent(result.getString("content"));
				cyclopedia.setTime(result.getString("time"));
				
			}
			return cyclopedia;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return cyclopedia;
	}
	
	
	
	//查询所有科室
	public List<Map<String, String>> querySectionList() throws SQLException {
		
		String sql = "select id, name, icon1, icon2 from section";
		DBUtil dbUtil = new DBUtil(sql);

		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		ResultSet result = null;
		try {
			result = dbUtil.pst.executeQuery();

			while (result.next()) {
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", result.getString("name"));
				map.put("icon1", result.getString("icon1"));
				map.put("icon2", result.getString("icon2"));

				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
	//随机查询两条记录
	public List<Cyclopedia> queryCyclopediaRandomTwo() throws SQLException{
		
		String sql = " select id,icon,title,content,time from cyclopedia order by Rand() limit 2 ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;

		
		List<Cyclopedia> list = new ArrayList<Cyclopedia>();
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				Cyclopedia cyclopedia = new Cyclopedia();
				cyclopedia.setId(result.getInt("id"));
				cyclopedia.setIcon(result.getString("icon"));
				cyclopedia.setTitle(result.getString("title"));
				cyclopedia.setContent(result.getString("content"));
				cyclopedia.setTime(result.getString("time"));
				
				list.add(cyclopedia);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	/*管理后台获取文章列表*/
	public List<Map<String, Object>> quireCyclopedia() throws SQLException {

		String sql = "SELECT id,icon,title,content,time FROM cyclopedia";
		DBUtil dbUtil = new DBUtil(sql);

		ResultSet result = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			result = dbUtil.pst.executeQuery();

			while (result.next()) {
                             
				Integer id  = result.getInt("id");
				String icon = result.getString("icon");
				String title = result.getString("title");
				String content = result.getString("content");
				String time = result.getString("time");

				Map<String, Object> map = new HashMap<String, Object>();
				      
					  map.put("id", id);
				      map.put("icon", icon);
				      map.put("title", title);
				      map.put("content", content);
				      map.put("time", time);
				      
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close();
			result.close();
		}

		return list;
	}
	//根据id修改文章
	public int updataCyclopedia(Integer id){
		
		String sql = " UPDATE cyclopedia SET  WHERE id = "+id+"";
		DBUtil dbUtil = new DBUtil(sql);
		try {
			dbUtil.pst.executeUpdate();
			return 1;//success
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;//error
		} finally{
			if(dbUtil != null)dbUtil.close();
		}
	}
		
	//删除一段时间的用药提醒
		public int deleteRemindListByTimeStamp(String timeStamp){
			
			String sql = " delete from remind where timestamp = "+"'"+timeStamp+"'"+" ";
			DBUtil dbUtil = new DBUtil(sql);
			
			
			try {
				dbUtil.pst.executeUpdate();
				return 1;//success
			} catch (SQLException e) {
				e.printStackTrace();
				return 2;//error
			} finally{
				if(dbUtil != null)dbUtil.close();
			}
		}
	
	
}
