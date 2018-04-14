package com.ulsterbank.hackathon.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Property {

    private GeoLocation geoLocation;
    private BigDecimal price;
    private String Address;
    private String energyRate;
    private Integer bedRoomQty;
    private Integer toiletQty;
    private Double floorArea;
    private LocalDate dateEntered;
    private String picture;

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEnergyRate() {
        return energyRate;
    }

    public void setEnergyRate(String energyRate) {
        this.energyRate = energyRate;
    }

    public Integer getBedRoomQty() {
        return bedRoomQty;
    }

    public void setBedRoomQty(Integer bedRoomQty) {
        this.bedRoomQty = bedRoomQty;
    }

    public Integer getToiletQty() {
        return toiletQty;
    }

    public void setToiletQty(Integer toiletQty) {
        this.toiletQty = toiletQty;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public LocalDate getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(LocalDate dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}