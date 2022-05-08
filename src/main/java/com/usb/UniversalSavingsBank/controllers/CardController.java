package com.usb.UniversalSavingsBank.controllers;

import com.usb.UniversalSavingsBank.entities.Card;
import com.usb.UniversalSavingsBank.entities.CreditCard;
import com.usb.UniversalSavingsBank.entities.DebitCard;
import com.usb.UniversalSavingsBank.repositories.CardRepository;
import com.usb.UniversalSavingsBank.services.CardService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable String cardId) {
        Card card = cardService.getCardById(cardId);

        return card;
    }

    @GetMapping("/number/{accNumber}")
    public List<Card> getCardsForAccNumber(@PathVariable String accNumber) {
        List<Card> cards = cardService.getAllByAccNumber(accNumber);
        return cards;
    }

    @GetMapping("/user/{userId}")
    public List<Card> getCardsForUser(@PathVariable String userId) {
        List<Card> cards = cardService.getAllByUserId(userId);
        return cards;
    }

    @PostMapping
    public Card createCard(@RequestParam Boolean isCredit,
                           @RequestParam String accNumber) {
        Card card = cardService.create(isCredit, accNumber);
        return card;
    }

    @PatchMapping("/{cardId}")
    public Card updateCardLimits(@PathVariable String cardId,
                                 @RequestBody List<Pair<String, Integer>> limits) {
        Card card = cardService.updateLimits(cardId, limits);

        return card;
    }

    @PatchMapping("/extend/{cardId}")
    public Card expandExpiry(@PathVariable String cardId) {
        Card card = cardService.expand(cardId);
        return card;
    }

    @PatchMapping("/change/{cardId}")
    public Card changeType(@PathVariable String cardId) {
        // TODO add user requirements for credit upgrade
        Card card = cardService.changeType(cardId);
        return card;
    }

    @PutMapping("/block/{cardId}")
    public Card blockCard(@PathVariable String cardId) {
        Card card = cardService.block(cardId, true);
        return card;
    }

    @PutMapping("/unblock/{cardId}")
    public Card unblockCard(@PathVariable String cardId) {
        Card card = cardService.block(cardId, false);
        return card;
    }

    @DeleteMapping("/delete/{cardId}")
    public Card deleteCard(@PathVariable String cardId) {
        Card card = cardService.remove(cardId);
        return card;
    }
}
