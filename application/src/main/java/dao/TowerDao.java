package dao;

import domain.Tower;

import javax.xml.transform.Result;
import java.sql.*;

public class TowerDao {

    private final String url;

    public TowerDao() {
        this.url = "jdbc:sqlite:td.db";
        initDatabase();
    }

    private Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void initDatabase() {

        String sql = "CREATE TABLE IF NOT EXISTS Towers ("
                + "id INTEGER PRIMARY KEY, "
                + "costToBuild INTEGER, "
                + "attackSpeed INTEGER, "
                + "attackRange INTEGER, "
                + "attackDamage INTEGER);";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        addTowerTypesIfDbIsEmpty();
    }

    private void addTowerTypesIfDbIsEmpty() {

        String sql = "SELECT * FROM Towers;";

        try (Connection conn = this.connect();

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.next()) {
                sql = "INSERT INTO Towers (id, costToBuild, attackSpeed, attackRange, attackDamage) "
                        + "VALUES (0, 20, 1, 278, 5)";

                Statement stmt2 = conn.createStatement();
                stmt2.execute(sql);
                stmt2.close();

                sql = "INSERT INTO Towers (id, costToBuild, attackSpeed, attackRange, attackDamage) "
                        + "VALUES (1, 30, 2, 370, 10)";

                Statement stmt3 = conn.createStatement();
                stmt3.execute(sql);
                stmt3.close();
            }
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Tower getTowerById(int id) {

        String sql = "SELECT costToBuild, attackSpeed, attackRange, attackDamage FROM Towers WHERE "
                + "Towers.id == ? ;";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            Tower tower = new Tower(id, rs.getInt("costToBuild"), rs.getInt("attackSpeed"), (double) (rs.getInt("attackRange")), rs.getInt("attackDamage"), -1.0, -1.0);

            return tower;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
