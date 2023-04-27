package net.softsociety.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.blog.dao.MemberDAO;
import net.softsociety.blog.domain.Member;

@Service
public class MemberSeriveImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public int join(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getBlogpwd());
		member.setBlogpwd(encodedPassword);
		
		int result = dao.join(member);
		
		return result;
	}

	@Override
	public boolean idCheck(String id) {
		boolean result = dao.idCheck(id);
		return result;
	}
	
	
}
