# spring-cloud-oauth-demo
Spring Cloud OAuth Demo Using Github as Auth Server

## Modules
1. github-token-generator : Module used to generate the token
2. service-provider : Module that serves the dummy service.

## How to use
1. Run both modules' Main Class
2. Open http://localhost:8080/token in a browser

    2.1. Login with Github if not yet logged on.
    
    2.3. Copy the displayed token.

3. Use postman to run the dummy service : http://localhost:9001/services/api/v1/dummy
    
    3.1. Add this header in postman

            *Key : Authorization

            *Value: Bearer <token from github>
