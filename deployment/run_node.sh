#!/bin/bash

app_dest_path=/home/vagrant
app_jar=DAW-videoclub-1.0-SNAPSHOT.jar
log_file=/home/vagrant/log.txt

java -jar "${app_dest_path}/${app_jar}" > $log_file 2>&1 &
