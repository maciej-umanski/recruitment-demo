#!/bin/sh
java --version
./mvnw clean test compile assembly:single
clear
java -jar ./target/recruitment-demo-0.0.1-SNAPSHOT-jar-with-dependencies.jar