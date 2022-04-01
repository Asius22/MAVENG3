package olympics;

import utils.DBConnector;
import utils.Log;

import java.sql.*;

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
                "height float not null, " +
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
        String insert = "insert into athlete (name, nation, birthdate, height) " +
                "values (?,?,?,?)";

        try {
            stat = conn.prepareStatement(insert);

            stat.setString(1, obj.getName());
            stat.setString(2, obj.getNation());
            stat.setDate(3, obj.getBirthdate());
            stat.setFloat(4, obj.getHeight());

            print(stat.executeUpdate(), "insert");

            commit();
        } catch (SQLException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void commit() throws SQLException {
        conn.commit();
        stat.close();
    }

    private void print(int res, String method) {
        l.info(method.toUpperCase() + " : " +
                ((res > 0) ? "Riuscito" : "Riprova")
        );
    }

    @Override
    public void delete(Athlete obj) {
        String delete = "delete from athlete where code = ?";

        try {

            stat = conn.prepareStatement(delete);
            stat.setInt(1, obj.getCode());
            print(stat.executeUpdate(), "delete");
            commit();
        } catch (SQLException e) {
            l.info(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Athlete obj) {
        String update = "update athlete set " +
                "name = ?, nation = ? , birthdate = ?, height = ?) " +
                "where code = ?";

        try {
            stat = conn.prepareStatement(update);

            stat.setString(1, obj.getName());
            stat.setString(2, obj.getNation());
            stat.setDate(3, obj.getBirthdate());
            stat.setFloat(4, obj.getHeight());
            stat.setInt(5, obj.getCode());

            print(stat.executeUpdate(), "update");

            commit();
        } catch (SQLException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void print(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                sb.append(rs.getString(i)).append("\t\t");
            l.info(sb.toString());

        }

        rs.close();
    }

    @Override
    public void findAll() {
        String select = "select * from athlete";

        try {
            stat = conn.prepareStatement(select);

            print(
                    stat.executeQuery()
            );

            stat.close();
        } catch (SQLException e) {
            l.error(e.getMessage());
        }
    }

    @Override
    public void findByPk(int pk) {
        String select = "select * from athlete where code = ?";

        try {
            stat = conn.prepareStatement(select);

            stat.setInt(1, pk);
            print(
                    stat.executeQuery()
            );

            stat.close();
        } catch (SQLException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void findByH(float height) {
        String select = "select * from athlete where height > ?";

        try {
            stat = conn.prepareStatement(select);

            stat.setFloat(1, height);
            print(
                    stat.executeQuery()
            );

            stat.close();
        } catch (SQLException e) {
            l.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
