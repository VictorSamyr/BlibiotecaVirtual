import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;

public class Principal {
    private JFrame frame;    
    private JPanel panel;
    private JButton btnSair;
    private JButton btnBusca;
    private Usuario user;

    public Principal(Usuario user){
        this.user = user;
        prepararJanela();
        inicializar();
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

    private void prepararJanela(){
        frame = new JFrame("BibliotecaVistual");
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 1000, 600, 20, 20));
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        }    

        private void colocarComponentes(){
        JPanel logoFundo = new JPanel();
        JPanel editorasParceiras = new JPanel();
        JLabel todosOsLivros = new JLabel("Todos Os Livros");
        todosOsLivros.setBounds(220, 10, 500, 50);
        todosOsLivros.setFont(new Font("", Font.BOLD, 45));
        todosOsLivros.setForeground(Color.decode("#3cc3be"));
        editorasParceiras.setBounds(200, 520, 800, 200);
        editorasParceiras.setBackground(Color.decode("#38B4D9"));
        logoFundo.setBounds(2, 5, 195, 195);
        logoFundo.setBackground(Color.decode("#3CC3BE"));
        definirOpçaoConta();
        definirOpçaoFavoritos();
        definirOpçaoSair();
        definirOpçãoBusca();
        definirOpçaoCategorias();
        definirImgLogo();
        this.panel.add(logoFundo);
        this.panel.add(editorasParceiras);
        this.panel.add(todosOsLivros);
    }

    private void definirImgLogo(){
        JLabel bibliotecaIcone = new JLabel();
        bibliotecaIcone.setIcon(new ImageIcon(this.getClass().getResource("BibliotecaIconePrincipal.png"))); 
        bibliotecaIcone.setBounds(0, 0, 200, 200);
        this.panel.add(bibliotecaIcone);
    }

    private void trocarCor(JButton btn, JPanel p){

        btn.addMouseListener(new MouseAdapter(){
        
            public void mouseEntered(MouseEvent e) {
                p.setBackground(Color.decode("#319592"));
            }
    
            public void mouseExited(MouseEvent e) {
            p.setBackground(Color.decode("#3cc3be"));
            }
        });
    }

    private void definirOpçaoSair(){
        JLabel opçao5txt  = new JLabel("Sair");
        opçao5txt.setBounds(50, 27, 50, 25);
        opçao5txt.setFont(new Font("", Font.BOLD, 25));
        opçao5txt.setForeground(Color.decode("#FFFFFF"));
        btnSair = new JButton();
        btnSair.setBounds(0, 520, 200, 80);
        JPanel opçao5 = new JPanel();
        opçao5.setBounds(0, 520, 200, 80);
        opçao5.setBackground(Color.decode("#3cc3be"));
        opçao5.setLayout(null);
        btnSair.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();       
            }
        });
        
        trocarCor(btnSair, opçao5);
        
        this.panel.add(opçao5);
        opçao5.add(opçao5txt);
        this.panel.add(btnSair);
        btnSair.setOpaque(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setBorderPainted(false);
    }

    private void definirOpçãoBusca(){
        btnBusca = new JButton();
        btnBusca.setBounds(0, 440, 200, 80);
        JPanel opçao4 = new JPanel();
        opçao4.setBounds(0, 440, 200, 80);
        opçao4.setBackground(Color.decode("#3cc3be"));
        opçao4.setLayout(null);
        JLabel opçao4txt  = new JLabel("Busca");
        opçao4txt.setBounds(50, 27, 90, 25);
        opçao4txt.setFont(new Font("", Font.BOLD, 25));
        opçao4txt.setForeground(Color.decode("#FFFFFF"));
        
        trocarCor(btnBusca, opçao4);
        
        this.panel.add(opçao4);
        opçao4.add(opçao4txt);
        this.panel.add(btnBusca);
        btnBusca.setOpaque(false);
        btnBusca.setContentAreaFilled(false);
        btnBusca.setBorderPainted(false);
    }

    private void definirOpçaoCategorias(){
        JButton btnCategorias = new JButton();
        btnCategorias.setBounds(0, 360, 200, 80);
        JPanel opçao3 = new JPanel();
        opçao3.setBounds(0, 360, 200, 80);
        opçao3.setBackground(Color.decode("#3cc3be"));
        JLabel opçao3txt  = new JLabel("Categorias");
        opçao3txt.setBounds(50, 20, 180, 40);
        opçao3txt.setFont(new Font("", Font.BOLD, 25));
        opçao3txt.setForeground(Color.decode("#FFFFFF"));
        opçao3.setLayout(null);
        
        trocarCor(btnCategorias,opçao3);
        
        this.panel.add(opçao3);
        opçao3.add(opçao3txt);
        this.panel.add(btnCategorias);
        btnCategorias.setOpaque(false);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.setBorderPainted(false);
    }

    private void definirOpçaoFavoritos(){
        JPanel opçao2 = new JPanel();
        opçao2.setBounds(0, 280, 200, 80);
        opçao2.setBackground(Color.decode("#3cc3be"));
        opçao2.setLayout(null);
        JLabel opçao2txt  = new JLabel("Favoritos");
        opçao2txt.setBounds(50, 20, 180, 40);
        opçao2txt.setFont(new Font("", Font.BOLD, 25));
        opçao2txt.setForeground(Color.decode("#FFFFFF"));
        JButton btnFavoritos = new JButton();
        btnFavoritos.setBounds(0, 280, 200, 80);

        trocarCor(btnFavoritos, opçao2);

        this.panel.add(opçao2);
        opçao2.add(opçao2txt);
        this.panel.add(btnFavoritos);
        btnFavoritos.setOpaque(false);
        btnFavoritos.setContentAreaFilled(false);
        btnFavoritos.setBorderPainted(false);
    }
    private void definirOpçaoConta(){
        JPanel opçao1 = new JPanel();
        opçao1.setBounds(0, 200, 200, 80);
        opçao1.setBackground(Color.decode("#3cc3be"));
        opçao1.setLayout(null);
        JLabel opçao1txt = new JLabel("Conta");
        opçao1txt.setBounds(50, 27, 90, 25);
        opçao1txt.setFont(new Font("", Font.BOLD, 25));
        opçao1txt.setForeground(Color.decode("#FFFFFF"));
        JButton btnConta = new JButton();
        btnConta.setBounds(0, 200, 200, 80);    
        
        trocarCor(btnConta, opçao1);

        this.panel.add(opçao1);
        opçao1.add(opçao1txt);
        this.panel.add(btnConta);
        btnConta.setOpaque(false);
        btnConta.setContentAreaFilled(false);
        btnConta.setBorderPainted(false);
        btnConta.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
                TelaAuxiliar telaUsuario = new TelaAuxiliar();
                telaUsuario.abrirTelaUsuario(user);
            }
        });
    }
}
