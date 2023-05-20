package SolitaAcademyTask.HelsinkiCityBike.domain;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface JourneyRepository extends CrudRepository<Journey, Long>{

	@Query("SELECT j FROM Journey j JOIN FETCH j.departureStation JOIN FETCH j.returnStation")
	List<Journey> findAllWithStations();


}
