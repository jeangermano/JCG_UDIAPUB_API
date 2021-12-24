module br.com.udiapub.domain {
    requires transitive static lombok;
    requires transitive com.fasterxml.jackson.annotation;

    exports br.com.jcg.udiapub.domain.citycouncilor;
    exports br.com.jcg.udiapub.domain.parameter;
}