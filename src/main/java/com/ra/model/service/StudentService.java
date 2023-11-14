package com.ra.model.service;

import com.ra.dto.StudentDto;
import com.ra.model.dao.ClassRoomDAOIpm;
import com.ra.model.dao.StudentDaoIpm;
import com.ra.model.entity.Student;

import java.util.List;

public class StudentService implements  IGenericService<StudentDto,Integer>{
    private final StudentDaoIpm studentDaoIpm = new StudentDaoIpm();

    @Override
    public List<StudentDto> findAll() {
        return studentDaoIpm.findAll();
    }

    @Override
    public Boolean create(StudentDto studentDto) {
        return studentDaoIpm.create(studentDto);
    }

    @Override
    public Boolean update(StudentDto studentDto, Integer integer) {
        return studentDaoIpm.update(studentDto,integer);
    }

    @Override
    public StudentDto findId(Integer id) {
        return studentDaoIpm.findId(id);
    }

    @Override
    public void delete(Integer id) {
        studentDaoIpm.delete(id);
    }
}
