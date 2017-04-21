#!/bin/bash

if [[ $# -ne 1 ]]; then
	echo "Missing message"
	exit 1
fi

git checkout develop

git pull origin develop

git add * && git add .*

git commit -m "$1"

git push origin develop

echo "Successful dev-commit"


