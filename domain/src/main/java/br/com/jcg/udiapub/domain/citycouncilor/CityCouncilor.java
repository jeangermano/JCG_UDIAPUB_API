package br.com.jcg.udiapub.domain.citycouncilor;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"documentNumber"})
public class CityCouncilor {
    private String externalId;
    private String politicalName;
    private String fullName;
    private String documentNumber;


    CityCouncilor(String externalId, String politicalName, String fullName, String documentNumber) {
        this.externalId = externalId;
        this.politicalName = politicalName;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
    }
}
