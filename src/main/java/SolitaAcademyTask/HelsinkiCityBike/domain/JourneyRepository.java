package SolitaAcademyTask.HelsinkiCityBike.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JourneyRepository extends CrudRepository<Journey, Long> {

    @Query(value = "SELECT j FROM Journey j JOIN FETCH j.departureStation JOIN FETCH j.returnStation",
           countQuery = "SELECT COUNT(j) FROM Journey j")
    Page<Journey> findAllWithStations(Pageable pageable);


}
