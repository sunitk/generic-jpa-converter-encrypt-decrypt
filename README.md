# Spring Boot 2 generic JPA converter to encrypt and decrypt an entity attribute
Generic JPA converter for encryption decryption. Uses Spring Boot, JPA with Hibernate.

JPA allows writing 'conversion' code so that an entity attribute (table column) can be converted from one type to another and back. Though this is not a latest feature of JPA nor a bleeding edge topic, I am sharing how I wrote a generic converter for encryption and decryption of a string type table column.

This repository contains code which accompanies the blog post [Spring Boot 2 generic JPA converter to encrypt and decrypt an entity attribute](https://sunitkatkar.blogspot.com/2018/04/spring-boot-2-generic-jpa-converter-to.html)

## Getting Started

This is a typical maven project. Download the source as a zip file or checkout the code and import as an Existing Maven project in your IDE.

### Prerequisites

* Java 8
* Spring Boot 2
* MySQL
* Not mandatory, but you can use any suitable IDE like Spring STS

 

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) 
* [Thymeleaf](https://www.thymeleaf.org/) - Rendering HTML pages


## Authors

* **Sunit Katkar** - *Initial work* - [Sunit Katkar](https://sunitkatkar.blogspot.com/)

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details

## Request
You are free to fork this repository, but please drop me a note at sunitkatkar@gmail.com
