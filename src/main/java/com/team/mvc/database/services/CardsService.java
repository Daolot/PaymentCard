package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.repositories.CardsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;

    public Cards findById(int id) throws NotFoundException {
        return cardsRepository.getById((long) id);
    }

    public Cards findById(long id) throws NotFoundException {
        return cardsRepository.getById(id);
    }

    public Cards findByCardKey(long cardKey) throws NotFoundException {
        return cardsRepository.findByCardKey(cardKey);
    }

    public void saveCard(Cards card){
        cardsRepository.save(card);
    }

    public void update(Cards card){
        cardsRepository.update(card);
    }

    public List<Cards> getAll(){
        return cardsRepository.getAll();
    }


    public Cards findByCardName(String cardName){
        return cardsRepository.findByCardName(cardName);
    }


    public void blockCardById(long cardId){
        cardsRepository.blockCardById(cardId);
    }
}
