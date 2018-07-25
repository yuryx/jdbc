package ru.sbrf.jschool.jdbc.dao;

import ru.sbrf.jschool.jdbc.dao.h2.PersonDaoException;
import ru.sbrf.jschool.jdbc.domen.Person;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public interface PersonDaoService {
    Person getPersonById(Integer id) throws DaoException;
    Person save(Person person) throws PersonDaoException;
}
