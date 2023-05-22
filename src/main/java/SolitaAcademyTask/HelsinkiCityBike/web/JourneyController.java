package SolitaAcademyTask.HelsinkiCityBike.web;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Journey;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyRepository;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyResponse;
import SolitaAcademyTask.HelsinkiCityBike.domain.Station;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class JourneyController{
    

	@Autowired
	private JourneyRepository journeyRepository;
    @Autowired
    private StationRepository stationRepository;


    @GetMapping("/journeys")
    public ResponseEntity<Page<JourneyResponse>> getAllJourneys(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int pageSize) {
      Pageable pageable = PageRequest.of(page, pageSize);
      Page<Journey> journeyPage = journeyRepository.findAllWithStations(pageable);
      List<JourneyResponse> journeyResponses = journeyPage.getContent().stream()
          .map(journey -> {
              String departureStationName = journey.getDepartureStation().getName();
              String returnStationName = journey.getReturnStation().getName();
              return new JourneyResponse(journey, departureStationName, returnStationName);
          })
          .collect(Collectors.toList());

      return ResponseEntity.ok(new PageImpl<>(journeyResponses, pageable, journeyPage.getTotalElements()));
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
