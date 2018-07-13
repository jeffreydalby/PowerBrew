package edu.bu.met.cs665.condiments;

public class Condiments {

    //List of all condiments that can be added to the model
    //to add a new Condiment add it here, create a new object that implements AddCondiment
    //and don't forget to add it to whatever is injecting the proper behavior at the time of order
    //which for now is in ui.MainMenu fillCondimentMap;

    public enum CondimentChoices {
        sugar("spoonful(s)of sugar."),
        milk("splash(es) of milk.");


        private String returnName;

        CondimentChoices(String returnName) {
            this.returnName = returnName;
        }

        @Override
        public String toString() {
            return this.returnName;
        }

    }
}
