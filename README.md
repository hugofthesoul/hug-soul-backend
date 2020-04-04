# Getting Started

### Running it
Set the Youtube API key and run this project as a Spring Boot project.
Make sure you never commit that key.
An easy way to add that key is to define it in the environment variable `YOUTUBE_API_KEY`.

### Install lombok
For eclipse: Just download the Jar-File (version 1.18.12) from https://projectlombok.org and double click on it as administrator (Strg + Shift + Doubleclick), 
then follow the instructions.

For other IDEs see:
https://projectlombok.org/setup/overview

### Deployment to Heroku
Deployments will be done on every commit to the github master branch: https://github.com/hugofthesoul/hug-soul-backend

### Changing the Youtube Api Key
1. Go to https://dashboard.heroku.com/apps/hug-of-soul/settings
2. In section Config Vars: Click the button Reveal Config Vars
3. Edit the YOUTUBE_API_KEY (by clicking the pencil icon to the right of it)
4. Change the value and save


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)

