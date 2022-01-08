package br.com.jcg.udiapub.application.port.in.supplier;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;

import java.util.List;

public interface CityCouncilorSupplier {

    List<CityCouncilor> getCouncilorsOfCurrentLegislature();

}
