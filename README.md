# SpringBoot2CrudPostgrese
CrudExample with Swagger ,logger,exception,transaction,JPQL,ITEXT,APACHEPOI



# Create User

# POST call
  http://localhost:8080/crudapp/saveuser
  
  request body  in postman raw JSON
  
 # {"id":2345, "username":"mahesh"} 
 
 Reponse Sucess
 
 -----------------------------------------
 # GetUsers. GET Call 
 
 http://localhost:8080/crudapp/getusers
 
 Reponse 
 # [
    {
        "id": 123,
        "username": "rakesh"
    },
    {
        "id": 2345,
        "username": "mahesh"
    },
    {
        "id": 2,
        "username": "prajna Singh"
    }
# ] 

------------------------------------------------------

# PUT call to update User

url http://localhost:8080/crudapp/updateuser

 
  request body  in postman raw JSON
  
 # {"id":2345, "username":"mahesh"} 
 
 -------------------------------------------------
 
 # delete call delete user by id
 
url  http://localhost:8080/crudapp/delete/1


Reponse deleted

----------------------------------------

# Get Call For get user by id
url http://localhost:8080/crudapp/getuser/123

Response. 
{
    "id": 123,
    "username": "rakesh"
}

 --------------------------------
#Spring Boot Tutorial
- --------------
      1. Java Basics: Make sure you have a solid foundation in Java programming language. Understand concepts like classes, objects, inheritance, interfaces, and exceptions.
      2. Maven or Gradle: Learn how to use build tools like Maven or Gradle. These tools help manage dependencies and build your Spring Boot applications.
      3. Spring Framework: Familiarize yourself with the core concepts of the Spring Framework, including Dependency Injection, Spring Beans, Aspect-Oriented Programming (AOP), and Spring MVC.
      4. Spring Boot Introduction: Understand what Spring Boot is and how it simplifies the process of building and deploying Spring applications. Learn about features like auto-configuration, embedded servers, and production-ready defaults.
      5. Spring Boot Initializr: Learn how to use the Spring Initializr to bootstrap a new Spring Boot project with the necessary dependencies.
      6. Spring Boot Starters: Understand the concept of starters. Starters are pre-defined sets of dependencies that can help you quickly bootstrap various types of applications.
      7. Spring Boot Annotations: Get familiar with commonly used annotations in Spring Boot like @SpringBootApplication, @RestController, @RequestMapping, etc.
      8. Spring Data JPA: Learn how to use Spring Data JPA for easy data access and manipulation. This integrates with JPA (Java Persistence API) to simplify database operations.
      9. Spring Boot and Thymeleaf (or other templating engines): If you’re building web applications, learn how to integrate Spring Boot with a templating engine like Thymeleaf for creating dynamic web pages.
      10. Spring Boot and RESTful APIs: Understand how to create RESTful APIs using Spring Boot. Learn about handling HTTP methods, request/response handling, and serialization/deserialization of data.
      11. Spring Boot Security: Learn about securing your Spring Boot applications using Spring Security. This involves authentication, authorization, and protecting against common security vulnerabilities.
      12. Spring Boot Testing: Understand how to write unit tests and integration tests for your Spring Boot applications. Learn about tools like JUnit and Mockito.
      13. Spring Boot Actuator and Monitoring: Explore Spring Boot Actuator for monitoring and managing your application in production. This includes features like health checks, metrics, and environment information.
      14. Logging and Error Handling: Learn about logging best practices and how to handle exceptions gracefully in Spring Boot applications.
      15. Deployment and Dockerization: Understand how to package your Spring Boot application into a deployable artifact (like a JAR or WAR file) and consider containerizing it using Docker for easy deployment and scaling.
   

###Dependency injection (DI) is a fundamental concept in the Spring Framework that helps manage dependencies between different components of an application. It’s a technique where one object supplies the dependencies of another object. This helps in achieving loose coupling, making the code more modular, maintainable, and testable.

#####Here’s a detailed explanation of Dependency Injection in the context of the Spring Framework:

####	 1.	Inversion of Control (IoC): IoC is a design principle where the control flow of a program is inverted. Instead of the application controlling the flow of execution, it delegates control to an external framework or container. In the case of Spring, the IoC container is responsible for managing the objects and their dependencies.
####	 2.	Components in Spring: In Spring, components are Java objects that are managed by the Spring IoC container. These can be regular Java objects or special types like beans, controllers, services, etc.
####	3.	Types of Dependency Injection:
####	•	Constructor Injection: Dependencies are injected through the constructor of the dependent class.
####	•	Setter Injection: Dependencies are injected using setter methods.
####	•	Method Injection: Dependencies are injected through regular methods.
####	4.	Advantages of Dependency Injection:
	   •	Reduced Coupling: Classes are not directly responsible for creating their dependencies, reducing the tight coupling between classes.
	   •	Testability: With DI, it’s easier to substitute real implementations with mock objects during unit testing.
	   •	Flexibility: It allows for easier swapping of implementations or configurations without modifying the client code.
###	5.	Spring Container: The Spring IoC container is responsible for managing the lifecycle of application objects. It creates and manages beans based on the configuration metadata provided.
###	6.	Bean Configuration:
	    •	XML Configuration: Historically, Spring used XML files for configuration. Beans and their dependencies were defined in XML files.
	    •	Annotation-Based Configuration: In modern Spring applications, you can use annotations like @Component, @Service, @Repository, and @Autowired for configuring beans and their dependencies.
	     •	Java Configuration: Instead of using XML, you can use Java classes annotated with @Configuration to define beans and their dependencies.
###	7.	@Autowired Annotation: This annotation is used to inject dependencies. It can be applied to fields, setter methods, and constructors. Spring will look for a bean of the same type and inject it.
###	8.	Scopes of Beans: Spring manages the lifecycle of beans, and you can define their scope:
	    •	Singleton: Only one instance of the bean is created, and it is shared across the entire application.
	    •	Prototype: A new instance is created every time the bean is requested.
	    •	Request: A new instance is created for each HTTP request.
	    •	Session: A new instance is created for each HTTP session.
###	9.	Circular Dependencies: Spring can handle circular dependencies by creating proxies or using other strategies.
###	10.	Qualifiers: When you have multiple beans of the same type, you can use the @Qualifier annotation to specify which one to inject.
###	11.	Lazy Initialization: You can configure beans to be lazily initialized, meaning they are created only when they are first requested.
###	12.	Profiles: Spring allows you to define different sets of beans for different environments or scenarios using profiles.

##Spring IOC responsiblity

#### 1.create object
#### 2.manage object
#### 3.making application configurable
####  4.managing dependencies


##Question:Difference between beanfactory and Application context

| Feature                           | BeanFactory                                            | ApplicationContext                                     |
|-----------------------------------|--------------------------------------------------------|--------------------------------------------------------|
| **Container Type**                | Simple container with basic functionality.             | Extended container providing advanced features and services. |
| **Lazy Loading**                  | Supports lazy loading of beans.                        | Supports lazy loading of beans.                        |
| **XML Configuration**             | Supports XML-based configuration for bean definitions. | Supports XML-based configuration for bean definitions. |
| **Annotation Support**            | Lacks built-in support for annotations.                | Provides built-in support for annotations.              |
| **BeanPostProcessor Registration** | Manual registration of BeanPostProcessor instances.    | Automatic registration of BeanPostProcessor instances.  |
| **Implementation Classes**        | Uses implementations like XmlBeanFactory.              | Uses implementations like ClassPathXmlApplicationContext (deprecated in favor of GenericWebApplicationContext), FileSystemXmlApplicationContext, AnnotationConfigApplicationContext, etc. |
| **Internationalization**          | Does not support internationalization.                 | Supports internationalization through MessageSource.  |
| **Enterprise Services**           | Lacks built-in support for enterprise services.        | Provides built-in support for enterprise services like JNDI lookup, EJB integration, etc. |
| **ApplicationEvent Publication**  | Does not support publishing and handling application events. | Supports publishing and handling of application events. |
| **AOP (Aspect-Oriented Programming)** | Supports AOP, but with manual configuration.       | Provides declarative AOP with automatic proxy creation. |
| **Transaction Management**        | Supports programmatic transaction management.         | Provides declarative transaction management.           |
| **Web Application Contexts**      | Does not provide specialized contexts for web applications. | Provides specialized contexts like XmlWebApplicationContext (deprecated in favor of GenericWebApplicationContext) and AnnotationConfigWebApplicationContext for web applications. |
| **Use Case**                      | Suitable for small to medium-sized applications.       | Suitable for both small and large-scale enterprise applications with advanced features. |
| **Deprecation/Updates**           | XmlBeanFactory is deprecated as of Spring 3.1 in favor of DefaultListableBeanFactory and XmlBeanDefinitionReader. ClassPathXmlApplicationContext is deprecated in favor of GenericWebApplicationContext. XmlWebApplicationContext is deprecated in favor of GenericWebApplicationContext. | Continuously updated with each Spring version, incorporating new features and improvements. Developers are encouraged to use the latest ApplicationContext implementations. |


###FileSystemXmlApplicationContext
    Loading: Beans loaded through the full path.
###ClassPathXmlApplicationContext
    Loading: Beans loaded through the CLASSPATH.
###XMLWebApplicationContext and AnnotationConfigWebApplicationContext
    Loading: Beans loaded through the web application context.
###AnnotationConfigApplicationContext
    Loading: Loading Spring beans from Annotation-based configuration.
###Usage AnnotationConfigApplicationContext

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
##Note:
  #####XmlBeanFactory is deprecated as of Spring 3.1 in favor of DefaultListableBeanFactory and XmlBeanDefinitionReader.
 #####


## ApplicationContext vs. BeanFactory

In a Spring application, you have the option to use either ApplicationContext or BeanFactory for managing beans. Understanding the differences between them is crucial for making the right choice based on your project's requirements.

### ApplicationContext

- **Instantiation:** ApplicationContext loads and initializes beans as soon as the Spring container starts. It doesn't wait until a specific bean is explicitly requested using `getBean("springbeanref")`.
- **Lifecycle Management:** Manages the complete lifecycle of beans from creation to destruction during the container startup.
- **Usage:** Use ApplicationContext when you want eager initialization of beans and comprehensive lifecycle management.
- **ApplicationContext loads all beans at startup that is Eager Loading:**
### BeanFactory

- **Instantiation:** BeanFactory initializes beans only when they are explicitly requested using `getBean("springbeanref")`. It follows a lazy-loading approach, delaying the bean creation until necessary.
- **Lifecycle Management:** Manages the lifecycle of beans at the time of bean retrieval. Beans are created and initialized when you call `getBean()`.
- **Usage:** Use BeanFactory when you want to defer the initialization of beans until they are needed, optimizing resource usage.
- **BeanFactory loads beans on-demand that is Lazy Loading :**

## Choosing between ApplicationContext and BeanFactory

Consider the following factors when choosing between ApplicationContext and BeanFactory:

- If you need eager initialization and complete lifecycle management, ApplicationContext is the suitable choice.
- If you prefer lazy loading and want to control when beans are instantiated, BeanFactory provides a more on-demand approach.

Make a conscious choice between ApplicationContext and BeanFactory based on your application's requirements and performance considerations.

