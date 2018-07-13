# PowerBrew5000

The PowerBrew5000 is a state of the art hot beverage vending machine simulation. It emulates a machine that is typical in gas stations, where instead of brewing actual coffee grounds or tea leaves it injects a concentrate.


#Assumptions/Stipulations
 - This is a machine that has a simple power on button, therefore the program runs in a continuous loop by design and need ctrl-c to exit
 - Built as a console app and so makes use of stdin and stdout
 - All condiments and concentrates are in liguid form and simple injected into a cup that is placed by the user.
 - Because liquid concentrates are used, the water temp and brew times are consistent regardless of drink.
 - A background process runs to simulate water heating, and checking for concentrate/condiment levels
 - There are no checks for the presence of a cup..don't spill!

#Software Design Pattern
The PowerBrew 5000 utilizes the "Strategy Design Pattern" both for condiments and concentrates for the various drinks, and allows the menu system to inject the proper brewing and condiment behaviors. I've chosen this method because the concept of brewing a drink via concentrates is the same across all drinks, the primary difference being that each drink uses a different concentrate. With the Strategy Pattern we can simply make those behaviors separate classes and then inject the right behavior at run time.

By designing it this way we also create a lot of flexibility. A new condiment or beverage type can be added by simply creating a new behavior, updating an enum, and adding the behavior to an implementation map. Once down everything else, including menu generation is handle automatically.

There is very little code duplication because of the use of the strategy pattern in conjunction with enums that allow us to create menus and make drinks with out any long switch statements or if..then statements.

#Above and Beyond
I wanted to make use of the threading concept learned in the Advanced Programming class I just finished. To make a more realiztic simulation of hardware, a background process is started which checks/maintains water temperature, checks and updates extract/condiment levels, and will turn the machine off for maintence should these levels get low.

We simulate water temperature dropping over time, which causes the heater to kick back on until the "prefect" serving temp is maintained.





