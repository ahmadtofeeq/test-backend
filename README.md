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
<b>Pre-requiste</b> : Installed postgres data and create database named backend. database should be owned by user postges with password as postgres
* Its a simple spring boot application which can be run once pre-requiste is matched.



