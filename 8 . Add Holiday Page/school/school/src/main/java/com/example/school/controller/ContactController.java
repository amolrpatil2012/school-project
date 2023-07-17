package com.example.school.controller;

import com.example.school.model.Contact;
import com.example.school.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContactController {

    ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;

    }


    @RequestMapping("/contact")
    public String displayContactPage()
    {
        return "contact.html";

    }

    // @PostMapping
    @RequestMapping(value="/saveMsg",method = RequestMethod.POST)
    public ModelAndView saveMessage(Contact contact)
    {
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");

    }
}
