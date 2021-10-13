#!/bin/bash

args="$@"

cmd="java -jar app.jar $args"
echo "$cmd"
$cmd
