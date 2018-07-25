package ru.sbrf.jschool.jdbc;

import ru.sbrf.jschool.jdbc.dao.PersonDaoService;
import ru.sbrf.jschool.jdbc.dao.h2.PersonH2DaoService;
import ru.sbrf.jschool.jdbc.dao.h2.TrasferH2DaoService;
import ru.sbrf.jschool.jdbc.domen.Person;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;
import ru.sbrf.jschool.jdbc.service.PersonFacade;

import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static final String CONNECT_URL = "jdbc:h2:tcp://localhost/C:\\Users\\sbt-mikhiyenko-yua\\Documents\\Java-школа\\JDBC1\\jdbctest\\test.db";
    public static final String GET_PERSON_QUERY = "SELECT * FROM BANK.PERSON";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            Person person = new PersonFacade().getPersonById(2);
            System.out.println(person);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        TrasferH2DaoService daoService = new TrasferH2DaoService();
        daoService.createTrasfer("1234","4321",new BigDecimal(300));


    }
}
