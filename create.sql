
INSERT INTO user (name, email, password) VALUES("Jin", "mail@email.com", "123");

INSERT INTO quiz_type (name, difficulty, time_limit, description, image) VALUE ("Java core", 1, 300, "this is quiz for java core", "https://cdn.vox-cdn.com/thumbor/_AobZZDt_RVStktVR7mUZpBkovc=/0x0:640x427/1200x800/filters:focal(0x0:640x427)/cdn.vox-cdn.com/assets/1087137/java_logo_640.jpg");
INSERT INTO quiz_type (name, difficulty, time_limit, description, image) VALUE ("My SQL", 2, 300, "this is quiz for My SQL", "https://pbs.twimg.com/profile_images/1255113654049128448/J5Yt92WW_400x400.png");
INSERT INTO quiz_type (name, difficulty, time_limit, description, image) VALUE ("JavaScript", 1, 300, "this is quiz for JavaScript", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAKTjWnaZk9eXJTp4sMlzdCPPVYnBVpmBaqA&usqp=CAU");

INSERT INTO question (quiz_type_id, description) VALUE (1, "What is a correct syntax to output \"Hello World\" in Java?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "Java is short for \"JavaScript\".");
INSERT INTO question (quiz_type_id, description) VALUE (1, "How do you insert COMMENTS in Java code?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "Which data type is used to create a variable that should store text?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "How do you create a variable with the numeric value 5?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "How do you create a variable with the floating number 2.8?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "Which method can be used to find the length of a string?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "Which operator is used to add together two values?");
INSERT INTO question (quiz_type_id, description) VALUE (1, "The value of a string variable can be surrounded by single quotes.");
INSERT INTO question (quiz_type_id, description) VALUE (1, "Which method can be used to return a string in upper case letters?");

INSERT INTO choice (question_id, description, is_answer) VALUE (1, "System.out.println(\"Hello World\");", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (1, "print (\"Hello World\");", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (1, "echo(\"Hello World\");", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (1, "Console.WriteLine(\"Hello World\");", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (2, "True", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (2, "False", 1);

INSERT INTO choice (question_id, description, is_answer) VALUE (3, "// This is a comment  ", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (3, "# This is a comment", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (3, "/* This is a comment", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (4, "String", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (4, "Txt", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (4, "string", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (4, "myString", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (5, "int x = 5;", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (5, "Txt", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (5, "string", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (5, "myString", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (6, "float x = 2.8f;", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (6, "int x = 2.8f;", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (6, "x = 2.8f;", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (6, "byte x = 2.8f", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (7, "len()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (7, "length()", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (7, "getSize()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (7, "getLength()", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (8, "The & sign", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (8, "The + sign  ", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (8, "The * sign", 0);

INSERT INTO choice (question_id, description, is_answer) VALUE (9, "True", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (9, "False", 1);

INSERT INTO choice (question_id, description, is_answer) VALUE (10, "toUpperCase()  ", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (10, "touppercase()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (10, "tuc()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (10, "upperCase()", 0);


#mysql
INSERT INTO question (quiz_type_id, description) VALUE (2, "What is MySQL?");
INSERT INTO choice (question_id, description, is_answer) VALUE (11, "All the options are correct", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (11, "Cross-platform, open-source and free", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (11, "A relational database management system", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (11, "Developed, distributed, and supported by Oracle Corporation", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "Which MySQL statement is used to select data from a database?");
INSERT INTO choice (question_id, description, is_answer) VALUE (12, "SELECT", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (12, "EXTRACT", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (12, "OPEN", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (12, "GET", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "Which MySQL statement is used to update data in a database?");
INSERT INTO choice (question_id, description, is_answer) VALUE (13, "SAVE", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (13, "INSERT", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (13, "UPDATE", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (13, "MODIFY", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "Which MySQL statement is used to delete data from a database?");
INSERT INTO choice (question_id, description, is_answer) VALUE (14, "REMOVE", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (14, "DELETE", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (14, "COLLAPSE", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "Which MYSQL statement is used to insert new data in a database?");
INSERT INTO choice (question_id, description, is_answer) VALUE (15, "ADD NEW", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (15, "ADD RECORD", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (15, "INSERT INTO", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (15, "INSERT NEW", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "With MySQL, how do you select a column named \"FirstName\" from a table named \"Persons\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (16, "SELECT FirstName FROM Persons", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (16, "SELECT Persons.FirstName", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (16, "EXTRACT FirstName FROM Persons", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "With MySQL, how do you select all the columns from a table named \"Persons\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (17, "SELECT Persons", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (17, "SELECT * FROM Persons  ", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (17, "SELECT *.Persons", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (17, "SELECT [all] FROM Persons", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "With MySQL, how do you select all the records from a table named \"Persons\" where the value of the column \"FirstName\" is \"Peter\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (18, "SELECT [all] FROM Persons WHERE FirstName LIKE 'Peter'", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (18, "SELECT [all] FROM Persons WHERE FirstName='Peter'", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (18, "SELECT [all] FROM Persons WHERE FirstName='Peter'", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (18, "SELECT * FROM Persons WHERE FirstName='Peter'", 1);

INSERT INTO question (quiz_type_id, description) VALUE (2, "With MySQL, how do you select all the records from a table named \"Persons\" where the value of the column \"FirstName\" starts with an \"a\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (19, "SELECT * FROM Persons WHERE FirstName LIKE '%a'", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (19, "SELECT * FROM Persons WHERE FirstName='%a%'", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (19, "SELECT * FROM Persons WHERE FirstName LIKE 'a%'", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (19, "SELECT * FROM Persons WHERE FirstName='a'", 0);

INSERT INTO question (quiz_type_id, description) VALUE (2, "The OR operator displays a record if ANY conditions listed are true. The AND operator displays a record if ALL of the conditions listed are true");
INSERT INTO choice (question_id, description, is_answer) VALUE (20, "False", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (20, "True", 1);

#javascript
INSERT INTO question (quiz_type_id, description) VALUE (3, "Inside which HTML element do we put the JavaScript?");
INSERT INTO choice (question_id, description, is_answer) VALUE (21, "<scripting>", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (21, "<javascript>", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (21, "<js>", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (21, "<script>", 1);

INSERT INTO question (quiz_type_id, description) VALUE (3, "What is the correct JavaScript syntax to change the content of the HTML element below? \n <p id=\"demo\">This is a demonstration.</p>");
INSERT INTO choice (question_id, description, is_answer) VALUE (22, "document.getElementByName(\"p\").innerHTML = \"Hello World!\"; ", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (22, "#demo.innerHTML = \"Hello World!\";", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (22, "document.getElementById(\"demo\").innerHTML = \"Hello World!\";", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (22, "document.getElement(\"p\").innerHTML = \"Hello World!\";", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "Where is the correct place to insert a JavaScript?");
INSERT INTO choice (question_id, description, is_answer) VALUE (23, "The <body> section", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (23, "The <head> section", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (23, "Both the <head> section and the <body> section are correct", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "What is the correct syntax for referring to an external script called \"xxx.js\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (24, "<script src=\"xxx.js\">", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (24, "<script href=\"xxx.js\">", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (24, "<script name=\"xxx.js\">", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "The external JavaScript file must contain the <script> tag.");
INSERT INTO choice (question_id, description, is_answer) VALUE (25, "False", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (25, "True", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "How do you write \"Hello World\" in an alert box?");
INSERT INTO choice (question_id, description, is_answer) VALUE (26, "msgBox(\"Hello World\");", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (26, "alert(\"Hello World\");  ", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (26, "alertBox(\"Hello World\");", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (26, "msg(\"Hello World\");", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "How do you create a function in JavaScript?");
INSERT INTO choice (question_id, description, is_answer) VALUE (27, "function:myFunction()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (27, "function = myFunction()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (27, "function myFunction()", 1);

INSERT INTO question (quiz_type_id, description) VALUE (3, "How do you call a function named \"myFunction\"?");
INSERT INTO choice (question_id, description, is_answer) VALUE (28, "call myFunction()", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (28, "myFunction()", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (28, "call function myFunction()", 0);

INSERT INTO question (quiz_type_id, description) VALUE (3, "How to write an IF statement in JavaScript?");
INSERT INTO choice (question_id, description, is_answer) VALUE (29, "if i = 5", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (29, "if i == 5 then", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (29, "if i = 5 then", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (29, "if (i == 5)", 1);

INSERT INTO question (quiz_type_id, description) VALUE (3, "How to write an IF statement for executing some code if \"i\" is NOT equal to 5?");
INSERT INTO choice (question_id, description, is_answer) VALUE (30, "while (i <= 10)", 1);
INSERT INTO choice (question_id, description, is_answer) VALUE (30, "while i = 1 to 10", 0);
INSERT INTO choice (question_id, description, is_answer) VALUE (30, "while (i <= 10; i++)", 0);
