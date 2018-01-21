# CometSale
OOAD course project

In order to run mongoDB, you have to download the mongoDB driver from [MongoDB Driver](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.mongodb%22%20AND%20a%3A%22mongo-java-driver%22).

After you download the jar file mongodb-java-driver-3.6.0-beta1.jar .
Add it as a user library to the project(I use eclipse. You can try other IDE.)
You can run the main() in test. It will use the pushUser() method in com.CometSale.MongoDB.User to push a user class to the mongoDB online.You can also find the login information in that method.

If you want more information about the mongodb java driver. [Click here](http://mongodb.github.io/mongo-java-driver/3.5/driver/getting-started/quick-start-pojo/)

Good luck, guys.

#### update of 09/20/2017 by Jiawei
1. create a generic mongoDB insert, find and update methods class.
2. use the generic methods to implement the operations on UserDetails collection.

Use the following URL to start:
http://localhost:8080/CometSale/login

All Working now!!!!
- main bug was empty Resources folder needed to be added!

Addition 1:
User Details pushing to MongoDB has  which needs to be corrected.
