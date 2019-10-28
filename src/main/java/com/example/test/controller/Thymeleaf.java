package com.example.test.controller;

import com.example.test.Entity.Student;
import com.example.test.common.PageParam;
import com.example.test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("thymeleaf")
@Controller("thymeleaf")
@Slf4j
public class Thymeleaf {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getlist")
    public Object getStudentList(HttpServletRequest request) {
        PageParam<Student>  pageParam = new PageParam<Student> (1, 5, new String[]{});
        List<Student> o = (List<Student>) studentService.queryStudentList(pageParam);
        request.setAttribute("stu", o);
        return "studentList";
    }

    @GetMapping("/delete/{id}")
    public Object deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/thymeleaf/getlist";
    }

    @GetMapping("/toUpdate/{id}")
    public Object toUpdate(HttpServletRequest request, @PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        request.setAttribute("student", student);
        return "update";
    }

    @PostMapping(value = "/update")
    public Object update(HttpServletRequest request, Student student) {
        studentService.updateStudentById(student);
        return "redirect:/thymeleaf/getlist";
    }

    @GetMapping(value = "/toInsert")
    public Object toInsert() {
        return "insert";
    }

    @PostMapping(value = "/insert")
    public Object insert( Student student) {
        studentService.insert(student);
        return "redirect:/thymeleaf/getlist";
    }

    @GetMapping(value = "/toSelect")
    public Object toSelect() {
        return "select";
    }

    @PostMapping(value = "/select")
    public Object select(HttpServletRequest request, @RequestParam("name") String name) {
        List<Student> student = studentService.selectByName(name);
        request.setAttribute("stu", student);
        return "studentList";
    }






}
