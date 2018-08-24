package com.example.demo1.service.implemintation;

import com.example.demo1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final static String GET_USER_LIST = "SELECT p.id,p.name FROM people p";
    private final static String GET_USER_BY_ID = "SELECT * FROM people p WHERE p.id = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Map<String, Object>> getUsersList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForList(GET_USER_LIST);
    }

    @Override
    public Map<String, Object> getUserInfo(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForMap(GET_USER_BY_ID, id);
    }
}
