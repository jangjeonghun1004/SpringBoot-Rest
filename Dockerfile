FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/*.jar
ARG PROFILES
ARG ENV
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.jar"]



mkdir -p /my/local/data
sudo chown -R 1001:1001 /my/local/data

docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -v /my/local/data:/var/lib/mysql -d mysql


