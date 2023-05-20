package SolitaAcademyTask.HelsinkiCityBike.domain;

public class JourneyResponse {
	
    private Journey journey;
    private String departureStationName;
    private String returnStationName;

    public JourneyResponse(Journey journey, String departureStationName, String returnStationName) {
        this.journey = journey;
        this.departureStationName = departureStationName;
        this.returnStationName = returnStationName;
    }

    public Journey getJourney() {
        return journey;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public String getReturnStationName() {
        return returnStationName;
    }
}
