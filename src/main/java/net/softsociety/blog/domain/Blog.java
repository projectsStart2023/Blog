package net.softsociety.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Blog {
	private int blogseq;
	private String blogid;
	private String title;
	private String blogtext;
	private String regdate;
	private int likecnt;
	
}
