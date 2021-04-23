package com.green.cinemamanagement.dao;

import com.green.cinemamanagement.dbhelper.DBManager;
import com.green.cinemamanagement.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private static final String GET_ALL_USER="select * from user";
    private Connection connection= null;
    private ArrayList<User> listUser=new ArrayList<>();
    private DBManager dbManager=new DBManager();

    public ArrayList<User> getAllUser(){
        Statement statement=null;

        try {
            connection=dbManager.getDBManager();
            statement=connection.createStatement();

            ResultSet rs=statement.executeQuery(GET_ALL_USER);  
            while (rs.next()){
                int id=rs.getInt(1);
                String email=rs.getString(2);
                String pass=rs.getString(3);
                User user=new User(id,email,pass);
                listUser.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Get all user success!");
        return listUser;
    }
}
