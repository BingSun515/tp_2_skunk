INSTALL:
JDK 11.X
MAVEN IF NEEDED
https://marketplace.eclipse.org/content/m2e-apt


From Command prompt:
Build project: mvn clean install
Run project java -cp dist/SkunkProject-0.0.1-SNAPSHOT.jar edu.skunkApp.SkunkAppMain

Run project java -cp dist/SkunkProject-0.0.1-SNAPSHOT.jar;lib/;libs/ edu.skunkApp.SkunkAppMain

RUN ALL tests: mvn test -P dev
For single TEST: mvn test -Dtest=test/edu.skunkApp.businessobject.Implementation.RollBoImplTest
