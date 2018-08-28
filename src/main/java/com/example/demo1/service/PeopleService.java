package com.example.demo1.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PeopleService {
    List<Map<String, Object>> getUsersList() throws SQLException;
    Map<String, Object> getUserInfo(int id);
    void updateUser (int id, Map<String, Object> values);
    void addUser(Map<String, Object> values);
    void deleteUser (int id);
}
