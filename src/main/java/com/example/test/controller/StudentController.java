package com.example.test.controller;

import com.example.test.Entity.Student;
import com.example.test.common.MyRsp;
import com.example.test.common.PageParam;
import com.example.test.dao.StudentDao;
import com.example.test.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@Api(value = "/student",description = "这是一个查询所有学生的接口")
@Controller("studentController")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "这是一个获取所有学生的接口",notes = "查询所有学生")
    @ResponseBody
    @PostMapping("/list")
    public Object student(@RequestBody(required = false) PageParam<Student> pageParam) {
        return MyRsp.success(studentService.queryStudentList(pageParam));
    }

    @ApiOperation(value = "这是一个根据学生id获取学生的接口", notes = "查询某一个学生")
    @ResponseBody
    @GetMapping("/getUserById/{id}")
    public Object queryStudentById(@PathVariable("id") int id) {
        return MyRsp.success(studentService.getStudentById(id));
    }
    @ApiOperation(value = "插入一个学生信息的接口", notes = "插入条学生信息数据")
    @PostMapping("/addStudent")
    @ResponseBody
    public Object insertStudent(@RequestBody Student student) {
        return MyRsp.success(studentService.insert(student));
    }

}

