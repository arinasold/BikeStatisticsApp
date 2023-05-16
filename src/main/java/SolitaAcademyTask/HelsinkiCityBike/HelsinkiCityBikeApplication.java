package SolitaAcademyTask.HelsinkiCityBike;



import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import SolitaAcademyTask.HelsinkiCityBike.domain.Journey;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyRepository;
import SolitaAcademyTask.HelsinkiCityBike.domain.Station;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationRepository;


@SpringBootApplication
public class HelsinkiCityBikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelsinkiCityBikeApplication.class, args);
	}
	/*
    @Autowired
    private JourneyRepository journeyRepository;

    @Autowired
    private StationRepository stationRepository;
    
	@Bean
    public CommandLineRunner demoData() {
        return (args) -> {
            // Create and save some stations
            Station station1 = new Station();
            station1.setName("Laajalahden aukio");
            station1 = stationRepository.save(station1);

            Station station2 = new Station();
            station2.setName("Teljäntie");
            station2 = stationRepository.save(station2);

            Station station3 = new Station();
            station3.setName("Töölöntulli");
            station3 = stationRepository.save(station3);

            Station station4 = new Station();
            station4.setName("Pasilan asema");
            station4 = stationRepository.save(station4);

            Station station5 = new Station();
            station5.setName("Näkinsilta");
            station5 = stationRepository.save(station5);

            Station station6 = new Station();
            station6.setName("Vilhonvuorenkatu");
            station6 = stationRepository.save(station6);

            Station station7 = new Station();
            station7.setName("Viiskulma");
            station7 = stationRepository.save(station7);

            Station station8 = new Station();
            station8.setName("Hernesaarenranta");
            station8 = stationRepository.save(station8);

            // Create and save journeys
            Journey journey1 = new Journey();
            journey1.setDepartureStation(station1);
            journey1.setReturnStation(station2);
            journey1.setDepartureDate(Timestamp.valueOf("2021-05-31 23:57:25"));
            journey1.setReturnDate(Timestamp.valueOf("2021-06-01 00:05:46"));
            journey1.setDistance(2043);
            journey1.setDuration(500);
            journeyRepository.save(journey1);

            Journey journey2 = new Journey();
            journey2.setDepartureStation(station3);
            journey2.setReturnStation(station4);
            journey2.setDepartureDate(Timestamp.valueOf("2021-05-31 23:56:59"));
            journey2.setReturnDate(Timestamp.valueOf("2021-06-01 00:07:14"));
            journey2.setDistance(1870);
            journey2.setDuration(611);
            journeyRepository.save(journey2);

            Journey journey3 = new Journey();
            journey3.setDepartureStation(station5);
            journey3.setReturnStation(station6);
            journey3.setDepartureDate(Timestamp.valueOf("2021-05-31 23:56:44"));
            journey3.setReturnDate(Timestamp.valueOf("2021-06-01 00:03:26"));
            journey3.setDistance(1025);
            journey3.setDuration(399);
            journeyRepository.save(journey3);

            Journey journey4 = new Journey();
            journey4.setDepartureStation(station7);
            journey4.setReturnStation(station8);
            journey4.setDepartureDate(Timestamp.valueOf("2021-05-31 23:56:23"));
            journey4.setReturnDate(Timestamp.valueOf("2021-06-01 00:29:58"));
            journey4.setDistance(4318);
            journey4.setDuration(2009);
            journeyRepository.save(journey4);

	        // Print the information to the console
	        

	        System.out.println(journey1);
	        System.out.println(journey2);
	        System.out.println(journey3);
	        System.out.println(journey4);
	     

	    };
	}
	*/
}
