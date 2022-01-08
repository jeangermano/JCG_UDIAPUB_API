package br.com.jcg.udiapub.domain.citycouncilor;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
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
