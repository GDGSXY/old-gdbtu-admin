#!/bin/bash

if [[ $BUILD_ENV == local ]]; then
  mkdir ~/.m2
  curl http://39.108.112.152:65432/maven/settings.xml > ~/.m2/settings.xml
  cat ~/.m2/settings.xml
fi

mvn clean package -DskipTests
