use CandM;
-- 결제 테이블
create table tbl_pay
(
    pay_id int auto_increment primary key,                                   -- 결제 고유번호
    pay_user_id int not null,                                                -- 결제한 사용자 고유번호
#     pay_service_id int not null,                                             -- 결제 서비스 고유번호
    pay_final_amount bigint not null,                                -- 결제 최종 금액
    pay_donation_amount bigint default 0,                            -- 결제 후원 금액
    pay_status enum ('pending', 'completed', 'failed', 'refunded') not null, -- 결제 상태
    pay_method enum ('creditcard', 'banktransfer', 'paypal') not null-- 결제 수단
);
