package olympics;

import utils.DBConnector;
import utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryHelper implements BaseRepository<Athlete> {

    private DBConnector connector = DBConnector.getIstance();
    private PreparedStatement stat;
    private Log l = Log.getInstance();
    private Connection conn;

    public RepositoryHelper() {
        String create = "CREATE TABLE IF EXISTS ATHLETE(" +
                "code int not null auto increment, " +
                "name varchar(20) not null, " +
                "birthdate date not null, " +
                "nation varchar(40) not null, " +
                "height double not null, " +
                "primary key (code));";

        try {
            conn = connector.getConnection();
            conn.setAutoCommit(false);
            stat = connector.getPreparedStatement(create);
            stat.executeUpdate();

            conn.commit();

            stat.close();
        } catch (SQLException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void persist(Athlete obj) {

    }

    @Override
    public void delete(Athlete obj) {

    }

    @Override
    public void update(Athlete obj) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findByPk(int pk) {

    }

    @Override
    public void findByH(double height) {

    }
}
