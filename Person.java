/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author gabriel
 */
abstract public class Person implements Serializable {

    private String id;
    private String first;
    private String last;
    private String email;
    private String address;
    private String zip;
    private String string;
    private java.util.Date date;
    transient private static ArrayList<String> ids = new ArrayList<String>();

    Person(){
        setId();
        setDate();
        setZip();
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("ID: " + id);
        s.append("\nFirst: " + first + "\nLast: " + last);
        s.append("\nEmail: " + email);
        s.append("\nAddress: " + address);
        s.append("\nZip: " + zip);
        s.append('\n' + date.toString()); 
        return s.toString();
    }
    
    public String getId() {
        return id;
    }

    private void setId(){
        Random rand = new Random();
        String ID = Integer.toString(rand.nextInt(999999999) + 100000000);
        if(ids.contains(ID)){
            setId();
        }
        else
            this.id = ID;
    }
    
    public void setId(int a) {
        Random rand = new Random();
        this.id = Integer.toString(rand.nextInt(999999999) + 100000000);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date){
        this.date = date;
    }
    
    public void setDate() {
        this.date = new java.util.Date();
    }
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(){
        Random rand = new Random();
        this.zip = Integer.toString(rand.nextInt(99999) + 10000);
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
