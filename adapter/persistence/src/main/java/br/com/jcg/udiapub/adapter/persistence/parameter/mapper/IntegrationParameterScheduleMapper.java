package br.com.jcg.udiapub.adapter.persistence.parameter.mapper;


import br.com.jcg.udiapub.adapter.persistence.parameter.entity.IntegrationParameterScheduleJpaEntity;
import br.com.jcg.udiapub.domain.parameter.IntegrationParameterSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IntegrationParameterScheduleMapper {

    IntegrationParameterScheduleMapper MAPPER = Mappers.getMapper(IntegrationParameterScheduleMapper.class);

    IntegrationParameterSchedule mapToDomain(IntegrationParameterScheduleJpaEntity entity);

    IntegrationParameterScheduleJpaEntity mapToEntity(IntegrationParameterSchedule domain);
}
