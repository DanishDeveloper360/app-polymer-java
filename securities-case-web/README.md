# Securities Case Web

securities-case-web implements a REST API and contains a websocket for price updates. The web front-end should be implemented with AngularJS or React.

After building this project it may be started by: 

    $ mvn spring-boot:run
    
Or by running the main class:

    securities.web.BootApp
    
Open the URL: http://localhost:8080/instruments to retrieve the instruments.
Open the URL: http://localhost:8080/ to see an example of a page which receives price updates over websockets
    
   
