package com.example.school.service;

import com.example.school.controller.ContactController;
import com.example.school.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;


    }
}
