package com.example.demo.property;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.*;

@Entity
@Table
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long propertyId;
    private int price;
    private Integer area;
    private boolean garden;
    private byte rooms;
    private boolean clime;
    private boolean balcony;
    private String heating;
    private long advertiserId;
    private long addressId;


    public Property() {
    }

    public Property(int price, int area, boolean garden, byte rooms, boolean clime, boolean balcony, String heating, long advertiserId, long addressId) {
        this.price = price;
        this.area = area;
        this.garden = garden;
        this.rooms = rooms;
        this.clime = clime;
        this.balcony = balcony;
        this.heating = heating;
        this.advertiserId = advertiserId;
        this.addressId = addressId;
    }

    public Property(long propertyId, int price, int area, boolean garden, byte rooms, boolean clime, boolean balcony, String heating, long advertiserId, long addressId) {
        this.propertyId = propertyId;
        this.price = price;
        this.area = area;
        this.garden = garden;
        this.rooms = rooms;
        this.clime = clime;
        this.balcony = balcony;
        this.heating = heating;
        this.advertiserId = advertiserId;
        this.addressId = addressId;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
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

    public boolean getGarden() {
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

    public boolean getClime() {
        return clime;
    }

    public void setClime(boolean clime) {
        this.clime = clime;
    }

    public boolean getBalcony() {
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

    public long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(long advertiserId) {
        this.advertiserId = advertiserId;
    }


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
                '}';
    }
}
