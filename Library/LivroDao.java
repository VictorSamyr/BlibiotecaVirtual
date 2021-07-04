import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LivroDao {
    private Connection connection;

    public LivroDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Livro livro){
        String comando = "INSERT INTO livro(genero, ano_lancamento, isbn, sinopse, autor, imagem)"
                       + "VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = this.connection.prepareStatement(comando);
            stmt.setString(1, livro.getGenero());
            stmt.setInt(2, livro.getAnoLancamento());
            stmt.setLong(3, livro.getIsbn());
            stmt.setString(4, livro.getSinopse());
            stmt.setString(5, livro.getAutor());
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
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setGenero(rs.getString("genero"));
                livro.setAnoLancamento(rs.getInt("ano_lancamento"));
                livro.setIsbn(rs.getLong("isbn"));
                livro.setSinopse(rs.getString("sinopse"));
                livro.setAutor(rs.getString("autor"));
                InputStream is = rs.getBinaryStream("imagem");
                BufferedImage img = ImageIO.read(is);
                livro.setImagem(img);
                livros.add(livro);
            }
            rs.close();
            stmt.close();
            return livros;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
