package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Card;
import com.prometheus.bank.entity.ServiceFee;
import com.prometheus.bank.form.CardForm;
import com.prometheus.bank.service.CardService;
import com.prometheus.bank.service.FeeService;
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
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/serviceFees")
public class ServiceFeeController {

    @Autowired
    private FeeService feeService;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping("/show")
    public String showServiceFees(Model model) {

        List<ServiceFee> serviceFees = feeService.getAllServiceFees();

        model.addAttribute("serviceFees", serviceFees);

        return "admin/service-fees-page";
    }


}
