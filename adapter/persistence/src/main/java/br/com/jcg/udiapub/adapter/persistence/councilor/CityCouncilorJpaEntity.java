package br.com.jcg.udiapub.adapter.persistence.councilor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city_councilor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityCouncilorJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "political_name")
    private String politicalName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "document_number")
    private String documentNumber;
}
