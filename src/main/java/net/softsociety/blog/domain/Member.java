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
public class Member {
	private String blogid;
	private String blogpwd;
	private String blogername;
	private int photo;
}
