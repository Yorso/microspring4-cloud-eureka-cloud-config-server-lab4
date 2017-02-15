##Lab 4 - Create a Spring Cloud Eureka Server and Client (2)

  **BONUS - Refactor to use Spring Cloud Config Server.**  

  We can use Eureka together with the config server to eliminate the need for each client to be configured with the location of the Eureka server

22. Add a new file to your GitHub repository called “application.yml” (or properties).  Add the following key / values (use correct YAML formatting):
  - eureka.client.serviceUrl.defaultZone=http://localhost:8010/eureka/ 

23. Open the common-config-server project (ConfigData-lab3).  This is essentially the same config server that you produced in lab 3.  Alter the application.yml to point to your own github repository.  Save all and run this server.  (You can use it as the config server for almost all of the remaining labs in this course.)  

24. Edit each client application’s application.properties file.  Remove the eureka client serviceUrl defaultZone key/value.  We will get this from the config server.

25. In each client project, add the following key/value to bootstrap.yml (or bootstrap.properties), using correct YAML formatting: 
  - spring.cloud.config.uri: http://localhost:8001.
  
26. Add an additional dependency for spring-cloud-config-client in pom.xml:
  ```
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-config</artifactId>
  </dependency>
  ```

27. Make sure the Eureka server is still running.  Start (or restart) each client. Open [http://localhost:8020/sentence](http://localhost:8020/sentence) to see the completed sentence.

28. If you like, you can experiment with moving the “words” properties to the GitHub repository so they can be served up by the config server.  You’ll need to use separate profile sections within the file (yml) or files with names that match the application names (yml or properties).  A single application.yml file in the common-config-server project (ConfigData-lab3) would look something like this:

  ```
  ---
  eureka:
    client:
      serviceUrl:
        defaultZone: http://localhost:8010/eureka/
  ---
  spring:
    profiles: subject
  words: I,You,He,She,It
  
  ---
  spring:
    profiles: verb
  words: ran,knew,had,saw,bought

  ---
  spring:
    profiles: article
  words: a,the

  ---
  spring:
    profiles: adjective
  words: reasonable,leaky,suspicious,ordinary,unlikely

  ---
  spring:
    profiles: noun
  words: boat,book,vote,seat,backpack,partition,groundhog  
  ```
