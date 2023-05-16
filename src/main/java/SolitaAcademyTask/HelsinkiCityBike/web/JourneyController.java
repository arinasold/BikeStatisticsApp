package SolitaAcademyTask.HelsinkiCityBike.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Journey;
import SolitaAcademyTask.HelsinkiCityBike.domain.JourneyRepository;

@RestController
@RequestMapping("/api/journeys")
public class JourneyController {
	
	
    @Autowired
    private JourneyRepository journeyRepository;

    @GetMapping
    public Iterable<Journey> getAllJourneys() {
    	
        Iterable<Journey> journeys = journeyRepository.findAll();

        return journeys;
    }
}
