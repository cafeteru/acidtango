# acidtango

## Create MongoDB server

```shell
docker run -d --name mongo-on-docker -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo &
```

To manage this database, it's recommended to install [MongoDB Compass](https://www.mongodb.com/try/download/compass)

## Execute the application

```shell
mvn spring-boot:run
```