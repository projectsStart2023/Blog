package net.softsociety.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.blog.dao.BlogDAO;
import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.domain.Member;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogDAO dao;

	@Override
	public List<Member> selectUserList() {
		List<Member> list = dao.selectUserList();
		return list;
	}

	@Override
	public List<Blog> blogByUser(String blogid) {
		List<Blog> blog = dao.blogByUser(blogid);
		return blog;
	}


	@Override
	public Blog read(int blogseq) {
		Blog blog = dao.read(blogseq);
		return blog;
	}

	@Override
	public void write(Blog blog) {
		dao.write(blog);
	}

	@Override
	public int likecnt(int blogseq) {
		int result = dao.likecnt(blogseq);
		return result;
		
	}

	@Override
	public void update(Blog blog) {
		dao.update(blog);
	}
	
	@Override
	public void delete(int blogseq) {
		dao.delete(blogseq);
	}





}
