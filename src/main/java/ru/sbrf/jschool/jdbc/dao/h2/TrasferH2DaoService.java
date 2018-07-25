package ru.sbrf.jschool.jdbc.dao.h2;

import ru.sbrf.jschool.jdbc.domen.Account;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public class TrasferH2DaoService extends AbstractH2DaoService{

    public void createTrasfer(String accFrom, String accTo, BigDecimal amount) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection(AbstractH2DaoService.CONNECT_URL);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            //statement.executeUpdate("UPDATE BANK.ACCOUNT SET balance = balance - "+amount +" WHERE number="+accFrom);
            boolean debug = true;
            if(debug){
                throw new RuntimeException("TERRRRRIBLE ERROR!!!!");
            }
            statement.executeUpdate("UPDATE BANK.ACCOUNT SET balance = balance + "+amount +" WHERE number="+accTo);
            connection.commit();
            //finally is here
            statement.close();
            connection.close();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (RuntimeException ex){
            connection.rollback();
        }
    }
}
