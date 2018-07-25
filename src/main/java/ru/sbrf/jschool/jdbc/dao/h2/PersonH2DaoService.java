package ru.sbrf.jschool.jdbc.dao.h2;

import ru.sbrf.jschool.jdbc.dao.PersonDaoService;
import ru.sbrf.jschool.jdbc.domen.Person;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

import java.sql.*;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public class PersonH2DaoService extends AbstractH2DaoService implements PersonDaoService {
    public static final String CONNECT_URL = "jdbc:h2:tcp://localhost/C:\\TEMP\\test.db";


    public Person getPersonById(Integer id) throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM BANK.PERSON WHERE id=?");){

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int i = 0;
            Person person = null;
            while (resultSet.next()) {
                i++;
                if (i > 1) {
                    throw new PersonDaoException("More than one row");
                }
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
            }
            if (person == null) {
                throw new DaoException("Person not found id=" + id);
            }
            if (!resultSet.isClosed()) {
                resultSet.close();
            }
            return person;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Get person error", e);
        }
    }

    public Person save(Person person) {
        return null;
    }
}
