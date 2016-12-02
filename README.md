Sample rest api using spring boot. Swagger is used for api documentation. Database used is MongoDb.
Note:
1)Configure the port in application.properties file (src/main/resources/)
2)Import the mongo db from folder "/SpringBootSampleDb".
	2.1)Sample Db restore command:
		mongorestore.exe --dir D:\StsWorkspace\SpringBootSample\SpringBootSampleDb --db SpringBootSampleDb
	2.2)Sample Db export command:
		mongodump -d SpringBootSampleDb -o "D:\StsWorkspace\SpringBootSample"
