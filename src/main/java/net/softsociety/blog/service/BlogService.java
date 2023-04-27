package net.softsociety.blog.service;

import java.util.List;

import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.domain.Member;

public interface BlogService {
	public List<Member> selectUserList();

	public List<Blog> blogByUser(String blogid);

	public Blog read(int blogseq);

	public void write(Blog blog);

	public int likecnt(int blogseq);

	public void delete(int blogseq);

	public void update(Blog blog);
}
