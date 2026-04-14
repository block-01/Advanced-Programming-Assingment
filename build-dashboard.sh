#!/bin/sh
echo //////////////////////
echo / Building Dashboard /
echo //////////////////////
echo

mvn -B clean package --file server/pom.xml

echo
echo /////////////////////
echo / Starting Database /
echo /////////////////////
echo

docker compose up --build -d

echo
echo //////////////////////
echo / Starting Dashboard /
echo //////////////////////
echo

mvn spring-boot:run -Dspring-boot.run.profiles=prod --file server/pom.xml
