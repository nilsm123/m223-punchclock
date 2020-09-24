package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.CheckInLocation;
import ch.zli.m223.punchclock.repository.CheckInLocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckInLocationService {
    private CheckInLocationRepository checkInLocationRepository;

    public CheckInLocationService(CheckInLocationRepository checkInLocationRepository) {
        this.checkInLocationRepository = checkInLocationRepository;
    }

    public CheckInLocation createLocation(CheckInLocation checkInLocation) {
        return checkInLocationRepository.saveAndFlush(checkInLocation);
    }

    public void deleteLocation(Long id) {
        checkInLocationRepository.deleteById(id);
    }

    public CheckInLocation putLocation(Long id, CheckInLocation location) {
        location.setId(id);
        return checkInLocationRepository.saveAndFlush(location);
    }

    public List<CheckInLocation> findAll() {
        return checkInLocationRepository.findAll();
    }
}
