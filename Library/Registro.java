import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.geom.RoundRectangle2D;


public class Registro{
    private JFrame frame;
    private JPanel panel;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JComboBox<String> sexo;
    private JButton btnRegistrar;
    private JPanel fundoAzul;
    private JLabel txtRegistro;
    private JLabel lblFechar;
    private JLabel lblLogo;
    private JLabel txtlogo;
    private JLabel lblEmail;
    private JTextField txtEmail;

    public Registro(){
        prepararJanela();
        inicializar();
    }

    // Decidimos definir os métodos que criam e adicionam os componenetes como privados
    // pois não há necessidade de ultiliza-los fora da classe

    private void prepararJanela(){
        frame = new JFrame("Registrar-se");
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 700, 450, 20, 20));
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }

    private void inicializar(){
        panel = new JPanel();
        panel.setBackground(Color.decode("#FFFFFF"));
        // Optamos por não usar nem um layout manager, pois nos dá mais liberdade e
        // agilidade ao inserir componentes
        panel.setLayout(null);
        colocarComponentes();
        frame.add(panel);
        frame.setVisible(true);
    }

    private void colocarComponentes(){
        JLabel lblEmail = new JLabel("E-mail");
        JLabel txtlogo = new JLabel("BEM VINDO!");
        JLabel txtRegistro = new JLabel("REGISTRO");
        JPanel fundoAzul = new JPanel();
        JLabel lblLogin = new JLabel("Login");
        JLabel lblSenha = new JLabel("Senha");
        JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
        JLabel lblNome = new JLabel("Nome");
        lblEmail.setForeground(Color.decode("#3CC3BE"));
        lblLogin.setForeground(Color.decode("#3CC3BE"));
        lblSenha.setForeground(Color.decode("#3CC3BE"));
        lblNome.setForeground(Color.decode("#3CC3BE"));
        lblConfirmarSenha.setForeground(Color.decode("#3CC3BE"));
        lblEmail.setBounds(410, 130, 50, 50);
        txtRegistro.setBackground(Color.decode("#3cc3be"));
        txtRegistro.setBounds(395, 40, 300, 65);
        txtRegistro.setFont(new Font("",Font.BOLD, 45));
        txtRegistro.setForeground(Color.decode("#3CC3BE"));
        txtlogo.setBounds(70, 370, 300, 50);
        txtlogo.setFont(new Font("", Font.BOLD, 30));
        txtlogo.setForeground(Color.decode("#FFFFFF"));
        fundoAzul.setBackground(Color.decode("#3cc3be"));
        fundoAzul.setBounds(0, 0, 325, 450);
        lblNome.setBounds(410, 85, 50, 50);
        lblLogin.setBounds(520, 85, 50, 50);
        lblSenha.setBounds(410, 175,  50, 50);
        lblConfirmarSenha.setBounds(410, 220, 100, 50);
        txtEmail = new JTextField();
        txtNome = new JTextField();
        txtLogin = new JTextField();
        txtSenha = new JPasswordField();
        txtConfirmarSenha = new JPasswordField();
        txtNome.setBounds(410, 120, 90, 25);
        txtLogin.setBounds(520, 120, 90, 25);
        txtSenha.setBounds(410, 210, 200, 25);
        txtEmail.setBounds(410, 165, 200, 25);
        txtConfirmarSenha.setBounds(410, 255, 200, 25);
        carrgarImagens();
        definirCampoIdade();
        definirCampoSexo();
        definirCampoGeneros();
        definirBotao();
        definirButaoFechar();
        this.panel.add(txtEmail);
        this.panel.add(lblEmail);
        this.panel.add(txtlogo);
        this.panel.add(txtRegistro);
        this.panel.add(fundoAzul);
        this.panel.add(lblLogin);
        this.panel.add(txtLogin);
        this.panel.add(lblNome);
        this.panel.add(txtNome);
        this.panel.add(lblSenha);
        this.panel.add(txtSenha);
        this.panel.add(lblConfirmarSenha);
        this.panel.add(txtConfirmarSenha);
    }
    private void carrgarImagens(){
        
            
        lblFechar = new JLabel();
        lblLogo  = new JLabel();
        lblFechar.setIcon(new ImageIcon(this.getClass().getResource("BotaoFechar.png")));
        lblLogo.setIcon(new ImageIcon(this.getClass().getResource("BibliotecaIconeRegistro&Login.png")));
        lblFechar.setBounds(670, 10, 20, 20);
        lblLogo.setBounds(12, 50, 300, 300);
        this.panel.add(lblFechar);
        this.panel.add(lblLogo);
    }
    
    private void definirCampoIdade(){
        JLabel lblIdade = new JLabel("Idade");
        lblIdade.setBounds(410, 275, 50, 50);
        lblIdade.setForeground(Color.decode("#3CC3BE"));
        txtIdade = new JTextField(3);
        txtIdade.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                // Limitamos o preenchimento desse campo para somente números com até
                // 3 digitos
                String valor = txtIdade.getText();
                // Checa se o caractere inserído é um número
                boolean EhUmDigito = ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9';
                // Checa se o usuário apagou um caractere
                boolean  EhBackspace = ke.getKeyChar() == '\b';
                // checa se o usuário violou o limite de caracteres
                boolean noLimite = valor.length() < 3;
                if ((EhUmDigito && noLimite) || EhBackspace){
                    txtIdade.setEditable(true);
                    return;
                }
                txtIdade.setEditable(false);
            }
        });
        txtIdade.setBounds(445, 290, 30, 20);
        this.panel.add(lblIdade);
        this.panel.add(txtIdade);
    }

    private void definirCampoSexo(){
        JLabel lblSexo = new JLabel("Sexo");
        lblSexo.setForeground(Color.decode("#3CC3BE"));
        lblSexo.setBounds(477, 275, 50, 50);
        sexo = new JComboBox<>();
        sexo.setForeground(Color.decode("#3CC3BE"));
        sexo.setBackground(Color.decode("#FFFFFF"));
        sexo.addItem("Masculino");
        sexo.addItem("Feminino");
        sexo.addItem("Outro");
        sexo.setBounds(510, 290, 100, 20);
        this.panel.add(lblSexo);
        this.panel.add(sexo);
    }

    private void definirCampoGeneros(){
        JCheckBox ficcaoCientifica = new JCheckBox("Ficção Científica");
        JCheckBox romance = new JCheckBox("Romance");
        JCheckBox autoAjuda = new JCheckBox("Auto Ajuda");
        JCheckBox historiaEmQuadrinhos = new JCheckBox("Historia em quadrinhos");
        JCheckBox suspense = new JCheckBox("Suspense");
        JLabel lblGeneros = new JLabel("Gêneros Favoritos");
        lblGeneros.setBounds(410, 300, 150, 50);
        ficcaoCientifica.setBounds(406, 355, 120, 20);
        romance.setBounds(526, 335, 80, 20);
        autoAjuda.setBounds(406, 335, 90, 20);
        suspense.setBounds(526, 355, 85, 20);
        historiaEmQuadrinhos.setBounds(406, 375, 200, 20);
        ficcaoCientifica.setBackground(Color.decode("#FFFFFF"));
        romance.setBackground(Color.decode("#FFFFFF"));
        autoAjuda.setBackground(Color.decode("#FFFFFF"));
        suspense.setBackground(Color.decode("#FFFFFF"));
        historiaEmQuadrinhos.setBackground(Color.decode("#FFFFFF"));
        ficcaoCientifica.setForeground(Color.decode("#3CC3BE"));
        romance.setForeground(Color.decode("#3CC3BE"));
        autoAjuda.setForeground(Color.decode("#3CC3BE"));
        suspense.setForeground(Color.decode("#3CC3BE"));
        historiaEmQuadrinhos.setForeground(Color.decode("#3CC3BE"));
        lblGeneros.setForeground(Color.decode("#3CC3BE"));
        this.panel.add(lblGeneros);
        this.panel.add(ficcaoCientifica);
        this.panel.add(romance);
        this.panel.add(autoAjuda);
        this.panel.add(historiaEmQuadrinhos);
        this.panel.add(suspense);
    }

    private void definirBotao(){
        btnRegistrar = new JButton("Registrar →");
        btnRegistrar.setBounds(450, 407, 120, 30);
        this.panel.add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoEvento();
            }
        });
    }
    private void definirButaoFechar(){
        
        lblFechar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frame.dispose();
                
            }
        });


    }

    private void botaoEvento(){
        char[] senha = this.txtSenha.getPassword();
        char[] senhaConfirmada = this.txtConfirmarSenha.getPassword();
        boolean nomeVazio = this.txtNome.getText().equals("");
        boolean loginVazio = this.txtLogin.getText().equals("");
        boolean senhaVazia = Arrays.equals(senha, new char[0]);
        boolean confirmarVazio = Arrays.equals(senhaConfirmada, new char[0]);
        boolean idadeVazia = this.txtIdade.getText().equals("");
        // Checa se todos os campos foram preenchidos
        if (nomeVazio || loginVazio || senhaVazia || idadeVazia || confirmarVazio){
            JOptionPane.showMessageDialog(null,"Por Favor, Preencha Todos os Campos",
                "ERRO!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Checa se a senha e a confirmação da senha coincidem
        if (!Arrays.equals(senha, senhaConfirmada)){
            JOptionPane.showMessageDialog(null,"As Senhas Não São Iguais",
            "ERRO!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,
        "Registrado com sucesso!", "Registrado!", JOptionPane.INFORMATION_MESSAGE);
        this.frame.dispose();
        new Login();
    }
}