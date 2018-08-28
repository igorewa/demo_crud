package com.example.demo1.controller;


import com.example.demo1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/user_list")
    @ResponseBody
    public List<Map<String, Object>> getUserList() throws SQLException {
        return peopleService.getUsersList();
    }

    @GetMapping(value = "/user_info/{id}")
    @ResponseBody
    public Map<String, Object> getUserInfo(@PathVariable(value = "id") int id) throws Exception {
        return peopleService.getUserInfo(id);
    }
//TODO прилетает JSON с морды. распарсить в Map и отправить в сервис.
//TODO дописать это добро в двух методах ниже
//    @GetMapping(value = "/update_user/{id}")
//    @ResponseBody
//    public void updateUser(@PathVariable(value = "id") int id) {
//        peopleService.updateUser(id, values);
//    }
//
//    @GetMapping(value = "/add_user/{id}")
//    @ResponseBody
//    public void addUser(@PathVariable(value = "id") int id) {
//        peopleService.addUser(values);
//    }

    @GetMapping(value = "/delete_user/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable(value = "id") int id) {
        peopleService.deleteUser(id);
    }
}
