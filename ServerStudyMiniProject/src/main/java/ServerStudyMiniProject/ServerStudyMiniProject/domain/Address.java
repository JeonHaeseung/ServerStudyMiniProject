package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {
    private String country;

    private String city;

    private String zipcode;

    @Builder
    Address(String country, String city, String zipcode){
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
    }

}
