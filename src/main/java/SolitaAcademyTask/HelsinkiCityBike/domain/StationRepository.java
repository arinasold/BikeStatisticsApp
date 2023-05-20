package SolitaAcademyTask.HelsinkiCityBike.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long>{
	
	List<Station> findAllByDepartureJourneysIsNotNull();
    List<Station> findAllByReturnJourneysIsNotNull();

    List<Journey> findByDepartureJourneys(Station departureStation);
    List<Journey> findByReturnJourneys(Station returnStation);
}
