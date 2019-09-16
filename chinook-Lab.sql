-- SET SCHEMA 'chinook';
-- THIS IS THE HOMEWORK .SQL FILE WITH ALL THE ANSWERS TO THE LAB

--2 SQL QUERIES
--2.1 SQL SELECT

--Task – Select all records from the Employee table.
SELECT * FROM employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname = 'Andrew';

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city.
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
-- Task – Insert two new records into Genre table 
INSERT INTO genre (genreid, name) VALUES (26, 'K- Pop');
INSERT INTO genre (genreid, name) VALUES (27, 'Vietnamese Pop');

--Task – Insert two new records into Employee table
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) VALUES
(9, 'Gamez', 'Kevin', 'Intern', '1', '1996-04-17', '2019-09-15', '7050 3 Street NW', 'Lodi', 'NJ', 'USA', '07845', '+1 (403)760-5385','+1(403)534-9023', 'kevin@chinookcorp.com');
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) VALUES
(10, 'Parker', 'Peter', 'Intern', '25', '1996-01-06', '2019-09-15', '3213 21 Ave', 'Queens', 'NY', 'USA', '14526', '+1 (403)443-9441','+1(780)639-0932', 'parker@chinookcorp.com');

--Task – Insert two new records into Customer table

--2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE customerid = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
-- Task – Select all invoices with a billing address like “T%” 
SELECT * FROM invoice WHERE billingaddress LIKE '%T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-06-2003' AND '01-03-2004';

--2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT * FROM CUSTOMER;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
-- Solution: right click on customer table in connections tab, disable constraints, delete customer Robert Walter, finally enable constraints

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP IS
T TIMESTAMP;
BEGIN
    T := SYSDATE;
    RETURN(T);
END;
/
SELECT GET_TIME() FROM DUAL;

--Task – create a function that returns the length of name in MEDIATYPE table 
CREATE OR REPLACE FUNCTION GET_NAME_LENGTH(M_ID IN NUMBER)
RETURN NUMBER IS
L NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO L FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
    RETURN(L);
END;
/
SELECT GET_NAME_LENGTH(1) FROM DUAL;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER IS
EXP_TRACK NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO EXP_TRACK FROM TRACK;
    RETURN(EXP_TRACK);
END;
/
SELECT MOST_EXPENSIVE_TRACK() FROM DUAL;

--3.3 USER DEFINED SCALAR FUNCTIONSS
--Task – Create a function that returns the average price of invoice line items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_UNITPRICE
RETURN NUMBER IS
AVG_UNITPRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_UNITPRICE FROM INVOICELINE;
    RETURN(AVG_UNITPRICE);
END;
/
SELECT AVG_INVOICELINE_UNITPRICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION EMPLOYEES_AFTER_1968
RETURN SYS_REFCURSOR IS
EMPLOYEES_AFTER SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEES_AFTER FOR
    SELECT * FROM EMPLOYEE
    WHERE BIRTHDATE > '01-JAN-1968';
    RETURN EMPLOYEES_AFTER;
END;
/
SELECT EMPLOYEES_AFTER_1968 FROM DUAL;

--4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_NAMES(S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

SET SERVEROUTPUT ON
DECLARE
    S SYS_REFCURSOR;
    FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
    LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_NAMES(S);
    LOOP
        FETCH S
        INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME);
    END LOOP;
    CLOSE S;
END;
/
-- 4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    E_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE,
    E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = E_LASTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FIRSTNAME = E_FIRSTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET CITY = E_CITY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET COUNTRY = E_COUNTRY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET POSTALCODE = E_POSTALCODE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET PHONE = E_PHONE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FAX = E_FAX WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET EMAIL = E_EMAIL WHERE EMPLOYEEID = E_EMPLOYEEID;
    COMMIT;
END;
/
EXECUTE UPDATE_EMPLOYEE_INFO(10, 'Dang', 'Khanh', '69 Yeaok Road', 'Westwood', 'United States', '07675', '+1 (201) 960-3636', '+1 (201) 960-3636', 'khanh@chinookcorp.com');

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE RETURN_MANAGER(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_MANAGERID OUT EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
    SELECT REPORTSTO INTO E_MANAGERID
    FROM EMPLOYEE WHERE EMPLOYEEID = E_EMPLOYEEID;
END;
/
SET SERVEROUTPUT ON
DECLARE
    E_EMPLOYEEID EMPLOYEE.EMPLOYEEID%TYPE;
    E_MANAGERID EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    RETURN_MANAGER(10, E_MANAGERID);
    DBMS_OUTPUT.PUT_LINE(E_MANAGERID);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY(
    CUSTOMER_ID IN CUSTOMER.CUSTOMERID%TYPE,
    C_FIRSTNNAME OUT CUSTOMER.FIRSTNAME%TYPE,
    C_LASTNAME OUT CUSTOMER.LASTNAME%TYPE,
    C_COMPANY OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO C_FIRSTNAME, C_LASTNAME, C_COMPANY
    FROM CUSTOMER WHERE CUSTOMERID = CUSTOMER_ID;
END;
/
SET SERVEROUTPUT ON
DECLARE
    C_FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
    C_LASTNAME CUSTOMER.LASTNAME%TYPE;
    C_COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_NAME_COMPANY(10, C_FIRSTNAME, C_LASTNAME, C_COMPANY);
    DBMS_OUTPUT.PUT_LINE(C_FIRSTNAME || ' ' || C_LASTNAME || ' - ' || C_COMPANY);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
 CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN INVOICE.INVOICEID%TYPE)
IS
BEGIN
    -- DELETE INVOICE FROM INVOICELINE
    DELETE FROM INVOICELINE
    WHERE INVOICEID = INVOICE_ID;
    
    -- DELETE INVOICE
    DELETE FROM INVOICE
    WHERE INVOICEID = INVOICE_ID;
END;
/
EXECUTE DELETE_INVOICE(111);

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTER_CREATE_EMPLOYEE
AFTER INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.FIRSTNAME || ' ' || :NEW.LASTNAME || ' created');
END;
/
SET SERVEROUTPUT ON
INSERT INTO EMPLOYEE
VALUES(11, 'Christ', 'Jesus', 'IT Staff', 6, '08-MAR-87', '20-AUG-04', 
'284 Main St', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 382-3842', 
'+1 (780) 382-3892', 'smithj@chinookcorp.com');

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
AFTER UPDATE OR INSERT ON ALBUM FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.TITLE || ' created');
END;
/
SET SERVEROUTPUT ON
INSERT INTO ALBUM
VALUES(348, 'If You Are Reading This Is Too Late', 147);

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.FIRSTNAME || ' ' || :OLD.LASTNAME || ' deleted');
END;
/
SET SERVEROUTPUT ON
DELETE FROM CUSTOMER WHERE CUSTOMERID = 70;

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.X
SELECT lastname, firstname, invoiceid FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER C
FULL JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.LASTNAME;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album
RIGHT JOIN artist ON album.artistid = artist.artistid
ORDER BY NAME;

--7.4 CROSS
-- – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album
ORDER BY NAME ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT
    (E.FIRSTNAME || ' ' || E.LASTNAME) EMPLOYEE,
    (M.FIRSTNAME || ' ' || M.LASTNAME) MANAGER
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON E.REPORTSTO = M.EMPLOYEEID
ORDER BY MANAGER;




 



