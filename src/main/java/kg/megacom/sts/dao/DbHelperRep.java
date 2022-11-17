package kg.megacom.sts.dao;
import kg.megacom.sts.dao.impl.DbHelperRepImpl;
import java.sql.Connection;
import java.sql.SQLException;

public interface DbHelperRep {
    DbHelperRep INSTANCE = new DbHelperRepImpl();
    Connection connect() throws SQLException;
}
