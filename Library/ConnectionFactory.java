import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
    public static Connection getConnection(){
        try
        {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library DB",
                                               "postgres", "password");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}