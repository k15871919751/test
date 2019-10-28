package com.example.test.service;


import com.example.test.Entity.Student;
import com.example.test.common.PageParam;

import java.util.List;

public interface StudentService {
   Object queryStudentList(PageParam<Student> pageParam);//查询所有

   Object insert(Student student); //插入一条

   Student getStudentById(int id); //获取一条

   int updateStudentById(Student student);//更新

   int delete(int id);//删除

   List<Student> selectByName(String name);
}
