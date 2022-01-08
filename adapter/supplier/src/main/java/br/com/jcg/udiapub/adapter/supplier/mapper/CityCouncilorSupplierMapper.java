package br.com.jcg.udiapub.adapter.supplier.mapper;

import br.com.jcg.udiapub.adapter.supplier.response.councilor.AgentePoliticoResponse;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilorFactory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityCouncilorSupplierMapper {

    CityCouncilorSupplierMapper MAPPER = Mappers.getMapper(CityCouncilorSupplierMapper.class);

    default CityCouncilor toDomain(AgentePoliticoResponse agentePoliticoResponse) {
        return CityCouncilorFactory.builder()
            .politicalName(agentePoliticoResponse.getNomePolitico())
            .fullName(agentePoliticoResponse.getPessoa().getNome())
            .documentNumber(agentePoliticoResponse.getPessoa().getDocumento())
            .externalId(agentePoliticoResponse.getId().toString())
            .build();
    }

}
