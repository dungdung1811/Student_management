package com.ra.model.service;

import com.ra.model.dao.ClassRoomDAOIpm;
import com.ra.model.entity.ClassRoom;

import java.util.List;

public class ClassRoomService implements  IGenericService<ClassRoom,Integer>{
private final  ClassRoomDAOIpm classRoomDAOIpm = new ClassRoomDAOIpm();

    @Override
    public List<ClassRoom> findAll() {
        return classRoomDAOIpm.findAll();
    }

    @Override
    public Boolean create(ClassRoom classRoom) {
        return null;
    }

    @Override
    public Boolean update(ClassRoom classRoom, Integer integer) {
        return null;
    }

    @Override
    public ClassRoom findId(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
