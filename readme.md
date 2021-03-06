<img src="https://github.com/MarcinPekala/readme_images/blob/master/PLA.png" width="400"/>

Please go to https://github.com/MarcinPekala/ppfrontend for HTML/CSS/JS frontend repository.

And please go to https://github.com/MarcinPekala/ppfrontend-vaadin for Vaadin frontend repository.

# 1. General description

## 1.1 Application's name
*Personal Library App*

## 1.2 Application's purpose
The main purpose of this application development is to display practical skills I gathered in regards to the development of REST API applications that use Spring Boot Java on Gradle project in a form of a personal project with separate repositories for HTML/CSS/JS frontend, Vaadin frontend and backend. 
</br></br>
On top of that, *Personal Library App* is to help people organize their books' collection on a web based app with multiple functions.

## 1.3 Brief summary of application

<img src="https://github.com/MarcinPekala/readme_images/blob/master/FRONT.png" width="800"/>

### Backend:
REST API writen in Java's Spring Boot with usage of following technologies in the project:

<ul>
    <li>H2 databse (or MySQL database upon personal configuration)</li>
      <li>Spring Data JPA</li>
    <li>Swagger.io</li>
    <li>Spring Actuator</li>
        <li>Google GSON</li>
        <li>Mockito for JUnit tests</li>
  <li>Spring Hibernate</li>
</ul>
In total, backend side consists of 10 packages, totalling 12 classes, which have about 1285 lines of java according to the statistic IntelliJ IDEA plugin and JUnit tests coverage of about 89%.

### Frontend:
Frontend side was developed using both HTML/CSS/JS and Vaadin technology. Additionally, I used jQuery v3.4.1 framework for javascript to process HTTPS requests from the REST API. I also used Google Books API and Materialize v0.100.2 for HTML/JS/CSS. Summarizing, I used the following technologies:

<ul>
  <li>HTML/CSS/JS</li>
  <li>Google Books API</li>
  <li>Materialize v0.100.2</li>
  <li>jQuery v3.4.1</li>
  <li>Vaadin (Java framework for web applications)</li>
</ul>

In total HTML/CSS/JS frotnend side has one java file with about 46 lines of code. Additionally, there are 2 css files, 2 js files and 2 html files. Html code has about 140 lines, css about 241 and js about 645.

Vaadin frontend side has 4 packages, totaling 4 clasess with about 387 lines of java according to statistic plugin in IntelliJ IDEA. 

## 1.4 Target Users

<ul>
  <li><b>Web Admin</b> - A person who manages the server and database on which the application is deployed.</li>
  <li><b>User</b> - A web user, who uses this application to manage their personal libraries. 
</ul>

# 2. Description of functionalities

## 2.1 Starting the application

### To start an application off you need the following:
<ul>
<li>JDK and Java up to date</li>
<li>Gradle installed(Not sure if needed. To verify)</li>
</ul>

### In order to start the application off you need to do the following steps:

1.	Clone or dowload repositories from: https://github.com/MarcinPekala/ppbackend.git, https://github.com/MarcinPekala/ppfrontend.git and https://github.com/MarcinPekala/ppfrontend-vaadin.git
```
You can use the following commands in terminal (for MacOS) to clone the repositories:
  git clone https://github.com/MarcinPekala/ppbackend.git
  git clone https://github.com/MarcinPekala/ppfrontend.git
  git clone https://github.com/MarcinPekala/ppfrontend-vaadin.git
```

2.	The H2 database is configured automatically, however in case you want to access the SQL database click the following button on the main page (both ppbackend and ppfrontend packages needs to be up and running to access it):

  <img src="https://github.com/MarcinPekala/readme_images/blob/master/DB1.png" width="400"/>

And use the following configuration:

  <img src="https://github.com/MarcinPekala/readme_images/blob/master/DB2.png" width="400"/>
  <img src="https://github.com/MarcinPekala/readme_images/blob/master/DB3.png" width="400"/>

3.	To start the project first you need to:

a) Open a terminal window (for MacOS) and find the location of ppbackend-master on your hard drive or any other location of your choice (or ppbackend when cloning the repository) by using "ls" and "cd example_path" commands (for MacOS). After you get it  open the ppbackend-master (or ppbackend) via terminal, use the following command:
```
  ./gradlew build
```
<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal1.png" width="400"/>

In the case of the application being built correctly, you use the following command to start the application:
```
  ./gradlew bootRun
```

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal2.png" width="400"/>

b) In the case of the backend getting successfully up and running, you repeat all the steps for ppfrontend-master (or ppfrontend when cloning) and ppfrontend-vaadin-master (or ppfrontend-vaadin when cloning) in two new terminal windows. It may take some time for frontend windows to start, so don't get discouraged.

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal3.png" width="400"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal4.png" width="400"/>

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal5.png" width="400"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal6.png" width="400"/>

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Terminal7.png" width="400"/>

4. When ppbackend-master (or ppbackend), ppfrontend-master (or ppfrontend) and ppfrontend-vaadin-master (or ppfrontend-vaadin) are succesfully up and running you access the following address via search engine of your choice (Google Chrome reccomended): http://localhost:8081

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Localhost.png" width="400"/>

5. To close the application you need to close all terminal windows, which locally host the application's frontend and backend or click "ctrl + c" in all terminal windows in order to stop the application hosting, without the need to close the terminal windows.

## 2.2 Application's abilities and main functionalities (HTML/CSS/JS part)

#### 2.2.1 Database size reminder

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DBS.png" width="600"/>

First thing you'll notice is the database size alert, which appears every time when openning the website and also is set to reappear as a reminder every 10 seconds. Just click *OK* to proceed to the website. You can also find the same information in the terminal window on which the backend part is running:

<img src="https://github.com/MarcinPekala/readme_images/blob/master/CONSOLE.png"/>

#### 2.2.2 Accessing the database and endpoints documentation

<img src="https://github.com/MarcinPekala/readme_images/blob/master/TB.png" width="600"/>

On the top right you'll see two buttons. The first one on the left lets you access the endpoints’ documentation powered by swagger.io, and the second one lets you access the database console in SQL.

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DOCS.png" width="600"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/DB2.png" width="600"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/DB3.png" width="600"/>

#### 2.2.3 Book form

<img src="https://github.com/MarcinPekala/readme_images/blob/master/FORM.png" width="600"/>

In order to submit a book to the database, you simply enter the book's details into "Book author", "Book title" and "Book's year of publication" fields, and click "Add a book". Not all fields need to be filled. You can also click "Delete all books" but this proccess is irreversible.

#### 2.2.4 Switch to Vaadin front

<img src="https://github.com/MarcinPekala/readme_images/blob/master/FORMV.png" width="600"/>

Under "Add a book" and "Delete all books" button you can see "Switch to Vaadin Frontend" button, which allows you to switch frontend from HTML/CSS/JS based one to Vaadin, which is a Java framework for the frontend of web applications.

#### 2.2.5 Editing and deleting books from the database

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DBF.png" width="600"/>

Under the form you'll see the list of all books in the database. By clicking "edit" you'll toggle the editing state, which will allow you to rewrite information regarding the book or abort this proccess if you don't want to make any changes. Some fields can be left blank. You can also click "delete" in order to delete a book from the database by its id.

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DBF2.png" width="600"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/DELETE.gif" width="600"/>

#### 2.2.6 Book status, details and book search via Google Books
You can adjust a book status from "Bought and read", "Bought but unread" and "To buy".

<img src="https://github.com/MarcinPekala/readme_images/blob/master/BOOKSTATUS.gif" width="600"/>

If you want to know more about any book present in the database you can click "details" or "search". The first one will use Google Books API on the separate page where you can click "Get Details", which will initialize the API or click "Get Back" to go back to the main page. On the main page you can also use search, which will instantly direct you to the Google Books search engine.

<img src="https://github.com/MarcinPekala/readme_images/blob/master/BOOKDETAILS.gif" width="600"/>
<img src="https://github.com/MarcinPekala/readme_images/blob/master/BOOKSEARCH.gif" width="600"/>

## 2.3 Application's abilities and main functionalities (Vaadin part)

<img src="https://github.com/MarcinPekala/readme_images/blob/master/VaadinScreen.png" width="600"/>

### 2.3.1 Select a book
Click on the table to highlight and select a title of your choice.

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Select.gif" width="600"/>

### 2.3.2 Update a book
Use the third button from the left on the bottom right corner to update "Author", "Title" or "Year Of Publication" of any of the books. Even if you didn't make any changes please click the "update" button to empty the fields. 

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Update.gif" width="600"/>

### 2.3.3 Delete a book 
Click the second button on the bottom right corner to delete a single book. Please keep in mind that this process is irreversible. 

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DeleteV.gif" width="600"/>

### 2.3.4 Add a new book
Use the first button from the left on the bottom right corner to add new books into the database. Some or all fields can be null but please deselect the book by clicking "update" as mentioned in point 2, because otherwise, the new book might not be added to the database. 

<img src="https://github.com/MarcinPekala/readme_images/blob/master/Add.gif" width="600"/>

### 2.3.5 Check stored books 
Click "Check Stored Books" in the middle bottom corner to get a number of books currently present in the database. 

<img src="https://github.com/MarcinPekala/readme_images/blob/master/CheckStoredBooks.gif" width="600"/>

### 2.3.6 Find by author 
If you want to categorize books by the same author in a table on the bottom left, please click the button "Find By Author", which is located on the left of in the middle bottom corner. 

<img src="https://github.com/MarcinPekala/readme_images/blob/master/FindByAuthor.gif" width="600"/>

### 2.3.7 Delete all books
Lastly, if you want to delete all books from the database please click the fourth button from the left on the bottom right corner. Please bear in mind that this process is irreversible.  

<img src="https://github.com/MarcinPekala/readme_images/blob/master/DeleteAll.gif" width="600"/>
