#!/bin/sh


curl -v -X POST -H "Content-Type: application/json" -d '{"firstname":"Nikolaj","surname":"Majorov","email":"nikolaj@majorov.biz"}' http://localhost:8088/foo && echo
