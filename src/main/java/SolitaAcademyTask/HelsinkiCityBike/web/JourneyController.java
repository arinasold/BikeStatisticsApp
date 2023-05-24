package SolitaAcademyTask.HelsinkiCityBike.web;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Journey;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyRepository;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class JourneyController{
    

	@Autowired
	private JourneyRepository journeyRepository;

	@GetMapping("/journeys")
	public ResponseEntity<Page<JourneyResponse>> getAllJourneys(
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "10") int pageSize,
	    @RequestParam(defaultValue = "departureDate,desc") String sort) { // Added sort parameter with default value
	  Pageable pageable = createPageable(page, pageSize, sort); // Create Pageable object with sort information
	  
	  Page<Journey> journeyPage = journeyRepository.findAllWithStations(pageable); // Retrieve all journeys with stations
	  
	  List<JourneyResponse> journeyResponses = journeyPage.getContent().stream()
	      .map(journey -> {
	          String departureStationName = journey.getDepartureStation().getName();
	          String returnStationName = journey.getReturnStation().getName();
	          return new JourneyResponse(journey, departureStationName, returnStationName);
	      })
	      .collect(Collectors.toList());

	  return ResponseEntity.ok(new PageImpl<>(journeyResponses, pageable, journeyPage.getTotalElements()));
	}

	private Pageable createPageable(int page, int pageSize, String sort) {
	  String[] sortParams = sort.split(",");
	  String sortField = sortParams[0];
	  Sort.Direction sortDirection = Sort.Direction.ASC;
	  
	  if (sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc")) {
	    sortDirection = Sort.Direction.DESC;
	  }
	  
	  Sort.Order sortOrder = new Sort.Order(sortDirection, sortField);
	  Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortOrder));
	  
	  return pageable;
	}



    
}
