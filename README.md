# JEE Document Similarity
This repository contains code and information for my fourth-year (hons) undergraduate project for the module **Advanced Object-Oriented Design Principles & Patterns.**
The module is taught to undergraduate students at [GMIT](http://www.gmit.ie/) in the Department of Computer Science and Applied Physics for the course [B.S.c. (Hons) in Software Developement.](https://www.gmit.ie/software-development/bachelor-science-honours-software-development)
The lecturer is John Healey.

## Project Guidelines
> You are required to develop a Java web application that enables two or more text documents to be compared for similarity. An overview of the system is given below:  
<p align="center">
  <img width="627" height="281" src="https://github.com/RicardsGraudins/JEE-Document-Similarity/blob/master/Resources/Design.PNG">
</p>

> Your implementation should include the following features:   
> * **A document or URL should be specified or selected** from a web browser and then dispatched to a servlet instance running under Apache Tomcat.  
> * Each submitted document should be **parsed into its set of constituent shingles** and then compared against the existing document(s) in an object-oriented database (**db4O**) and then stored in the database.  
> * The **similarity of the submitted document** to the set of documents stored in the database should be returned and presented to the session user.

## What is Tomcat:
Apache Tomcat, often referred to as Tomcat Server, is an open-source Java Servlet Container developed by the Apache Software Foundation (ASF). Tomcat implements several Java EE specifications including Java Servlet, JavaServer Pages (JSP), Java EL, and WebSocket, and provides a "pure Java" HTTP web server environment in which Java code can run.

## What is a Servlet:
Servlets provide a component-based, platform-independent method for building Webbased applications, without the performance limitations of CGI programs. Servlets have access to the entire family of Java APIs, including the JDBC API to access enterprise databases.

## What is JSP:
Java Server Pages (JSP) is a server-side programming technology used to create web application just like Servlet technology. It can be thought of as an extension to servlet because it provides more functionality than servlet such as expression language, jstl etc.
A JSP page consists of HTML tags and JSP tags. The jsp pages are easier to maintain than servlet because we can separate designing and development. It provides some additional features such as Expression Language, Custom Tag etc.

## What is DB4O:
DB4O represents an object-oriented database model. One of its main goals is to provide an easy and native interface to persistence for object oriented programming languages. Development with db4o database does not require a separate data model creation, the application’s class model defines the structure of the data. db4o attempts to avoid the object/relational impedance mismatch by eliminating the relational layer from a software project. db4o is written in Java and .NET and provides the respective APIs. It can run on any operating system that supports Java or .NET. It is offered under licenses including GPL, the db4o Opensource Compatibility License (dOCL), and a commercial license for use in proprietary software.  

A simple how to get started with DB4O tutorial is available [here](http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf).

## How to run:

## References:
* [Apache Tomcat](http://tomcat.apache.org/)
* [Servlets](https://www.tutorialspoint.com/servlets/)
* [JavaServer Pages](https://www.tutorialspoint.com/jsp/)
* [DB4O](https://en.wikipedia.org/wiki/Db4o)
* [DB4O Tutorial](http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf)
