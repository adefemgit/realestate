package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RealEstate house = new RealEstate("Budapest", 1000.0, 100, 3.0, Genre.FAMILY_HOUSE);
        System.out.println(house);
        house.makeDiscount(10);
        System.out.println("After 10% discount: " + house);

        // Test Panel
        Panel apartment = new Panel("Debrecen", 800.0, 80, 2.5, Genre.CONDOMINIUM, 1, true);
        System.out.println(apartment);
        System.out.println("Room price: " + apartment.roomprice());
        System.out.println("Same total price as house? " + apartment.hasSameAmount(house));

    }
}