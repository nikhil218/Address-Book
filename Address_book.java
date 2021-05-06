package com.Address_book;

import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city , String state, String zip, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Details of: "+ firstName+ " "+lastName+"\n"
                +"Address: "+address+"\n"
                +"City: "+city+"\n"
                +"State: "+state+"\n"
                +"Zip: "+zip+"\n"
                +"Phone Number: "+phoneNumber+"\n"
                +"Email: "+email;
    }
}

public class Address_book {
    static ArrayList<Contact> list = new ArrayList<Contact>();

    static Scanner sc = new Scanner(System.in);
    public static String check = "yes";

    private void addDetails(){

        System.out.println("How many Contacts do you want to add?");
        int noOfContact = sc.nextInt();

        for (int i =0; i < noOfContact; i++) {
            System.out.println("Enter FirstName");
            String firstName=sc.next();
            System.out.println("Enter LastName");
            String lastName=sc.next();
            System.out.println("Enter Address");
            String address=sc.next();
            System.out.println("Enter City");
            String city=sc.next();
            System.out.println("Enter State");
            String state=sc.next();
            System.out.println("Enter ZipCode");
            String zip=sc.next();
            System.out.println("Enter PhoneNumber");
            String phoneNumber=sc.next();
            System.out.println("Enter Email");
            String email=sc.next();

            list.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
            System.out.println("Contact for " + firstName + " is added Successfully!");
        }
    }

    public static void editDetails() {
        String name;
        System.out.println("Enter First Name of Contact to be Edited : ");
        name = sc.next();

        for(int i=0; i<list.size(); i++) {
            if(name.equals(list.get(i).getFirstName())) {
                System.out.println("Enter FirstName");
                list.get(i).setFirstName(sc.next());
                System.out.println("Enter LastName");
                list.get(i).setLastName(sc.next());
                System.out.println("Enter Address");
                list.get(i).setAddress(sc.next());
                System.out.println("Enter CityName");
                list.get(i).setCity(sc.next());
                System.out.println("Enter StateName");
                list.get(i).setState(sc.next());
                System.out.println("Enter Zip");
                list.get(i).setZip(sc.next());
                System.out.println("Enter PhoneNumber");
                list.get(i).setPhoneNumber(sc.next());
                System.out.println("Enter Email");
                list.get(i).setEmail(sc.next());

                System.out.println(list.get(i));
                System.out.println("Contact for " + name + " is edited Successfully");
            }

        }
    }

    public static void deleteDetails() {
        String name;
        System.out.println("Enter First Name of Contact to be deleted : ");
        name = sc.next();

        for(int i=0; i<list.size(); i++) {
            if(name.equals(list.get(i).getFirstName())) {
                list.remove(i);
                System.out.println("\nContact for " + name + " is deleted sucessfully");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Problem\n");

        Address_book user = new Address_book();
        user.addDetails();

        System.out.println("\nDo you want to Delete the Contact ? \nEnter yes or no");
        check = sc.next().toLowerCase();

        if(check.equals("yes"))
            deleteDetails();
        else
            System.out.println("contact not present");

        System.out.println("\nAfter deletion the contacts available are : ");
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i)+"\n");

    }
}
