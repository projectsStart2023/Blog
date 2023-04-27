DROP TABLE blog_member;
DROP TABLE blog_board;

CREATE TABLE blog_member
(   
    blogid          varchar2(20)        primary key,    -- 회원ID
    blogpwd         varchar2(100)       not null,       -- 비밀번호
    blogername      varchar2(20)        not null,       -- 회원 이름 
    photo           number(1) default 1 check(photo in (1,2,3,4)),
    enabled         number(1) default 1 
                    check(enabled in (0,1)),
    rolename        varchar2(20) default 'ROLE_USER'
                    check(rolename in ('ROLE_USER','ROLE_ADMIN'))
);

CREATE TABLE blog_board
(   
    blogseq         number          primary key,    
    blogid          varchar2(20)    references blog_member(blogid) on delete cascade, 
    title           varchar2(200)   not null,       -- 글 제목
    blogtext        varchar2(2000)  not null,       -- 글 내용      
    regdate         date default sysdate,           -- 작성 날짜
    likecnt         number default 0                -- 해당 글에 대한 추천수
);

CREATE SEQUENCE blog_board_seq; -- 블로그 글의 일련번호에 사용할 시퀀스 객체

select * from blog_member;
select * from blog_board;