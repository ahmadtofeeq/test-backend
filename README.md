# Automatic Irrigation System

### Plot APIs
Following are the endpoints for plot:


* Add a new plot  [Post] /plot/add
* List all plots  [Get] /plot/list
* Configure Plot  [Put] /plot/configure/{id}
* Edit a plot     [Put] /plot/edit/{id}

### Guides
##How solution is designed:
* Two thread are created with a shared blocking queue to simulate IOT irrigation request/response model. 
* One thread is acting as IOT sensors and send information to cloud that certain plots need to be irrigated.
* Second thread is receiving response from first thread and acting upon it. Once Plot is irrigated, this thread change the irrigation status.

### How to run
<b>Pre-requiste</b> : Database readyness
* 1. Install postgres or leverage existing postgres client 
* 2. Create a user with username as **postgres** and password as **postgres**.
`CREATE USER postgres WITH PASSWORD 'postgres';`
* 3. Create database **backend**
* 4. Use below script to assign proper access to database user
## A script to
`GRANT USAGE ON SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON DATABASE backend TO postgres;
GRANT ALL PRIVILEGES ON ALL tables IN SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON ALL sequences IN SCHEMA public TO postgres;`

## Running Spring boot application
go to project directory and run below command
`gradlew bootRun`



