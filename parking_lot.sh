#!/usr/bin/env bash
echo "compiling code"
mvn clean install
java -jar target/parking-lot-jar-with-dependencies.jar testing