--Create database ebook_system;
use ebook_system;

--创建书籍列表
create table Books
(
	bid varchar(15) primary key,	--书籍的id
	bname varchar(50) not null,		--书名（非空）
	ISBN varchar(13),				--ISBN
	author varchar(16),				--作者
	branch varchar(8),				--分类名
	location varchar(60) not null	--书籍保存位置（非空）
)

--创建用户列表
create table Users
(
	uname varchar(20) primary key,	--用户名
	upwd varchar(30) not null,		--密码
	ip	varchar(15),				--用户登录的IP地址
	signature varchar(50)		--个性签名
)

--创建朋友列表
create table Friends
(
	user1 varchar(20) foreign key references Users(uname),
	user2 varchar(20) foreign key references Users(uname),
	constraint primary_key primary key (user1,user2)
)