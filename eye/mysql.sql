-- 来源网站表
create table if not exists res(
	id integer primary key auto_increment,-- 主键
    name varchar(20) not null, -- 网站名称 
    url varchar(200) not null -- 网站的网址
    );
-- 爬取地址表，主要针对网站的各个地址进行爬取
create table if not exists res_link(
	id integer primary key auto_increment,
    name varchar(20) not null,
    url varchar(200) not null,
    resid integer not null, -- 来源网站的id
    typeid integer 
	);
-- alert 文章表
create table if not exists alert(
	id integer primary key auto_increment,
    title varchar(80) not null,
    desc1 varchar(500) not null, -- 简单的表述
    content text not null,-- 文章内容
    url varchar(200) not null, -- 文章原网址
    res_link_id integer not null,-- 从网站的那个地址进行爬取的
    res_id integer not null,-- 网站的id,为了效率所以这样设计
    atype_id integer not null, -- 文章的分类
    hot integer  default 0,
    createtime timestamp default CURRENT_TIMESTAMP,
    img varchar(300), -- 图片地址
    alerttime varchar(20),
    param1 varchar(200), -- 保留参数1
    param2 varchar(200), -- 保留参数2
    param3 varchar(200), -- 保留参数3
    param4 varchar(200), -- 保留参数4
    param5 varchar(200) -- 保留参数5
);

-- 文章分类表
create table if not exists alertType(
	id integer primary key auto_increment,
    name varchar(20),
    param1 varchar(200), -- 保留参数1
    param2 varchar(200) -- 保留参数2
);

-- 相应的css样式表
create table if not exists css(
	id integer primary key auto_increment, -- 主键	
	res_link_id integer not null,-- 分类来源的id
	csslink varchar(500) not null-- css link语句
);
--创建用户表
create table if not exists users(
	username varchar(20) not null,
	password varchar(32) not null,
	disabled int not null default 1
);
-- 用户登陆日志表
create table if not exists userlog(
	id integer primary key auto_increment, -- 主键	
	username varchar(20) not null, -- 登陆的用户名
	logintime timestamp default CURRENT_TIMESTAMP,-- 登陆的时间
	ip varchar(20) not null, -- 登陆的IP
	issuccess integer not null -- 时候登陆成功
);
--意见与建议的表
create table if not exists commend(
	id integer primary key auto_increment, -- 主键
	email varchar(30) not null, -- 建议者邮箱
	nickname varchar(20) , -- 建议者昵称
	commend varchar(500) not null, -- 建议的详细
	createtime timestamp not null default CURRENT_TIMESTAMP
);
--APP版本记录
create table if not exists appversion(
	id integer  primary key auto_increment, -- 主键
	version integer, -- app最新的版本
	url varchar(500) not null, -- 新版本的下载地址
	des varchar(500) not null, -- 新版本描述
	nametype integer -- 名称，Android，IOS
);

---添加文章的存储过程
CREATE  PROCEDURE `alertPro`(in title varchar(80),in desc1 varchar(500),in content text,
in url varchar(200),in res_link_id integer,in res_id integer,in atype_id integer,
in img varchar(300),in alerttime varchar(20))
BEGIN
DECLARE count INT DEFAULT 0;
select count(*) INTO count from alert a where a.title=title or a.url=url;
IF count=0 THEN
INSERT INTO alert(title,desc1,content,url,res_link_id,res_id,atype_id,hot,img,alerttime) VALUES
(title,desc1,content,url,res_link_id,res_id,atype_id,0,img,alerttime);
ELSE 
select '已经存在';
END IF;
END


drop table if exists res;
drop table if exists res_link;
drop table if exists alert;
drop table if exists alertType;
drop table if exists css;
drop table if exists users;
drop table if exists userlog;
drop table if exists commend;
