import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeDao {
    private Connection connection;

    public LeDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Le le){
        String comando = "INSERT INTO le VALUES(?, ?)";
        try
        {
            PreparedStatement stmt = this.connection.prepareStatement(comando);
            stmt.setInt(1, le.getIdUsuario());
            stmt.setInt(2, le.getIdLivro());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Le> getLeituras(String sql){
        try
        {
            List<Le> leituras = new ArrayList<Le>();
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Le leitura = new Le();
                leitura.setIdUsuario(rs.getInt("id_usuario"));
                leitura.setIdLivro(rs.getInt("id_livro"));
                leituras.add(leitura);
            }
            rs.close();
            stmt.close();
            return leituras;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
