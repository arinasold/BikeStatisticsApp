package SolitaAcademyTask.HelsinkiCityBike.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface StationRepository extends CrudRepository<Station, Long> {


    Page<Station> findAll(Pageable pageable);

}

