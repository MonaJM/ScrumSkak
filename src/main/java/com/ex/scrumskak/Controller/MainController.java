// Controls the routing in home.html

package com.ex.scrumskak.Controller;

import com.ex.scrumskak.Service.EmployeeService;
import com.ex.scrumskak.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    @Autowired
    MemberService memberService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model member, Model employee)
    {
        member.addAttribute("members", memberService.fetchAllMembers());
        employee.addAttribute("employees", employeeService.fetchAllEmployees());
        return "index";
    }

    @GetMapping("/create_team")
    public String show_create_team_page(Model employee)
    {
        employee.addAttribute("employees", employeeService.fetchAllTeamleader());
        return "create_team";
    }
}
