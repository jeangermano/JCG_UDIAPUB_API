package br.com.jcg.udiapub.adapter.api.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

@Configuration
public class Config {

    private static final String[] adaptersPath = {"br.com.jcg.studies.account.adapter.persistence"};
    private static final String[] applicationsPortPath = {"br.com.jcg.studies.account.application.port.out"};
    private static final String[] servicesPath = {"br.com.jcg.studies.account.application.service"};
    private static final String[] factoryPath = {"br.com.jcg.studies.account.domain.factory"};


    @Bean
    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory -> {
            genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
        };
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan(adaptersPath);
        beanDefinitionScanner.scan(servicesPath);
        beanDefinitionScanner.scan(applicationsPortPath);
        beanDefinitionScanner.scan(factoryPath);
    }

    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
            .getClassName()
            .endsWith("Model");
    }
}
