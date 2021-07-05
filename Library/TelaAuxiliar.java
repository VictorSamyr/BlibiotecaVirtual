import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class TelaAuxiliar {
    private JFrame frame;

    public TelaAuxiliar(){
        this.frame = new JFrame();
        this.frame.setSize(350, 460);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void abrirTelaUsuario(Usuario usuario){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        panel.setVisible(true);
        panel.setBackground(Color.decode("#FFFFFF"));
        JLabel iconeUsuario = new JLabel();
        iconeUsuario.setIcon(new ImageIcon(this.getClass().getResource("userIcon.jpg")));
        iconeUsuario.setBounds(100, 10, 150, 120);
        JLabel lblNome = new JLabel(usuario.getNome());
        lblNome.setBounds(140, 100, 100, 100);
        lblNome.setFont(new Font("",Font.BOLD, 17));
        JLabel lblLogin = new JLabel("Login: " + usuario.getLogin());
        lblLogin.setBounds(20, 140, 300, 100);
        lblLogin.setFont(new Font("",Font.BOLD, 17));
        JLabel lblEmail = new JLabel("Email: " + usuario.getEmail());
        lblEmail.setBounds(20, 180, 310, 100);
        lblEmail.setFont(new Font("",Font.BOLD, 17));
        String sexo;
        if (usuario.getSexo().equals("M")){sexo = "Masculino";}
        else if (usuario.getSexo().equals("F")){sexo = "Feminino";}
        else {sexo = "Não binário";}
        JLabel lblSexo = new JLabel("Sexo: " + sexo);
        lblSexo.setBounds(20, 220, 310, 100);
        lblSexo.setFont(new Font("",Font.BOLD, 17));
        JLabel lblIdade = new JLabel("Idade: " + Integer.toString(usuario.getIdade()));
        lblIdade.setBounds(20, 260, 310, 100);
        lblIdade.setFont(new Font("",Font.BOLD, 17));
        JLabel lblPreferidos = new JLabel("Gêneros Preferidos:");
        lblPreferidos.setBounds(20, 300, 310, 100);
        lblPreferidos.setFont(new Font("",Font.BOLD, 17));
        panel.add(iconeUsuario);
        panel.add(lblNome);
        panel.add(lblLogin);
        panel.add(lblEmail);
        panel.add(lblSexo);
        panel.add(lblIdade);
        panel.add(lblPreferidos);
        this.frame.add(panel);
        this.frame.setVisible(true);
    }
}
