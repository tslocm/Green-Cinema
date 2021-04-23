package com.green.cinemamanagement.dao;

import com.green.cinemamanagement.dbhelper.DBManager;
import com.green.cinemamanagement.entity.Staff;

import java.sql.*;
import java.util.ArrayList;

public class StaffDAO {

    private static final String GET_ALL_STAFT="select * from staft";
    private static final String ADD_STAFT="insert Staft(fullName,gender,address,phone) values(?,?,?,?)";
    private Connection connection=null;
    private ArrayList<Staff> listStaft=new ArrayList<>();
    private DBManager dbManager=new DBManager();

    public StaffDAO(){

    }

    public ArrayList<Staff> getAllStaff(){
        Statement statement=null;

        try {
            connection=dbManager.getDBManager();
            statement=connection.createStatement();

            ResultSet rs=statement.executeQuery(GET_ALL_STAFT);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String gender=rs.getString(3);
                String address=rs.getString(4);
                String phone=rs.getString(5);
                Staff staft=new Staff(id,name,gender,address,phone);
                listStaft.add(staft);
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
        System.out.println("Get all staft success!");
        return listStaft;
    }

    public void insertStaff(Staff staft){
        PreparedStatement preparedStatement=null;

        try {
            connection=dbManager.getDBManager();
            preparedStatement = connection.prepareStatement(ADD_STAFT);
            preparedStatement.setString(1,staft.getFullName());
            preparedStatement.setString(2,staft.getGender());
            preparedStatement.setString(3,staft.getAddress());
            preparedStatement.setString(4,staft.getPhone());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException : "+e.getMessage());
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("Add Employee success! ");
    }
}
