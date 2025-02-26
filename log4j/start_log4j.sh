#!/bin/bash
echo "Bonjour David"

# Définition de JAVA_HOME et mise à jour du PATH
export JAVA_HOME="/usr/lib/jvm/java-1.8.0-openjdk"
export PATH="$JAVA_HOME/bin:$PATH"

# Démarrer le service Log4j
cd log4j
javac -cp "lib/*" -d bin src/MyLogger/MyLogger.java
java -cp "bin:lib/*" MyLogger.MyLogger










