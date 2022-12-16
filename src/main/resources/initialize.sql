create table users
(
    id    int primary key not null ,
    pwd     varchar(30) not null,
    nickname     varchar(30) not null,
    -- is user or admin
    isAdmin     bool not null,
    userName    varchar(30) not null,
    -- id card or other identifier
    isIdCard        bool not null,
    idNum       varchar(30) not null,
    phone        varchar(11) not null,
    intro        varchar(100),
    city         varchar(30) not null,
    -- set automatically
    createTime  datetime not null ,
    reviseTime  datetime not null
);

-- "寻味道"请求信息
create table requests
(
    requestId  varchar(32) not null,
    userId     int not null,
    -- 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
    flavorType        int not null,
    city        varchar(30) not null,
    theme       varchar(30) not null,
    intro       varchar(200) not null,
    maxPrice    int not null,
    endDate     date not null,
    photo       varchar(100),
    createTime  datetime not null ,
    reviseTime  datetime not null ,
    -- 0:已完成 1:待响应 2:已取消 3:到期未达成
    curStatus       int not null
);

-- 请品鉴响应信息
create table responses
(
    id varchar(32) not null,
    requestId varchar(32) not null,
    respondUserId int not null,
    respondIntro varchar(100) not null,
    createTime  datetime not null ,
    reviseTime  datetime not null ,
    -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    state int not null
);



-- 成功明细表
create table bargains
(
    requestId int primary key auto_increment,
    requestUser int not null,
    respondUser int not null,
    city varchar(30) not null,
    successDate date not null
);

-- 中介收益汇总: 统计某个月不同的交易类型对应的收入
create table reports
(
    id varchar(32) primary key,
    yy int not null,
    mm int not null,
    -- 省-市
    city varchar(30) not null ,
    -- 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
    responseType int not null,
    -- 达成笔数
    respondNum int not null,
    totalMoney int not null
);

