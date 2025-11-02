package org.example;

import java.util.logging.Logger;


public class Panel extends RealEstate implements PanelInterface {

    private static final Logger logger = Logger.getLogger(Panel.class.getName());

    private int floor;
    private boolean isInsulated;


    public Panel() {
        super();
        logger.info("Panel() constructor called");
        this.floor = 0;
        this.isInsulated = false;
    }


    public Panel(String city, double price, int sqm, double numberOfRooms,
                 Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        logger.info("Panel(full) constructor called");
        this.floor = floor;
        this.isInsulated = isInsulated;
    }


    public int getFloor() {
        logger.info("getFloor() called");
        return floor;
    }


    public void setFloor(int floor) {
        logger.info("setFloor(" + floor + ") called");
        this.floor = floor;
    }


    public boolean isInsulated() {
        logger.info("isInsulated() called");
        return isInsulated;
    }


    public void setInsulated(boolean insulated) {
        logger.info("setInsulated(" + insulated + ") called");
        this.isInsulated = insulated;
    }


    @Override
    public int getTotalPrice() {
        logger.info("Panel.getTotalPrice() called");
        double total = getPrice() * getSqm();
        String city = getCity();
        if ("Budapest".equals(city)) total *= 1.30;
        else if ("Debrecen".equals(city)) total *= 1.20;
        else if ("Nyíregyháza".equals(city)) total *= 1.15;

        if (floor >= 0 && floor <= 2) total *= 1.05;
        else if (floor == 10) total *= 0.95;
        if (isInsulated) total *= 1.05;

        return (int) total;
    }


    @Override
    public boolean hasSameAmount(RealEstate other) {
        logger.info("hasSameAmount() called");
        return this.getTotalPrice() == other.getTotalPrice();
    }


    @Override
    public int roomprice() {
        logger.info("roomprice() called");
        try {
            if (getNumberOfRooms() == 0) return 0;
            return (int) ((getPrice() * getSqm()) / getNumberOfRooms());
        } catch (Exception e) {
            logger.severe("Error in roomprice(): " + e.getMessage());
            return 0;
        }
    }


    @Override
    public String toString() {
        logger.info("Panel.toString() called");
        return "Panel [city=" + getCity() +
                ", price/sqm=" + getPrice() +
                ", sqm=" + getSqm() +
                ", rooms=" + getNumberOfRooms() +
                ", genre=" + getGenre() +
                ", floor=" + floor +
                ", insulated=" + isInsulated +
                ", totalPrice=" + getTotalPrice() +
                ", avgSqmPerRoom=" + averageSqmPerRoom() + "]";
    }
}