package com.example.test.dao;

import com.example.test.Entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public interface StudentDao {
    @Select("SELECT * FROM student")
    List<Student> queryStudentList(Student student); //查找所有学生信息

    @Insert("INSERT into student(name,reg_no,grade,card_no) VALUES(#{name},#{reg_No},#{grade},#{card_No})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Student student); //插入一条学生信息

    @Select("SELECT * FROM student WHERE id=#{id}")
    Student getStudentById(int id); //获取一个学生的信息

    @Update("UPDATE student SET name=#{name} WHERE id=#{id}")
    int update(Student student);

    @Delete("DELETE FROM student WHERE id=#{id}")
    int delete(int id);

    @Select("SELECT * FROM student WHERE name like '%${name}%'")
    List<Student> selectByName(String name);
}
