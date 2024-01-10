#!/bin/bash

./gradlew shadowJar \
 && java -jar build/dist/ojc-0.0.0-SNAPSHOT-cli.jar $@
