# Document Classification using Google Cloud Natural Language API

This API takes text as an input and returns all the possible categories/classification of that text

In this application, only text document can be uploaded as of now. As soon as the document is uploaded, it will invoke the Google content Classification API and retrieve the content categories that their hosted model predicted. It also provides the confidence factor for the categories that it listed. It may provide more than 1 category for each document. 


## PREREQUISITES

1. Sign up on Google Cloud Platform and enable Machine learning API for new/existing project.
2. Create credentials to access this API. And download the json file of this credentials.
3. Then set environment variable for GOOGLE_APPLICATION_CREDENTIALS using the command given below:
    
    set GOOGLE_APPLICATION_CREDENTIALS="Path of json file"
4. set up the following software:

    a.Java 8
    
    b.npm v5.0.3
    
    c.Apache Maven 3.2.5
    
## Setup Instructions:

### User Interface :
    1. fork the UI code and run the below command:
            
            npm install
            
    2. To start the UI you need to run below command : 
    
        npm start
        
### Restful Service;
      1. fork the RestFul service code and run the below command:
            
            mvn install
            
      2. Now in the base directory of the forked code base , a new folder would be generated i.e. target
      3. Go inside the target folder and run the below command to start the restful services:
        
            java -jar SpringBootRestApiApp-1.0.0.jar
          
    

    
    
