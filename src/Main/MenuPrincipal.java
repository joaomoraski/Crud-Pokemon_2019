package Main;

import CrudPokemon.PokemonGUI;
import CrudTipoPokemon.PokemonTipoGUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MenuPrincipal extends JFrame {

    Container cp;
    JPanel pnNorte = new JPanel();
    JLabel lbTitulo = new JLabel("GUI PRA AJUDAR A ORGANIZAR ISSO");

    Font fonte = new Font("Monotype Corsiva", Font.BOLD, 30);

    JLabel labelComImagemDeTamanhoDiferente = new JLabel();

    JMenuBar menuBar = new JMenuBar();
    JMenu menuOpcoes = new JMenu("Opções");
    JMenuItem cadTipo = new JMenuItem("Tipo");
    JMenuItem cadPokemon = new JMenuItem("Pokemon");

    Point p;

    public MenuPrincipal(Dimension dimensao) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(dimensao);
        setTitle(lbTitulo.getText());

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        pnNorte.add(lbTitulo);
        lbTitulo.setFont(fonte);

        cadTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PokemonTipoGUI();
            }
        });
        cadPokemon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new PokemonGUI();
            }
        });


        cp.add(pnNorte, BorderLayout.NORTH);

        setJMenuBar(menuBar);
        menuBar.add(menuOpcoes);

        menuOpcoes.add(cadTipo);
        menuOpcoes.add(cadPokemon);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Sai do sistema  
                System.exit(0);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
