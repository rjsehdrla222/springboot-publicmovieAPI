drop table movies;
CREATE TABLE movies
(
    id    BIGINT(20) NOT NULL,
    title CHAR(40) NOT NULL,
    ranks INT(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE weekmovies
(
    id    BIGINT(20) NOT NULL,
    title CHAR(40) NOT NULL,
    ranks INT(20) not null,
    PRIMARY KEY (id)
);

CREATE TABLE totalmovies
(
    id      BIGINT(20) AUTO_INCREMENT,
    title   VARCHAR(40) NOT NULL,
    ranks   INT(20) NOT NULL,
    content VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE totalmovies
    ADD UNIQUE (title);

CREATE TABLE member
(
    id       BIGINT(20) AUTO_INCREMENT,
    name     CHAR(20) NOT NULL,
    pw       CHAR(20) NOT NULL,
    loginame CHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recommended
(
    id       BIGINT(20) AUTO_INCREMENT,
    title    CHAR(20) NOT NULL,
    loginame CHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE comment
(
    id      BIGINT(20) AUTO_INCREMENT,
    title   CHAR(30)     NOT NULL,
    name    CHAR(20)     NOT NULL,
    pw      CHAR(20)     NOT NULL,
    comment VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

select *
from comment;

insert into comment (title, name, pw, comment)
values ('이터널스', '김동건', '1234', '재밌어요');

insert into comment (title, name, pw, comment)
values ('이터널스', '일동건', '1234', '재밌더라고요');

select *
from comment
where title = '이터널스';

select id, pw
from comment
where name = '이동건';

CREATE TABLE drama
(
    id    BIGINT(20) NOT NULL,
    title CHAR(40) not null,
    ranks INT(20) not NULL,
    primary key (id)
);

UPDATE totalmovies
SET ranks=5
WHERE id = 5;

drop table weekmovies;
drop table drama;
drop table totalmovies;

select *
from totalmovies;

select *
from recommended;

insert into recommended (title, loginame)
values ('이터널스', 'rjsehdrla');

delete
from recommended
where id = '3';

select *
from drama;

select *
from weekmovies;

select *
from movies;

select *
from member;

delete
from movies;