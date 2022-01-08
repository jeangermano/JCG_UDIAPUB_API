package br.com.jcg.udiapub.adapter.supplier.response.councilor;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilorFactory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentePoliticoResponse {
    private Long id;
    private PessoaResponse pessoa;
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
