DROP TABLE PAYMENT CASCADE CONSTRAINTS;
/
DROP TABLE EMP CASCADE CONSTRAINTS;


-----------------CREATING TABLES-------------------
CREATE TABLE EMP (
    EMP_ID NUMBER(5) CONSTRAINT PK_EMP_ID PRIMARY KEY,
    EMP_NAME VARCHAR2(30),
    MANAGER_ID NUMBER(5),
    EMP_USERNAME VARCHAR2(20) UNIQUE NOT NULL,
    EMP_PASSWORD VARCHAR2(20) NOT NULL,
    IS_MANAGER NUMBER(1) DEFAULT 0 -- 1 FOR YES 0 FOR NO
);
/

CREATE TABLE PAYMENT(
    PAY_ID NUMBER(5) NOT NULL,
    PAY_AMOUNT NUMBER(5),
    PAY_STATUS VARCHAR2(10) DEFAULT 'PENDING',
    MANAGER_ID NUMBER(10),
    EMP_ID NUMBER(10)
);
/

-----------CREATING SEQUENCES AND TRIGGERS---------
CREATE SEQUENCE SQ_EMPS_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_EMPS
BEFORE INSERT ON EMP
FOR EACH ROW
BEGIN
    SELECT SQ_EMPS_PK.NEXTVAL INTO :NEW.EMP_ID
    FROM DUAL;
END;
/

CREATE SEQUENCE SQ_PAYMENTS_PK
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_PAYMENTS
BEFORE INSERT ON PAYMENT
FOR EACH ROW
BEGIN
    SELECT SQ_PAYMENTS_PK.NEXTVAL INTO :NEW.PAY_ID
    FROM DUAL;
END;
/

---------------MISC--------------------------------
INSERT INTO EMP VALUES (1, 'Khanh Dang', 1, 'khanh', 'kd123', 1); 
INSERT INTO EMP VALUES (2, 'Sherlock Holmes', null, 'bakerst', 'watson321', 0);
INSERT INTO EMP VALUES (3, 'Tony Stark', null, 'tonys789', '3000', 0);
INSERT INTO EMP VALUES (4, 'Bruce Wayne', 2 , 'brucew654', 'batman123', 1);

SELECT * FROM EMP;
SELECT * FROM PAYMENT;

INSERT INTO PAYMENT VALUES (1, 1500, 'PENDING', 1, 1);
INSERT INTO PAYMENT VALUES (2,10000,'ACCEPT', 2, 4); 
INSERT INTO PAYMENT VALUES (3, 5000, 'PENDING', 2, 4);
INSERT INTO PAYMENT VALUES (4, 300, 'DENIED', 2, 4);

-- LOCATING DUPLICATE OBJS
SELECT *

FROM all_objects

WHERE object_name = �EMPLOYEES�;

--ADDING FK CONSTRAINT
ALTER TABLE PAYMENT
ADD CONSTRAINT FK_EMP_ID
FOREIGN KEY (EMP_ID) REFERENCES EMP(EMP_ID);
/