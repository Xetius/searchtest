SearchTest
==========
Building
--------
Requirements:
* Java 1.8
* Maven 3 

To build this you should simply run the following command:

`mvn clean install`

Once this has completed it will leave the output as a jar file inside the target directory.

Running
-------
To run the application use the included script file `search` as follows:

`./search [-x] -f <fileName> <directory>`

`-x             ` : Optional parameter to enable regex compatibiliy.  Changes the -f and -p options to be regular expressions.  
`-f <fileName>  ` : Name of the file to search for.  If regex compatibility is enabled, then this is the pattern to match against.  
`-p <text>      ` : Matching files must contain this text.  If regex compatibility is enabled, then this is the pattern to match against.  
`<directory>    ` : Path to the root directory to start the search in.  
`-h             ` : Display the help.  

Desired Libraries
-----------------
[Commons CLI](https://commons.apache.org/proper/commons-cli/)   Apache library for handling command line parameters