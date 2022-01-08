package br.com.jcg.udiapub.adapter.supplier;

import br.com.jcg.udiapub.adapter.supplier.mapper.CityCouncilorSupplierMapper;
import br.com.jcg.udiapub.application.port.in.supplier.CityCouncilorSupplier;
import br.com.jcg.udiapub.adapter.supplier.response.councilor.AgentePoliticoResponse;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class CityCouncilorRestClientSupplier implements CityCouncilorSupplier {

    @Override
    public List<CityCouncilor> getCouncilorsOfCurrentLegislature() {
        HttpRequest request;

        try {
            request = HttpRequest.newBuilder()
                .uri(new URI("https://sistema.camarauberlandia.mg.gov.br/GRP/portalcidadao/webservices/agentePolitico/getAgentesPorAnoMes"))
                .headers("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("{\"val0\":2020, \"val1\":null, \"val2\":\"VEREADOR\", \"val3\":\"2021-01-01T00:00:00.000\", \"val4\":\"2021-12-31T00:00:00.000\"}"))
                .build();

            var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() >= 200 && response.statusCode() < 300) {
                var objectMapper = new ObjectMapper();
                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

                List<AgentePoliticoResponse> cityList = objectMapper.readValue(
                    response.body(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, AgentePoliticoResponse.class));

                return cityList.stream()
                    .map(CityCouncilorSupplierMapper.MAPPER::toDomain)
                    .collect(Collectors.toList());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
