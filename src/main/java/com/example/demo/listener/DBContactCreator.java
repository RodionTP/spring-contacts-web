package com.example.demo.listener;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DBContactCreator {
    private final ContactService contactService;

//    @EventListener(ApplicationStartedEvent.class)
    public void createContactData() {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 10; ) {
            Contact contact = new Contact();
            contact.setId((long) ++i);
            contact.setFirstName("FirstName " + i);
            contact.setLastName("LastName " + i);
            contact.setEmail("mail" + i + "@mail.ru");
            contact.setPhone("phone" + i);
            contacts.add(contact);
        }
        contactService.batchInsert(contacts);

    }
}
