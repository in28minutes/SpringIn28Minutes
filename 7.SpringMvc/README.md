## Todolist MVC

Todolist MVC is like [TodoMVC][] but for Java Web Frameworks instead of Javascript Frameworks.

The goal is to implement the same application using different technologies and compare them
 in order to help you choose the right framework for your next Java web application.

Two types of frameworks are being compared:

#### 1. Request/Action based frameworks

* Servlets/JSPs 
* Spring MVC
* Struts

#### 2. Component based frameworks

* Tapestry
* JSF

Other frameworks will be added progressively (Wicket, Grails, Play, etc..), you are welcome to contribute with any Java web framework you are comfortable with.

Note that performance comparison is not addressed here since there are many excellent benchmarks on the web like [TechEmpower's Framework Benchmarks][].

The goal is to focus on features set and developer productivity using each framework:

* Form handling
* Request parameters binding
* Session handling
* Ajax support
* I18N support
* etc

## About Todolist MVC

Todolist MVC is the classic CRUD web application to manage todo list online.

Some features like user and session management go beyond CRUD operations.
 The application is small enough to be easy to implement, and big enough to cover most of the features of each framework.
 Here is the list of features:
 
#### User management

* Register a new account
* View account details
* Update account
* Delete account

#### Session management

* Login
* Logout

#### Todolist management

* CRUD operations on todos
* Search todo list

Todolist MVC uses [Twitter Bootstrap][] for the user interface, here are some screenshots:

![Index page](https://github.com/benas/todolist-mvc/raw/master/src/site/screenshots/todolist-index.png)

![Sign-in page](https://github.com/benas/todolist-mvc/raw/master/src/site/screenshots/todolist-signin.png)

![Home page](https://github.com/benas/todolist-mvc/raw/master/src/site/screenshots/todolist-home.png)

![Search page](https://github.com/benas/todolist-mvc/raw/master/src/site/screenshots/todolist-search.png)

## Architecture

The application's backend is developed using Spring and JPA/Hibernate. Data is persisted in an in-memory HSQL database to make testing/running the application relatively easy.
The module named `todolist-core` is common to all web layers and is a good use case to see how web frameworks integrate with Spring.

Common web utilities (JSTL tags, Filters, Backing beans, etc) are packaged in a separate common web module named `todolist-web-common`.

For each web framework, a separate war module is created to implement ONLY the web layer of the application.

View technology may vary for each framework. Here, JSP views are (re)used for most of current implementations.

URLs under `/user/*` and `/todos/*` must be accessible to only logged users. 
This requirement should be implemented using a servlet filter or equivalent (Struts interceptor, Spring MVC interceptor, etc)

Note that security is not addressed since not all frameworks provide security support.

Form validation should be done using Bean Validation API (JSR303). Form backing beans are already defined with validation constraints in the `todolist-web-common` module.
All you have to do is to integrate the validation logic with the framework in use.

Finally, the static html template located in `src/site/template` can be used as a starting point to implement the application with a new framework.

## Build and run Todolist MVC

1.  Check out the project source code from github : `git clone https://github.com/benas/todolist-mvc.git`
2.  Open a terminal and run the following command from root directory : `mvn install`
3.  Choose a web framework to test and run it. For example : `cd todolist-web-springmvc && mvn tomcat7:run`
4.  Browse the following URL : `localhost:8080/`
5.  You can register a new account or login using the following credentials : foo@bar.org / foobar

## Contributions

In order to compare these frameworks objectively, the best implementation should be provided for each framework.

If you are an expert in some of these technologies, please don't hesitate to fix/improve every single aspect of the current implementation if any.

The goal of Todolist MVC is to be community driven, so every single contribution is welcome!

## License
Todolist MVC is released under the [MIT License][].

[TodoMVC]: http://todomvc.com/
[TechEmpower's Framework Benchmarks]: https://github.com/TechEmpower/FrameworkBenchmarks
[Twitter Bootstrap]: http://getbootstrap.com/
[MIT License]: http://opensource.org/licenses/mit-license.php/
