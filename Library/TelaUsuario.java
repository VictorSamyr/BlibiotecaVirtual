import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class TelaUsuario {
    private JFrame frame;
    private JPanel panel;
    private Usuario usuario;

    public TelaUsuario(Usuario usuario){
        this.usuario = usuario;
        prepararTela();
        inicializar();
    }

    public void prepararTela(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.frame.setSize(420, 500);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void inicializar(){
        this.frame.add(this.panel);
        configurarPanel();
        this.frame.setVisible(true);
    }

    public void configurarPanel(){
        this.panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(Color.decode("#3cc3be"));
        mostrarPainelUsuario();
        mostrarDadosUsuario();
        mostrarGenerosFavoritos();
    }

    public void mostrarPainelUsuario(){
        JLabel iconeUsuario = new JLabel();
        iconeUsuario.setIcon(new ImageIcon(this.getClass().getResource("userIcon.jpg")));
        iconeUsuario.setBounds(135, 10, 150, 120);
        JLabel lblNome = new JLabel(this.usuario.getNome(), SwingConstants.CENTER);
        lblNome.setBounds(0, 90, 420, 100);
        lblNome.setFont(new Font("",Font.BOLD, 17));
        lblNome.setForeground(Color.decode("#FFFFFF"));
        JPanel panelUser = new JPanel();
        panelUser.setLayout(null);
        panelUser.setBackground(Color.decode("#2E3E77"));
        panelUser.setBounds(0, 0, 420, 160);
        panelUser.add(iconeUsuario);
        panelUser.add(lblNome);
        this.panel.add(panelUser);
    }

    public void mostrarDadosUsuario(){
        JLabel lblLogin = new JLabel("Login: " + this.usuario.getLogin());
        lblLogin.setBounds(20, 140, 300, 100);
        lblLogin.setFont(new Font("",Font.BOLD, 17));
        lblLogin.setForeground(Color.decode("#FFFFFF"));
        JLabel lblEmail = new JLabel("Email: " + this.usuario.getEmail());
        lblEmail.setBounds(20, 180, 310, 100);
        lblEmail.setFont(new Font("",Font.BOLD, 17));
        lblEmail.setForeground(Color.decode("#FFFFFF"));
        String sexo;
        if (this.usuario.getSexo().equals("M")){sexo = "Masculino";}
        else if (this.usuario.getSexo().equals("F")){sexo = "Feminino";}
        else {sexo = "Não binário";}
        JLabel lblSexo = new JLabel("Sexo: " + sexo);
        lblSexo.setBounds(20, 220, 310, 100);
        lblSexo.setFont(new Font("",Font.BOLD, 17));
        lblSexo.setForeground(Color.decode("#FFFFFF"));
        JLabel lblIdade = new JLabel("Idade: " + Integer.toString(this.usuario.getIdade()));
        lblIdade.setBounds(20, 260, 310, 100);
        lblIdade.setFont(new Font("",Font.BOLD, 17));
        lblIdade.setForeground(Color.decode("#FFFFFF"));
        panel.add(lblLogin);
        panel.add(lblEmail);
        panel.add(lblSexo);
        panel.add(lblIdade);
    }

    public void mostrarGenerosFavoritos(){
        JLabel lblPreferidos = new JLabel("Gêneros Preferidos:");
        lblPreferidos.setBounds(20, 300, 310, 100);
        lblPreferidos.setFont(new Font("",Font.BOLD, 17));
        lblPreferidos.setForeground(Color.decode("#FFFFFF"));
        JPanel favoritos = new JPanel();
        favoritos.setLayout(new GridLayout(3, 2));
        favoritos.setBackground(Color.decode("#3cc3be"));
        favoritos.setBounds(30, 360, 380, 90);
        for (String genero : this.usuario.getPreferencia()){
            JLabel lblGenero = new JLabel(genero);
            lblGenero.setFont(new Font("",Font.BOLD, 15));
            lblGenero.setForeground(Color.decode("#FFFFFF"));
            favoritos.add(lblGenero);
        }
        panel.add(lblPreferidos);
        panel.add(favoritos);
    }
}
