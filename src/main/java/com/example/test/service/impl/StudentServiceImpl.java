package com.example.test.service.impl;

import com.example.test.Entity.Student;
import com.example.test.common.PageParam;
import com.example.test.dao.StudentDao;
import com.example.test.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public Object queryStudentList(PageParam<Student> pageParam  ) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        for (int i = 0; i < pageParam.getOrderParams().length; i++) {
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }

        List<Student> userList=studentDao.queryStudentList(pageParam.getModel());
        PageInfo<Student> userPageInfo = new PageInfo<Student>(userList);
        log.info(userPageInfo.toString());
        return userPageInfo.getList();
    }

    @CachePut(key = "#p0.id", value = "students")
    @Override
    public Object insert(Student student) {
        studentDao.insert(student);
        return studentDao.getStudentById(student.getId());
    }



    @Cacheable(key = "#p0",value = "students")
    @Override
    public Student getStudentById(int id) {

        return studentDao.getStudentById(id);
    }

    @Override
    public int updateStudentById(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(int id) {
        return studentDao.delete(id);
    }

    @Override
    public List<Student> selectByName(String name) {
        return studentDao.selectByName(name);
    }
}
