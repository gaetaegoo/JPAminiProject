-- 환자 정보
DROP TABLE patient cascade constraint;

-- 진료 정보
DROP TABLE clinic cascade constraint;

-- 처방 정보
DROP TABLE recipe cascade constraint;

-- 조회 정보
DROP TABLE desk cascade constraint;

DROP SEQUENCE desk_upload_id_seq;

-- 환자 정보 테이블 
CREATE TABLE patient (
       patient_id       VARCHAR2(20) 	PRIMARY KEY,
       name      		VARCHAR2(20) 	NOT NULL,
       gender			VARCHAR2(20) 	NOT NULL,
       age				VARCHAR2(20)	NOT NULL,
       birth			VARCHAR2(20) 	NOT NULL,
       phone			VARCHAR2(20) 	NOT NULL
);

-- 진료 정보 테이블
CREATE TABLE clinic (
       clinic_id        VARCHAR2(20) 	PRIMARY KEY,
       sign             VARCHAR2(20) 	NOT NULL,
       general         	VARCHAR2(20) 	NOT NULL,
       test				VARCHAR2(20) 	NOT NULL,
       surgery			VARCHAR2(20) 	NOT NULL
);

-- 처방 정보 테이블
CREATE TABLE recipe (
	   recipe_id		VARCHAR2(20) 	PRIMARY KEY,
	   patient     		VARCHAR2(20) 	NOT NULL,
       pay           	VARCHAR2(20) 	NOT NULL,       
       rx          		VARCHAR2(20) 	NOT NULL
);

-- 조회 정보 테이블
CREATE SEQUENCE desk_upload_id_seq;
CREATE TABLE desk (
		desk_id			NUMBER(5) 		PRIMARY KEY,
		patient     	VARCHAR2(20) 	NOT NULL,
		clinic 			VARCHAR2(20) 	NOT NULL,
		recipe          VARCHAR2(20) 	NOT NULL  
);

ALTER TABLE recipe ADD FOREIGN KEY (patient) REFERENCES patient (patient_id);
ALTER TABLE desk ADD FOREIGN KEY (patient) REFERENCES patient (patient_id);
ALTER TABLE desk ADD FOREIGN KEY (clinic) REFERENCES clinic (clinic_id);
ALTER TABLE desk ADD FOREIGN KEY (recipe) REFERENCES recipe (recipe_id);
