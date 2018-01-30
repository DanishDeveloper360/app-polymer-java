# Securities-Case

This project is used as assignment when selecting new hires at ING Securities and Private Banking.

Build this project by;

    $ mvn clean install
	$ cd securities-case-web
	$ mvn spring-boot:run

## Main subprojects

### securities-case-service

`securities-case-services` implements the services for this application and contains its domain model.
The domain model is simple. There is an Instrument class and a Price class. An instrument has a code and price.
A price has a timestamp and an amount. The services module contains the `InstrumentService` (spring component) which can be used to retrieve all instruments with their latest prices. It is also possible to register a InstrumentListener which will callback in case a price of an instrument is updated.
To simulate real instrument price updates a spring scheduler is used which randomly updates prices every second and triggers the callback.


### securities-case-web

`securities-case-web` implements a REST API to retrieve the instrument list `/instruments` and contains a websocket to retrieve updates of instrument prices.

The `webapp` folder contains a minimal client implementation to connect with the web socket as an example.

## The Assignment

Use the REST API and the web socket connection to show the instruments and their prices on a web page.
The prices should automatically update and highlight on update.
You could use Angular, Polymer or React for this.

Approach this assignment as if you're at a client project implementing a Minimum Viable Product which is going to be shipped the current sprint.
Code Quality is more important than features. There are bonus points for creating a stunning user interface.

Please add a short README file to explain how we can run your solution.
You can also use this README to document assumptions, caveats or anything else you would like to explain.

We expect that you’ll need about 3 to 5 hours for the assessment.
If you're running out of time, let us know what you wanted to do, but didn't have time for.

**NOTE**: Please do not use a generator (like yeoman),
because then it is very difficult for us to determine what you have written yourself and what parts are generated.

We judge the solution on:

- the overall approach you took to the assignment
- the architecture of the solution and the technologies used
- your solution for the use case

I you have any questions, don't hesitate to ask them at rob.faber@ing.nl, jan.heijmans@ing.nl or jens.panneel@ing.nl.

Good luck with the assignment!

## Solution

Clone this repository (do not fork), make a branch and create a pull request.
