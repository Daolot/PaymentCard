package com.team.mvc.database.services;

import com.team.mvc.database.entities.*;
import com.team.mvc.database.repositories.PersonRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Persons findByEmail(String email){return personRepository.findByEmail(email);}

    public Persons findById(int id) throws NotFoundException {
        return personRepository.getById(id);
    }

    public Persons findByNickname(String nickname) {
        return personRepository.findByNickname(nickname);
    }

    public void savePerson(Persons persons){
        persons.setPassword(passwordEncoder.encode(persons.getPassword()));
        personRepository.save(persons);
    }

    public List<Persons> getAllUser(){
        return personRepository.getAll();
    }


    public boolean isPersonsNicknameUnique(Integer id, String nickname) {
        Persons persons = findByNickname(nickname);
        return ( persons==null || ((id != null) && (persons.getPersonId().equals(id) )));

    }
    public void updPass (String mail, String pass){
        Persons persons = new Persons();
        persons = personRepository.findByEmail(mail);
        persons.setPassword(passwordEncoder.encode(pass));
    }

   /* public List<Cards> findCradsByNickname(String nickname) {return personRepository.findCardsByNickname(nickname);}
    public CardBalance findBalanceByNickname(String nickname) {return personRepository.findBalanceByNickname(nickname);}
    public List<BalanceHist> findBalanceHistByNickname(String nickname) {return personRepository.findBalanceHistByNickname(nickname);}
    public List<Events> findEventsByNickname(String nickname) {return personRepository.findEventsByNickname(nickname);}*/
}
