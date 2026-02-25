drop table tbl_post;
create table tbl_post
(
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    member_id bigint unsigned not null,
    created_date datetime default current_timestamp(),
    updated_date datetime default current_timestamp(),
    post_status enum('active', 'inactive') default 'active',
    constraint fk_member_post foreign key (member_id) references tbl_member(id)
);

select * from tbl_post;

select count(*)
from tbl_member m join tbl_post p
                       on m.id = p.member_id
where m.id = 5;


DELIMITER $$
CREATE PROCEDURE insertLoop()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 50 DO
            INSERT INTO tbl_post (post_title, post_content, member_id)
            VALUES (CONCAT('테스트 제목 ', i), CONCAT('테스트 내용 ', i), 5);
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER ;

CALL insertLoop(); -- 실행
DROP PROCEDURE insertLoop();