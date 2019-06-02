package com.davtsin.mapstruct;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private Title title;
    private LocalDate dateOfBirth;
    private BigDecimal creditStore;
    private CustomerType customerType;
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getCreditStore() {
        return creditStore;
    }

    public void setCreditStore(BigDecimal creditStore) {
        this.creditStore = creditStore;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title=" + title +
                ", dateOfBirth=" + dateOfBirth +
                ", creditStore=" + creditStore +
                ", customerType=" + customerType +
                ", address=" + address +
                '}';
    }
}
