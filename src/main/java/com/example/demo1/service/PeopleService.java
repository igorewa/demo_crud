package com.example.demo1.service;

import java.util.List;
import java.util.Map;

public interface PeopleService {
    List<Map<String, Object>> getUsersList() throws Exception;
    Map<String, Object> getUserInfo(int id);
}
