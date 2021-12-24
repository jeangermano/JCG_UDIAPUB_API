package br.com.jcg.udiapub.adapter.persistence.councilor;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilorFactory;

public class CityCouncilorMapper {

    static CityCouncilor mapToDomain(CityCouncilorJpaEntity entity) {
        return CityCouncilorFactory.builder()
            .externalId(entity.getExternalId())
            .politicalName(entity.getPoliticalName())
            .fullName(entity.getFullName())
            .documentNumber(entity.getDocumentNumber())
            .build();
    }

    static CityCouncilorJpaEntity mapToJpaEntity(Long id, CityCouncilor cityCouncilor) {
        return CityCouncilorJpaEntity.builder()
            .id(id)
            .externalId(cityCouncilor.getExternalId())
            .politicalName(cityCouncilor.getPoliticalName())
            .fullName(cityCouncilor.getFullName())
            .documentNumber(cityCouncilor.getDocumentNumber())
            .build();
    }

    static CityCouncilorJpaEntity mapToJpaEntity(CityCouncilor cityCouncilor) {
        return mapToJpaEntity(null, cityCouncilor);
    }
}
