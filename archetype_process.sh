#!/bin/bash

mvn archetype:create-from-project -Darchetype.properties=./archetype.properties
cd target/generated-sources/archetype
mvn install