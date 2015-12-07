#! /usr/bin/env python
"""
    Simple server to emulate requests
    author: Nikolaj Majorov
    04.12.2015
"""

from bottle import route, run, response,post,get,request

@post('/rest')
def hello():
    response.content_type = 'application/json; charset=utf-8'
    return '{"response": "OK"}'

@get('/rest/list')
def hello():
    """
    response for get method
    """
    response.content_type = 'application/json; charset=utf-8'
    return '{"response": "OK"}'

@post('/rest/plus')
def helloHeaders():
    """
    Check the special header field
    """
    response.content_type = 'application/json; charset=utf-8'
    if request.headers.get('X-MySpecialHeader') == 'NM-JBOSS':
        return '{"response": "OK","headers":"OK"}'
    else:

        return '{"reasponse: "BAD"}'

#start server
run(host='localhost', port=7000, debug=True)
