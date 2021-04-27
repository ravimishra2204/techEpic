restapi app shows the basic CRUD operations carried out through a Spring boot project

Prerequisite
Installed:
Docker

Library:
Java 1.8 
Maven 3.x
H2 in-memory database
Lombok plugin installed in IDE (for local run)

Steps

/* accessing through repository */
- Go to bitbuket url:https://github.com/ravimishra2204/techEpic/tree/feature/restApi
- Clone the branch from local folder:
  git clone --single-branch --branch feature/restApi https://github.com/ravimishra2204/techEpic.git
- Import as maven project into Intellij/ide's
	execute maven command to generate jar:
  mvn clean install
-go to main class, and run as java application
  verify thorugh console logs. post succesfull startup test app as below

-Test application
go to swagger url: http://localhost:8083/swagger-ui.html#/

it will display the company service endpoint screen

/* accessing through docker hub */
docker hub url for app container: https://hub.docker.com/r/ravi2204docker/restapi/
Use below docker pull command to setup locally
$ docker pull ravi2204docker/restapi:latest
// verify through swagger. hit below url in browser
http://localhost:8083/swagger-ui.html#/
it will display the company service endpoint screen

Curl URLS:

1)add a company (api name : addCompany) 
- curl -X POST "http://localhost:3333/api/v1/addCompany" -H "accept: */*" -H "Content-Type: application/json" -d 
	"{ \"compName\": \"string\", \"country\": \"string\", \"owners\": [ { \"name\": \"string\", \"ssnNo\": \"string\" } ], \"phNo\": \"string\"}"

2)add an owner under a company (api name: addOwner)

-curl -X POST "http://localhost:3333/api/v1/addOwner?id=1" -H "accept: */*" -H 
	"Content-Type: application/json" -d "{ \"name\": \"string\", \"ssnNo\": \"string\"}"
	
3)get list of companies (api name: getCompanies)
	
-curl -X GET "http://localhost:3333/api/v1/getCompanies" -H "accept: */*"
	
4)get a company by id (api name : getCompany)
	
-curl -X GET "http://localhost:3333/api/v1/getCompany?id=1" -H "accept: */*"
	
5)to update a company by id (api name :updateCompany)
	
-curl -X PUT "http://localhost:3333/api/v1/updateCompany?id=1" -H "accept: */*" -H "Content-Type: application/json" 
	-d "{ \"compName\": \"1\", \"country\": \"string\",\"owners\": [ { \"name\": \"string\", \"ssnNo\": \"string\" } ], \"phNo\": \"string\"}"
	
6)to validate a ssn no ( api name : validate SSN)
 	
-curl -X PUT "http://localhost:3333/api/v1/validateSSN?ssn=1d" -H "accept: */*"
