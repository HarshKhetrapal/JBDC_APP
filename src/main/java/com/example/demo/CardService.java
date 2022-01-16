package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Integer createCard(Card card){
        card.setId(null);
        Card createdCard = cardRepository.save(card);
        return createdCard.getId();
    }

    public Card getCard(Integer id)
    {
        Optional<Card> optional = cardRepository.findById(id);

        if(optional.isPresent())
            return optional.get();

        return null;
    }
}
