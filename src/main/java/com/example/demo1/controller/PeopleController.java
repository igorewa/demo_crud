package com.example.demo1.controller;


import com.example.demo1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

//    @RequestMapping(value = "/user_list", method = RequestMethod.POST, produces = "application/json")
    @GetMapping(value = "/user_list")
    @ResponseBody
    public List<Map<String, Object>> getUserList() throws Exception {
        return peopleService.getUsersList();
    }

//    @RequestMapping(value = "/user_info/{id}", method = RequestMethod.POST, produces = "application/json")
    @GetMapping(value = "/user_info/{id}")
    @ResponseBody
    public Map<String, Object> getUserInfo(@PathVariable(value = "id") int id) throws Exception {
        return peopleService.getUserInfo(id);
    }
}
