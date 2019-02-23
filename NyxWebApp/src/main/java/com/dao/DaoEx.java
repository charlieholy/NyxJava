package com.dao;

import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoEx {

    public static void main(String[] args) {
        insert();
        query();;
    }

    private static void insert(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("init");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/new_schema",
                    "root",
                    "123456"
            );
            System.out.println("conn..");
            stmt = conn.createStatement();
            System.out.println("after conn..");
            String sql2 = "insert into users (uname,uage) values('bb',33)";
            String sql =  "insert into users(uname uage) values('bb',33)";
            Object o = stmt.executeUpdate(sql2);
            System.out.println(JSON.toJSONString(o));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static void query(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("init");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/new_schema",
                    "root",
                    "123456"
            );
            System.out.println("conn..");
            stmt = conn.createStatement();
            System.out.println("after conn..");
            String sql2 = "select * from  users ";
            String sql =  "insert into users(uname uage) values('bb',33)";
            ResultSet o = stmt.executeQuery(sql2);
            //System.out.println(JSON.toJSONString(o));
            while (o.next()){
                String id = o.getString(1);
                String uname  = o.getString(2);
                Integer uage = o.getInt(3);
                System.out.println("id: " + id + " uname: " + uname +
                        " uage " + uage);

            }
            System.out.println("over...");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
