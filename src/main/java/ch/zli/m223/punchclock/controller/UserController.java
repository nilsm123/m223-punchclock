package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ApplicationUserService applicationUserService;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserService applicationUserService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.applicationUserService = applicationUserService;
    }

    //this is the sign-up function to sign-up a user use the URL /users/sign-up, method: POST and in the body as a JSON:
    //{
    //"username": "yourUsername",
    //"password": "yourPassword"
    //}
    //Warning the username must be unique
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    //this is the function to delete a user. To delete a user use the URL /users/idOfTheUser, method: DELETE
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        applicationUserService.deleteUser(id);
    }

    //this is the function to edit a user. To edit a user use the URL /users/idOfTheUser, method: PUT and in the body as a JSON:
    // {
    //"username": "yourUsername",
    //"password": "yourPassword"
    //}
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser putUser(@PathVariable Long id, @Valid @RequestBody ApplicationUser user) {
        return applicationUserService.putUser(id, user);
    }

    //this is the function to get all users. To get all users use the URL /users, method: GET
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }
}
