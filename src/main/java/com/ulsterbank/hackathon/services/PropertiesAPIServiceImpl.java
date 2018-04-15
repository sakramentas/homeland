package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.GeoLocation;
import com.ulsterbank.hackathon.domain.Property;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class PropertiesAPIServiceImpl implements PropertiesAPIService {

    private List<Property> propertiesMock = new LinkedList<>();

    public PropertiesAPIServiceImpl() {
        Property property1 = new Property();
        property1.setGeoLocation(new GeoLocation(53.349687,-6.241755));
        property1.setPrice(new BigDecimal(145000));
        property1.setAddress("96 Rathlin House, Custom House Square, Lower Mayor Street, IFSC, Dublin 1, D01 X8W3");
        property1.setEnergyRate("B3");
        property1.setBedRoomQty(1);
        property1.setToiletQty(1);
        property1.setFloorArea(56.0);
        property1.setDateEntered(LocalDate.of(2018, 04, 04));
        property1.setPicture("https://b.dmlimg.com/ZTQwN2U5OTZlMDRiNGMyN2RhNjA1NjJmOTIyOWJmMTmWl4b17KuTcsqPTO_fTLlIaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvMy8zLzMzODZlMGRiM2JlNjY0NzlmNmQ2MDdhZDY2OTJlYjQ1LmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property1.setId(1);
        property1.setAffordabilityStatus("green");

        Property property2 = new Property();
        property2.setGeoLocation(new GeoLocation(53.349353,-6.242611));
        property2.setPrice(new BigDecimal(140000));
        property2.setAddress("7 Boyne House, Custom House Square, Mayor Street Lower, IFSC, Dublin 1, D01 CX78");
        property2.setEnergyRate("C3");
        property2.setBedRoomQty(1);
        property2.setToiletQty(1);
        property2.setFloorArea(42.3);
        property2.setDateEntered(LocalDate.of(2018, 04, 14));
        property2.setPicture("https://b.dmlimg.com/MjIxNTExYTc5ZjVmYWYwZjQ3NDI2Y2UxZTIzZjA4NTL9TQDbLM3FKfvEyHUIn63NaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvMy9iLzNiMDc2MTBkMTJiY2ZjMGQ5NDAyZDllYjc4OGRjMmY0LmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property2.setId(2);
        property2.setAffordabilityStatus("green");

        Property property3 = new Property();
        property3.setGeoLocation(new GeoLocation(53.349322,-6.243839));
        property3.setPrice(new BigDecimal(150000));
        property3.setAddress("55 Spencer House, IFSC, Custom House Square, Dublin 1");
        property3.setEnergyRate("B3");
        property3.setBedRoomQty(2);
        property3.setToiletQty(1);
        property3.setFloorArea(46.64);
        property3.setDateEntered(LocalDate.of(2018, 04, 06));
        property3.setPicture("https://b.dmlimg.com/MDNlOGRiYjM5ZmNjMjVlZGExOTBiMjViN2M2ZDcwYWSjy757P1KgZw8PN5bCLz9uaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvZC81L2Q1MmEzNmVmMjQ4ZGIwOWQ1ODQ0MDUxZTE5NDRjMmZmLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property3.setId(3);
        property3.setAffordabilityStatus("green");

        Property property4 = new Property();
        property4.setGeoLocation(new GeoLocation(53.349507,-6.245438));
        property4.setPrice(new BigDecimal(160000));
        property4.setAddress("Apartment 14, First Floor, Malton House, Customs House Square, Dublin 1");
        property4.setEnergyRate("C3");
        property4.setBedRoomQty(1);
        property4.setToiletQty(1);
        property4.setFloorArea(40.0);
        property4.setDateEntered(LocalDate.of(2018, 04, 14));
        property4.setPicture("https://b.dmlimg.com/OTNmMTJhNzNmNjhiZjVlMjZhZGQzN2NlYTdlNWRhZDaqmEWtnBCs61D6KWgIlB2iaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvZS81L2U1NGU2ZjUwNzRmMTEyNzk5YzdkMGQ0ODJiNjI3N2JhLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property4.setId(4);
        property4.setAffordabilityStatus("green");

        Property property5 = new Property();
        property5.setGeoLocation(new GeoLocation(53.349744,-6.244698));
        property5.setPrice(new BigDecimal(170000));
        property5.setAddress("Apt 170 Skellig House, Block G, Custom House Square, IFSC, Dublin 1");
        property5.setEnergyRate("D1");
        property5.setBedRoomQty(1);
        property5.setToiletQty(1);
        property5.setFloorArea(41.1);
        property5.setDateEntered(LocalDate.of(2018, 04, 06));
        property5.setPicture("https://b.dmlimg.com/ZmNhZWU5ZmJmZmFmYmMwOTc3YzAyODJkMzQ1ZjJhNTTut2qmywDwH6LPv_U37DRRaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvOS9iLzliMGY0ZDNhMzdiMmEyZWEyY2FjZjU4NDM4Y2ZhYzYxLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property5.setId(5);
        property5.setAffordabilityStatus("amber");

        Property property6 = new Property();
        property6.setGeoLocation(new GeoLocation(53.349859,-6.246788));
        property6.setPrice(new BigDecimal(210000));
        property6.setAddress("Apt. 25 Gandon House,IFSC, Dublin 1");
        property6.setEnergyRate("D1");
        property6.setBedRoomQty(1);
        property6.setToiletQty(1);
        property6.setFloorArea(40.0);
        property6.setDateEntered(LocalDate.of(2018, 04, 12));
        property6.setPicture("https://b.dmlimg.com/OTdlYTA5ZmZmZTY1OGUwNDFmYTU0YWZiMWUxZjYyYzaeu1BThNHQL9XHtRAQ56FKaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvZi80L2Y0YTU2ZTY4MDRhMTVmOGMxZDY4NzYzNWU4Y2Y0MDFjLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property6.setId(6);
        property6.setAffordabilityStatus("amber");

        Property property7 = new Property();
        property7.setGeoLocation(new GeoLocation(53.350081,-6.247393));
        property7.setPrice(new BigDecimal(200000));
        property7.setAddress("194 Tuskar Rock, Custom House Harbour, IFSC, Dublin 1");
        property7.setEnergyRate("D1");
        property7.setBedRoomQty(2);
        property7.setToiletQty(2);
        property7.setFloorArea(61.0);
        property7.setDateEntered(LocalDate.of(2018, 04, 14));
        property7.setPicture("https://b.dmlimg.com/ZTJmMDU4N2E2NmJlYzc2Zjc5NmFjOGMxNTViZWVhYTAFS1K4tk1r2DmiQwsAtZhtaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvYy9mL2NmNzJlMjg4NjBjMDFlYWVhZTBjYTVmODIxNGI0YjgxLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property7.setId(7);
        property7.setAffordabilityStatus("amber");

        Property property8 = new Property();
        property8.setGeoLocation(new GeoLocation(53.348413,-6.246967));
        property8.setPrice(new BigDecimal(385000));
        property8.setAddress("246 The Asgard, Custom House Harbour, IFSC, Co. Dublin");
        property8.setEnergyRate("C3");
        property8.setBedRoomQty(2);
        property8.setToiletQty(2);
        property8.setFloorArea(67.0);
        property8.setDateEntered(LocalDate.of(2018, 04, 14));
        property8.setPicture("https://b.dmlimg.com/ZDBmYTVlYzYyNThmZjM0ZDcyYzQ1ZGNkNzE4NTA5ZTgD48-JX4iVEzNyFrIfqTABaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvYi85L2I5YTE0OTc3MDgwODU5NWJhNjI0OTA1M2ExMWMzNWJhLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property8.setId(8);
        property8.setAffordabilityStatus("red");

        Property property9 = new Property();
        property9.setGeoLocation(new GeoLocation(53.350597,-6.246101));
        property9.setPrice(new BigDecimal(365000));
        property9.setAddress("150 Ratlin O'Birne House, Custom House Harbour, IFSC, Co. Dublin");
        property9.setEnergyRate("D2");
        property9.setBedRoomQty(2);
        property9.setToiletQty(1);
        property9.setFloorArea(62.0);
        property9.setDateEntered(LocalDate.of(2018, 04, 14));
        property9.setPicture("https://b.dmlimg.com/N2U5NDhmYjUyNTRkYTdjNWZlMmFlMDRlY2M3YTgzN2LG9Gcv09TrubrQN6VnabgoaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvZC80L2Q0NTgyOTRjMjcxMjIzY2I0MGI3NGI4MDE5ZTM3ZDAwLmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property9.setId(9);
        property9.setAffordabilityStatus("red");

        Property property10 = new Property();
        property10.setGeoLocation(new GeoLocation(53.350602,-6.246019));
        property10.setPrice(new BigDecimal(350000));
        property10.setAddress("Apt 166 Raithlin O'Birne Custom House Harbour Apts, IFSC, Dublin 1, D01 C668");
        property10.setEnergyRate("D1");
        property10.setBedRoomQty(2);
        property10.setToiletQty(1);
        property10.setFloorArea(60.0);
        property10.setDateEntered(LocalDate.of(2018, 04, 9));
        property10.setPicture("https://b.dmlimg.com/NjJmMzVkZmVkMDg2MmQ0ZDIyOWI0ZjNkYWZiNzQ0MWIj2JqxUSYaVf9TzyNAuhbzaHR0cDovL3MzLWV1LXdlc3QtMS5hbWF6b25hd3MuY29tL21lZGlhbWFzdGVyLXMzZXUvZS8wL2UwMWU0OWI0YmUzZjAzMTBhMTFkZWQ5NDc4ZjYzZjY3LmpwZ3x8fHx8fDYwMHg0NTB8fHx8.jpg");
        property10.setId(10);
        property10.setAffordabilityStatus("red");

        propertiesMock.add(property1);
        propertiesMock.add(property2);
        propertiesMock.add(property3);
        propertiesMock.add(property4);
        propertiesMock.add(property5);
        propertiesMock.add(property6);
        propertiesMock.add(property7);
        propertiesMock.add(property8);
        propertiesMock.add(property9);
        propertiesMock.add(property10);
    }

    public List<Property> getProperties(){

        System.out.println(this.propertiesMock);

        return this.propertiesMock;

    }
}
