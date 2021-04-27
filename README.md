restapi app shows the basic CRUD operations carried out through a Spring boot project

Prerequisite
Installed:
Docker

Optional:
Java 1.8 
Maven 3.x
H2 in-memory database
Lombok plugin installed in IDE (for local run)

Steps

/* accessing through repository */
un zip the sources from the shared zip file.
setup in ide:
import as maven project. Generate jar file through maven.
goal: mvn clean:install
open command prompt, go to the source path where .docker file is copied.
Build Docker image
$ docker build -t restapi:latest .
verify the image
$ docker images

Run Docker Container
$ docker run -p 8083:8083  restapi
it will display the application startup logs
Test application
go to swagger url:
http://localhost:8083/swagger-ui.html#/
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
	curl -X POST "http://localhost:3333/api/v1/addCompany" -H "accept: */*" -H "Content-Type: application/json" -d 
	"{ \"compName\": \"string\", \"country\": \"string\", \"owners\": [ { \"name\": \"string\", \"ssnNo\": \"string\" } ], \"phNo\": \"string\"}"

2)add an owner under a company (api name: addOwner)
	curl -X POST "http://localhost:3333/api/v1/addOwner?id=1" -H "accept: */*" -H 
	"Content-Type: application/json" -d "{ \"name\": \"string\", \"ssnNo\": \"string\"}"
	
3)get list of companies (api name: getCompanies)
	curl -X GET "http://localhost:3333/api/v1/getCompanies" -H "accept: */*"
	
4)get a company by id (api name : getCompany)
	curl -X GET "http://localhost:3333/api/v1/getCompany?id=1" -H "accept: */*"
	
5)to update a company by id (api name :updateCompany)
	curl -X PUT "http://localhost:3333/api/v1/updateCompany?id=1" -H "accept: */*" -H "Content-Type: application/json" 
	-d "{ \"compName\": \"1\", \"country\": \"string\",\"owners\": [ { \"name\": \"string\", \"ssnNo\": \"string\" } ], \"phNo\": \"string\"}"
	
6)to validate a ssn no ( api name : validate SSN)
 	curl -X PUT "http://localhost:3333/api/v1/validateSSN?ssn=1d" -H "accept: */*"
