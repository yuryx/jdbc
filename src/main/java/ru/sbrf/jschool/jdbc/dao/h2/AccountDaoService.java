package ru.sbrf.jschool.jdbc.dao.h2;

import ru.sbrf.jschool.jdbc.domen.Account;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

import java.util.List;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public interface AccountDaoService {
    List<Account> getAccountByNumber(Integer personId) throws DaoException;
}
