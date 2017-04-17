package com.team.mvc.controller;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {


    private static final Logger logger = Logger.getLogger(AppController.class.getName());

    @Autowired
    CityService cityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PersonService personService;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        return "welcome";
    }

    @RequestMapping(value = "/admin/getlAllUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getAllUsers() {
        List<Persons> listPerson = personService.getAllUser();
        Persons person = personService.findByNickname(GetRole.getPrincipal());
        listPerson.remove(person);
        return listPerson;
    }


    @RequestMapping(value = "/admin/getUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getUsers() {
        return personService.getUsers();
    }

    @RequestMapping(value = "/admin/getOwners", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getOwners() {
        return personService.getOwners();
    }

    @RequestMapping(value = "/admin/getDrivers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getDrives() {
        return personService.getDrivers();
    }

    @RequestMapping(value = "/admin/getCities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getCities() {
        return cityService.stringCities();
    }


    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteUser(@RequestBody List<String> list) {

        for (String nickName : list) {
            personService.deleteByNickName(nickName);
            System.out.println("Delete " + nickName);
        }
        return "Success";
    }

    @RequestMapping(value = "/admin/saveChanges", method = RequestMethod.POST)
    public
    @ResponseBody
    String saveChanges(@RequestBody List<String> list) {

        System.out.println("SAVECHANGES");
        for (String s:list) {
            System.out.println(s);
        }

//        Persons person = personService.findByNickname(list.get(0));
//        person.setNickname(list.get(1).toString());
//        person.setFirstName(list.get(2).toString());
//        person.setLastName(list.get(3).toString());
//        person.setMobileNumber(list.get(4).toString());
//        person.setEmail(list.get(5).toString());
//        person.setPassword(passwordEncoder.encode(list.get(6)));

//        personService.update(person);
        System.out.println("Success changes");
        return "Success changes";
    }





    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "admin/admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "user/user";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {

        if (Flag.isFlag()) {
            model.addAttribute("flag", Flag.isFlag());
            Flag.setFlag(false);
        }


// перенавправляем пользователя после его входа и при попытке повторного доступа к страничке login
        if (isCurrentAuthenticationAnonymous())
            return "login";
        else {
            if (GetRole.hasRole("ROLE_ADMIN"))
                return "redirect:/admin";
            else
                return "redirect:/user";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }



    // метод для проверки авторизации пользователя
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
