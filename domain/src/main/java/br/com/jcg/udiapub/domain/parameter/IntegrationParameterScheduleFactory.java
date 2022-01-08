package br.com.jcg.udiapub.domain.parameter;

import java.time.LocalDateTime;

public class IntegrationParameterScheduleFactory {

    public static IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder builder() {
        return new IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder();
    }

    public static class IntegractionParameterScheduleBuilder {

        private IntegrationType type;
        private IntegrationFrequencyType frequency;
        private LocalDateTime lastIntegration;
        private boolean isActive;

        public IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder type(IntegrationType type) {
            this.type = type;
            return this;
        }

        public IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder fraquency(IntegrationFrequencyType frequency) {
            this.frequency = frequency;
            return this;
        }

        public IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder lastIntegration(LocalDateTime lastIntegration) {
            this.lastIntegration = lastIntegration;
            return this;
        }

        public IntegrationParameterScheduleFactory.IntegractionParameterScheduleBuilder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public IntegrationParameterSchedule build() {
            return new IntegrationParameterSchedule(type, frequency, lastIntegration, isActive);
        }
    }
}
