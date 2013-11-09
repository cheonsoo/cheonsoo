package mansoo.board.service;

import java.util.List;

import mansoo.board.data.Contact;


public interface ContactService {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(int id);
}
