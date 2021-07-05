import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {
    private Connection connection;

    public LivroDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Livro livro){
        String comando = "INSERT INTO livros(titulo, genero, autor, ano_lancamento, sinopse, imagem)"
                       + "VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = this.connection.prepareStatement(comando);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getAutor());
            stmt.setInt(4, livro.getAnoLancamento());
            stmt.setString(5, livro.getSinopse());
            stmt.setString(6, livro.getImagem());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> getLivros(String sql){
        try
        {
            List<Livro> livros = new ArrayList<Livro>();
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setGenero(rs.getString("genero"));
                livro.setAnoLancamento(rs.getInt("ano_lancamento"));
                livro.setSinopse(rs.getString("sinopse"));
                livro.setAutor(rs.getString("autor"));
                livros.add(livro);
            }
            rs.close();
            stmt.close();
            return livros;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
