package br.com.jcg.udiapub.application.service.supplier.impl.response;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilorFactory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityCouncilorUdiaAgentePoliticoResponse {
    private Long id;
    private CityCouncilorUdiaPessoaResponse pessoa;
    private String nomePolitico;

    public CityCouncilor toDomain() {
        return CityCouncilorFactory.builder()
            .externalId(String.valueOf(this.id))
            .documentNumber(this.pessoa.getDocumento())
            .fullName(this.pessoa.getNome())
            .politicalName(this.nomePolitico)
            .build();
    }
}
