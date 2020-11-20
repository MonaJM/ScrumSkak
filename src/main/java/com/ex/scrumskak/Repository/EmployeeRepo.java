// reposiroty is for database communication to send data and receive data. (Working with SQL queries)
package com.ex.scrumskak.Repository;

import com.ex.scrumskak.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Employee> fetchAllEmployees()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public List<Employee> fetchAllChairman()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Employee WHERE type = 'chairman'";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public List<Employee> fetchAllTeamleader()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Employee WHERE type = 'teamleader'";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public List<Employee> fetchAllCashier()
    {
        // This is where the actual SQL communication would have been done!

        String sql ="SELECT * FROM Employee WHERE type = 'cashier'";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (type, fName, lName, uName, pwd) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, employee.getType(), employee.getfName(), employee.getlName(), employee.getuName(), employee.getPwd());

        //String sql = "INSERT INTO Member ('fName', 'lName', 'membership_type', 'status', 'created_date', 'expire_date') VALUES ()";
    }
}