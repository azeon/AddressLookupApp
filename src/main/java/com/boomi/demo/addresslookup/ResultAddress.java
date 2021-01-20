package com.boomi.demo.addresslookup;

public class ResultAddress {
    private String street_no;
    private String street_name;
    private String postcode;
    private String suburb;
    private String unit_floor;
    private String building_name;
    private String city;
    private String country_code;
    private String delivery_service_type;
    private String formatted_address;
    private String norm_address_odr_key;

    public void setStreet_no(String street_no) {
        this.street_no = street_no;
    }

    public String getNorm_address_odr_key() {
        return norm_address_odr_key;
    }

    public void setNorm_address_odr_key(String norm_address_odr_key) {
        this.norm_address_odr_key = norm_address_odr_key;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getDelivery_service_type() {
        return delivery_service_type;
    }

    public void setDelivery_service_type(String delivery_service_type) {
        this.delivery_service_type = delivery_service_type;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getUnit_floor() {
        return unit_floor;
    }

    public void setUnit_floor(String unit_floor) {
        this.unit_floor = unit_floor;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet_no() {
        return street_no;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStreet_name() {
        return street_name;
    }
 
    @Override
    public String toString() {
        return "[street_name=" + street_name + ", street_no=" + street_no + "]";
    }

}