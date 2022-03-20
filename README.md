A small Apache-based application with Spring Boot
----------------------------------------------
##What it does
It has a <code>SingleController.java</code> java class mapping the <code>http://localhost:8080</code> path to the contents of the folder <code>src/main/resources</code>

##How to run
* Maven build with goal <code>spring-boot:run</code> to just run it from inside eclipse
* Maven build with goal <code>clean package</code> to produce a clean .jar 

TroubleShoot
----------------
##How to clean up the apache tomcat port
Solution: Open dos prompt to kill the process holding 8080

```
C:\Users\pvassil>netstat -ano | findstr :8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       13304
  TCP    [::]:8080              [::]:0                 LISTENING       13304

C:\Users\pvassil>taskkill /pid 13304 /f
SUCCESS: The process with PID 13304 has been terminated.
```

See also:
   https://stackoverflow.com/questions/12737293/how-do-i-resolve-the-java-net-bindexception-address-already-in-use-jvm-bind

##How to fix the error sign at Eclipse
Right click on the project -> Maven -> Update project
   