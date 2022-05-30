# Jessica's Online Course System
This is an online course system
- Customers can view the course ad teacher information
- Only registered users can view the course videos
- Admins can sign in the admin dashboard and manage resources according to their permission

## Installation
Use the following command to pull the source code from the remote repository to the local

```
git clone https://git.imooc.com/littlelittleJessica/course-online.git
or
git clone ssh://git@git.imooc.com:80/littlelittleJessica/course-online.git
```

## modules in project
* **admin**<br>
admin dashborad, managing resources，vue cli project
* **business**<br>
The core bussiness module including all business controllers. (spring boot project)
* **doc**<br>
Related documentation, including database initialization script
* **eureka**<br>
Registration Center. (spring boot project)
* **file**<br>
File module, including file upload operations. (spring boot project)
* **gateway**<br>
Routing module, define the gateway of the project. (spring boot project)
* **generator**<br>
Mybatis code generator, run mybatis-generator to generate domain, mapper.xml and mapper for a table
* **server**<br>
Public jar module which business, file, system dependent on (spring boot project)
* **system**<br>
System module，including system operations such as user login. (spring boot project)
* **web**<br>
Front end web module，vue cli project


## Project initialization
* You should install the following tools: idea, nodejs，jdk1.8, mysql8.0, navicat
* Open the source code with idea
* Refresh the maven dependencies
* Install vue-cli
```
npm install -g @vue/cli
```
* Install node module
```
Initialize web module
cd web
npm install

Initialize admin module
cd admin
npm install
```
* Create database: courseimooc
* The database initialization script is in /doc/db/all.sql

## Run the project
* Run Eureka：EurekaApplication
* Run the gateway module：GatewayApplication
* Run the system module：SystemApplication
* Run the business module：BusinessApplication
* Run the file module：FileApplication
* Run the frontend-admin module：admin\package.json
* Run the frontend-web module：web\package.json

## Page access
* The admin dashboard address: http://localhost:8080/login<br>
The initial username and password：test/test
* The web address: http://localhost:8083<br>
You can register a new user(check the backend log to get the SMS code)

## Resources
All the resources are in /doc/db/resource.json<br>
You need to configure all resources on the admin dashboard and configure permissions in role management
After the permissions are configured, you need to log in again
