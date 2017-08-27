## Eclipse [Download](http://www.eclipse.org/downloads/eclipse-packages)
```
Download Eclipse IDE for Java EE Developers 64 bit
Extract contents to home directory
```

## Tomcat [Download](http://tomcat.apache.org/download-80.cgi)
```
Download 8.5.20 / Binary Distributions / Core / zip
Extract contents to home directory

Optionally download 8.5.20 / Source Code Distributions / zip
Move (NOT extract!) zip into tomcat directory
```

## Configure Tomcat in Eclipse
```
Window / Preferences / Server / Runtime Environments / Add...
Select the type of runtime environment: Apache Tomcat v8.5
Next
Tomcat installation directory: /home/fred/apache-tomcat-8.5.20
Finish
Apply and Close

Window / Show View / Other...
Server / Servers
Open

No servers are available. Click this link to create a new server...
Select the server type: Tomcat v8.5 Server
Finish
```

## Clone Projects from GitHub
```
cd ~/git
git clone https://github.com/frectures/spring
```

## Import Projects into Eclipse
```
File / Import...
Maven / Existing Maven Projects / Next
Root directory: /home/fred/git/spring
Finish
```

## Start Project for the first time
```
Project Explorer / geizhals (right-click) / Run As / Run on Server
[x] Always use this server when running this project
Finish
