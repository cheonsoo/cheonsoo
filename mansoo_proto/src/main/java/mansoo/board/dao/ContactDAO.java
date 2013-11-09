package mansoo.board.dao;

import java.util.List;

import mansoo.board.data.Contact;


public interface ContactDAO {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(int id);
}
