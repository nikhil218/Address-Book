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

    public Contact(String firstName, String lastName, String address, String city , String state,String zip, String phoneNumber, String email){
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
public class AddressBook
{
    static ArrayList<Contact> list = new ArrayList<Contact>();
    public static AddressBook addressBook = new AddressBook(null);
    public static Contact contact=new Contact();

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<AddressBook> book = new ArrayList<>();
    public HashMap<String,String> citydict=new HashMap<>();
    public HashMap<String,String> statedict=new HashMap<>();
    public int count=0;

    public AddressBook(String str) {

    }

    public static void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public void defaultContact(){
        book.get(0).list.add(new Contact("omkar", "mali", "palaspe", "mumbai", "maharashtra", "4000129", "90290642", "omkar@gmail.com"));
        book.get(0).list.add(new Contact("sumit", "wagh", "tilaknagar", "mumbai", "maharashtra", "400089", "816979161", "sumit@gmail.com"));
        book.get(1).list.add(new Contact("surendra", "chouhan", "wadala", "jodhpur", "rajastan", "4000012", "8181818818", "surendra@gmail.com"));
        book.get(1).list.add(new Contact("nikhil", "tirpude", "wadala", "thane", "bihar", "4000012", "1121221", "nikhil@gmail.com"));
        book.get(2).list.add(new Contact("gaurav", "purao", "kohinoor", "thane", "tamilnadu", "4040091", "82828882", "gaurav@gmail.com"));
    }


    public static void addAddressBook() {
        System.out.print("Enter name of new Address Book: ");
        String str=sc.next();
        book.add(new AddressBook(str));
    }

    public void searchPersonByCity() {
        System.out.println("Enter city for the contact info: ");
        String city=sc.next();
        for(int i=0;i<list.size();i++) {
            if(city.equals(list.get(i).getCity())) {
                System.out.println(list.get(i));
            }
        }
    }

    public void searchPersonByState() {
        System.out.println("Enter state for the contact info: ");
        String state=sc.next();
        for(int i=0;i<list.size();i++) {
            if(state.equals(list.get(i).getState())) {
                System.out.println(list.get(i));
            }
        }
    }

    public void personCityDictionary() {
        for(AddressBook address : book) {
            for(Contact contact : address.list) {
                String name=contact.getFirstName();
                citydict.put(name, contact.getCity());
            }
        }
        System.out.println("Enter the city name to search for contacts: ");
        String city=sc.next();
        int count = 0;
        for(Entry<String, String> entry : citydict.entrySet()) {
            if(city.equals(entry.getValue())) {
                System.out.println("Person from "+entry.getValue()+" city are: "+entry.getKey());
                count+=1;
            }
        }
        System.out.println("Count of contacts in " + city + " city is: " + count);
    }

    public void personStateDictionary() {
        for(AddressBook address : book) {
            for(Contact contact : address.list) {
                String name = contact.getFirstName();
                statedict.put(name, contact.getState());
            }
        }
        System.out.println("Enter the state name to search for contacts: ");
        String state=sc.next();
        int count = 0;
        for(Entry<String, String> entry:statedict.entrySet()) {
            if(state.equals(entry.getValue())) {
                System.out.println("Person from " + entry.getValue() + " State is: " + entry.getKey());
                count+=1;
            }
        }
        System.out.println("Count of contacts in " + state + " state is: " + count);
    }

    private void addDetails() {
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
    }

    public void sortByCity() {
        Comparator<Contact> list1 = Comparator.comparing(Contact::getCity);
        System.out.println("\n After Sorting the contact details by city : \n");
        list.stream().sorted(list1).forEach(System.out::println);
    }

    public void sortByState() {
        Comparator<Contact> list1 = Comparator.comparing(Contact::getState);
        System.out.println("\n After Sorting the contact details by State : \n");
        list.stream().sorted(list1).forEach(System.out::println);
    }

    private void displayDetails() {
        Comparator<Contact> list1 = Comparator.comparing(Contact::getFirstName);
        System.out.println("\n After Sorting the contact details are: \n");
        list.stream().sorted(list1).forEach(System.out::println);
    }

    public static String editDetails() {
        String name;
        System.out.println("Enter First Name of Details to be Edited: ");
        name = sc.next();

        if (name.equals(list.get(0).getFirstName())) {
            System.out.println("Enter FirstName");
            list.get(0).setFirstName(sc.next());
            System.out.println("Enter LastName");
            list.get(0).setLastName(sc.next());
            System.out.println("Enter Address");
            list.get(0).setAddress(sc.next());
            System.out.println("Enter CityName");
            list.get(0).setCity(sc.next());
            System.out.println("Enter StateName");
            list.get(0).setState(sc.next());
            System.out.println("Enter ZipCode");
            list.get(0).setZip(sc.next());
            System.out.println("Enter PhoneNumber");
            list.get(0).setPhoneNumber(sc.next());
            System.out.println("Enter Email");
            list.get(0).setEmail(sc.next());

            System.out.println(list.get(0));
            return "Contact Edited";
        }
        else {
            return "Name Not Available in List";
        }
    }

    public static String deleteContacts() {
        String name;
        System.out.print("Enter FirstName");
        name =sc.next();

        if (name.equals(list.get(0).getFirstName())) {
            list.remove(0);
            return "Deleted";
        }
        else {
            return "Name Not Available in List";
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Problem\n");

        AddressBook address = new AddressBook(null);
        address.defaultBook();
        address.defaultContact();
        int check = 0;

        address.sortByCity();
        address.sortByState();

        while(check != 10) {
            System.out.print("\n1.Add AddressBook \n2.Add Contact \n3.Display Contact \n4.Delete \n5.Edit"
                    + "\n6.Search for contacts based on city \n7.Search for contacts based on state"
                    + "\n8.To see name of a person based on city \n9.To see name of a person based on state \n10.Exit\n");
            check=sc.nextInt();

            switch(check) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    address.addDetails();
                    //address.sortEnteries();
                    break;
                case 3:
                    address.displayDetails();
                    break;
                case  4:
                    deleteContacts();
                    for(int i=0; i<list.size(); i++){
                        System.out.println(list.get(i));
                    }
                    break;
                case 5:
                    editDetails();
                    for(int i=0; i<list.size(); i++){
                        System.out.println(list.get(i));
                    }
                    break;
                case 6:
                    address.searchPersonByCity();
                    break;
                case 7:
                    address.searchPersonByState();
                    break;
                case 8:
                    address.personCityDictionary();
                    break;
                case 9:
                    address.personStateDictionary();
                    break;
                case 10:
                    System.out.println("Thank you!!!");
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}