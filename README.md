# PowerBrew5000

The PowerBrew5000 is a state of the art hot beverage vending machine simulation.  

It emulates a machine that is typical in gas stations, where instead of brewing actual coffee grounds or tea leaves it injects a concentrate.

As part of the emulate a background process is started which checks/maintains water temperature, checks and updates extract/condiment levels, and will turn itself off for maintence should these levels get low.

#Software Design Pattern
The PowerBrew 5000 utilizes the "Strategy Design Pattern" both for condiments and concentrates for the various drinks, by allowing the menu system to inject the proper brewing and condiment injection behaviors. We've chosen this method because the concept of brewing a drink is the same across all drinks, the primary difference being that each drink uses a different concentrate. With the Strategy Pattern we can simply make those behaviors separate classes and then inject the right behavior at run time.

By designing it this way we also create a lot of flexibility. A new condiment or beverage type can be added by simply creating a new behavior, updating an enum, and adding the behavior to an implementation map. Once down everything else, including menu generation is handle automatically.

There is very little code duplication because of the use of the strategy pattern in conjunction with enums that allow us to create menus and make drinks with out any long switch statements or if..then statements.





# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runable package 


```bash
mvn clean compile assembly:single
```


# How to run


```bash
java -classpath target/Example-1-1.0-SNAPSHOT-jar-with-dependencies.jar edu.bu.met.cs665.Main
```

or


```bash
run.sh 
```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```

# Run Checkstyle 

To analyse this example using CheckStyle run 

```bash
mvn checkstyle:check
```


CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. You can change it to other styles like sun checkstyle. 







