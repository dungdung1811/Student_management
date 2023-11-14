package com.ra.model.dao;

import com.ra.dto.StudentDto;
import com.ra.ulti.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoIpm implements  IGenericDAO<StudentDto,Integer> {
    @Override
    public List<StudentDto> findAll() {
        Connection connection = null;
        connection = ConnectionDB.openConnection();

        List<StudentDto> list;
        try {
            String sql = "CALL PROC_GET_TALL_STUDENT()";
            CallableStatement cstm = connection.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(rs.getInt("id"));
                studentDto.setName(rs.getString("name"));
                studentDto.setBirthday(rs.getDate("birthday"));
                studentDto.setClassName(rs.getString("className"));
                list.add(studentDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return list;
    }

    @Override
    public Boolean create(StudentDto studentDto) {
        Connection connection = null;
        String sql = "CALL PROC_INSERT_STUDENT(?,?,?)";

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1,studentDto.getName());
            cstm.setDate(2,studentDto.getBirthday());
            cstm.setInt(3,studentDto.getClassId());
            int check = cstm.executeUpdate();
           if(check> 0){
               return true;
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }


        return false;
    }

    @Override
    public Boolean update(StudentDto studentDto, Integer id) {
        Connection connection = ConnectionDB.openConnection();

        try {
            String sql = "CALL  UPDATE_STUDENT_BY_ID(?,?,?,?)";
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setInt(1,id);
            cstm.setString(2,studentDto.getName());
            cstm.setDate(3,studentDto.getBirthday());
            cstm.setInt(4,studentDto.getClassId());

            int ckeck = cstm.executeUpdate();
            if(ckeck>0){
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }


        return false;
    }

    @Override
    public StudentDto findId(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        StudentDto studentDto = new StudentDto();

        try {
            String sql = "CALL  FIND_STUDENT_BY_ID(?)";
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setInt(1,id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()){
                studentDto.setId(rs.getInt("id"));
                studentDto.setName(rs.getString("name"));
                studentDto.setBirthday(rs.getDate("birthday"));
                studentDto.setClassName(rs.getString("class_name"));
                studentDto.setClassId(rs.getInt("class_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return studentDto ;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "CALL PROC_DELETE_STUDENT_BY_ID(?)";
        try {

            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setInt(1,id);
            cstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

    }
}
