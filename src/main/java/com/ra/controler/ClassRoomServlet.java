package com.ra.controler;

import com.ra.model.entity.ClassRoom;
import com.ra.model.entity.Student;
import com.ra.model.service.ClassRoomService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ClassRoomServlet", value = "/classroomservlet")
public class ClassRoomServlet extends HttpServlet {
    private ClassRoomService classRoomService;
    @Override
    public void init() {
        classRoomService =new ClassRoomService();


    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        viewAllClass(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    public void destroy() {
        super.destroy();
    }



    public void viewAllClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClassRoom> list = classRoomService.findAll();
        req.setAttribute("list",list);
        System.out.println(list);
        req.getRequestDispatcher("views/ClassRoom.jsp").forward(req,resp);
    }

}
