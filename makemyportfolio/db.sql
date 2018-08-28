create table users (
user_id number(10) primary key,
user_name varchar2(30) unique not null,
password varchar2(64) not null
);
create table profile_pictures (
id number(10) primary key,
picture_filename varchar2(255) not null
);
create table profiles (
profile_id number(10) primary key,
profile_user_id number(10) unique not null,
full_name varchar2(255) not null,
profile_picture_id number(10) unique,
about_you varchar2(255)not null,
hometown varchar2(50),
current_city varchar2(50),
email_id varchar2(50) not null unique,
phone_no varchar2(12) not null unique, 
total_friends number(4) check (total_friends <= 5000),
constraint profile_fk1 foreign key (profile_user_id ) references users(user_id),
constraint profile_fk2 foreign key (profile_picture_id ) references profile_pictures(id)
);



create table educational_info (
id number(10) primary key,
education_profile_id number(10) not null,
institution_name varchar2(50) not null,
degree_type varchar2(50) not null,
year_of_pass number(4) not null,
percentage number(5,2) not null,
constraint educational_info_fk1 foreign key (education_profile_id)references profiles(profile_id)
);


create table technical_info(
id number(10) primary key,
tech_profile_id number(10) not null,
programming_languages varchar2(1024),
web_technologies varchar2(1024),
os_known varchar2(255),
databases_known varchar2(255),
constraint tech_info_fk1 foreign key (tech_profile_id) references profiles(profile_id)
);

create table development_categories(
id number(10) primary key,
dev_category_tech_id number(10) not null,
category_title varchar2(50) not null,
constraint dev_category_fk1 foreign key (dev_category_tech_id) references technical_info(id)
);

create table extracurricular_info(
id number(10)  primary key,
extracur_profile_id number(10) not null,
activity_title varchar2(30),
activity_description varchar2(255),
constraint extracur_info_fk1 foreign key (extracur_profile_id) references profiles(profile_id)
);

create table friends(
friends_id number(10) not null,
friend_profile_id number(10) not null,
primary key(friends_id,friend_profile_id),
constraint friends_fk1 foreign key (friends_id) references profiles(profile_id),
constraint friends_fk2 foreign key (friend_profile_id) references profiles(profile_id)
);


create table portfolios(
portfolio_id number(10) primary key,
portfolio_profile_id number(10) unique not null,
about_yourself varchar2(255) not null,
strengths varchar2(255) not null,
weaknesses varchar2(255) not null,
interests varchar2(255) not null,
achievements varchar2(255),
career_objective varchar2(255),
links varchar2(255),
constraint portfolio_fk1 foreign key (portfolio_profile_id) references profiles(profile_id)
);

create table projects (
 project_id number(10) primary key,
 project_portfolio_id not null,
 project_title varchar2(255) not null,
 technologies_used varchar2(255) ,
 project_description varchar2(255) ,
 project_duration varchar2(50),
 constraint project_fk1 foreign key (project_portfolio_id) references portfolios(portfolio_id)
);

create table posts(
 post_id number(10) primary key,
 post_user_id number(10) not null,
 post_title varchar2(255) ,
 post_content varchar2(1000),
 post_image varchar2(255) unique,
 post_tags varchar2(255),
 comment_count number(3) check(comment_count <= 500),
 likes_count number(5),
 constraint posts_fk1 foreign key (post_user_id) references users(user_id)
);

create table comments(
 comment_post_id number(10) not null,
 comment_user_id number(10) not null,
 comment_content varchar2(255) not null,
 primary key(comment_post_id,comment_user_id),
 constraint comments_fk1 foreign key (comment_post_id)references posts(post_id),
 constraint comments_fk2 foreign key (comment_user_id)references users(user_id)
);

create table likes(
 like_post_id number(10) not null,
 like_user_id number(10) not null,
 primary key(like_post_id,like_user_id),
 constraint likes_fk1 foreign key (like_post_id)references posts(post_id),
 constraint likes_fk2 foreign key (like_user_id)references users(user_id)
);
 

