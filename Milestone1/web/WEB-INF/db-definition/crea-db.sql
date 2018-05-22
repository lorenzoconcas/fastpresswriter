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
    imgDesc varchar(200),
    category varchar(128),
    dataC varchar(10),
    autore bigint unsigned references utente(id) on delete cascade
                                                 on update cascade  
);

create table commenti(
    commentID serial primary key,
    commentAuthor bigint unsigned references utente(id) on delete cascade 
                                                        on update cascade,
    newsID bigint unsigned references notizia(id) on delete cascade
                                                   on update cascade,
    comment varchar(512)
);

insert into utente values(default, 'Lore', 'Concas', 'lore@glassfish.com', 'test', 'res/user_pictures/test_profile_pic.png', 1);
insert into utente values(default, 'Lord', 'Fener', 'lordfener@impero.com', 'theforce', 'res/user_pictures/header_user_icon.png', 1);
insert into utente values(default, 'Luke', 'Skywalker', 'luke@resistenza.com', 'resistence', 'res/user_pictures/header_user_icon.png', 1);
insert into utente values(default, 'Han', 'Solo', 'hansolo@resistenza.com', 'milleniumfalcon', 'res/user_pictures/header_user_icon.png', 0);

/*inseriamo le notizie di prova*/

insert into notizia values(default, 'Articolo1' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    'res/news_pictures/news.image.1.png', 'none', 'Politica', 0);

