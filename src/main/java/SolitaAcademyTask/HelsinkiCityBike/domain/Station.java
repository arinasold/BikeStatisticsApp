package SolitaAcademyTask.HelsinkiCityBike.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


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
    @JsonIgnoreProperties({"departureJourney", "returnJourney"})
    private List<Journey> departureJourneys;

    @OneToMany(mappedBy = "returnStation")
    @JsonIgnoreProperties({"departureJourney", "returnJourney"})
    private List<Journey> returnJourneys;
    
    
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
	
	//ToString

	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", departureJourneys=" + departureJourneys + ", returnJourneys="
				+ returnJourneys + "]";
	}
    
    

 
}