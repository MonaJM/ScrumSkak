// Controls the routing in home.html

package com.ex.scrumskak.Controller;

import com.ex.scrumskak.Model.Employee;
import com.ex.scrumskak.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/create_employee")
    public String create_employee(@ModelAttribute Employee employee)
    {
        employeeService.addEmpolyee(employee);
        return "redirect:/";
    }

    @GetMapping("/create_employee")
    public String show_create_page()
    {
        return "create_employee";
    }
}
