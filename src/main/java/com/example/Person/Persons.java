package com.example.Person;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Persons {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotEmpty(message = "Last name is required")
    private String lastName;
  
    @NotEmpty(message = "First name is required")
    private String firstName;
      
    @NotEmpty(message = "Email is required")
    @Email
    private String address;
     
    private String city;
     
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
     
    @NotEmpty(message = "Communication preference is required")
    private String commPreference;
     
    @ElementCollection
    private List<@NotEmpty String> mobileDevices;
 
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
 
    public String getAddress() {
        return address;
    }
 
    public void setEmail(String address) {
        this.address = address;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setMobilePhone(String city) {
        this.city = city;
    }
 
    public String getCommPreference() {
        return commPreference;
    }
 
    public void setCommPreference(String commPreference) {
        this.commPreference = commPreference;
    }
 
    public List<String> getMobileDevices() {
        return mobileDevices;
    }
 
    public void setMobileDevices(List<String> mobileDevices) {
        this.mobileDevices = mobileDevices;
    }
     
}
