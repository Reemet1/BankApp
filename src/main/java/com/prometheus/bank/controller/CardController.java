package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Card;
import com.prometheus.bank.form.CardForm;
import com.prometheus.bank.service.CardService;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {


    @Autowired
    CardService cardService;

    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping("/show")
    public String showCards(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Card> cards = cardService.getAllCardsForClient(user.getUsername());

        model.addAttribute("cards", cards);

        return "user/cards";
    }

    @RequestMapping("/showAddCard")
    public String showAddCardForm(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CardForm cardForm = new CardForm();
        model.addAttribute("cardForm",cardForm);

        List<Account> accounts = userService.getUser(user.getUsername()).getClient().getAccounts();
        model.addAttribute("accounts", accounts);

        return "user/add-card-form";
    }

    @RequestMapping("/addCard")
    public String showCard(/*@Valid */@ModelAttribute("cardForm") CardForm cardForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "user/add-card-form";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Card card = new Card();
        card.setCardNumber(cardForm.getCardNumber());

        List<Account> accounts = userService.getUser(user.getUsername()).getClient().getAccounts();
        model.addAttribute("accounts", accounts);

        for(Account account : accounts) {
            if(account.getId() == cardForm.getAccountId()) {
                card.setAccount(account);
                break;
            }
        }

        card.setHolder(userService.getUser(user.getUsername()).getClient());
        card.setValidUntil(LocalDate.now().plusYears(2));

        cardService.saveCard(card);

        return "redirect:/cards/show";
    }

}
