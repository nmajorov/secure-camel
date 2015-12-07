#!/bin/sh

#call route with special header
curl -v -X POST -H "Content-Type: application/json" \
      -H "X-MySpecialHeader: NM-JBOSS" \
      -d '{"firstname":"Nikolaj","surname":"Majorov","email":"nikolaj@majorov.biz"}' \
       http://localhost:8088/foo | python -mjson.tool
