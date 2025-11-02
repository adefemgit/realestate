

package org.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {

    private static final Logger rootLogger = Logger.getLogger("");

    public static void main(String[] args) {
        configureLogging();

        RealEstate house = new RealEstate("Budapest", 1000.0, 100, 3.0, Genre.FAMILY_HOUSE);
        System.out.println(house);
        house.makeDiscount(10);
        System.out.println("After 10% discount: " + house);

        Panel apartment = new Panel("Debrecen", 800.0, 80, 2.5, Genre.CONDOMINIUM, 1, true);
        System.out.println(apartment);
        System.out.println("Room price: " + apartment.roomprice());
        System.out.println("Same total price as house? " + apartment.hasSameAmount(house));
    }


    private static void configureLogging() {
        try {
            FileHandler handler = new FileHandler("../realEstateApp.log", true);
            handler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(handler);
            rootLogger.setLevel(java.util.logging.Level.INFO);
        } catch (IOException e) {
            System.err.println("Failed to set up file logging: " + e.getMessage());
            e.printStackTrace();
        }
    }
}