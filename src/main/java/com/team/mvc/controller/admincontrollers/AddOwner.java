package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.AppController;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
@RequestMapping("/admin/addOwner")
public class AddOwner {

    private static final Logger logger = Logger.getLogger(AppController.class.getName());

    @Autowired
    CompanyService companyService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    OwnerService ownerService;

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewOwner(ModelMap model) {
        Owners owner = new Owners();
        model.addAttribute("ownerForm", owner);
        return "admin/addOwner";
    }

    @RequestMapping(value = "/newOwner", method = RequestMethod.POST)
    public String saveOwner(@Valid @ModelAttribute("ownerForm") Owners owner, BindingResult result) {

        List<FieldError> listError = new ArrayList<>();

        try {
            if (result.hasErrors()) {
                return "errorPage";
            }

            if (!personService.isPersonsNicknameUnique(owner.getPerson().getPersonId(), owner.getPerson().getNickname())) {
                FieldError nicknameUniqError = new FieldError("owner", "person.nickname", messageSource.getMessage("non.unique.owner.nickname", new String[]{owner.getPerson().getNickname()}, Locale.getDefault()));
                listError.add(nicknameUniqError);
            }
            if (!personService.isPersonsEmailUnique(owner.getPerson().getPersonId(), owner.getPerson().getEmail())) {
                FieldError emailUniqError = new FieldError("owner", "person.email", messageSource.getMessage("non.unique.owner.email", new String[]{owner.getPerson().getEmail()}, Locale.getDefault()));
                listError.add(emailUniqError);
            }
            if (!personService.isPersonsMobileUnique(owner.getPerson().getPersonId(), owner.getPerson().getMobileNumber())) {
                FieldError mobileUniqError = new FieldError("owner", "person.mobileNumber", messageSource.getMessage("non.unique.owner.mobileNumber", new String[]{owner.getPerson().getMobileNumber()}, Locale.getDefault()));
                listError.add(mobileUniqError);
            }

            if (!listError.isEmpty()) {
                for (FieldError fieldError : listError) {
                    result.addError(fieldError);
                }
                return "admin/addOwner";
            } else {
                ownerService.saveOwner(owner);
                return "redirect:/admin/allOwners";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }

    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

    @ModelAttribute("companies")
    public List<Companies> getCompaniesWithoutOwners() {
        return companyService.getCompaniesWithoutOwners();
    }

}