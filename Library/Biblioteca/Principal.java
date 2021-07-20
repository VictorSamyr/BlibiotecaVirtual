import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Image;


public class Principal {
    private JFrame frame;    
    private JPanel panel;
    private JButton btnSair;
    private Usuario user; //Usuario que logou na sessão
    
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
        JPanel tarjaDecorativa = new JPanel();
        JLabel todosOsLivros = new JLabel("Todos Os Livros");
        todosOsLivros.setBounds(220, 10, 500, 50);
        todosOsLivros.setFont(new Font("", Font.BOLD, 45));
        todosOsLivros.setForeground(Color.decode("#FFFFFF"));
        tarjaDecorativa.setBounds(200, 520, 800, 200);
        tarjaDecorativa.setBackground(Color.decode("#3cc3be"));
        logoFundo.setBounds(2, 5, 195, 195);
        logoFundo.setBackground(Color.decode("#2e3e77"));
        fundoPrincipal.setBounds(0, 200, 200, 440);
        fundoPrincipal.setBackground(Color.decode("#2e3e77"));
        definirOpçaoConta();
        definirOpçaoSair();
        definirImagensDaTelaPrincipal();
        mostrarImagensDosLivros();
        this.panel.add(fundoPrincipal);
        this.panel.add(logoFundo);
        this.panel.add(tarjaDecorativa);
        this.panel.add(todosOsLivros);
    }

    private void definirImagensDaTelaPrincipal(){
        try {
        JLabel img1 = new JLabel();
        JLabel bibliotecaIcone = new JLabel();
        bibliotecaIcone.setIcon(new ImageIcon(this.getClass().getResource("Icones/BibliotecaIcone2.png"))); 
        bibliotecaIcone.setBounds(0, 0, 200, 200);
        this.panel.add(bibliotecaIcone);
        this.panel.add(img1);
    } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }

    private void mostrarImagensDosLivros(){
        List<String> paths = getPathImagens();
        int x = 230;
        for (int i = 0; i < 5; i++){
            String imagem = paths.get(i);
            JLabel imagem_livro = getImagemLivro(imagem, x, 80);
            this.panel.add(imagem_livro);
            x += 150;
        }
        x = 230;
        for (int i = 0; i < 5; i++){
            String imagem = paths.get(i+5);
            JLabel imagem_livro = getImagemLivro(imagem, x, 300);
            this.panel.add(imagem_livro);
            x += 150;
        }
    }
    
    private JLabel getImagemLivro(String path, int x, int y){
        // Retorna uma label com a imagem no tamanho certo
        JLabel lblLivro = new JLabel();
        ImageIcon imagem = new ImageIcon(path);
        Image pegaImagem = imagem.getImage();
        Image ImagemModificada = pegaImagem.getScaledInstance(130, 200, java.awt.Image.SCALE_SMOOTH);
        lblLivro.setIcon(new ImageIcon(ImagemModificada));
        lblLivro.setBounds(x, y, 130, 200);
        return lblLivro;
    }

    private void trocarCor(JButton btn, JPanel p){
        // Muda a cor de um painel quando o mouse está sobre ele
        btn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                p.setBackground(Color.decode("#319592"));
            }
    
            public void mouseExited(MouseEvent e) {
            p.setBackground(Color.decode("#3cc3be"));
            }
        });
    }

    private List<String> getPathImagens(){
        // Retorna uma lista de paths das imagens do banco de dados
        List<String> paths = new ArrayList<String>();
        LivroDao livrodao = new LivroDao();
        String comando = "SELECT * FROM livros";
        // Preenche a lista de livros com os livros do banco de dados
        List<Livro> livros = livrodao.getLivros(comando);
        for (Livro livro : livros){
            paths.add(livro.getImagem());
        }
        return paths;
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
        // botão que abre uma janela com as informações do usuario logado
        // na sessão
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
        Usuario usuario = this.user;
        btnConta.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
                new TelaUsuario(usuario);
            }
        });
    }
}