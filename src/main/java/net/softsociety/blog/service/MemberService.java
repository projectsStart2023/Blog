package net.softsociety.blog.service;

import net.softsociety.blog.domain.Member;

public interface MemberService {

	public int join(Member member);

	public boolean idCheck(String id);

}
