package com.team.mvc.controller;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    PersonService personService;

    @Autowired
    RoleService roleService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistration(ModelMap model) {
        Persons person = new Persons();

        model.addAttribute("userForm", person);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("userForm") Persons person, BindingResult result,
                           ModelMap model) {

        List<FieldError> errors = new ArrayList<>();

        if (result.hasErrors()) {
            return "errorPage";
        }

        if (person.getNickname().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "nickname", messageSource.getMessage("NotEmpty.person.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(nicknameError);
        }

        if (!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())) {
            FieldError nicknameUniqError = new FieldError("person", "nickname", messageSource.getMessage("non.unique.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(nicknameUniqError);
        }


        if (person.getPassword().isEmpty()) {
            FieldError passwordError = new FieldError("person", "password", messageSource.getMessage("NotEmpty.person.password", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(passwordError);
        }

        if (person.getFirstName().isEmpty()) {
            FieldError firstNameError = new FieldError("person", "firstName", messageSource.getMessage("NotEmpty.person.firstName", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(firstNameError);
        }

        if (person.getLastName().isEmpty()) {
            FieldError lastNameError = new FieldError("person", "lastName", messageSource.getMessage("NotEmpty.person.lastName", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(lastNameError);
        }

        if (person.getEmail().isEmpty()) {
            FieldError emailError = new FieldError("person", "email", messageSource.getMessage("NotEmpty.person.email", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(emailError);
        }

        if (person.getCity().equals(null)) {
            FieldError cityError = new FieldError("person", "city", messageSource.getMessage("NotEmpty.person.city", new String[]{person.getNickname()}, Locale.getDefault()));
            errors.add(cityError);
        }
        if(!errors.isEmpty()){

            for(FieldError error: errors){
                result.addError(error);
            }
            return "registration";
        }
        person.setRole(roleService.findByType("USER"));
        personService.savePerson(person);

        return "success";
    }

    @ModelAttribute("cities")
    public List<Cities> InitializeCities() {
        return cityService.getAll();
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}