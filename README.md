##0. Micronaut demo

Run the application

```
./gradlew run
```

If application is not running - install SDKMAN and Micronaut from SDKMAN:
```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version

sdk install micronaut

./gradlew run
```

## 1. WebSocket Demo
Code in java/websocket.chat

Open 2 browser windows with different URIs:

```
http://localhost:8080/#/stuff/fred
http://localhost:8080/#/stuff/bob
```

The first part of the URI (in the above case `stuff`) is the topic being discussed, last part is the username of the user.

Send messages!

## 3. JSON example 3 variants.
Code in java/websocket.chat.jsonexample

Curl requests:

```
curl -X POST -H "Content-type: application/json" -H "Accept: application/json" localhost:8080/people/simple -d '{"firstName":"Fred","lastName":"Flintstone","age":45}'
curl -X POST -H "Content-type: application/json" -H "Accept: application/json" localhost:8080/people/future -d '{"firstName":"Fred","lastName":"Flintstone","age":45}'
curl -X POST -H "Content-type: application/json" -H "Accept: application/json" localhost:8080/people/single -d '{"firstName":"Fred","lastName":"Flintstone","age":45}'
```

## 4. Build/Deploy application

Simple way - build and run JAR as usual:

```
java -jar ***/build/libs/websocket-chat-0.1-all.jar
```

Create Graal native images in Docker or outside Docker and run(ultrafast!!!) as in this short guide(
read from this paragraph: "5.1 Creating Graal native image"):

```
https://guides.micronaut.io/micronaut-creating-first-graal-app/guide/index.html
```

Also Micronaut support many deploying features like:

- Deploying Functions to AWS Lambda:
```
https://docs.micronaut.io/latest/guide/index.html#lambdaFunctions
```

- Cloud Environment Detection and Configuration:
```
https://docs.micronaut.io/latest/guide/index.html#cloudConfiguration
```

and many others.
