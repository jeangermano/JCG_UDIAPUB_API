package br.com.jcg.udiapub.application.port.out;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;

import java.util.List;

public interface CityCouncilorRepository {

    List<CityCouncilor> getAll();

    void saveAll(List<CityCouncilor> cityCouncilorList);
}
