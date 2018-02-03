# spring-cloud-oauth-demo
Spring Cloud OAuth Demo Using Github as Auth Server

## Modules
1. github-token-generator : Module used to generate the token
2. service-provider : Module that serves the dummy service.

## How to use (For Github)

Note : Make sure that the service-provider's application.yml user-info-uri is pointed to https://api.github.com/user to use Github as token generator

1. Run both modules' Main Class
2. Open http://localhost:8080/token in a browser

    2.1. Login with Github if not yet logged on.
    
    2.3. Copy the displayed token.

3. Use postman to run the dummy service : http://localhost:9001/services/api/v1/dummy
    
    3.1. Add this header in postman

            *Key : Authorization

            *Value: Bearer <token from github>

          
          
## How to use (Custom Auth Server)

Note : Make sure that the service-provider's application.yml user-info-uri is pointed to http://localhost:9002/services/user instead of github

1. Run custom-auth-server and service-provider's main class

2. Use Postman to get the tokens from our custom auth server: http://localhost:9002/services/oauth/token

    2.1. Request Instructions
    
            2.1.1 Method : POST
            
            2.1.2 User Basic Auth and fill in the fields using (dummyid and dummysecret) - refer to application.yml
            
            2.1.3 In the Body, select urlencoded and add these values
            
                        KEY         |    VALUE
                   *  grant_type    |   password  
                   *  client_id     |   dummyid
                   *  username      |   dummyuser01  (refer to Dummy Security Config for the possible users)
                   *  password      |   password     (refer to Dummy Security Config for the password)
                   
    2.2. Example result of this request is shown below, now copy the access token, it will be used to get the secured data from our service
    
        {
            "access_token": "9d199930-40a7-476d-a3bf-54f1b83b7a1e",
            "token_type": "bearer",
            "refresh_token": "5d44442a-3610-49dc-9e54-85a55712bf09",
            "expires_in": 42952,
            "scope": "dummy_read dummy_report"
        }

3.  Use Postman to get the dummy data : http://localhost:9001/services/api/v1/dummy

    3.1. Add this header in postman
    
          * Key : Authorization
          * Value: Bearer <token from custom auth server>
            


Grant Type Reference : https://alexbilbie.com/guide-to-oauth-2-grants/
