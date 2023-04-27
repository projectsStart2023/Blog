package net.softsociety.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.softsociety.blog.domain.Member;
import net.softsociety.blog.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ser;

	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@PostMapping("/member/join")
	public String join(Member member) {
		int result = ser.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		return "redirect:/logout";
	}
}
