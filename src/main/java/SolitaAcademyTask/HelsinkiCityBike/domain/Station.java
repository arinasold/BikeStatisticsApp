package SolitaAcademyTask.HelsinkiCityBike.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "departureStation")
    @JsonIgnore
    private List<Journey> departureJourneys;

    @OneToMany(mappedBy = "returnStation")
    @JsonIgnore
    private List<Journey> returnJourneys;
    
    @Column(name = "departure_journeys_count")
    private int departureJourneysCount;

    @Column(name = "return_journeys_count")
    private int returnJourneysCount;

    
    // constructors
    
    public Station() {
		super();

	}

	public Station(String name, List<Journey> departureJourneys, List<Journey> returnJourneys) {
		super();
		this.name = name;
		this.departureJourneys = departureJourneys;
		this.returnJourneys = returnJourneys;
	}
	
	// getters and setters
	

	public Long getId() {
		return id;
	}

	public int getDepartureJourneysCount() {
		return departureJourneysCount;
	}

	public void setDepartureJourneysCount(int departureJourneysCount) {
		this.departureJourneysCount = departureJourneysCount;
	}

	public int getReturnJourneysCount() {
		return returnJourneysCount;
	}

	public void setReturnJourneysCount(int returnJourneysCount) {
		this.returnJourneysCount = returnJourneysCount;
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

	public List<Journey> getDepartureJourneys() {
		return departureJourneys;
	}

	public void setDepartureJourneys(List<Journey> departureJourneys) {
		this.departureJourneys = departureJourneys;
	}

	public List<Journey> getReturnJourneys() {
		return returnJourneys;
	}

	public void setReturnJourneys(List<Journey> returnJourneys) {
		this.returnJourneys = returnJourneys;
	}

	//calculations
	
	public double getAverageDistanceOfDepartureJourneys() {
        if (departureJourneys.isEmpty()) {
            return 0.0;
        }

        double totalDistance = departureJourneys.stream()
                .mapToInt(Journey::getDistance)
                .sum();
        return totalDistance / departureJourneys.size();
    }

    public double getAverageDistanceOfReturnJourneys() {
        if (returnJourneys.isEmpty()) {
            return 0.0;
        }

        double totalDistance = returnJourneys.stream()
                .mapToInt(Journey::getDistance)
                .sum();
        return totalDistance / returnJourneys.size();
    }
    
    public List<String> getTop5PopularReturnStations() {
        Map<String, Long> stationCountMap = departureJourneys.stream()
                .map(Journey::getReturnStation)
                .collect(Collectors.groupingBy(
                        Station::getName,
                        Collectors.counting()
                ));

        return stationCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public List<String> getTop5PopularDepartureStations() {
        Map<String, Long> stationCountMap = returnJourneys.stream()
                .map(Journey::getDepartureStation)
                .collect(Collectors.groupingBy(
                        Station::getName,
                        Collectors.counting()
                ));

        return stationCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

	
	//ToString

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", departureJourneys=" + departureJourneys + ", returnJourneys="
				+ returnJourneys + "]";
	}
    
    

 
}