package com.example.test.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public interface TaskDao {

    @Select("SELECT cron_expression FROM cron WHERE id=#{id}")
    public String getCron(int id);
}
