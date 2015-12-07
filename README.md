Demo for a security policy assertions in camel route
====================================================
Camel route is acting as http request interceptor to validate users access-rights.

open the file:

        $[karaf.base]/etc/users.properties

set admin and optionally guest user.


install python module

        sudo pip install bottle

and run simple REST service:

        simpleRestService.py



## FUSE installation ##

install features:

    features:addurl mvn:org.jboss.quickstarts.fuse/secure-camel/6.2.0.redhat-133/xml/features

    features:install secure-camel


call service:

            curl -v -X POST -H "Content-Type: application/json" -d '{"firstname":"Nikolaj","surname":"Majorov","email":"nikolaj@majorov.biz"}' http://localhost:8088/foo | echo

you  should get response :


        < HTTP/1.1 401 Unauthorized
        < WWW-Authenticate: Basic realm="karaf"
        < Content-Type: text/plain
        < Content-Length: 0

Now call the same URL providing username and password:


            curl -v -X POST -H "Content-Type: application/json" --basic -u fuseadmin    -d '{"firstname":"Nikolaj","surname":"Majorov","email":"nikolaj@majorov.biz"}' http://localhost:8088/foo
            Enter host password for user 'fuseadmin':
            *   Trying 127.0.0.1...
            * Connected to localhost (127.0.0.1) port 8088 (#0)
            * Server auth using Basic with user 'fuseadmin'
            > POST /foo HTTP/1.1
            > Authorization: Basic ZnVzZWFkbWluOnMzY3IzdDEy
            > User-Agent: curl/7.40.0
            > Host: localhost:8088
            > Accept: */*
            > Content-Type: application/json
            > Content-Length: 73
            >
            * upload completely sent off: 73 out of 73 bytes
            < HTTP/1.1 200 OK
            < Content-Length: 18
            < Accept: */*
            < Authorization: Basic ZnVzZWFkbWluOnMzY3IzdDEy
            < breadcrumbId: ID-rh-niko-lenovo-40568-1449491738236-0-5
            < Server: WSGIServer/0.1 Python/2.7.10
            < User-Agent: curl/7.40.0
            < Content-Type: application/json; charset=utf-8
            < Connection: keep-alive
            <
            * Connection #0 to host localhost left intact
            {"response": "OK"}
