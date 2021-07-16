package com.example.firebaseexample;

public class Employee {

    private String lastName;
    private String firstName;

    Employee(){
        this.lastName = "empty";
        this.firstName = "empty";
    }

    Employee(String fName, String lName){
        this.lastName = lName;
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
