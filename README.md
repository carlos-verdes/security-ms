# security-ms

## Introduction

Spring Boot microservice for login, after user authentication retrieves a Json Web Token (RS256).
http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html

##Operations

It provides the next REST operations:
- POST /tokens --> authenticates the user and creates a new JWT 
- PUT /tokens token --> validates a token and retrieves tokenInfo


This first implementation authenticate with a mock with the next credential:
admin/secret

So the next BASIC Auth header should be added with the POST operation:
```
Authorization Basic YWRtaW46c2VjcmV0
```

##Examples:

Request:
```
POST /tokens
Authorization Basic YWRtaW46c2VjcmV0
```

Response:
```
{
  "data": "eyJhb..."
}
```

Request:
```
PUT /tokens
eyJhb...
```
Response:
```
{
  "data": {
    "subject": "admin"
  }
}
```

