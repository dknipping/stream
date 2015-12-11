# Project setup

- Checkout Project
- Build with maven ( mvn install )

## Setup MongoDB

[https://docs.mongodb.org/manual/installation/](https://docs.mongodb.org/manual/installation/)

## Setup Neo4j

Neo4j runs embedded. Neo4j Browser is available at [http://localhost:7474/browser/](http://localhost:7474/browser/)

# Run Projects
java -jar stream-mongodb-1.0.0-SNAPSHOT.jar  => Port 9000

java -jar stream-neo4j-1.0.0-SNAPSHOT.jar    => Port 9100 


## Git Config

* git config --global user.name "Firstname Lastname"
* git config --global user.email "firstname.lastname@mail.com"
* git config --global core.eol lf

* Windows: git config --global core.autocrlf false
* Linux:   git config --global core.autocrlf input

* Windows: git config --global core.longpaths true   