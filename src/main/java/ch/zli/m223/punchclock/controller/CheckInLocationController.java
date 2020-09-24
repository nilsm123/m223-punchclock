package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.CheckInLocation;
import ch.zli.m223.punchclock.service.CheckInLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//The CheckInLocation is the Location where the User checked in for example "Building 1" or "Building 3"
@RestController
@RequestMapping("/locations")
public class CheckInLocationController {
    private CheckInLocationService checkInLocationService;

    public CheckInLocationController(CheckInLocationService checkInLocationService) {
        this.checkInLocationService = checkInLocationService;
    }

    //Gets all Entities of CheckInLocation from the DB. Accessible via the URL /locations and method: GET
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CheckInLocation> getAllEntries() {
        return checkInLocationService.findAll();
    }

    //creates CheckInLocation and saves it to the Database. Accessible via /locations, method: POST and in the Body as a JSON:
    //{
    //    "location": "yourLocation"
    //}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CheckInLocation createEntry(@Valid @RequestBody CheckInLocation checkInLocation) {
        return checkInLocationService.createLocation(checkInLocation);
    }
}
