package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;

    private String city;

    private String zipcode;

    public Address(String country, String city, String zipcode){
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
    }
}
