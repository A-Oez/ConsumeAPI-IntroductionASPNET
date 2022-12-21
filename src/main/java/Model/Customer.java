package Model;

public class Customer {
    private String userId;
    private String forename;
    private String surename;
    private String birthday;
    private String city;
    private String code;
    private String street;
    private String houseNumber;
    private String email;
    private String telephone;

    public Customer(String userId, String forename, String surename, String birthday, String city, String code, String street, String houseNumber, String email, String telephone) {
        this.userId = userId;
        this.forename = forename;
        this.surename = surename;
        this.birthday = birthday;
        this.city = city;
        this.code = code;
        this.street = street;
        this.houseNumber = houseNumber;
        this.email = email;
        this.telephone = telephone;
    }
}
