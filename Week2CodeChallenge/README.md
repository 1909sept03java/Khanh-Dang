Week 2 Challenge:

Create a database with two tables:
EMPLOYEE
Columns: EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL
DEPARTMENT:
Columns: DEPARTMENT_ID, DEPARTMENT_NAME

Create a sequence and trigger to auto-generate primary key values for both tables. 

Insert at least six employees and three departments. 

Create a stored procedure SP_GIVE_RAISE which takes in a DEPARTMENT_ID and increases each employee's salary within the department by 10%, and returns the new average salary for the department, as well as a boolean value indicating whether the ID entered corresponds to a valid department. 

Create a program in Java using JDBC and the DAO pattern to connect to your database.
Store your database credentials in a properties file. 

Write a prepared statement which prints each department's name and average salary to the console in Eclipse.

Write a callable statement which executes the SP_GIVE_RAISE procedure. 

In your main class, use these statements to print average department salaries before and after
a particular department is given a raise. 

BONUS 1: Obtain the department to be given a raise from user input. (i.e.- Scanner) 
BONUS 2: Make the raise percentage an IN parameter to SP_GIVE_RAISE and obtain it from user input. 

Submit your code to your repository as a Java project called “Week2CodeChallenge”, and include the .sql file with all of your entity creation statements in the same location. 

Suggestion: work requirement-by-requirement, because the later sections depend on the earlier sections (and that’s how I’ll be grading it). 

