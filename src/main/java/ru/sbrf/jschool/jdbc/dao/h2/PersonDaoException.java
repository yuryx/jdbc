package ru.sbrf.jschool.jdbc.dao.h2;

import ru.sbrf.jschool.jdbc.exceptions.DaoException;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public class PersonDaoException extends DaoException {
    public PersonDaoException(String message) {
        super(message);
    }

    public PersonDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
