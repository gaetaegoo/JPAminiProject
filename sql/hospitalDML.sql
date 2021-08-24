-- patient insert[환자 정보 테이블]
insert into patient values('01a' , '이건우', 'M', '5Y', '17.06.12', '010-111-1111');
insert into patient values('02b' , '마슈슈', 'F', '17Y', '05.06.26', '010-222-2222');
insert into patient values('03c' , '김만두', 'M', '8Y', '13.08.08', '010-333-3333');

-- clinic insert [진료 정보 테이블]
insert into clinic values('0823-001','교상', 'O', 'O', 'X');
insert into clinic values('0823-002','신부전', 'O', 'O', 'O');
insert into clinic values('0823-003','정기검진', 'O', 'X', 'X');

-- recipe insert [처방 정보 테이블]
insert into recipe values('A','01a', '38,900원', '항생제');
insert into recipe values('B','02b', '650,000원', '수액');
insert into recipe values('C','03c', '20,000원', '유산균');

-- desk insert 
insert into desk values(desk_upload_id_seq.nextval, '01a', '0823-001', 'A');
insert into desk values(desk_upload_id_seq.nextval, '02b', '0823-002', 'B');
insert into desk values(desk_upload_id_seq.nextval, '03c', '0823-003', 'C');

commit;
