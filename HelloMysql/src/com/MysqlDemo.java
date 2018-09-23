package com;

import java.sql.*;



/**
 * @author baijia
 *
 */
public class MysqlDemo {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";


    static final String USER = "root";
    static final String PASS = "root";
    
    public static int msqlConnect(String inputUser,String inputPassword)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT *FROM register where user=? and password =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, inputUser);
            ps.setString(2, inputPassword);
            System.out.println(ps);


            ResultSet rs = ps.executeQuery();
        
            // 展开结果集数据库
            if(rs.next())
            {
                rs.close();
                stmt.close();
                conn.close();
                return 1;
            }
            else {
                rs.close();
                stmt.close();
                conn.close();
                return 0;
            }


            
        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }finally{
            
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return 0;

    }


}
