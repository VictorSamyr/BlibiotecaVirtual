import java.sql.Connection;

public class Main {
    public static void main(String[] args){
       new Login();
       Connection conn = ConnectionFactory.getConnection();
    }
}
