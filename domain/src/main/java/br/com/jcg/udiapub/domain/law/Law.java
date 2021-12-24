package br.com.jcg.udiapub.domain.law;

import br.com.jcg.udiapub.domain.citycouncilor.CityCouncilor;

import java.time.LocalDate;
import java.util.List;

public class Law {

    private LawType type;
    private LawSituation situation;

    private String topic;
    private LawContent content;

    private LocalDate proposalDate;
    private LocalDate startDate;

    private String externalId;
    private String processNumber;
    private String projectNumber;

    private List<CityCouncilor> authorList;


}
