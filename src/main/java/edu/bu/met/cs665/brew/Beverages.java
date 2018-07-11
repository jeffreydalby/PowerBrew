package edu.bu.met.cs665.brew;

public class Beverages {

    public enum beverageChoices {
        Espresso("Espresso"),
        Americano("Americano"),
        Latte_Macchiato("Latte Macchiato"),
        Black_Tea("Black Tea"),
        Green_Tea("Green Tea"),
        Yellow_Tea("Yellow Tea");


        private String returnName;

        beverageChoices(String returnName) {
            this.returnName = returnName;
        }

        @Override
        public String toString() {
            return this.returnName;
        }

    }
}
