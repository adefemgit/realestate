package org.example;

public class Panel extends RealEstate implements PanelInterface {
    private int floor;
    private boolean isInsulated;


    public Panel() {
        super();
        this.floor = 0;
        this.isInsulated = false;
    }


    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isInsulated() {
        return isInsulated;
    }

    public void setInsulated(boolean insulated) {
        isInsulated = insulated;
    }

    @Override
    public int getTotalPrice() {
        double total = getPrice() * getSqm();
        String city = getCity();
        if (city.equals("Budapest")) {
            total *= 1.30;
        } else if (city.equals("Debrecen")) {

            total *= 1.20;
        } else if (city.equals("Nyíregyháza")) {

            total *= 1.15;
        }

        if (this.floor >= 0 && this.floor <= 2) {
            total *= 1.05;
        } else if (this.floor == 10) {
            total *= 0.95;
        }

        if (this.isInsulated) {
            total *= 1.05;
        }
        return (int) total;
    }

    @Override
    public String toString() {
        return "Panel [city=" + getCity() + ", price/ sqm=" + getPrice() + ", sqm=" + getSqm() +
                ", numberofRooms=" + getNumberOfRooms() + ", genre=" + getGenre() +
                ", floor=" + floor + ", isInsulated=" + isInsulated +
                ", totalPrice=" + getTotalPrice() + ", avgSqmPerRoom=" + averageSqmPerRoom() + "]";
    }

    @Override
    public boolean hasSameAmount(RealEstate other) {
        return this.getTotalPrice() == other.getTotalPrice();
    }

    @Override
    public int roomprice() {
        if (getNumberOfRooms() == 0) {


            return 0;
        }
        double totalWithoutModifiers = getPrice() * getSqm();

        return (int) (totalWithoutModifiers / getNumberOfRooms());
    }
}
