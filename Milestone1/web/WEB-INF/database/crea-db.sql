/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lorec
 * Created: 14-mag-2018
 */

create table utente(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100) not null,
    password varchar(100) not null,
    urlImg varchar(100),
    isAuthor integer
);

create table notizia(
    id serial primary key,
    titolo varchar(200) not null,
    content varchar(2000),
    img varchar(200),
    autore bigint unsigned references utente(id) on delete cascade
                                                 on update cascade,
    categoria integer
);

create table commenti(
    commentID serial primary key,
    commentAuthor bigint unsigned references utente(id) on delete cascade 
                                                        on update cascade,
    newsID bigint unsigned references notizia(id) on delete cascade
                                                   on update cascade,
    comment varchar(512)
);

insert into utente values(default, 'lore', 'concas', 'lore@glassfish.com', 'test', 'n', 1);
insert into utente values(default, 'lord', 'fener', 'lordfener@impero.com', 'force', 'n', 1);
insert into utente values(default, 'luke', 'skywalker', 'luke@resistenza.com', 'theforce', 'n', 1);
insert into utente values(default, 'han', 'solo', 'hansolo@resistenza.com', 'milleniumfalcon', 'n', 0);
