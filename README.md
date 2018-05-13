# CRUD-Database-Operations
Perform CRUD (Create, Read, Update, Delete) operations on any database on a web app.

NOTE: You'll need a tomcat server to run this program.

What this does:

1. Firstly, it opens you up to a page where you have an option to upload a new database.
2. After you upload your new database, it'll make modifications on the existing database as follows:
    a. If the primary key(ID) exists in the current database, it'll update the row from the imported database to the current database.
    b. If the primary key(ID) does not exist in the current database, it'll insert a new row from the imported database to the current                database.
3. It will then redirect you to the main page, wherein you have an option to search/view/delete/edit or create a new record in the         
   database.
4. Modifications in the database can be done on the same page itself.

It is a MVC application and uses HSQLDb (Hyper Sql database) 

This project was done by me during my internship at Hexaware in June 2017.
