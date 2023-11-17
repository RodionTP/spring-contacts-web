package com.example.demo.repository;

import com.example.demo.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryContactRepository implements ContactRepository {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contacts.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Contact save(Contact contact) {
        contact.setId(System.currentTimeMillis());
        contacts.add(contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        Contact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact != null) {
            existedContact.setLastName(contact.getLastName());
            existedContact.setFirstName(contact.getFirstName());
            existedContact.setEmail(contact.getEmail());
            existedContact.setPhone(contact.getPhone());
        }
        return existedContact;
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(contacts::remove);
    }

    @Override
    public void batchInsert(List<Contact> contacts) {
        this.contacts.addAll(contacts);
    }
}
