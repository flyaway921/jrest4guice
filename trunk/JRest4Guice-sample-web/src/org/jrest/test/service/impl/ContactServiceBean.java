package org.jrest.test.service.impl;

import java.util.List;

import org.jpa4guice.annotation.Transactional;
import org.jrest.test.dao.ContactDao;
import org.jrest.test.entity.Contact;
import org.jrest.test.service.ContactService;

import com.google.inject.Inject;

@SuppressWarnings("unchecked")
public class ContactServiceBean implements ContactService {
	@Inject
	private ContactDao dao;

	@Transactional
	public String createContact(Contact contact) {
		if (contact == null)
			throw new RuntimeException("联系人的内容不能为空");

		if (this.dao.findContactByName(contact.getName()).size() > 0) {
			throw new RuntimeException("联系人的姓名相同，请重新输入");
		}

		this.dao.createContact(contact);
		return contact.getId();
	}

	@Transactional
	public void deleteContact(String contactId) {
		Contact contact = this.findContactById(contactId);
		if (contact == null)
			throw new RuntimeException("联系人不存在");

		this.dao.deleteContact(contact);
	}

	public Contact findContactById(String contactId) {
		Contact contact = this.dao.findContactById(contactId);
		return contact;
	}

	public List<Contact> listContacts(int first, int max)
			throws RuntimeException {
		return this.dao.listContacts(first, max);
	}

	@Transactional
	public void updateContact(Contact contact) {
		if (contact == null)
			throw new RuntimeException("联系人的内容不能为空");

		this.dao.updateContact(contact);
	}
}
