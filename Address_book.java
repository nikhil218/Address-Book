package com.Address_book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

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


    public Contact() {
        // TODO Auto-generated constructor stub
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
        return "\nDetails of: "+ firstName+ " "+lastName+"\n"
                +"Address: "+address+"\n"
                +"City: "+city+"\n"
                +"State: "+state+"\n"
                +"Zip: "+zip+"\n"
                +"Phone Number: "+phoneNumber+"\n"
                +"Email: "+email;
    }
}

public class AddressBook {
    static ArrayList<Contact> list = new ArrayList<Contact>();
    public static AddressBook addressbook = new AddressBook(null);
    public static Contact contact = new Contact();
    public static ArrayList<AddressBook> book = new ArrayList<>();
    public HashMap<String, String> citydict = new HashMap<>();
    public HashMap<String, String> statedict = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    public AddressBook(String str) {
        // TODO Auto-generated constructor stub
    }

    public static void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public void DefaultContact()
    {
        book.get(0).list.add(new Contact("omkar", "mali", "palaspe", "mumbai", "maharashtra", "4000129", "90290642", "omkar@gmail.com"));
        book.get(0).list.add(new Contact("sumit", "wagh", "tilaknagar", "mumbai", "maharashtra", "400089", "816979161", "sumit@gmail.com"));
        book.get(1).list.add(new Contact("surendra", "chouhan", "wadala", "mumbai", "maharashtra", "4000012", "8181818818", "surendra@gmail.com"));
        book.get(1).list.add(new Contact("rahul", "tiwari", "kalyan", "thane", "maharashtra", "4000012", "1121221", "rahul@gmail.com"));
        book.get(2).list.add(new Contact("gaurav", "purao", "kohinoor", "thane", "maharashtra", "4040091", "82828882", "gaurav@gmail.com"));
        for(int i=0;i<book.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

    private void addAddressBook(){
        System.out.println("Enter the name of the new address book : ");
        String name = sc.next();
        book.add(new AddressBook(name));

        System.out.println("New Address Book is Added as " + name);
    }

    public void SearchPersonWithCity()
    {
        System.out.println("Enter city for the contact info: ");
        String city=sc.next();
        for(int i=0; i<list.size(); i++)
        {
            if(city.equals(list.get(i).getCity()))
            {
                System.out.println(list.get(i));
            }
        }
    }

    public void SearchPersonWithState()
    {
        System.out.println("Enter state for the contact info: ");
        String state=sc.next();
        for(int i=0;i<list.size();i++)
        {
            if(state.equals(list.get(i).getState()))
            {
                System.out.println(list.get(i));
            }
        }
    }

    public void PersonCityDictionary() {
        for(AddressBook address : book) {
            for(Contact contact : address.list) {
                String name = contact.getFirstName();
                citydict.put(name, contact.getCity());
            }
        }

        System.out.println("Enter the city name to search for contacts: ");
        String city=sc.next();
        int count = 0;
        for(Entry<String, String> entry:citydict.entrySet())
        {
            if(city.equals(entry.getValue()))
            {
                System.out.println("Person from "+entry.getValue()+" city are: "+entry.getKey());
                count+=1;
            }
        }
        System.out.println("Count of contacts in " + city + " is : " + count);
    }

    public void PersonStateDictionary()
    {
        for(AddressBook address: book)
        {
            for(Contact contact:address.list)
            {
                String name=contact.getFirstName();
                statedict.put(name, contact.getState());
            }
        }
        System.out.println("Enter the State name to search for contacts: ");
        String state=sc.next();
        int count = 0;
        for(Entry<String, String> entry:statedict.entrySet())
        {
            if(state.equals(entry.getValue()))
            {
                System.out.println("Person from "+entry.getValue()+"State is: "+entry.getKey());
                count += 1;
            }
        }
        System.out.println("Count of contacts in " + state + " is : " + count);
    }

    private void addContact() {
        System.out.println("How many contacts do you want to enter? ");
        int num=sc.nextInt();
        list.add(0,new Contact("omkar", "mali", "palaspe", "panvel", "maharastra", "4000129", "90290642", "omkar@gmail.com"));

        for(int i=0; i<num; i++) {
            System.out.println("Enter First Name");
            String firstName=sc.next();
            System.out.println("Enter Last Name");
            String lastName=sc.next();
            System.out.println("Enter Address");
            String address=sc.next();
            System.out.println("Enter City Name");
            String city=sc.next();
            System.out.println("Enter State Name");
            String state=sc.next();
            System.out.println("Enter Zip Code");
            String zip=sc.next();
            System.out.println("Enter Phone Number");
            String phoneNumber=sc.next();
            System.out.println("Enter Email");
            String email=sc.next();

            if(!firstName.equals(list.get(0).getFirstName())) {
                list.add( new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
                System.out.println(list);
            }
            else {
                System.out.println("You have already entered this contact");
                break;
            }
        }

        Comparator<Contact> list1 = Comparator.comparing(Contact::getFirstName);
        System.out.println("\n After Sorting the contact details are: \n");
        list.stream().sorted(list1).forEach(System.out::println);
    }

    private void displayDetails() {
        Comparator<Contact> list1 = Comparator.comparing(Contact::getFirstName);
        System.out.println("\n After Sorting the contact details are: \n");
        list.stream().sorted(list1).forEach(System.out::println);
    }

    public static String editContact() {
        String name;
        System.out.println("Enter First Name of Contact to be Edited : ");
        name = sc.next();

        for(int i=0; i < list.size(); i++) {
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

                System.out.println("\n" + list.get(i));
                return "\nContact for " + name + " is edited Successfully";
            }
        }
        return "\n" + name + " is not available in Contact list.";
    }

    public static String deleteContact(){
        String name;
        System.out.println("\nEnter First Name : ");
        name = sc.next();

        for(int i=0; i < list.size(); i++) {
            if(name.equals(list.get(0).getFirstName())) {
                list.remove(0);
                return ("\nContact for " + name + " is deleted sucessfully");
            }
        }
        return "\n" + name + " is not available in Contact list";
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Problem\n");

        AddressBook address = new AddressBook(null);
        address.defaultBook();
        address.DefaultContact();

        int check=0;

        while(check != 8) {
            System.out.println("\n1. Add Address Book \n2. Add Contact \n3. View Available Contacts \n4. Edit Contact \n5. Delete Contact \n6. Search Person With City \n7. Search Person With State \n8. Exit" );
            check = sc.nextInt();
            switch(check) {
                case 1:
                    address.addAddressBook();
                    break;
                case 2:
                    address.addContact();
                    break;
                case 3:
                    System.out.println("\nContacts available are : ");
                    for(int i=0; i<list.size(); i++)
                        System.out.println(list.get(i)+"\n");
                    break;
                case 4:
                    editContact();
                    for(int i=0; i<list.size(); i++)
                        System.out.println(list.get(i));
                    break;
                case 5:
                    deleteContact();
                    for(int i=0; i<list.size(); i++)
                        System.out.println(list.get(i));
                    break;
                case 6:
                    address.PersonCityDictionary();
                    break;
                case 7:
                    address.PersonStateDictionary();
                    break;
                case 8:
                    System.out.println("Thanks");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}