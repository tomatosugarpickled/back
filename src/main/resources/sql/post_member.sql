drop table tbl_post_member;
create table tbl_post_member
(
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    post_id bigint unsigned not null ,
    constraint fk_post_member_member foreign key (member_id)
        references tbl_member (id),
    constraint fk_post_member_post foreign key (post_id)
        references tbl_post (id)
);