import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;


public class Login {
    private JFrame frame;
    private JPanel panel;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JLabel lblRegistrar;
    private JLabel lblFechar;
    private JLabel labelLogin;
    private JLabel labelSenha;
    private JLabel labelLogo;

    public Login(){
        configurarJanela();
        inicializar();
    }

    // Decidimos definir os métodos que criam e adicionam os componenetes como privados
    // pois não há necessidade de ultiliza-los fora da classe

    private void configurarJanela(){
        frame = new JFrame("Entrar");
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 700, 450, 20, 20));
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void inicializar(){
        panel = new JPanel();
        // Optamos por não usar nem um layout manager, pois nos dá mais liberdade e
        // agilidade ao inserir componentes
        panel.setLayout(null);
        definirComponentes();
        this.frame.add(panel);
        this.frame.setVisible(true);
    }

    private void definirComponentes(){
        JLabel txtlogo = new JLabel("BEM VINDO!");
        JLabel lblLogin = new JLabel("Login:");
        JLabel lblSenha = new JLabel("Senha:");
        JLabel tituloLogin = new JLabel("LOGIN");
        JPanel imgLogin = new JPanel();
        lblLogin.setBounds(10, 30, 50, 50);
        lblLogin.setFont(new Font("", Font.BOLD, 15));
        lblSenha.setBounds(10, 60, 60, 50);
        lblSenha.setFont(new Font("", Font.BOLD, 15));
        tituloLogin.setBounds(440, 40, 300, 65);
        tituloLogin.setFont(new Font("",Font.BOLD, 45));
        tituloLogin.setForeground(Color.decode("#3CC3BE"));
        txtlogo.setBounds(70, 370, 300, 50);
        txtlogo.setFont(new Font("", Font.BOLD, 30));
        txtlogo.setForeground(Color.decode("#FFFFFF"));
        txtLogin = new JTextField("");
        txtSenha = new JPasswordField("");
        txtLogin.setBounds(412, 150, 200, 30);
        txtSenha.setBounds(412, 200, 200, 30);
        imgLogin.setBounds(0, 0, 325, 450);
        imgLogin.setBackground(Color.decode("#3CC3BE"));
        definirBotao();
        carrgarImagens();
        definirLabelRegistrar();
        definirButaoFechar();
        this.panel.add(txtlogo);
        this.panel.add(tituloLogin);
        this.panel.add(imgLogin);
        this.panel.add(lblLogin);
        this.panel.add(lblSenha);
        this.panel.add(txtLogin);
        this.panel.add(txtSenha);
    }
    private void carrgarImagens(){
        
        labelSenha = new JLabel(); 
        labelLogin = new JLabel();
        labelLogo = new JLabel();
        lblFechar = new JLabel();

        labelLogin.setIcon(new ImageIcon(this.getClass().getResource("LoginIcone.png")));
        labelSenha.setIcon(new ImageIcon(this.getClass().getResource("SenhaIcone.png"))); 
        labelLogo.setIcon(new ImageIcon(this.getClass().getResource("BibliotecaIcone.png")));
        lblFechar.setIcon(new ImageIcon(this.getClass().getResource("BotaoFechar.png")));
        
        labelLogin.setBounds(617, 150, 30, 30);
        labelSenha.setBounds(617, 200, 30, 30);
        labelLogo.setBounds(12, 50, 300, 300);
        lblFechar.setBounds(670, 10, 20, 20);

        this.panel.add(lblFechar);
        this.panel.add(labelLogo);        
        this.panel.add(labelSenha);
        this.panel.add(labelLogin);
    }
    private void definirButaoFechar(){
        
        lblFechar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frame.dispose();
                
            }
        });


    }

    private void definirLabelRegistrar(){
        lblRegistrar = new JLabel("Não Possui uma Conta? Clique Aqui!");
        lblRegistrar.setBounds(410, 300, 230, 50);
        lblRegistrar.setForeground(Color.decode("#3CC3BE"));
        // Quando a label é clicada a janela atual é fechada e
        // a janela de registro é aberta
        lblRegistrar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frame.dispose();
                new Registro();
            }
        });
        this.panel.add(lblRegistrar);
    }

    private void definirBotao(){
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(452, 260, 120, 30);
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBotao();
            }
        });
        this.panel.add(btnEntrar);
    }

    private void eventoBotao(){
        boolean loginVazio = this.txtLogin.getText().equals("");
        boolean senhaVazia = Arrays.equals(txtSenha.getPassword(), new char[0]);
        if (loginVazio || senhaVazia){
            JOptionPane.showMessageDialog(null,"Login ou Senha Inválidos",
            "ERRO!", JOptionPane.ERROR_MESSAGE);
        return;
        }
        JOptionPane.showMessageDialog(null,
        "Você Entrou no Sistema", "Bem Vindo!", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
