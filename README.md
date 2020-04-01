# Getting Started

### Install lombok
For eclipse: Just download the Jar-File (version 1.18.12) from https://projectlombok.org and double click on it as administrator (Strg + Shift + Doubleclick), 
then follow the instructions.

For other IDEs see:
https://projectlombok.org/setup/overview

### Deployment to AWS
Make sure, you use Java 8.

Run `mvn package`.

And upload the generated jar from the target folder to AWS Beanstalk.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)

