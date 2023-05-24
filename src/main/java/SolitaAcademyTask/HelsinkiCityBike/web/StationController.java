package SolitaAcademyTask.HelsinkiCityBike.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SolitaAcademyTask.HelsinkiCityBike.domain.Station;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationRepository;
import SolitaAcademyTask.HelsinkiCityBike.domain.StationSummary;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins="http://localhost:3000")
public class StationController {
	
	
    @Autowired
    private StationRepository stationRepository;

    @GetMapping
    public ResponseEntity<Page<StationSummary>> getAllStationSummaries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int pageSize,
            @RequestParam(defaultValue = "id,asc") String sort) {
        Pageable pageable = createPageable(page, pageSize, sort);
        Page<Station> stationPage = stationRepository.findAll(pageable);

        List<StationSummary> stationSummaries = stationPage.getContent().stream()
                .map(station -> new StationSummary(
                        station.getId(),
                        station.getName(),
                        station.getAverageDistanceOfDepartureJourneys(),
                        station.getAverageDistanceOfReturnJourneys(),
                        station.getTop5PopularReturnStations(),
                        station.getTop5PopularDepartureStations()
                ))
                .collect(Collectors.toList());

        Page<StationSummary> stationSummaryPage = new PageImpl<>(stationSummaries, pageable, stationPage.getTotalElements());

        return ResponseEntity.ok(stationSummaryPage);
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




    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable("id") Long id) {
        Optional<Station> station = stationRepository.findById(id);
        if (station.isPresent()) {
            return ResponseEntity.ok(station.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
