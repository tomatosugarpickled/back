drop table tbl_member_category_career;
create table tbl_member_category_career (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null ,
    constraint fk_category_career_member foreign key(member_id)
    references tbl_member(id),
    constraint fk_member_category_career foreign key (category_id)
    references tbl_member_category_career_member(id)
);

select * from tbl_member_category_career;

# create view view_member_career as (
# select mc.id
#      , affiliation_title
#      , member_employment_type
#      , member_role
#      , member_skill
#      , intro_detailed
#      , start_date
#      , end_date
#      , member_id
#      , created_datetime
#      ,updated_datetime
#
# from tbl_member_career mc
#     join tbl_member_category_career mcc
#     on mc.id = mcc.id

                                  )
