package ru.sbrf.jschool.jdbc.service;

import ru.sbrf.jschool.jdbc.dao.PersonDaoService;
import ru.sbrf.jschool.jdbc.dao.h2.AccountDaoService;
import ru.sbrf.jschool.jdbc.dao.h2.AccountH2DaoService;
import ru.sbrf.jschool.jdbc.dao.h2.PersonH2DaoService;
import ru.sbrf.jschool.jdbc.domen.Account;
import ru.sbrf.jschool.jdbc.domen.Person;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

import java.util.List;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public class PersonFacade {

    public Person getPersonById(Integer id) throws DaoException {
        PersonDaoService personDaoService = new PersonH2DaoService();
        AccountDaoService accountDaoService = new AccountH2DaoService();
        Person person = personDaoService.getPersonById(id);
        List<Account> accountList = accountDaoService.getAccountByNumber(person.getId());
        person.setAccountList(accountList);
        return person;
    }
}
