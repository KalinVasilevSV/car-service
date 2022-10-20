#!/bin/bash

cp ../build/libs/car-service-DEV-SNAPSHOT.jar ./car-service-DEV-SNAPSHOT.jar

docker system prune -f

DOCKER_BUILDKIT=1 docker build -t car-service .

docker run -p 8080:8080 car-service-DEV-SNAPSHOT