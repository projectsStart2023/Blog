package net.softsociety.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.blog.domain.Member;

@Mapper
public interface MemberDAO {
	public int join(Member member);

	public boolean idCheck(String id);
}
