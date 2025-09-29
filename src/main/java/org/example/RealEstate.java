package org.example;

public class RealEstate implements PropertyInterface{
    private String city;
    private double price;
    private int sqm;
    private double numberOfRooms;
    private Genre genre;


    public RealEstate() {
        this.city = "";

        this.price = 0.0;

        this.sqm = 0;

        this.numberOfRooms = 0.0;

        this.genre = Genre.FAMILY_HOUSE;
    }


    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        this.city = city;

        this.price = price;

        this.sqm = sqm;

        this.numberOfRooms = numberOfRooms;

        this.genre = genre;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSqm() {
        return sqm;
    }

    public void setSqm(int sqm) {
        this.sqm = sqm;
    }

    public double getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(double numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public void makeDiscount(int percent) {
        if (percent > 0 && percent <= 100) {
            this.price = this.price * (1 - (percent / 100.0));
        }
    }

    @Override
    public int getTotalPrice() {
        double total = this.price * this.sqm;
        if (this.city.equals("Budapest")) {
            total *= 1.30;
        } else if (this.city.equals("Debrecen")) {
            total *= 1.20;
        } else if (this.city.equals("Nyíregyháza")) {
            total *= 1.15;
        }
        return (int) total;
    }

    @Override
    public double averageSqmPerRoom() {
        if (this.numberOfRooms == 0) {
            return 0.0;
        }
        return this.sqm / this.numberOfRooms;
    }

    @Override
    public String toString() {
        return "RealEstate [city=" + city + ", price / sqm=" + price + ", sqm=" + sqm +
                ", numberofRooms=" + numberOfRooms + ", genre=" + genre +
                ", totalPrice=" + getTotalPrice() + ", avgSqmPerRoom=" + averageSqmPerRoom() + "]";
    }
}
