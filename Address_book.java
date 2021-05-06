package com.Address_book;

class Contact {
    public final String firstName;
    public final String lastName;
    public final String address;
    public final String city;
    public final String state;
    public final String zip;
    public final String phoneNumber;
    public final String email;

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

    public String toString() {
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

    private int numOfContacts = 0;
    private Contact[] contact;

    public Address_book(){
        contact = new Contact[3];
    }

    public void addDetails(String firstName, String lastName, String address, String city , String state, String zip, String phoneNumber1, String email){
        contact [ numOfContacts ] = new Contact(firstName, lastName, address, city, state, zip, phoneNumber1, email);
        numOfContacts++;
    }

    private void Details(){
        for (int i=0; i<numOfContacts; i++){
            System.out.println(contact[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Problem\n");

        Address_book address = new Address_book();
        address.addDetails("Nikhil", "Tirpude", "Chembur", "Mumbai", "Maharashtra", "400074", "855811692", "nikhil@gmail.com");
        address.Details();

    }
}
