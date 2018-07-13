package edu.bu.met.cs665.brew;

public class Beverages {

    //List of all beverages that can be made by this model
    //to add a new beverage add it here, create a new object that implements BrewBeverage
    //and don't forget to add to whatever is injecting the proper behavior at the time of ordering
    //should be in ui.MainMenu fillBeverageMap
    public enum BeverageChoices {
        Espresso("Espresso"),
        Americano("Americano"),
        Latte_Macchiato("Latte Macchiato"),
        Black_Tea("Black Tea"),
        Green_Tea("Green Tea"),
        Yellow_Tea("Yellow Tea");


        private String returnName;

        BeverageChoices(String returnName) {
            this.returnName = returnName;
        }

        @Override
        public String toString() {
            return this.returnName;
        }

    }
}
