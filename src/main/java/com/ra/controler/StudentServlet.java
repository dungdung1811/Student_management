package com.ra.controler;

import com.ra.dto.StudentDto;
import com.ra.model.entity.ClassRoom;
import com.ra.model.service.ClassRoomService;
import com.ra.model.service.StudentService;

import java.io.*;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/studentservlet")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    private ClassRoomService classRoomService;

    @Override
    public void init() {
        studentService = new StudentService();
        classRoomService = new ClassRoomService();


    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            viewAllStudent(req, resp);
            return;
        }
        List<ClassRoom> classRooms = classRoomService.findAll();
        switch (action) {
            case "add":

                req.setAttribute("classRooms", classRooms);
                req.getRequestDispatcher("views/student-add.jsp").forward(req, resp);
                break;

            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                studentService.delete(idDelete);
                resp.sendRedirect("studentservlet");

                break;

            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                StudentDto studentDto = studentService.findId(idEdit);
                req.setAttribute("studentDto", studentDto);
                req.setAttribute("classRooms", classRooms);
                req.getRequestDispatcher("views/student-edit.jsp").forward(req, resp);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String studentName = req.getParameter("fullName");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        if (action == null) {
            studentService.create(new StudentDto(studentName, birthday, classId));
            resp.sendRedirect("/studentservlet");
        } else {
            switch (action){
                case "update":
                   int updateId = Integer.parseInt(req.getParameter("id"));
                   StudentDto studentDto =new StudentDto();
                   studentDto.setName(studentName);
                   studentDto.setBirthday(birthday);
                   studentDto.setClassId(classId);
                   studentService.update(studentDto,updateId);
                    viewAllStudent(req,resp);
                    break;
            }
        }



    }

    @Override
    public void destroy() {
        super.destroy();
    }

    public void viewAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentDto> list = studentService.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("views/student.jsp").forward(req, resp);
    }
}

