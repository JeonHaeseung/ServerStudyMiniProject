package ServerStudyMiniProject.ServerStudyMiniProject.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Embeddable
@AllArgsConstructor
public class Address {
    private String country;

    private String city;

    private String zipcode;
}
