package org.niit.C13_S3_MongoDemo.domain;

public class Address {

    private int zipcode;
    private String city;

    public Address() {
    }

    public Address(int zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipcode=" + zipcode +
                ", city='" + city + '\'' +
                '}';
    }
}
