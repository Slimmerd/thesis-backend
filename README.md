## Description

Server side of thesis project. This part receives statistics data and uploads it to DB

## Environment variable file .env
```
MONGO_DB=mongodb://thesisDBTest:pass@mongodb:27017/thesisDB
statsKey="key"
MONGO_INITDB_DATABASE="thesisDB"
MONGO_INITDB_ROOT_USERNAME="thesisDBUser"
MONGO_INITDB_ROOT_PASSWORD="pass"
```

## Installation

```bash
$ npm install
```

## Running the app

```bash
# development
$ npm run start

# watch mode
$ npm run start:dev

# production mode
$ npm run start:prod
```

**To use all functionality of backend including database it is recommended to use Docker.**

## Running the app using Docker
Docker and Docker-Compose is required to run the application. The installation part above should be skipped.

```bash
# build container
$ docker build -t thesis-backend ./   

# start
$ docker-compose up

# stop
$ docker-compose down
```

## Load, Build, Save Docker container
This part needed in case if you want to run backend container on the separate device without extra building.
In this case you will need to move to your server container file ```thesis-backend.tar```, ```docker-compose.yml```, ```.env```, and folder ```docker-entrypoint-initdb.d```

```bash
# build container
$ docker build -t thesis-backend ./   

# save backend container
$ sudo docker save -o ./thesis-backend.tar thesis-backend

# load container in Docker
$ sudo docker load -i ./thesis-backend.tar
```