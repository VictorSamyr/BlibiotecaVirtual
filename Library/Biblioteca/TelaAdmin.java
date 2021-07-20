import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class TelaAdmin {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JPanel formPanel;
    private JPanel generosPanel;
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JTextField txtSexo;
    private JTextField txtIdade;
    private JTextField txtEmail;
    private UsuarioDao userDao;
    private List<JCheckBox> preferencias;

    public TelaAdmin(){
        userDao = new UsuarioDao();
        frame = new JFrame();
        configurarJanela();
        frame.setVisible(true);
    }

    private void configurarJanela(){
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel = new JPanel();
        formPanel = new JPanel();
        tablePanel = new JPanel();
        formPanel.setBounds(0, 0, 300, 500);
        tablePanel.setBounds(280, 0, 420, 500);
        mainPanel.setLayout(null);
        formPanel.setLayout(null);
        tablePanel.setLayout(null);
        mainPanel.add(formPanel);
        mainPanel.add(tablePanel);
        adicionarFormulario();
        frame.add(mainPanel);
    }

    private void adicionarFormulario(){
        JLabel lblId = new JLabel("ID");
        JLabel lblNome = new JLabel("Nome");
        JLabel lblLogin = new JLabel("Login");
        JLabel lblSexo = new JLabel("Sexo");
        JLabel lblIdade = new JLabel("Idade");
        JLabel lblEmail = new JLabel("E-Mail");
        JLabel lblPreferencias = new JLabel("Preferências");
        txtId = new JTextField();
        txtNome = new JTextField();
        txtLogin = new JTextField();
        txtSexo = new JTextField();
        txtIdade = new JTextField();
        txtEmail = new JTextField();
        lblId.setBounds(10, 11, 20, 12);
        lblNome.setBounds(10, 36, 48, 12);
        lblLogin.setBounds(10, 61, 48, 15);
        lblSexo.setBounds(10, 86, 48, 15);
        lblIdade.setBounds(10, 111, 48, 15);
        lblEmail.setBounds(10, 136, 48, 15);
        lblPreferencias.setBounds(10, 161, 104, 15);
        lblId.setFont(new Font("", Font.BOLD, 15));
        lblNome.setFont(new Font("", Font.BOLD, 15));
        lblLogin.setFont(new Font("", Font.BOLD, 15));
        lblSexo.setFont(new Font("", Font.BOLD, 15));
        lblIdade.setFont(new Font("", Font.BOLD, 15));
        lblEmail.setFont(new Font("", Font.BOLD, 15));
        lblPreferencias.setFont(new Font("", Font.BOLD, 15));
        txtId.setBounds(35, 9, 30, 15);
        txtNome.setBounds(63, 36, 85, 16);
        txtLogin.setBounds(63, 61, 85, 16);
        txtSexo.setBounds(63, 86, 15, 16);
        txtIdade.setBounds(63, 111, 30, 15);
        txtEmail.setBounds(63, 136, 85, 16);
        //adicionarPreferencias();
        formPanel.add(lblId);
        formPanel.add(lblNome);
        formPanel.add(lblLogin);
        formPanel.add(lblSexo);
        formPanel.add(lblIdade);
        formPanel.add(lblEmail);
        formPanel.add(lblPreferencias);
        formPanel.add(txtId);
        formPanel.add(txtNome);
        formPanel.add(txtLogin);
        formPanel.add(txtSexo);
        formPanel.add(txtIdade);
        formPanel.add(txtEmail);
        generosPanel = new JPanel();
        generosPanel.setBounds(0, 180, 400, 150);
        generosPanel.setLayout(new GridLayout(3, 2));
        adicionarPreferencias();
        formPanel.add(generosPanel);
    }

    private void adicionarPreferencias(){
        preferencias = new ArrayList<JCheckBox>();
        JCheckBox ficcaoCientifica = new JCheckBox("Ficção Científica");
        JCheckBox romance = new JCheckBox("Romance");
        JCheckBox autoAjuda = new JCheckBox("Auto-Ajuda");
        JCheckBox historiaEmQuadrinhos = new JCheckBox("História em quadrinhos");
        JCheckBox suspense = new JCheckBox("Suspense");
        preferencias.add(ficcaoCientifica);
        preferencias.add(romance);
        preferencias.add(autoAjuda);
        preferencias.add(historiaEmQuadrinhos);
        preferencias.add(suspense);
        generosPanel.add(ficcaoCientifica);
        generosPanel.add(romance);
        generosPanel.add(autoAjuda);
        generosPanel.add(suspense);
        generosPanel.add(historiaEmQuadrinhos);
    }
}
