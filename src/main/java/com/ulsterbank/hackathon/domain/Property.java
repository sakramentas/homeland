package com.ulsterbank.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Property {

    @JsonProperty("geo")
    private GeoLocation geoLocation;
    private BigDecimal price;
    private String Address;
    private String energyRate;
    private Integer bedRoomQty;
    private Integer toiletQty;
    private Double floorArea;
    private LocalDate dateEntered;
    private String picture;
    private Integer id;
    private String affordabilityStatus;
    private boolean detachedHouse;
    private boolean parkingSpace;
    private boolean gasHeating;
    private boolean closeToWork;
    private boolean quiteNeighboorhood;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAffordabilityStatus() {
        return affordabilityStatus;
    }

    public void setAffordabilityStatus(String affordabilityStatus) {
        this.affordabilityStatus = affordabilityStatus;
    }

    public boolean isDetachedHouse() {
        return detachedHouse;
    }

    public void setDetachedHouse(boolean detachedHouse) {
        this.detachedHouse = detachedHouse;
    }

    public boolean isParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(boolean parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public boolean isGasHeating() {
        return gasHeating;
    }

    public void setGasHeating(boolean gasHeating) {
        this.gasHeating = gasHeating;
    }

    public boolean isCloseToWork() {
        return closeToWork;
    }

    public void setCloseToWork(boolean closeToWork) {
        this.closeToWork = closeToWork;
    }

    public boolean isQuiteNeighboorhood() {
        return quiteNeighboorhood;
    }

    public void setQuiteNeighboorhood(boolean quiteNeighboorhood) {
        this.quiteNeighboorhood = quiteNeighboorhood;
    }
}
