// Controls the routing in home.html

package com.ex.scrumskak.Controller;

import com.ex.scrumskak.Model.Member;
import com.ex.scrumskak.Service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController
{
    @Autowired
    MemberService memberService;

    @RequestMapping("/create_member")
    public String create_member(@ModelAttribute Member member)
    {
        memberService.addMember(member);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String show_user_profile(Model member)
    {
        //member.addAttribute("member", memberService.fetchAllMembers());
        return "profile";
    }

    @GetMapping("/member_list")
    public String show_member_list(Model member)
    {
        member.addAttribute("members", memberService.fetchAllMembers());
        return "member_list";
    }

    @GetMapping("/create_member")
    public String create_member()
    {
        return "create_member";
    }
}
