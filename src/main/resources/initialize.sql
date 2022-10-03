create table users
(
    id    int primary key auto_increment,
    nickname     varchar(30) not null unique ,
    password     varchar(30) not null,
    -- is user or admin
    is_admin     bool not null,
    user_name    varchar(30) not null,
    -- id card or other identifier
    is_id        bool not null,
    id_num       varchar(30) not null,
    phone        varchar(11) not null,
    -- vip or normal user
    is_vip       bool not null,
    intro        varchar(100),
    city         varchar(30) not null,
    -- set automatically
    create_time  timestamp not null ,
    revise_time  timestamp not null
);

-- "寻味道"请求信息
create table requests
(
    request_id  int primary key auto_increment,
    user_id     int not null,
    -- 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
    flavor_type        int not null,
    city        varchar(30) not null,
    theme       varchar(30) not null,
    intro       varchar(200) not null,
    max_price   int not null,
    end_date    date not null,
    photo       varchar(100),
    create_time timestamp not null ,
    revise_time timestamp not null ,
    -- 0:已完成 1:待响应 2:已取消 3:到期未达成
    status      int not null
);
-- 请品鉴响应信息
create table responses
(
    id int primary key auto_increment,
    request_id int not null,
    respond_user_id int not null,
    respond_intro varchar(100) not null,
    respond_date date not null ,
    revise_date date not null ,
    -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    status int not null
);
-- 成功明细表
create table bargains
(
    request_id int primary key,
    request_user int not null,
    respond_user int not null,
    city varchar(30) not null,
    success_date date not null
);
-- 中介收益汇总: 统计某个月不同的交易类型对应的收入
create table reports
(
    id int primary key auto_increment,
    year int not null,
    month int not null,
    -- 省-市
    city varchar(30) not null ,
    -- 0:请品鉴 1:寻味道
    response_type int not null,
    respond_num int not null,
    total_money int not null
);