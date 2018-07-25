package ru.sbrf.jschool.jdbc.dao.h2;

import ru.sbrf.jschool.jdbc.domen.Account;
import ru.sbrf.jschool.jdbc.exceptions.DaoException;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by SBT-Pozdnyakov-AN on 02.11.2017.
 */
public class TrasferH2DaoService extends AbstractH2DaoService{

    public void createTrasfer(String accFrom, String accTo, BigDecimal amount) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection(AbstractH2DaoService.CONNECT_URL);
            connection.setAutoCommit(false);
            changeBalance(connection, accFrom, amount.negate());
            changeBalance(connection,accTo, amount);
            connection.commit();
            //finally is here
            connection.close();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (RuntimeException ex){
            connection.rollback();
        }
    }

    protected void changeBalance(final Connection connection, String account, BigDecimal amount) throws SQLException {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT balance from BANK.ACCOUNT where number=?",
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1,account);
            ResultSet rset = pstmt.executeQuery();
            rset.next();
            final BigDecimal balance = rset.getBigDecimal("balance");
            rset.updateBigDecimal("balance", balance.add(amount));
            rset.updateRow();
            rset.close();
        }catch (SQLException e) {
            e.printStackTrace();
        };
    }


}
