package SolitaAcademyTask.HelsinkiCityBike.domain;

import java.util.List;

public class StationSummary {
	
    private Long id;
    private String name;
    private double averageDistanceOfDepartureJourneys;
    private double averageDistanceOfReturnJourneys;
    private List<String> top5PopularReturnStations;
    private List<String> top5PopularDepartureStations;
    
    //constructors

    public StationSummary(Long id, String name, double averageDistanceOfDepartureJourneys,
                          double averageDistanceOfReturnJourneys, List<String> list,
                          List<String> list2) {
        this.id = id;
        this.name = name;
        this.averageDistanceOfDepartureJourneys = averageDistanceOfDepartureJourneys;
        this.averageDistanceOfReturnJourneys = averageDistanceOfReturnJourneys;
        this.top5PopularReturnStations = list;
        this.top5PopularDepartureStations = list2;
    }
    
    public void setAverageDistanceOfReturnJourneys(double averageDistanceOfReturnJourneys) {
        this.averageDistanceOfReturnJourneys = averageDistanceOfReturnJourneys;
    }

    public List<String> getTop5PopularReturnStations() {
        return top5PopularReturnStations;
    }

    public void setTop5PopularReturnStations(List<String> top5PopularReturnStations) {
        this.top5PopularReturnStations = top5PopularReturnStations;
    }

    public List<String> getTop5PopularDepartureStations() {
        return top5PopularDepartureStations;
    }

    public void setTop5PopularDepartureStations(List<String> top5PopularDepartureStations) {
        this.top5PopularDepartureStations = top5PopularDepartureStations;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageDistanceOfDepartureJourneys() {
        return averageDistanceOfDepartureJourneys;
    }

    public void setAverageDistanceOfDepartureJourneys(double averageDistanceOfDepartureJourneys) {
        this.averageDistanceOfDepartureJourneys = averageDistanceOfDepartureJourneys;
    }

    public double getAverageDistanceOfReturnJourneys() {
        return averageDistanceOfReturnJourneys;
    }

   
   }
