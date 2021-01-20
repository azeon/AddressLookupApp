package com.boomi.demo.addresslookup;

public class Result 
{

    private String street_no;
    private String street_name;
    private ResultAddress[] addresses;
     

    public void setStreet_no(String street_no){
        this.street_no = street_no;
    }

    public String getStreet_no(){
        return street_no;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getStreet_name() {
        return street_name;
    }

    public ResultAddress[] getAddresses(){
        return addresses;
    }

    public void setAddresses(ResultAddress[] addresses){
        this.addresses = addresses;
    }

}