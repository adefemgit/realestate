package org.example;

import java.util.logging.Logger;


public class RealEstate implements PropertyInterface {

    private static final Logger logger = Logger.getLogger(RealEstate.class.getName());

    private String city;
    private double price;
    private int sqm;
    private double numberOfRooms;
    private Genre genre;


    public RealEstate() {
        logger.info("RealEstate() constructor called");
        this.city = "";
        this.price = 0.0;
        this.sqm = 0;
        this.numberOfRooms = 0.0;
        this.genre = Genre.FAMILY_HOUSE;
    }


    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        logger.info("RealEstate(String, double, int, double, Genre) constructor called");
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }


    public String getCity() {
        logger.info("getCity() called");
        return city;
    }


    public void setCity(String city) {
        logger.info("setCity(" + city + ") called");
        this.city = city;
    }


    public double getPrice() {
        logger.info("getPrice() called");
        return price;
    }


    public void setPrice(double price) {
        logger.info("setPrice(" + price + ") called");
        this.price = price;
    }


    public int getSqm() {
        logger.info("getSqm() called");
        return sqm;
    }


    public void setSqm(int sqm) {
        logger.info("setSqm(" + sqm + ") called");
        this.sqm = sqm;
    }

    public double getNumberOfRooms() {
        logger.info("getNumberOfRooms() called");
        return numberOfRooms;
    }


    public void setNumberOfRooms(double numberOfRooms) {
        logger.info("setNumberOfRooms(" + numberOfRooms + ") called");
        this.numberOfRooms = numberOfRooms;
    }


    public Genre getGenre() {
        logger.info("getGenre() called");
        return genre;
    }


    public void setGenre(Genre genre) {
        logger.info("setGenre(" + genre + ") called");
        this.genre = genre;
    }


    @Override
    public void makeDiscount(int percent) {
        logger.info("makeDiscount(" + percent + ") called");
        try {
            if (percent > 0 && percent <= 100) {
                this.price = this.price * (1 - (percent / 100.0));
            } else {
                logger.warning("Invalid discount percent: " + percent + " (must be 1–100)");
            }
        } catch (Exception e) {
            logger.severe("Exception in makeDiscount: " + e.getMessage());
        }
    }


    @Override
    public int getTotalPrice() {
        logger.info("getTotalPrice() called");
        double total = this.price * this.sqm;
        if ("Budapest".equals(this.city)) total *= 1.30;
        else if ("Debrecen".equals(this.city)) total *= 1.20;
        else if ("Nyíregyháza".equals(this.city)) total *= 1.15;
        return (int) total;
    }


    @Override
    public double averageSqmPerRoom() {
        logger.info("averageSqmPerRoom() called");
        if (this.numberOfRooms == 0) return 0.0;
        return this.sqm / this.numberOfRooms;
    }


    @Override
    public String toString() {
        logger.info("RealEstate.toString() called");
        return "RealEstate [city=" + city +
                ", price/sqm=" + price +
                ", sqm=" + sqm +
                ", rooms=" + numberOfRooms +
                ", genre=" + genre +
                ", totalPrice=" + getTotalPrice() +
                ", avgSqmPerRoom=" + averageSqmPerRoom() + "]";
    }
}