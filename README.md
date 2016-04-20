# Jewelry-Shop (JESH)
##### Jewerly online shop, fullstack application for final project of JavaEE master in [CICE], JESH it is developed with JavaEE 8 the part of server (API) and HTML5, CSS3 and JavaScript the part of client. Uses a number of open source libraries and frameworks to work properly.

# API
* User
* Administrator
* Product
* Order
* Cart

### Version
0.0.1

### Tech

##### Front-End:
* [NodeJS] Event-driven I/O server-side JavaScript environment based on V8
* [npm] Package manager.
* [Grunt] Automation, performing repetitive tasks like minification, compilation, unit testing and linting.
* [Bower] Web sites are made of lots of things — frameworks, libraries, assets, and utilities.
* [Yeoman] Through our official Generators, we promote the "Yeoman workflow".
* [Angular] Is what HTML would have been, had it been designed for building web-apps.
* [Bootstrap] A sleek, intuitive, and powerful mobile first front-end framework for faster and easier web development.
* [Karma] Brings a productive testing environment to developers.
* [Jasmine] The Jasmine node package contains helper code for developing and running Jasmine tests for node-based projects.
##### Back-End:
* [Jersey] RESTful Web Services framework
* [Jetty] Jetty provides a Web server and javax.servlet container
* [Hibernate] An open source Java persistence framework project
* [Maven] Apache build manager for Java projects.
* [MySQL] An open-source relational database management system.
* [jUnit] A unit testing framework which is a central element of the Extreme Programming.
* [LOG4J] A logging library for Java

And of course JESH itself is open source with a [public repository] on GitHub.

### Installation

You need Maven, NodeJS and npm installed globally, and then:
*It is advisable have installed globaly npm dependencies: yo, grunt-cli, bower and generator-angular. Else you need add the .bin folder of .node_modules in your $PATH*

```sh
$ git clone https://github.com/ToniChaz/jewelry-shop jewelry-shop
$ cd jewelry-shop/server
$ mvn clean install
$ cd ../client
$ npm install
```
### Run to localhost
```sh
$ cd jewelry-shop/server
$ mvn jetty:run
$ cd ../client
$ grunt serve
```

### Build
```sh
$ cd jewelry-shop/client/
$ grunt build
$ cp dist/ ../server/src/main/webapp/
$ cd ../server
$ mvn clean package
```

### Todos

 - Write Tests
 - Add Code Comments

[License]
----

MIT


**Free Software, Hell Yeah!**

[CICE]: <http://cice.es/>
[NodeJS]: <https://nodejs.org/>
[npm]: <https://www.npmjs.com/>
[Grunt]: <http://gruntjs.com/>
[Bower]: <http://bower.io/>
[Yeoman]: <http://yeoman.io/>
[Angular]: <https://angularjs.org/>
[Bootstrap]: <http://getbootstrap.com/>
[Karma]: <https://karma-runner.github.io/>
[Jasmine]: <https://jasmine.github.io/2.0/node.html>
[Jersey]: <https://jersey.java.net/>
[Jetty]: <http://eclipse.org/jetty>
[Hibernate]: <http://hibernate.org/>
[Maven]: <https://maven.apache.org/>
[MySQL]: <https://www.mysql.com/>
[jUnit]: <http://junit.org/>
[LOG4J]: <http://logging.apache.org/log4j/>
[public repository]: <https://github.com/ToniChaz/jewelry-shop>
[License]: <LICENSE.txt>



