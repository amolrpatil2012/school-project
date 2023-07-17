package com.example.school.controller;

import com.example.school.model.Contact;
import com.example.school.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class ContactController {

    ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;

    }


    @RequestMapping("/contact")
    public String displayContactPage(Model model)
    {
        model.addAttribute("contact",new Contact());
        return "contact.html";

    }

    // @PostMapping
    @RequestMapping(value="/saveMsg",method = RequestMethod.POST)
    public String saveMessage(@Valid  @ModelAttribute("contact") Contact contact, Errors errors)
    {
        if ( errors.hasErrors())
        {
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";

    }
}
