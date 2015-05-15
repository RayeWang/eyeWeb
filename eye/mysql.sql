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
    resid integer not null -- 来源网站的id
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
    hot integer not null default 0,
    createtime timestamp not null default CURRENT_TIMESTAMP,
    alerttime varchar(20) not null,
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

drop table if exists res;
drop table if exists res_link;
drop table if exists alert;
drop table if exists alertType;

select CURRENT_TIMESTAMP

