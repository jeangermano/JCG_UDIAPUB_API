package br.com.jcg.udiapub.domain.citycouncilor;

public class CityCouncilorFactory {

    public static CityCouncilorFactory.CityCouncilorBuilder builder() {
        return new CityCouncilorFactory.CityCouncilorBuilder();
    }

    public static class CityCouncilorBuilder  {
        private String externalId;
        private String politicalName;
        private String fullName;
        private String documentNumber;

        public CityCouncilorFactory.CityCouncilorBuilder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CityCouncilorFactory.CityCouncilorBuilder politicalName(String politicalName) {
            this.politicalName = politicalName;
            return this;
        }

        public CityCouncilorFactory.CityCouncilorBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public CityCouncilorFactory.CityCouncilorBuilder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public CityCouncilor build() {
            return new CityCouncilor(this.externalId, this.politicalName, this.fullName, this.documentNumber);
        }
    }

}
