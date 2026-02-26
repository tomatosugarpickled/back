create table tbl_member_profile_file
(
	id bigint unsigned not null primary key,
	member_id bigint unsigned not null,
	constraint fk_member_profile_file_member foreign key (member_id)
	references tbl_member(id),
    constraint fk_member_profile_file_file foreign key (id)
    references tbl_file(id)
);