drop database budget_commander;
drop user budgetcommander;
create user budgetcommander with password 'password';
create database budgetcommander_db with template=template0 owner=budgetcommander;
\connect budgetcommander;
alter default privileges grant all on tables to budgetcommander;
alter default privileges grant all on sequences to budgetcommander;

create table bc_users(
	user_id integer primary key not null,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	email varchar(30) not null,
	password text not null
);

create table bc_categories(
	category_id integer primary key not null,
	user_id integer not null,
	title varchar(20) not null,
	description varchar(20) not null
);

alter table bc_categories add constraint cat_users_fk
foreign key (user_id) references bc_users(user_id);

create table bc_transactions (
	transaction_id integer primary key not null,
	category_id integer not null,
	user_id integer not null,
	amount numeric(10, 2) not null,
	note varchar(50) not null,
	transaction_date bigint not null
);

alter table bc_transactions add constraint trans_cat_fk
foreign key (category_id) references bc_categories(category_id);
alter table bc_transactions add constraint trans_users_fk
foreign key (user_id) references bc_users(user_id);

create sequence bc_users_seq increment 1 start 1;
create sequence bc_categories_seq increment 1 start 1;
create sequence bc_transactions_seq increment 1 start 1000;