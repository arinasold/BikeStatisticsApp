package SolitaAcademyTask.HelsinkiCityBike.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Journey;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyRepository;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyResponse;
import SolitaAcademyTask.HelsinkiCityBike.domain.Station;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationRepository;

@RestController
@RequestMapping("/api/journeys")
public class JourneyController {
	
	
    @Autowired
    private JourneyRepository journeyRepository;
    
    @Autowired
    private StationRepository stationRepository;

    @GetMapping
    public ResponseEntity<List<JourneyResponse>> getAllJourneys() {
        List<Journey> journeys = journeyRepository.findAllWithStations();
        List<JourneyResponse> journeyResponses = new ArrayList<>();

        for (Journey journey : journeys) {
            String departureStationName = journey.getDepartureStation().getName();
            String returnStationName = journey.getReturnStation().getName();
            JourneyResponse response = new JourneyResponse(journey, departureStationName, returnStationName);
            journeyResponses.add(response);
        }

        return ResponseEntity.ok(journeyResponses);
    }


    
    @GetMapping("/{id}")
    public ResponseEntity<JourneyResponse> getJourneyById(@PathVariable Long id) {
        Optional<Journey> optionalJourney = journeyRepository.findById(id);

        if (optionalJourney.isPresent()) {
            Journey journey = optionalJourney.get();
            String departureStationName = journey.getDepartureStation().getName();
            String returnStationName = journey.getReturnStation().getName();
            JourneyResponse response = new JourneyResponse(journey, departureStationName, returnStationName);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
    @GetMapping("/departure-journeys/{stationId}")
    public List<Journey> getDepartureJourneysByStation(@PathVariable Long stationId) {
        Optional<Station> optionalStation = stationRepository.findById(stationId);

        if (optionalStation.isPresent()) {
            Station station = optionalStation.get();
            return station.getDepartureJourneys();
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/return-journeys/{stationId}")
    public List<Journey> getReturnJourneysByStation(@PathVariable Long stationId) {
        Optional<Station> optionalStation = stationRepository.findById(stationId);

        if (optionalStation.isPresent()) {
            Station station = optionalStation.get();
            return station.getReturnJourneys();
        } else {
            return Collections.emptyList();
        }
    }
    
}
