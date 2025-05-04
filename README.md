# Register_And_Login_validate_from_DatabaseAndLogin
In this repo you find how to create register and store value in database and then login and cross check from get values from db and login into home page.


------------ Project Structure-----------
pgsql
Copy code
/WebApp
│
├── WebContent/
│   ├── Register.html
│   ├── login.html
│   ├── home.html
│
├── src/
│   ├── servlet1.java
│   ├── servlet2.java
│
├── WEB-INF/
│   ├── web.xml
│
└── lib/ 



🛠️ ---------Requirements----------


JDK 11 or above

Apache Tomcat 10 or above

Eclipse IDE or IntelliJ IDEA (for Java EE support)

Jakarta EE Servlet API JAR

Optional: MySQL (if extending with JDBC)


------------- Setup Steps-----------
1. Install Required Tools
Install the following if not already available:

Java JDK: Download

Apache Tomcat: Download

Eclipse IDE for Java EE: Download

---------------2. Configure Tomcat Server in Eclipse-------
Go to Window > Preferences > Server > Runtime Environments.

Click Add, select Apache Tomcat v10+.

Provide Tomcat installation directory.

Click Finish.

-----------3. Create Dynamic Web Project------------
Open Eclipse IDE.

Go to File > New > Dynamic Web Project.

Project Name: RegisterPage

Target Runtime: Select Apache Tomcat.

Finish.

-------------------4. Add JARs (Servlet API)---------------
Add the Servlet API JAR manually:

Download jakarta.servlet-api-5.0.x.jar from here

Place it under WebContent/WEB-INF/lib/

Right-click project > Build Path > Configure Build Path > Libraries > Add JARs

-----------------5. Add HTML Pages-------------
Place your Register.html, login.html, and home.html in the WebContent/ folder.

-------------------6. Add Servlets--------------
Paste the following into servlet1.java and servlet2.java in the src/ folder.

------------7. Configure web.xml-----------
Located at: WebContent/WEB-INF/web.xml

 -------------Optional: Setup Database with JDBC------------
If you plan to store registered users in a database:

Install MySQL Server

Create DB:

Add MySQL JDBC JAR: mysql-connector-java

Update servlet1.java to connect and verify using JDBC.

----------🚀 Running the Project-----------
Right-click your project in Eclipse.

Run As > Run on Server.

Tomcat will start and open Register.html in your browser.



-----------------✅ Features--------------
 Registration Page (HTML)

 Login Page (HTML + Servlet)

 Home Page after successful login

 Servlet-based validation

 JDBC & Database (optional extension)

📷 Screenshot (Optional)
You can include screenshots here of:

Registration page

![image](https://github.com/user-attachments/assets/fc3f49f1-ca45-46cc-b461-d80270433fb6)


Login page

![image](https://github.com/user-attachments/assets/90dc8b9d-bde1-4017-bd39-414f274415a9)



Home page After login 

![image](https://github.com/user-attachments/assets/b1761f31-7f3a-4d8d-831d-b7200ebcab9b)


🧑‍💻 Author
   Praveen
   Feel free to contact on Instagram @praveenbhardwaj02
