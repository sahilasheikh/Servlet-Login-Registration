## Servlet Login Registration
Here, you will learn that how to create simple Registration and Login form in servlet. We are using oracle10g database.

## Getting Started
You just have to clone the repo and import in any java editor.

## Prerequisites: So you need to create a table first as given below:
create table loginregister001(id number(5), name varchar2(4000), email varchar2(4000), password varchar2(4000), mobile_number number(10), dob varchar2(4000), gender varchar2(4000));

To create the registration and login page in servlet, we can separate the database logic from the servlet.
Here, we are creating the Modal Class and DAO Class to organized the database logic in the servlet.

## File required
	In this example, we have created the eight files which are:
		index.html, register.html, Welcome.html, web.xml
		User.java, User_DAO.java, LoginServlet.java, RegisterServlet.java, WelcomeServlet.java, LogoutServlet.java
		
	index.html:
		In this html file, we have getting user's username and password from the user using text fields and combobox.
		The information entered by the user is forwarded to LoginServlet servlet, which is responsible to validate the user's info from the database.

	registration.html:
		In this html file, we have getting input from the user using text fields and combobox.
		The information entered by the user is forwarded to RegisterServlet servlet, which is responsible to store the data into the database.
	
	Welcome.html:
		In this html file, user get perform their operation (but that operations we have to created as a function).
		This file is accessed by user only after user gets validates from LoginServlet.java.
	
	User.java:
		This is the model class for the project where all the variables is set also setters() and getters() set.
	
	User_DAO.java:
		This is the DAO (Data Access Object) where all the logic is performed so it can invoked by the LoginServlet and RegisterServlet Classes.
	
	LoginServlet.java:
		This servlet class receives all the data entered by user and validate the user's info from the database.
	
	RegisterServlet.java:
		This servlet class receives all the data entered by user and stores it into the database.
	
	WelcomeServlet.java:
		This servlet class is to perform all the operations which we have to created for the user (for demo purpuse we are not creating any operation for this project).
		
	LogoutServlet.java
		This servlet class is to perform logout operation.
	
	web.xml:
		The is the configuration file, providing information about the servlet.

## Built With
This application is developed using Java, Servlet, JDBC & Oracle Database.
