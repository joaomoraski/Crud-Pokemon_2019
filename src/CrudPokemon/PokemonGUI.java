package CrudPokemon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import tools.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PokemonGUI extends JDialog {

    private Container cp;
    private JLabel lbId = new JLabel("ID");
    private JTextField tfId = new JTextField(20);
    private JLabel lbNome = new JLabel("Nome");
    private JTextField tfNome = new JTextField(20);
    private JLabel lbDatadeNasc = new JLabel("DatadeNasc");
    private DateTextField tfDatadeNasc = new DateTextField();
    private JLabel lbEvoluiu = new JLabel("Evoluiu");
    private JCheckBox cbEvoluiu = new JCheckBox("Evoluiu", false);
    private JTextField tfEvoluiu = new JTextField(20);
    private JLabel lbCaracteristicas = new JLabel("Caracteristicas");
    private JTextField tfCaracteristicas = new JTextField(20);
    private JLabel lbPeso = new JLabel("Peso");
    private JTextField tfPeso = new JTextField(20);
    private JButton btAdicionar = new JButton("Adicionar");
    private JButton btListar = new JButton("Listar");
    private JButton btBuscar = new JButton("Buscar");
    private JButton btAlterar = new JButton("Alterar");
    private JButton btExcluir = new JButton("Excluir");
    private JButton btLocalizar = new JButton("Localizar");
    private JButton btSalvar = new JButton("Salvar");
    private JButton btCancelar = new JButton("Cancelar");
    private JButton btCarregarDados = new JButton("Carregar");
    private JButton btGravar = new JButton("Gravar");
    private JToolBar toolBar = new JToolBar();
    private JPanel painelNorte = new JPanel();
    private JPanel painelCentro = new JPanel();
    private JPanel painelSul = new JPanel();
    private JTextArea texto = new JTextArea();
    private JScrollPane scrollTexto = new JScrollPane();
    private JScrollPane scrollTabela = new JScrollPane();
    private String acao = "";
    private String chavePrimaria = "";
    private PokemonControle controle = new PokemonControle();
    private CrudPokemon crudpokemon = new CrudPokemon();
    String[] colunas = new String[]{"Id", "Nome", "DatadeNasc", "Evoluiu", "Caracteristicas", "Peso"};

    String[][] dados = new String[0][4];
    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);
    private JPanel painel1 = new JPanel(new GridLayout(1, 1));
    private JPanel painel2 = new JPanel(new GridLayout(1, 1));
    private CardLayout cardLayout;

    public PokemonGUI() {
        String caminhoENomeDoArquivo = "DadosCrudPokemon.csv";
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setTitle("CRUD Pkemon - V01");
        cp = getContentPane();

        ManipulaImagem manipulaImagem = new ManipulaImagem();
        ImageIcon icon = manipulaImagem.criaIcon("/icones/retrieve.png", 30, 30);
        btBuscar = manipulaImagem.insereBotao(icon, "Buscar");

        icon = manipulaImagem.criaIcon("/icones/list.png", 30, 30);
        btListar = manipulaImagem.insereBotao(icon, "Listar");

        icon = manipulaImagem.criaIcon("/icones/retrieve_1.png", 30, 30);
        btLocalizar = manipulaImagem.insereBotao(icon, "Localizar");

        icon = manipulaImagem.criaIcon("/icones/delete_1.png", 30, 30);
        btExcluir = manipulaImagem.insereBotao(icon, "Excluir");

        icon = manipulaImagem.criaIcon("/icones/update.png", 35, 30);
        btAlterar = manipulaImagem.insereBotao(icon, "Alterar");

        icon = manipulaImagem.criaIcon("/icones/save-as.png", 30, 30);
        btSalvar = manipulaImagem.insereBotao(icon, "Salvar");

        icon = manipulaImagem.criaIcon("/icones/newCancelar.png", 30, 30);
        btCancelar = manipulaImagem.insereBotao(icon, "Cancelar");

        icon = manipulaImagem.criaIcon("/icones/save.png", 30, 30);
        btGravar = manipulaImagem.insereBotao(icon, "Gravar");

        icon = manipulaImagem.criaIcon("/icones/create_1.png", 30, 30);
        btAdicionar = manipulaImagem.insereBotao(icon, "Adicionar");

        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelCentro, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);
        cardLayout = new CardLayout();
        painelSul.setLayout(cardLayout);
        painel1.add(scrollTexto);
        painel2.add(scrollTabela);
        texto.setText("\n\n\n\n\n\n");
        scrollTexto.setViewportView(texto);
        painelSul.add(painel1, "Avisos");
        painelSul.add(painel2, "Listagem");
        painelNorte.setLayout(new GridLayout(1, 1));
        painelNorte.add(toolBar);
        painelCentro.setLayout(new GridLayout(5, 2));
        painelCentro.add(lbNome);
        painelCentro.add(tfNome);
        painelCentro.add(lbDatadeNasc);
        painelCentro.add(tfDatadeNasc);
        painelCentro.add(lbCaracteristicas);
        painelCentro.add(tfCaracteristicas);
        painelCentro.add(lbPeso);
        painelCentro.add(tfPeso);
        painelCentro.add(cbEvoluiu);
        toolBar.add(lbId);
        toolBar.add(tfId);
        toolBar.add(btAdicionar);
        toolBar.add(btBuscar);
        toolBar.add(btLocalizar);
        toolBar.add(btListar);
        toolBar.add(btAlterar);
        toolBar.add(btExcluir);
        toolBar.add(btSalvar);
        toolBar.add(btCancelar);
        btAdicionar.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        tfNome.setEditable(false);
        tfDatadeNasc.setEditable(false);
        cbEvoluiu.setEnabled(false);
        tfCaracteristicas.setEditable(false);
        tfPeso.setEditable(false);
        texto.setEditable(false);
        btCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) {
                    String aux[];
                    CrudPokemon t;
                    List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);
                    for (String linha : listaStringCsv) {
                        aux = linha.split(";");
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            t = new CrudPokemon(Integer.valueOf(aux[0]), String.valueOf(aux[1]), Date.valueOf(aux[2]), Boolean.valueOf(aux[3].equals("Sim") ? true : false), Integer.valueOf(aux[4]), Float.valueOf(aux[5]));
                            controle.adicionar(t);
                        } catch (Exception err) {
                            System.out.println("Deu ruim " + err);
                        }
                    }
                    cardLayout.show(painelSul, "Listagem");
                }
            }
        });
        btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<CrudPokemon> listaCrudPokemon = controle.listar();
                List<String> listaCrudPokemonEmFormatoStringCSV = new ArrayList<>();
                for (CrudPokemon t : listaCrudPokemon) {
                    listaCrudPokemonEmFormatoStringCSV.add(t.toString());
                }
                new ManipulaArquivo().salvarArquivo(caminhoENomeDoArquivo, listaCrudPokemonEmFormatoStringCSV);
                System.out.println("gravou");
            }
        });
        btLocalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = controle.listStrings();
                if (listaAuxiliar.size() > 0) {//se a lista não estiver vazia abre a janela
                    Point lc = btLocalizar.getLocationOnScreen();//precisa mexer aqui para centralizar a janela// o ponto onde a janela vai abrir
                    lc.x = lc.x + btLocalizar.getWidth();//um pouco para frente do botão localizar
                    String selectedItem = new JanelaPesquisar(listaAuxiliar,
                            lc.x,
                            lc.y).getValorRetornado();////matriz x coluna y é linha - posicionamento da janela
                    if (!selectedItem.equals("")) {//pega toda a linha 
                        String[] aux = selectedItem.split(";");//divide no ponto e virgula
                        tfId.setText(aux[0]);//pega so cpf e preenche no textfield cpf
                        btBuscar.doClick();//faca um clique,  faz a mesma coisa que o buscar clicando automaticamente
                    } else {
                        tfId.requestFocus();
                        tfId.selectAll();
                    }
                }
            }
        });

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btAdicionar.setVisible(false);
                cardLayout.show(painelSul, "Avisos");
                scrollTexto.setViewportView(texto);
                if (tfId.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(cp, "ID nâo pode ser vazio");
                    tfId.requestFocus();
                    tfId.selectAll();
                } else {
                    chavePrimaria = tfId.getText();
                    crudpokemon = controle.buscar(tfId.getText());
                    if (crudpokemon == null) {
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);
                        tfNome.setText("");
                        tfDatadeNasc.setText("");
                        cbEvoluiu.setSelected(false);
                        tfCaracteristicas.setText("");
                        tfPeso.setText("");
                        texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");
                    } else {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);
                        tfNome.setText(String.valueOf(crudpokemon.getNome()));
                        tfNome.setEditable(false);
                        tfDatadeNasc.setText(formato.format(crudpokemon.getDatadeNasc()));
                        tfDatadeNasc.setEditable(false);
                        cbEvoluiu.setSelected(crudpokemon.getEvoluiu());
                        cbEvoluiu.setEnabled(false);
                        tfCaracteristicas.setText(String.valueOf(crudpokemon.getCaracteristicas()));
                        tfCaracteristicas.setEditable(false);
                        tfPeso.setText(String.valueOf(crudpokemon.getPeso()));
                        tfPeso.setEditable(false);
                    }
                }
            }
        });
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = "adicionar";
                tfId.setText(chavePrimaria);
                tfNome.setEditable(true);
                tfDatadeNasc.setEditable(true);
                cbEvoluiu.setEnabled(true);
                tfCaracteristicas.setEditable(true);
                tfPeso.setEditable(true);
                tfId.setEditable(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btLocalizar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);
                texto.setText("Preencha os atributos\n\n\n\n\n");
            }
        });
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = "alterar";
                tfId.setText(chavePrimaria);
                tfId.setEditable(false);
                tfNome.requestFocus();
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btLocalizar.setVisible(false);
                texto.setText("Preencha os atributos\n\n\n\n\n");
                tfNome.setEditable(true);
                tfDatadeNasc.setEditable(true);
                cbEvoluiu.setEnabled(true);
                tfCaracteristicas.setEditable(true);
                tfPeso.setEditable(true);
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                btLocalizar.setVisible(true);
                tfId.setEditable(true);
                tfNome.setText("");
                tfNome.setEditable(false);
                tfDatadeNasc.setText("");
                tfDatadeNasc.setEditable(false);
                cbEvoluiu.setSelected(false);
                cbEvoluiu.setEnabled(false);
                tfCaracteristicas.setText("");
                tfCaracteristicas.setEditable(false);
                tfPeso.setText("");
                tfPeso.setEditable(false);
                tfId.requestFocus();
                tfId.selectAll();
                texto.setText("Cancelou\n\n\n\n\n");
            }
        });
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acao.equals("alterar")) {
                    CrudPokemon crudpokemonAntigo = crudpokemon;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        crudpokemon.setNome(String.valueOf(tfNome.getText()));
                        crudpokemon.setDatadeNasc(Date.valueOf(sdfEua.format(formato.parse(tfDatadeNasc.getText()))));
                        crudpokemon.setEvoluiu(cbEvoluiu.isSelected());
                        crudpokemon.setCaracteristicas(Integer.valueOf(tfCaracteristicas.getText()));
                        crudpokemon.setPeso(Float.valueOf(tfPeso.getText()));
                        controle.alterar(crudpokemon, crudpokemonAntigo);
                        texto.setText("Registro alterado\n\n\n\n\n");
                    } catch (Exception err) {
                        System.out.println("Deu ruim jijijijij" + err);
                    }
                } else {
                    crudpokemon = new CrudPokemon();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        crudpokemon.setId(Integer.valueOf(tfId.getText()));
                        crudpokemon.setNome(String.valueOf(tfNome.getText()));
                        crudpokemon.setDatadeNasc(Date.valueOf(sdfEua.format(formato.parse(tfDatadeNasc.getText()))));
                        crudpokemon.setEvoluiu(cbEvoluiu.isSelected());
                        crudpokemon.setCaracteristicas(Integer.valueOf(tfCaracteristicas.getText()));
                        crudpokemon.setPeso(Float.valueOf(tfPeso.getText()));
                        controle.adicionar(crudpokemon);
                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);
                    } catch (Exception err) {
                        System.out.println("Deu ruim " + err);
                    }
                }
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                btLocalizar.setVisible(true);
                tfId.setEditable(true);
                tfId.requestFocus();
                tfId.selectAll();
                tfNome.setText("");
                tfDatadeNasc.setText("");
                cbEvoluiu.setSelected(false);
                tfCaracteristicas.setText("");
                tfPeso.setText("");
                tfNome.setEditable(false);
                tfDatadeNasc.setEditable(false);
                cbEvoluiu.setEnabled(false);
                tfCaracteristicas.setEditable(false);
                tfPeso.setEditable(false);
            }
        });
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<CrudPokemon> lt = controle.listar();
                String[] colunas = {"Id", "Nome", "DatadeNasc", "Evoluiu", "Caracteristicas", "Peso"};
                Object[][] dados = new Object[lt.size()][colunas.length];
                String aux[];
                for (int i = 0; i < lt.size(); i++) {
                    aux = lt.get(i).toString().split(";");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                cardLayout.show(painelSul, "Listagem");
                scrollTabela.setPreferredSize(tabela.getPreferredSize());
                painel2.add(scrollTabela);
                scrollTabela.setViewportView(tabela);
                model.setDataVector(dados, colunas);

                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId.setText(chavePrimaria);
                if (JOptionPane.YES_OPTION
                        == JOptionPane.showConfirmDialog(null,
                                "Confirma a exclusão do registro <Nome = " + crudpokemon.getNome() + ">?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.excluir(crudpokemon);
                    texto.setText("Excluiu o registro de " + crudpokemon.getId() + " - " + crudpokemon.getNome() + "\n\n\n\n\n");
                } else {
                    texto.setText("Não excluiu o registro de " + crudpokemon.getId() + " - " + crudpokemon.getNome() + "\n\n\n\n\n");
                }
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                btExcluir.setVisible(false);
                btAlterar.setVisible(false);
                btLocalizar.setVisible(true);
                tfId.requestFocus();
                tfId.selectAll();
                tfId.setText("");
                tfNome.setText("");
                tfDatadeNasc.setText("");
                cbEvoluiu.setSelected(false);
                cbEvoluiu.setEnabled(true);
                tfCaracteristicas.setText("");
                tfPeso.setText("");
            }
        });

        tfCaracteristicas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();//C:/Users/jvmor/Documents/NetBeansProjects/Cobaia/
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosPokemonTipo.csv");
                if (listaAuxiliar.size() > 0) {//se a lista não estiver vazia abre a janela
                    Point lc = tfCaracteristicas.getLocationOnScreen();//precisa mexer aqui para centralizar a janela// o ponto onde a janela vai abrir
                    lc.x = lc.x + tfCaracteristicas.getWidth();//um pouco para frente do botão localizar
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y).getValorRetornado();////matriz x coluna y é linha - posicionamento da janela
                    if (!selectedItem.equals("")) {//pega toda a linha 
                        String[] aux = selectedItem.split(";");//divide no ponto e virgula
                        tfCaracteristicas.setText(aux[0]);//pega so cpf e preenche no textfield cpf
                    } else {
                        tfCaracteristicas.requestFocus();
                        tfCaracteristicas.selectAll();
                    }
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em disco
                btGravar.doClick();
                // Sai da classe
                dispose();
            }
        });
        setModal(true);
        btCarregarDados.doClick();
        setVisible(true);
    }
}
