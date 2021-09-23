package com.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;
import java.util.Map;

@RestController
public class jdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    public List<Map<String,Object>> QueryList(){
        String sql1="select * from employee";
        List<Map<String, Object>>maps=jdbcTemplate.queryForList(sql1);
        return maps;
    }


}
