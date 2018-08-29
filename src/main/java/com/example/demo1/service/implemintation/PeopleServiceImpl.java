package com.example.demo1.service.implemintation;

import com.example.demo1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final static String INSERT_NEW_USER = "";
    private final static String GET_USER_LIST = "SELECT p.id,p.name FROM people p";
    private final static String GET_USER_BY_ID = "SELECT p.id, p.name, p.phone, a.country, a.index ,a.city, a.street, a.house, wp.company_name, wp.role FROM people p LEFT JOIN addresses a ON p.addressId = a.address_id LEFT JOIN work_place wp ON p.workId = wp.work_place_id WHERE p.id = ?";
    private final static String UPDATE_USER_DATA = "";
    private final static String DELETE_USER = "DELETE FROM people WHERE id = ?";


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Map<String, Object>> getUsersList() throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForList(GET_USER_LIST);
    }

    @Override
    public Map<String, Object> getUserInfo(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForMap(GET_USER_BY_ID, id);
    }

    @Override
    public void updateUser(int id, Map<String, Object> values) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(UPDATE_USER_DATA, values);
    }

    @Override
    public void addUser(Map<String, Object> values) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(INSERT_NEW_USER, values);
    }

    @Override
    public void deleteUser(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(DELETE_USER, id);
    }
}
