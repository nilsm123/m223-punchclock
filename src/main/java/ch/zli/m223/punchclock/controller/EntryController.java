package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    //this is the function to get all entries. To get all users use the URL /entries, method: GET
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    //this is the function to create an entry use the URL /entries, method: POST and in the body as a JSON the attributes
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    //this is the function to delete an entry. To delete an entry use the URL /entries/idOfTheEntry, method: DELETE
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }

    //this is the function to edit an entry. To edit an entry use the URL /entries/idOfTheUser, method: PUT and in the body as a JSON the attributes
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Entry putEntry(@PathVariable Long id, @Valid @RequestBody Entry entry) {
        return entryService.putEntry(id, entry);
    }
}
