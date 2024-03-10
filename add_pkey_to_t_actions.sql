alter table transactions
add constraint fk_bc_user foreign key (bc_user) references bc_user (uid);
