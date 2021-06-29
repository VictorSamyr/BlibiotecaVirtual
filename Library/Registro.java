import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;


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
    
    public Registro(){
        prepararJanela();
        inicializar();
    }

    // Decidimos definir os métodos que criam e adicionam os componenetes como privados
    // pois não há necessidade de ultiliza-los fora da classe

    private void prepararJanela(){
        frame = new JFrame("Registrar-se");
        frame.setSize(400, 460);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }

    private void inicializar(){
        panel = new JPanel();
        // Optamos por não usar nem um layout manager, pois nos dá mais liberdade e
        // agilidade ao inserir componentes
        panel.setLayout(null);
        colocarComponentes();
        frame.add(panel);
        frame.setVisible(true);
    }

    private void colocarComponentes(){
        JLabel lblLogin = new JLabel("Nome:");
        JLabel lblSenha = new JLabel("Senha:");
        JLabel lblConfirmarSenha = new JLabel("Confirmar:");
        JLabel lblNome = new JLabel("Login:");
        lblLogin.setBounds(10, 10, 50, 50);
        lblNome.setBounds(10, 50, 50, 50);
        lblSenha.setBounds(10, 90,  50, 50);
        lblConfirmarSenha.setBounds(10, 130, 80, 50);
        txtNome = new JTextField();
        txtLogin = new JTextField();
        txtSenha = new JPasswordField();
        txtConfirmarSenha = new JPasswordField();
        txtLogin.setBounds(65, 25, 200, 20);
        txtNome.setBounds(65, 65, 200, 20);
        txtSenha.setBounds(65, 105, 200, 20);
        txtConfirmarSenha.setBounds(95, 145, 170, 20);
        definirCampoIdade();
        definirCampoSexo();
        definirCampoGeneros();
        definirBotao();
        this.panel.add(lblLogin);
        this.panel.add(txtLogin);
        this.panel.add(lblNome);
        this.panel.add(txtNome);
        this.panel.add(lblSenha);
        this.panel.add(txtSenha);
        this.panel.add(lblConfirmarSenha);
        this.panel.add(txtConfirmarSenha);
    }

    private void definirCampoIdade(){
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 170, 50, 50);
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
        txtIdade.setBounds(65, 185, 30, 20);
        this.panel.add(lblIdade);
        this.panel.add(txtIdade);
    }

    private void definirCampoSexo(){
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 210, 50, 50);
        sexo = new JComboBox<>();
        sexo.addItem("Masculino");
        sexo.addItem("Feminino");
        sexo.addItem("Outro");
        sexo.setBounds(65, 225, 100, 20);
        this.panel.add(lblSexo);
        this.panel.add(sexo);
    }

    private void definirCampoGeneros(){
        JCheckBox ficcaoCientifica = new JCheckBox("Ficção Científica");
        JCheckBox romance = new JCheckBox("Romance");
        JCheckBox autoAjuda = new JCheckBox("Auto Ajuda");
        JCheckBox historiaEmQuadrinhos = new JCheckBox("Historia em quadrinhos");
        JCheckBox suspense = new JCheckBox("Suspense");
        JLabel lblGeneros = new JLabel("Gêneros Favoritos:");
        lblGeneros.setBounds(10, 245, 200, 50);
        ficcaoCientifica.setBounds(10, 285, 174, 40);
        romance.setBounds(180, 285, 100, 40);
        autoAjuda.setBounds(10, 315, 174, 40);
        suspense.setBounds(180, 315, 100, 40);
        historiaEmQuadrinhos.setBounds(10, 350, 200, 35);
        this.panel.add(lblGeneros);
        this.panel.add(ficcaoCientifica);
        this.panel.add(romance);
        this.panel.add(autoAjuda);
        this.panel.add(historiaEmQuadrinhos);
        this.panel.add(suspense);
    }

    private void definirBotao(){
        btnRegistrar = new JButton("Registrar →");
        btnRegistrar.setBounds(260, 385, 120, 30);
        this.panel.add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoEvento();
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