package net.softsociety.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.domain.Member;

@Mapper
public interface BlogDAO {
	public List<Member> selectUserList();

	public List<Blog> blogByUser(String blogid);

	public Blog read(int blogseq);

	public void write(Blog blog);

	public int likecnt(int blogseq);

	public void delete(int blogseq);

	public void update(Blog blog);
}
