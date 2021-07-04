import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection connection;

    public UsuarioDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Usuario usuario){
        String comando = "INSERT INTO usuario(nome, login, sexo, email, idade, preferencia, senha)"
                       + " VALUES(?, ?, ?, ?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = this.connection.prepareStatement(comando);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, String.valueOf(usuario.getSexo()));
            stmt.setString(4, usuario.getEmail());
            stmt.setInt(5, usuario.getIdade());
            String preferencia = String.join(",", usuario.getPreferencia());
            stmt.setString(6, preferencia);
            stmt.setString(7, usuario.getSenha());
            stmt.execute();
            this.connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getUsuarios(String sql){
        try
        {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setIdade(rs.getInt("idade"));
                String preferencias = rs.getString("preferencia");
                usuario.setPreferencia(preferencias.split(","));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return usuarios;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
