package br.com.jcg.udiapub.adapter.persistence.parameter.entity;

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
import java.time.LocalDateTime;

@Entity
@Table(name = "integration_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationHistoryJpaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "integration_parameter_id")
    private Long integrationParameterId;

    @Column(name = "integration_code")
    private String integrationCode;

    @Column(name = "updated_data")
    private Boolean updatedData;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
