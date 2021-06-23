package com.example.demo.property;

public class Property {

    private String propertyId;
    private int price;
    private int area;
    private boolean garden;
    private byte rooms;
    private boolean clime;
    private boolean balcony;
    private String heating;
    private String advertiserId;
    private Address address;

    public Property() {
    }

    public Property(int price, int area, boolean garden, byte rooms, boolean clime, boolean balcony, String heating, String advertiserId, Address address) {
        this.price = price;
        this.area = area;
        this.garden = garden;
        this.rooms = rooms;
        this.clime = clime;
        this.balcony = balcony;
        this.heating = heating;
        this.advertiserId = advertiserId;
        this.address = address;
    }

    public Property(String propertyId, int price, int area, boolean garden, byte rooms, boolean clime, boolean balcony, String heating, String advertiserId, Address address) {
        this.propertyId = propertyId;
        this.price = price;
        this.area = area;
        this.garden = garden;
        this.rooms = rooms;
        this.clime = clime;
        this.balcony = balcony;
        this.heating = heating;
        this.advertiserId = advertiserId;
        this.address = address;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public byte getRooms() {
        return rooms;
    }

    public void setRooms(byte rooms) {
        this.rooms = rooms;
    }

    public boolean isClime() {
        return clime;
    }

    public void setClime(boolean clime) {
        this.clime = clime;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId='" + propertyId + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", garden=" + garden +
                ", rooms=" + rooms +
                ", clime=" + clime +
                ", balcony=" + balcony +
                ", heating='" + heating + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", address=" + address +
                '}';
    }
}
