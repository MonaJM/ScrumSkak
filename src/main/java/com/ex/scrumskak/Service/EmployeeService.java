// Service is used to the logic.

package com.ex.scrumskak.Service;

import com.ex.scrumskak.Model.Employee;
import com.ex.scrumskak.Repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepo employeeRepo;
    public List<Employee> fetchAllEmployees()
    {
        return employeeRepo.fetchAllEmployees();
    }

    public List<Employee> fetchAllChairman()
    {
        return employeeRepo.fetchAllChairman();
    }

    public List<Employee> fetchAllTeamleader()
    {
        return employeeRepo.fetchAllTeamleader();
    }

    public List<Employee> fetchAllCashier()
    {
        return employeeRepo.fetchAllCashier();
    }

    public void addEmpolyee(Employee employee) {
        employeeRepo.addEmployee(employee);
    }
}
