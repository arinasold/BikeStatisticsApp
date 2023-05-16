package SolitaAcademyTask.HelsinkiCityBike.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Station;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationRepository;

@RestController
@RequestMapping("/api/stations")
public class StationController {
    @Autowired
    private StationRepository stationRepository;

    @GetMapping
    public List<Station> getAllStations() {
        return (List<Station>) stationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable("id") Long id) {
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()) {
            return ResponseEntity.ok(station.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/departure")
    public List<Station> getDepartureStations() {
        return stationRepository.findAllByDepartureJourneysIsNotNull();
    }

    @GetMapping("/return")
    public List<Station> getReturnStations() {
        return stationRepository.findAllByReturnJourneysIsNotNull();
    }
}
