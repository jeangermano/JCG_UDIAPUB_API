module br.com.udiapub.application {
    requires br.com.udiapub.domain;

    requires com.fasterxml.jackson.databind;
    requires java.net.http;

    exports br.com.jcg.udiapub.application.port.in;
    exports br.com.jcg.udiapub.application.port.out;
}