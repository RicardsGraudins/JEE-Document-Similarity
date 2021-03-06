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

## What is the Jaccard Index:
The Jaccard index, also known as Intersection over Union and the Jaccard similarity coefficient (originally coined coefficient de communauté by Paul Jaccard), is a statistic used for comparing the similarity and diversity of sample sets. The Jaccard coefficient measures similarity between finite sample sets, and is defined as the size of the intersection divided by the size of the union of the sample sets:  
<p align="center">
  <img width="auto" height="auto" src="http://latex.codecogs.com/gif.latex?J%28A%2CB%29%20%3D%20%5Cfrac%7B%5Cleft%20%7C%20A%20%5Ccap%20B%5Cright%20%7C%7D%7B%5Cleft%20%7CA%20%5Ccup%20B%5Cright%20%7C%7D%20%3D%20%5Cfrac%7B%5Cleft%20%7CA%20%5Ccap%20B%5Cright%20%7C%7D%7B%5Cleft%20%7CA%5Cright%20%7C%20&plus;%20%5Cleft%20%7CB%5Cright%20%7C%20-%20%5Cleft%20%7C%20A%20%5Ccap%20B%20%5Cright%20%7C%7D">
</p>
<p align="center">
  (If A and B are both empty, we define J(A,B) = 1.)
</p>

Refer to the following [link](https://en.wikipedia.org/wiki/Jaccard_index) for additional information regarding the Jaccard Index and other Jaccard statistics.

## What is MinHash:
In computer science, MinHash (or the min-wise independent permutations locality sensitive hashing scheme) is a technique for quickly estimating how similar two sets are. The scheme was invented by Andrei Broder (1997), and initially used in the AltaVista search engine to detect duplicate web pages and eliminate them from search results. It has also been applied in large-scale clustering problems, such as clustering documents by the similarity of their sets of words. MinHash is commonly used alongside the Jaccard similarity coefficient to estimate J(A,B) quickly, without explicitly computing the intersection and union. Calculating the estimate is a much faster alternative to using the Jaccard Index and should be used when comparing large sets in the interest of time.

## How to run:
1. Download [Tomcat](https://tomcat.apache.org/download-70.cgi).
2. Place JACCARD.WAR into `path/to/apache-tomcat-version/webapps`.
3. Open console window and CD into `path/to/apache-tomcat-version/bin`.
4. In the console: `SET JAVA_HOME=path/to/Java/jdk`.
5. In the console: `SET JRE_HOME=path/to//Java/jdk`.
6. In the console: `startup.bat`.
7. In the browser navigate to `127.0.0.1:8080/JACCARD`.

Settng this project up in eclipse can be slightly cumbersome therefore do so at your own discretion.
## References:
* [Apache Tomcat](http://tomcat.apache.org/)
* [Servlets](https://www.tutorialspoint.com/servlets/)
* [JavaServer Pages](https://www.tutorialspoint.com/jsp/)
* [DB4O](https://en.wikipedia.org/wiki/Db4o)
* [DB4O Tutorial](http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf)
* [Jaccard Index](https://en.wikipedia.org/wiki/Jaccard_index)
* [MinHashing Lecture - Professor Jeff M. Phillips, University of Utah](https://www.youtube.com/watch?v=PV_i0xXisUs)
