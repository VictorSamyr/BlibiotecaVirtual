import javax.swing.*;
import java.awt.*;

public class TelaLivro {
    private JFrame janela;
    private JLabel titulo;
    private JTextArea sinopse;
    private JPanel capa;
    private JLabel infos;
    private JPanel panelInfos;
    private JPanel panelSinopse;
    private JPanel panel;
    private JPanel panelTitulo;
    private JPanel cinza;
    private JPanel azul;
    private Livro livro;

    //private Livro livro;
    public TelaLivro(Livro livro){
        this.livro = livro;

    preparaJanela();
    preparaComponentes();
    exibejanela();
    exibirComponentes();
}

    public void preparaJanela(){
        janela = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);
        preparaComponentes();
        janela.add(panel);
        panelSinopse = new JPanel();
        panelSinopse.setLayout(null);
        capa = new JPanel();
        capa.setLayout(null);
        capa.setBackground(Color.decode("#2e3e77"));
        panelInfos = new JPanel();
        azul = new JPanel();
        azul.setBackground(Color.decode("#2e3e77"));
        cinza = new JPanel();
        cinza.setBackground(Color.WHITE);
        janela.setResizable(false);
    }

    public void exibejanela(){
        janela.setSize(600,700);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void preparaComponentes(){
        capa.setBounds(150,150,260,250);
        panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 700, 50);
        panelTitulo.setBackground(Color.decode("#2e3e77"));
        titulo = new JLabel(this.livro.getTitulo());
        titulo.setFont(new Font("Arial", Font.BOLD, 35));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);
        infos = new JLabel("Autor, Data de lançamento");
        sinopse = new JTextArea(this.livro.getSinopse());
        sinopse.setBounds(150,400,600,110);
        //sinopse.setBackground(Color.decode("#EEEEEE"));
        sinopse.setLineWrap(true);
        sinopse.setEditable(false);
        infos.setBounds(300,400,300,300);
        panel.add(panelTitulo);
    }

    public void exibirComponentes(){
        janela.add(panel);
        panel.add(titulo);
        janela.add(azul);
        janela.add(capa);
        janela.add(cinza);
        panelSinopse.add(sinopse);
        janela.add(panelSinopse);
        panelInfos.add(infos);
        janela.add(panelInfos);
    }
}

