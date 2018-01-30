# instrument app

## Prerequisites

### Polymer CLI

Install [polymer-cli](https://github.com/Polymer/polymer-cli):

    npm install -g polymer-cli

### Setup
   1. cd securities-case-web\src\main\webapp 
   2. bower install

### Run the app using spring-boot server

1. $ mvn clean install
2. $ cd securities-case-web
3. cd securities-case-web\src\main\webapp 
4. bower install
5. polymer serve                                // you can close the polymer server once build is complete
6. cd securities-case-web 
6. $ mvn spring-boot:run


## Alternatively (optional) : Start seperate development server using polymer serve
// if your are using polymer serve, you would need to change the urls in the app to point towards the spring-boot server explicitly (eg. http://localhost:8080/instruments)
  1. instrument-app.html >> line number 227
  2. instrument-data.html >> line number 10

    1. cd securities-case-web\src\main\webapp 
    2. polymer serve

## Run web-component-tester tests

1. polymer serve
2. open http://localhost:8081/test

or 

polymer test (does not work for me)

## Build

Build presets provide an easy way to define common build configurations in your `polymer.json` file. There are 3 build presets we put in `polymer.json`:

**es5-bundled**

- js: {minify: true, compile: true}
- css: {minify: true}
- html: {minify: true}
- bundle: true
- addServiceWorker: true
- addPushManifest: true
- insertPrefetchLinks: true

**es6-unbundled**

- js: {minify: true, compile: false}
- css: {minify: true}
- html: {minify: true}
- bundle: false
- addServiceWorker: true
- addPushManifest: true
- insertPrefetchLinks: true

**es6-bundled**

- js: {minify: true, compile: false}
- css: {minify: true}
- html: {minify: true}
- bundle: true
- addServiceWorker: true
- addPushManifest: true
- insertPrefetchLinks: true

Run the command to build the presets:

    polymer build

## Test the build

Use `polymer serve` to serve a specific build preset of the app. For example:

    polymer serve build/es5-bundled
