package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * 数据库连接
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月14日
 */
public class DBUtil {
	
	public static int sum = 0;
	
	
	public static final String url = "jdbc:mysql://192.168.1.11/angelchildrens?characterEncoding=utf8&useSSL=false";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String username = "sungoudan";  
    public static final String password = "sungoudan";
  
    
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    
    public DBUtil(String sql) {  
    	try {
    		
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            
            if(conn != null){
            	System.out.println("Test:Connection successful!"+sum++);
            	pst = conn.prepareStatement(sql);
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    
    
    public void close() {
        try {  
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
    
}
