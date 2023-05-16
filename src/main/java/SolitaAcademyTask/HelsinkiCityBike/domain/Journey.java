package SolitaAcademyTask.HelsinkiCityBike.domain;


import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_station_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"departureJourneys", "returnJourneys"})
    private Station departureStation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "return_station_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"departureJourneys", "returnJourneys"})
    private Station returnStation;

    @Column(name = "distance")
    private int distance;

    @Column(name = "duration")
    private int duration;
   
    
 
    // constructors
    
    
    public Journey() {
		super();
		
	}

	public Journey(Timestamp departureDate, Timestamp returnDate, Station departureStation, Station returnStation,
			int distance, int duration) {
		super();
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.departureStation = departureStation;
		this.returnStation = returnStation;
		this.distance = distance;
		this.duration = duration;
	}

	// getters and setters
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public Station getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	public Station getReturnStation() {
		return returnStation;
	}

	public void setReturnStation(Station returnStation) {
		this.returnStation = returnStation;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	// toString


	@Override
	public String toString() {
		return "Journey [id=" + id + ", departureDate=" + departureDate + ", returnDate=" + returnDate
				+ ", departureStation=" + departureStation.getName() + ", returnStation=" + returnStation.getName() + ", distance="
				+ distance + ", duration=" + duration + "]";
	}


	
}