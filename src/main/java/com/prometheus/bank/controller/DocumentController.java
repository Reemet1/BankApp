package com.prometheus.bank.controller;

import com.prometheus.bank.dao.DocumentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentDAO documentDAO;

    @RequestMapping("/show")
    public String showCards(Model model) {

        //model.addAttribute("message", "Study Information Systen");
        model.addAttribute("document", new String("abc"));

        return "user/documents";
    }

    @RequestMapping("/download")
    public void downloadDoc(Model model, HttpServletResponse response) {

        byte[] file = documentDAO.getDocument(1).getFile();
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename="+"fail.pdf");
        try  {
            response.getOutputStream().write(file);
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return "documents";
    }

}
