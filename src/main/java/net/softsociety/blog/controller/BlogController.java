package net.softsociety.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.domain.Member;
import net.softsociety.blog.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	BlogService ser;

	@GetMapping("/blog/userList")
	public String userList(Model model) {
		List<Member> list = ser.selectUserList();
		model.addAttribute("list", list);
		
		return "blog/userList";
	}
	
	@GetMapping("/blog/user")
	public String blogByUser(String blogid, Model model) {
		List<Blog> blogByUser = ser.blogByUser(blogid);
		model.addAttribute("blogByUser", blogByUser);
		
		model.addAttribute("blogid", blogid);
		
		return "/blog/blogByUser";
	}
	
	@GetMapping("/blog/read")
	public String read(int blogseq, Model model) {
		Blog read = ser.read(blogseq);
		model.addAttribute("read", read);
		
		String blogid = read.getBlogid();
		model.addAttribute("blogid", blogid);
		model.addAttribute("blogseq", blogseq);
		
		return "/blog/read";
	}
	
	@GetMapping("/blog/write")
	public String write() {
		return "/blog/write";
	}
	
	@PostMapping("/blog/write")
	public String write(Blog blog, @AuthenticationPrincipal UserDetails user, RedirectAttributes rttr) {
		blog.setBlogid(user.getUsername()); // blog 객체에 blogid 설정.
		ser.write(blog);
		
		rttr.addAttribute("blogid", blog.getBlogid());
		return "redirect:/blog/user";
	}
	
	@ResponseBody
	@GetMapping("/blog/likecnt")
	public int likecnt(int blogseq) {
		int result = ser.likecnt(blogseq);
		
		Blog blog = ser.read(blogseq);
		int likecnt = blog.getLikecnt();
		return likecnt;
					
	}
	
	@GetMapping("/blog/update")
	public String update(int blogseq, Model model) {
		Blog read = ser.read(blogseq);
		model.addAttribute("read", read);
		
		return "blog/update";
	}
	
	@PostMapping("/blog/update")
	public String update(Blog blog, RedirectAttributes rttr) {
		ser.update(blog);
		
		rttr.addAttribute("blogseq", blog.getBlogseq());
		return "redirect:/blog/read";
	}
	
	@GetMapping("/blog/delete")
	public String delete(int blogseq, Model model, RedirectAttributes rttr) {
		Blog blog = ser.read(blogseq);
		rttr.addAttribute("blogid", blog.getBlogid());
		
		ser.delete(blogseq);
		return "redirect:/blog/user";
	}
	

}
