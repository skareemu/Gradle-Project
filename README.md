# Gradle Project

### Setup
* Install Gradle [Link](https://gradle.org/install/)
* Install Eclipse [Link](https://www.eclipse.org/downloads/) or InteliJ (https://www.jetbrains.com/idea/download/)
* Java SDK [Link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* JAVA_HOME: Set JAVA_HOME in system variables pointing to the Java SDK folder\bin
* GRADLE_HOME: Set GRADLE_HOME in system variables pointing to gradle local directory.
* After cloning the repo, make sure to provide your twitter accoun's access & secret keys in env.properties file
* After cloning the repo,make to provide your AWS keys in AWSAccess.java file


### Getting Started local execution
```sh
$ git clone https://github.com/skareemu/TwitterProject.git
$ import project from Eclipse or InteliJas a Gradle project
$ gradle clean
$ gradle build
$ gradle task E2E
