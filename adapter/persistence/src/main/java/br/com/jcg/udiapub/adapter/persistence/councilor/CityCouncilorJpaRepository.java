package br.com.jcg.udiapub.adapter.persistence.councilor;

import br.com.jcg.udiapub.application.port.out.CityCouncilorRepository;
import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;

import java.util.List;
import java.util.stream.Collectors;

public class CityCouncilorJpaRepository implements CityCouncilorRepository {

    CityCouncilorSpringDataRepository cityCouncilorSpringDataRepository;

    public CityCouncilorJpaRepository(CityCouncilorSpringDataRepository cityCouncilorSpringDataRepository) {
        this.cityCouncilorSpringDataRepository = cityCouncilorSpringDataRepository;
    }

    @Override
    public List<CityCouncilor> getAll() {
        var councilorJpaEntityList = cityCouncilorSpringDataRepository.findAll();
        return councilorJpaEntityList
            .stream()
            .map(CityCouncilorMapper::mapToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<CityCouncilor> cityCouncilorList) {
        var councilorJpaEntityList = cityCouncilorList
            .stream()
            .map(CityCouncilorMapper::mapToJpaEntity)
            .collect(Collectors.toList());
        cityCouncilorSpringDataRepository.saveAll(councilorJpaEntityList);
    }
}
