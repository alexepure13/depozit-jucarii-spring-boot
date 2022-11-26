create table t_categories(
    id integer NOT NULL auto_increment,
    tipjucarii varchar(50),
    cantitate integer,
    primary key(id)
    );

create table t_toys(
    id integer NOT NULL auto_increment,
    nume varchar(50),
    producator varchar(50),
    varsta varchar(50),
    pret double,
    cantitate integer,
    category_id integer,
    primary key(id),
    foreign key (category_id) references t_categories(id)
);

create table login(
    id integer auto_increment,
    username varchar(50),
    password varchar(50)
);


