package DAO;
import model.entities.Sinistre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinistreDAO {

    private    Connection connection;
    public SinistreDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }


}
