package br.com.jcg.udiapub.adapter.persistence.parameter;


import br.com.jcg.udiapub.domain.parameter.IntegrationParameterSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IntegrationParameterScheduleMapper {

    IntegrationParameterScheduleMapper MAPPER = Mappers.getMapper(IntegrationParameterScheduleMapper.class);

    IntegrationParameterSchedule map(IntegrationParameterScheduleJpaEntity entity);
}
