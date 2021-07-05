import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Principal {
    private JFrame frame;    
    private JPanel panel;
    private JButton btnSair;
    private JButton btnBusca;
    private Usuario user;
    JLabel img1 = new JLabel();
    JLabel img2 = new JLabel();
    JLabel img3 = new JLabel();
    JLabel img4 = new JLabel();
    JLabel img5 = new JLabel();
    JLabel img6 = new JLabel();
    JLabel img7 = new JLabel();
    JLabel img8 = new JLabel();
    JLabel img9 = new JLabel();
    JLabel img10 = new JLabel();
    JLabel[] labels = new JLabel[]{img1,img2,img3,img4,img5,img6,img7,img8,img9,img10};
    
    public Principal(Usuario user){
        this.user = user;
        prepararJanela();
        inicializar();
    }

    private void inicializar(){
        panel = new JPanel();
        panel.setBackground(Color.decode("#2e3e77"));
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
        JPanel fundoPrincipal = new JPanel();
        JPanel logoFundo = new JPanel();
        JPanel editorasParceiras = new JPanel();
        JLabel todosOsLivros = new JLabel("Todos Os Livros");
        todosOsLivros.setBounds(220, 10, 500, 50);
        todosOsLivros.setFont(new Font("", Font.BOLD, 45));
        todosOsLivros.setForeground(Color.decode("#FFFFFF"));
        editorasParceiras.setBounds(200, 520, 800, 200);
        editorasParceiras.setBackground(Color.decode("#3cc3be"));
        logoFundo.setBounds(2, 5, 195, 195);
        logoFundo.setBackground(Color.decode("#2e3e77"));
        fundoPrincipal.setBounds(0, 200, 200, 440);
        fundoPrincipal.setBackground(Color.decode("#2e3e77"));
        definirOpçaoConta();
        definirOpçaoSair();
        definirImagensDaTelaPrincipal();
        mostrarImagensDosLivros(labels);
        this.panel.add(fundoPrincipal);
        this.panel.add(logoFundo);
        this.panel.add(editorasParceiras);
        this.panel.add(todosOsLivros);
    }

    private void definirImagensDaTelaPrincipal(){
        try {
        JLabel img1 = new JLabel();
        JLabel bibliotecaIcone = new JLabel();
        bibliotecaIcone.setIcon(new ImageIcon(this.getClass().getResource("BibliotecaIconePrincipal.png"))); 
        bibliotecaIcone.setBounds(0, 0, 200, 200);
        
    
        
        this.panel.add(bibliotecaIcone);
        this.panel.add(img1);
    } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }
    private void mostrarImagensDosLivros(JLabel[] labelss){
        
        
        JLabel[] labels = labelss;
        String[] nomeLivros1 = new String[]{"ACulpaEDasEstrelas.jpg","AQuedaDoMorcegoV1.jpg","BladeRunner.jpg","ComoFazerAmigosEInfluenciarPessoas.jpg","Crepusculo.jpg"};
        int limitadorX = 230;

        for(int i=0 ; i < 5; i++){
            modificarImagemLivro(labels[i], nomeLivros1[i], limitadorX, 80);
            limitadorX = limitadorX + 150;
        }
        String[] nomeLivros2 = new String[]{"InvincibleUltimateCollectionV3.jpg","ItACoisa.jpg","Neuromancer.png","OHorrorDeDunwich.jpg","OPoderDoHabito.jpg"};
        
        limitadorX = 230;
        
        for(int i=0 ; i < 5; i++){    
           modificarImagemLivro(labels[i+5], nomeLivros2[i], limitadorX, 300);
           limitadorX = limitadorX + 150;
        }
    }
    
    private void modificarImagemLivro(JLabel l, String n, int x, int y){
        ImageIcon imagem = new ImageIcon(this.getClass().getResource("Images/"+n));
        Image pegaImagem = imagem.getImage();
        Image ImagemModificada = pegaImagem.getScaledInstance(130, 200, java.awt.Image.SCALE_SMOOTH);
        l.setIcon(new ImageIcon(ImagemModificada));
        l.setBounds(x, y, 130, 200);
        this.panel.add(l);
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

    
    private void definirOpçaoConta(){
        JPanel opçao1 = new JPanel();
        opçao1.setBounds(0, 440, 200, 80);
        opçao1.setBackground(Color.decode("#3cc3be"));
        opçao1.setLayout(null);
        JLabel opçao1txt = new JLabel("Conta");
        opçao1txt.setBounds(50, 27, 90, 25);
        opçao1txt.setFont(new Font("", Font.BOLD, 25));
        opçao1txt.setForeground(Color.decode("#FFFFFF"));
        JButton btnConta = new JButton();
        btnConta.setBounds(0, 440, 200, 80);    
        
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
