drop table tbl_post;
create table tbl_post
(
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    post_status enum('active', 'inactive') default 'active',
    constraint fk_member_post foreign key (member_id) references tbl_member(id)
);

select * from tbl_post


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
            VALUES (CONCAT('테스트 제목 ', i), CONCAT('엔비디아가 이번 분기 실적 발표에서 시장 컨센서스를 크게 상회하는 어닝 서프라이즈를 기록했습니다. 매출과 EPS 모두 예상치를 뛰어넘었으며, 특히 데이터센터 및 AI 관련 매출이 폭발적으로 증가하면서 전체 실적을 견인했습니다. 생성형 AI 수요 확대와 글로벌 빅테크 기업들의 GPU 투자 증가가 실적 성장의 핵심 동력으로 작용한 것으로 분석됩니다. 가이던스 또한 긍정적으로 제시되며 향후 성장 기대감을 더욱 높였습니다. ', i), 5);
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER ;

CALL insertLoop(); -- 실행
DROP PROCEDURE insertLoop();