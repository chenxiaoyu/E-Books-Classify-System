--Create database ebook_system;
use ebook_system;

--�����鼮�б�
create table Books
(
	bid varchar(15) primary key,	--�鼮��id
	bname varchar(50) not null,		--�������ǿգ�
	ISBN varchar(13),				--ISBN
	author varchar(16),				--����
	branch varchar(8),				--������
	location varchar(60) not null	--�鼮����λ�ã��ǿգ�
)

--�����û��б�
create table Users
(
	uname varchar(20) primary key,	--�û���
	upwd varchar(30) not null,		--����
	ip	varchar(15),				--�û���¼��IP��ַ
	signature varchar(50)		--����ǩ��
)

--���������б�
create table Friends
(
	user1 varchar(20) foreign key references Users(uname),
	user2 varchar(20) foreign key references Users(uname),
	constraint primary_key primary key (user1,user2)
)