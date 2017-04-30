package apk.Window;

import apk.Class.Line;
import apk.Class.LogicGate;
import apk.Class.LogicPoint;
import apk.Window.MainWindow.Rysunki;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.Accessible;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class MainWindow extends javax.swing.JFrame  {
    boolean siatka;
    String toolsDrawing;
    ObszarRoboczy obszarRysowania= new ObszarRoboczy();
    JScrollPane scroll=new JScrollPane();
    List<Rysunki> workSpace = new ArrayList<>();
    String data[][]={{"Obiekt:", "-"},{"ID:", "-" },{"Ilość wejść:", "-" },{"Stan na wyjściu:","-"}};
    DefaultTableModel modelTable;
    List<TableCellEditor> editors = new ArrayList<>(3);
    String[] items1 = { "2","3","4" };
    String[] items2 = { "1" };
    String[] items3 = { "true","false" };
    String[] items4 = { "2" };
    String[] columnNames = {"Nazwa","Właściwości"};
    JComboBox comboBox1,comboBox2,comboBox3,comboBox4;
    JTable tabela;
    JScrollPane jScrollPane1;
    public MainWindow() {
        initComponents();
        siatka=true;
        toolsDrawing="AND";
        this.setBounds(0, 0, 1200, 740);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH,jPanel2);
        jPanel1.setBounds(100,100, 200, 1200 );
        comboBox1 = new JComboBox( items1 );
        DefaultCellEditor dce1 = new DefaultCellEditor( comboBox1 );
        editors.add( dce1 );
        comboBox2 = new JComboBox( items2 );
        DefaultCellEditor dce2 = new DefaultCellEditor( comboBox2 );
        editors.add( dce2 );
        comboBox3 = new JComboBox( items3 );
        DefaultCellEditor dce3 = new DefaultCellEditor( comboBox3 );
        editors.add(dce3);
        comboBox4 = new JComboBox( items4 );
        DefaultCellEditor dce4 = new DefaultCellEditor( comboBox4 );
        editors.add(dce4);
        //modelTable=(DefaultTableModel) tabela.getModel();
         modelTable = new DefaultTableModel(data, columnNames);
         tabela = new JTable(modelTable){
            @Override
            public TableCellEditor getCellEditor(int row, int column)
            {
                int modelColumn = convertColumnIndexToModel( column );
                if(workSpace.get(obszarRysowania.getSelectedIndex()).indexGate>=0  ){
                   if(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(workSpace.get(obszarRysowania.getSelectedIndex()).indexGate).getLabel().equals("NOT")){
                    if (modelColumn == 1 && row==2 ){
                        return editors.get(1);
                    }
                   }
                 else{
                          if (modelColumn == 1 && row==2 ){
                           return editors.get(0);
                       } 
                       }
                }
                      if(workSpace.get(obszarRysowania.getSelectedIndex()).indexPoint>=0){
                        if (modelColumn == 1 && row==2 ){
                           return editors.get(2);
                       }
                    }

                    return super.getCellEditor(row, column);
            }
        };
        tabela.setSize(200, 100);
        jScrollPane1 = new JScrollPane(tabela);
        jScrollPane1.setSize(240,200);
        jPanel1.add(jScrollPane1);
       this.add(BorderLayout.WEST,jPanel1);
        comboBox1.addActionListener((ActionEvent ae) -> {
            int index=workSpace.get(obszarRysowania.getSelectedIndex()).indexGate; 
            if(index>=0){
                if(!(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(index).getLabel().equals("XOR") || workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(index).getLabel().equals("NXOR"))){
                    workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(index).setInput(Integer.parseInt(String.valueOf(comboBox1.getSelectedItem())));
                }
                repaint();
            }
        });
        comboBox3.addActionListener((ActionEvent ae) -> {
            int index=workSpace.get(obszarRysowania.getSelectedIndex()).indexPoint;
            if(index>=0){
                if(comboBox3.getSelectedIndex()==0){
                    workSpace.get(obszarRysowania.getSelectedIndex()).points.get(index).setState(true);
                }
                else{
                    workSpace.get(obszarRysowania.getSelectedIndex()).points.get(index).setState(false);
                }
                
                repaint();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jToolBar2.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/nowakarta.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/openfile.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/open.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);
        jToolBar2.add(jSeparator1);

        buttonGroup1.add(jToggleButton2);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/and18.png"))); // NOI18N
        jToggleButton2.setSelected(true);
        jToggleButton2.setToolTipText("Rysuj bramkę logiczną AND");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton2);

        buttonGroup1.add(jToggleButton4);
        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/or18.png"))); // NOI18N
        jToggleButton4.setToolTipText("Rysuj bramkę logiczną OR");
        jToggleButton4.setFocusable(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton4);

        buttonGroup1.add(jToggleButton6);
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/xor18.png"))); // NOI18N
        jToggleButton6.setToolTipText("Rysuj bramkę logiczną XOR");
        jToggleButton6.setFocusable(false);
        jToggleButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton6);

        buttonGroup1.add(jToggleButton3);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/nor18.png"))); // NOI18N
        jToggleButton3.setToolTipText("Rysuj bramkę logiczną NOR");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton3);

        buttonGroup1.add(jToggleButton1);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/not18.png"))); // NOI18N
        jToggleButton1.setToolTipText("Rysuj bramkę logiczną NOT");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton1);

        buttonGroup1.add(jToggleButton7);
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/nxor18.png"))); // NOI18N
        jToggleButton7.setToolTipText("Rysuj bramke logiczną NXOR");
        jToggleButton7.setFocusable(false);
        jToggleButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton7);

        buttonGroup1.add(jToggleButton8);
        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/Gate18/nand18.png"))); // NOI18N
        jToggleButton8.setToolTipText("Rysuj bramkę logiczną NAND");
        jToggleButton8.setFocusable(false);
        jToggleButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton8);

        buttonGroup1.add(jToggleButton9);
        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/select.png"))); // NOI18N
        jToggleButton9.setFocusable(false);
        jToggleButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton9);

        buttonGroup1.add(jToggleButton10);
        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/point.png"))); // NOI18N
        jToggleButton10.setFocusable(false);
        jToggleButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton10);

        buttonGroup1.add(jToggleButton11);
        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/line.png"))); // NOI18N
        jToggleButton11.setFocusable(false);
        jToggleButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton11);

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/grid.png"))); // NOI18N
        jToggleButton5.setSelected(true);
        jToggleButton5.setFocusable(false);
        jToggleButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/delete.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 471, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("Plik");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/nowakarta16.png"))); // NOI18N
        jMenuItem1.setText("Nowe okno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/open16.png"))); // NOI18N
        jMenuItem2.setText("Zapisz projekt");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apk/Resource/openfile16.png"))); // NOI18N
        jMenuItem3.setText("Otwórz projekt");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pomoc");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_WINDOWS, 0));
        jMenuItem4.setText("Info");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 702, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     ** Metoda która usuwa powiązania lini wraz z linią 
     * @param indexLine indeks Lini której powiązanie chcemy usunąć
     */
    private void removeLink(int indexLine ){
    for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).points.size();i++){
        for(int j=0;j<workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.size();j++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.get(j).getIndexLine()==indexLine){
                workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.remove(j);
            }
        }
        for(int j=0;j<workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.size();j++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.get(j).getIndexLine()==indexLine){
                workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.remove(j);
            }
        }
    }
    
    for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.size();i++){
        for(int j=0;j<workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.size();j++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.get(j).getIndexLine()==indexLine){
                workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.remove(j);
            }
        }
        for(int j=0;j<workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.size();j++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.get(j).getIndexLine()==indexLine){
                workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.remove(j);
            }
        }
    }
    removeLine(indexLine);
    }
    /**
     ** Metoda która usuwa linie której został podany indeks(identyfikator) 
     * @param indexLine indeks Lini(identyfikator)
     */
    private void removeLine(int indexLine){
        for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).linePoint.size();i++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).linePoint.get(i).getIndex()==indexLine){
                workSpace.get(obszarRysowania.getSelectedIndex()).linePoint.remove(i);
                return;
            }
        }
    }
    /**
     ** Metoda która odpowiedzialna jes za usuniecie punktu (stannu logicznego) 
     * @param indexPoint indeks(identyfikator nie pozycja na liście) punktu 
     */
    private void removePoint(int indexPoint){
        for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).points.size();i++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).getIndex()==indexPoint){
                workSpace.get(obszarRysowania.getSelectedIndex()).points.remove(i);
                return;
            }
        }
    }
    /**
     ** Metoda która usuwa bramke logiczną o podanym identyfikatorze. 
     * @param indexGate indeks bramki logicznej
     */
    private void removeGate(int indexGate){
        for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.size();i++){
            if(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).getIndex()==indexGate){
                workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.remove(i);
                return;
            }
        }
    }
    /**
     ** Metoda która jest odpowiedzialna za usuwanie obiektów wraz z połączeniami 
     * @param type- typ obiektu który ma być usunięty
     * @param id identyfikator obiektu który będzie usuwany
     */
    public void removeObject(String type, int id){
        if(type.equals("POINT")){
            for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).points.size();i++){
                if(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).getIndex()==id){
                    while(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.size()>0) {
                        removeLink(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.get(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).inObject.size()-1).getIndexLine());
                    }
                    while(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.size()>0) {
                        removeLink(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.get(workSpace.get(obszarRysowania.getSelectedIndex()).points.get(i).outObject.size()-1).getIndexLine());
                    }
                    removePoint(id);
                }
            }
        }
        if(type.equals("GATE")){
            for(int i=0;i<workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.size();i++){
                if(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).getIndex()==id){
                    while(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.size()>0) {
                        removeLink(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.get(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).inObject.size()-1).getIndexLine());
                    }
                    while(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.size()>0) {
                        removeLink(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.get(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate.get(i).outObject.size()-1).getIndexLine());
                    }
                    removeGate(id);
                }
            }
        }
    }
    /**
     ** Metoda  dodaje obszar rysowania na którym możemy rysować bramki logiczne
     */
    private  void addWorkSpace(){
        workSpace.add(new Rysunki());
        workSpace.get(workSpace.size()-1).setPreferredSize(new Dimension(2000, 3000));
        workSpace.get(workSpace.size()-1).setBackground(Color.white);
        JScrollPane scrollTab=new JScrollPane();
        scrollTab.getViewport().setView(workSpace.get(workSpace.size()-1));
        scrollTab.setHorizontalScrollBarPolicy(
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollTab.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(BorderLayout.CENTER,obszarRysowania);
        obszarRysowania.setVisible(true);
        obszarRysowania.addTab("Obszar rysowania "+String.valueOf(workSpace.size()),scrollTab);
    }
    /**
     ** Metoda wykonuje zapis projektu 
     */
    public void saveProject(){
               JFileChooser saveDialog = new JFileChooser();
        saveDialog.setDialogTitle("Zapisz projekt");
        UIManager.put("FileChooser.saveDialogTitleText", "Zapisz");
        UIManager.put("FileChooser.saveInLabelText", "Zapisz w");
        UIManager.put("FileChooser.saveButtonText", "Zapisz");
        UIManager.put("FileChooser.cancelButtonText", "Zamknij");
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa pliku:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ pliku");
        UIManager.put("FileChooser.openButtonToolTipText", "Otwórz zaznaczony plik");
        UIManager.put("FileChooser.cancelButtonToolTipText","Zamknij okno");
        UIManager.put("FileChooser.fileNameHeaderText","Nazwa pliku");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder wyżej");
        UIManager.put("FileChooser.homeFolderToolTipText","Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText","Utwórz nowy folder");
        UIManager.put("FileChooser.listViewButtonToolTipText","Lista");
        UIManager.put("FileChooser.newFolderButtonText","Utwórz nowy folder");
        UIManager.put("FileChooser.renameFileButtonText", "Zmień nazwę pliku");
        UIManager.put("FileChooser.deleteFileButtonText", "Usuń plik");
        UIManager.put("FileChooser.filterLabelText", "Typ pliku");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Szczegóły");
        UIManager.put("FileChooser.fileSizeHeaderText","Rozmiar");
        UIManager.put("FileChooser.fileDateHeaderText", "Data modyfikacji");
        SwingUtilities.updateComponentTreeUI(saveDialog);
        if (saveDialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                if (obszarRysowania.getSelectedIndex() >= 0) {
                    ObjectOutputStream pl;
                    FileOutputStream and = new FileOutputStream(saveDialog.getSelectedFile());
                    pl = new ObjectOutputStream(and);
                    pl.writeObject(workSpace.get(obszarRysowania.getSelectedIndex()).logicGate);
                    pl.writeObject(workSpace.get(obszarRysowania.getSelectedIndex()).points);
                    pl.writeObject(workSpace.get(obszarRysowania.getSelectedIndex()).linePoint);
                    pl.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     ** Metoda któa umożliwia otwarcie projektu 
     */
    public void openProject(){
        JFileChooser otworz = new JFileChooser();
       otworz.setDialogTitle("Otwórz projekt");
        UIManager.put("FileChooser.openDialogTitleText", "Otwórz");
        UIManager.put("FileChooser.lookInLabelText", "Zobacz w");
        UIManager.put("FileChooser.openButtonText", "Otwórz");
        UIManager.put("FileChooser.cancelButtonText", "Zamknij");
        UIManager.put("FileChooser.fileNameLabelText", "Nazwa pliku:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Typ pliku");
        UIManager.put("FileChooser.openButtonToolTipText", "Otwórz zaznaczony plik");
        UIManager.put("FileChooser.cancelButtonToolTipText","Zamknij okno");
        UIManager.put("FileChooser.fileNameHeaderText","Nazwa pliku");
        UIManager.put("FileChooser.upFolderToolTipText", "Folder wyżej");
        UIManager.put("FileChooser.homeFolderToolTipText","Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText","Utwórz nowy folder");
        UIManager.put("FileChooser.listViewButtonToolTipText","Lista");
        UIManager.put("FileChooser.newFolderButtonText","Utwórz nowy folder");
        UIManager.put("FileChooser.renameFileButtonText", "Zmień nazwę pliku");
        UIManager.put("FileChooser.deleteFileButtonText", "Usuń plik");
        UIManager.put("FileChooser.filterLabelText", "Typ pliku");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Szczegóły");
        UIManager.put("FileChooser.fileSizeHeaderText","Rozmiar");
        UIManager.put("FileChooser.fileDateHeaderText", "Data modyfikacji");
        SwingUtilities.updateComponentTreeUI(otworz);
        if (otworz.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ObjectInputStream pl;
            try {
                FileInputStream and = new FileInputStream(otworz.getSelectedFile());
                try {
                    pl = new ObjectInputStream(and);
                    try {
                        if (obszarRysowania.getSelectedIndex() >= 0) {
                            workSpace.get(obszarRysowania.getSelectedIndex()).logicGate = (List<LogicGate>)  (pl.readObject());
                            workSpace.get(obszarRysowania.getSelectedIndex()).points = (List<LogicPoint>) (pl.readObject());
                            workSpace.get(obszarRysowania.getSelectedIndex()).linePoint = (List<Line>) (pl.readObject());
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            }
        }
        repaint();
    }
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        toolsDrawing="NOT";
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        toolsDrawing="AND";
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        toolsDrawing="OR";
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
       toolsDrawing="XOR";
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
       toolsDrawing="NOR";
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        toolsDrawing="NXOR";
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        toolsDrawing="NAND";
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        toolsDrawing="TOUCH";
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        toolsDrawing="POINT";
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
        toolsDrawing="LINE";
       // workSpace.get(obszarRysowania.getSelectedIndex()).ifDrawLine=true;
    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        siatka=!siatka;
        repaint();
    }//GEN-LAST:event_jToggleButton5ActionPerformed
    /**
     ** Kliknięcie na przycisk rysuj punkty  
     * @param evt słuchacz
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int id=0;
        if(data[0][1].equals("POINT")){
            try{
                id=Integer.parseInt(data[1][1]);
            }
            catch(Exception ex){
                //bład
            }
            removeObject("POINT", id);
        }
        if(data[0][1].equals("OR") || data[0][1].equals("NOR") || data[0][1].equals("AND") || data[0][1].equals("NAND") || data[0][1].equals("NOT") || data[0][1].equals("XOR") || data[0][1].equals("NXOR")   ){
            try{
                id=Integer.parseInt(data[1][1]);
            }
            catch(Exception ex){
                //bład
            }
            removeObject("GATE", id);
        }
        repaint();
        workSpace.get(obszarRysowania.getSelectedIndex()).indexGate=-1;
        workSpace.get(obszarRysowania.getSelectedIndex()).indexPoint=-1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      addWorkSpace();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        openProject();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       addWorkSpace();   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        saveProject();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        openProject();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        URL urlFile = MainWindow.class.getClassLoader().getResource("apk/bramki/index.html"); 
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                try {
                    desktop.browse(urlFile.toURI());
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       saveProject();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              //  if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(new AcrylLookAndFeel() ); 
                    break;
               // }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
    /**
     * @author Andrzej Kierepka
     */
 public class Rysunki extends JPanel implements MouseMotionListener,Serializable {
        List<LogicGate> logicGate= new ArrayList<>();
        List<LogicPoint> points= new ArrayList<>();
        List<Line> linePoint= new ArrayList<>();
        boolean ifDrawLine=false;
        int indexGate=-1,indexPoint=-1;
        double moveX=0,moveY=0;
        Point beginingPoint;
  public Rysunki() {
      addMouseListener(new  MouseListener() {
           @Override
           public void mouseClicked(MouseEvent me) {
               int index;
               if(toolsDrawing.equals("TOUCH")){
                   index=retunrLogicGate(me.getX(), me.getY());
                   indexGate=index;
                   if(index>=0){
                       data[0][1]=logicGate.get(index).getLabel();
                       data[1][1]= String.valueOf(logicGate.get(index).getIndex());
                       data[2][0]="Ilość wejść";
                       data[2][1]= String.valueOf(logicGate.get(index).getInput());
                       data[3][1]= String.valueOf(logicGate.get(index).getState());
                       modelTable.setRowCount(0);
                       modelTable.addRow(data[0]);
                       modelTable.addRow(data[1]);
                       modelTable.addRow(data[2]);
                       modelTable.addRow(data[3]);
                       indexPoint=-1;
                   }
                   else{
                       index=retunrPoint(me.getX(), me.getY());
                       indexPoint=index;
                       if(index>=0){
                       indexGate=-1;
                       data[0][1]=points.get(index).getLabel();
                       data[1][1]= String.valueOf(points.get(index).getIndex());
                       data[2][0]="Stan logiczny";
                       data[2][1]= String.valueOf(points.get(index).getState());
                       modelTable.setRowCount(0);
                       modelTable.addRow(data[0]);
                       modelTable.addRow(data[1]);
                       modelTable.addRow(data[2]);
                   }
                    else{
                           if(returnLine(me.getX(), me.getY())>=0){
                               indexPoint=-1;
                               index=returnLine(me.getX(), me.getY());
                               data[0][1]=linePoint.get(index).getLabel();
                               data[1][1]= String.valueOf(linePoint.get(index).getIndex());
                               modelTable.setRowCount(0);
                               modelTable.addRow(data[0]);
                               modelTable.addRow(data[1]);
                           }
                            else{
                               modelTable.setRowCount(0);
                           }
                       
                   } 
                   }
               }        
           }

           @Override
           public void mousePressed(MouseEvent me) {
               int index=0;
               if(toolsDrawing.equals("LINE")){
                   if(linePoint.isEmpty()){
                       linePoint.add(new Line("LINE",1, me.getX(), me.getY(), me.getX(), me.getY()));
                   }
                   else{   
                       index=linePoint.get(linePoint.size()-1).getIndex()+1;
                       linePoint.add(new Line("LINE",index, me.getX(), me.getY(),me.getX(), me.getY()));
                   }
                   ifDrawLine=true;
               }
               if(toolsDrawing.equals("TOUCH")){
                   if(retunrLogicGate(me.getX(),me.getY())>=0){
                       indexGate=retunrLogicGate(me.getX(),me.getY());
                       indexPoint=-1;
                       moveX=me.getX()-logicGate.get(indexGate).x;
                       moveY=me.getY()-logicGate.get(indexGate).y;
                       
                   }
                    else{
                        if(retunrPoint(me.getX(),me.getY())>=0){
                            indexPoint=retunrPoint(me.getX(),me.getY());
                            indexGate=-1;
                            moveX=me.getX()-points.get(indexPoint).x;
                            moveY=me.getY()-points.get(indexPoint).y;
                        }    
                   }
                   
               }
               beginingPoint=me.getPoint();
           }
           @Override
           public void mouseReleased(MouseEvent me) {
           int index=0;
           int index2=0;
           int indexPt=0;
           boolean ifAdd=false;
           if(!toolsDrawing.equals("TOUCH")){
               if(retunrLogicGate(me.getX(), me.getY())<0){
                   if(toolsDrawing.equals("NOT")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("NOT",1, me.getX(), me.getY(),50.0,50.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("NOT",index, me.getX(), me.getY(),50.0,50.0));
                   }
                   }
                   if(toolsDrawing.equals("AND")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("AND",1, me.getX(), me.getY(),50.0,50.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("AND",index, me.getX(), me.getY(),50.0,50.0));
                   }
                   }
                   if(toolsDrawing.equals("NAND")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("NAND",1, me.getX(), me.getY(),45.0,45.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("NAND",index, me.getX(), me.getY(),45.0,45.0));
                   }
                   }
                   if(toolsDrawing.equals("OR")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("OR",1, me.getX(), me.getY(),50.0,40.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("OR",index, me.getX(), me.getY(),50.0,40.0));
                   }
                   }
                   if(toolsDrawing.equals("NOR")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("NOR",1, me.getX(), me.getY(),50.0,40.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("NOR",index, me.getX(), me.getY(),50.0,40.0));
                   }
                   }
                   if(toolsDrawing.equals("XOR")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("XOR",1, me.getX(), me.getY(),60.0,50.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("XOR",index, me.getX(), me.getY(),60.0,50.0));
                   }
                   }
                   if(toolsDrawing.equals("NXOR")){
                   if(logicGate.isEmpty()){
                       logicGate.add(new LogicGate("NXOR",1, me.getX(), me.getY(),55.0,40.0));
                   }
                   else{   
                       index=logicGate.get(logicGate.size()-1).getIndex()+1;
                       logicGate.add(new LogicGate("NXOR",index, me.getX(), me.getY(),55.0,40.0));
                   }
                   }
               }
           }
           if(toolsDrawing.equals("TOUCH")){
              indexGate=-1;
              indexPoint=-1;
           }
           if(toolsDrawing.equals("POINT")){
               if(retunrPoint(me.getX(),me.getY())<0){
                   if(points.isEmpty()){
                       points.add(new LogicPoint(true,"POINT", 1, me.getX(),me.getY()));
                   }
                   else{   
                       index=points.get(points.size()-1).getIndex()+1;
                       points.add(new LogicPoint(true,"POINT", index, me.getX(),me.getY()));
                   }
               }
           }
           if(toolsDrawing.equals("LINE")){// jezeli rysujemy linie
               if(retunrPoint(beginingPoint.x, beginingPoint.y)>=0){
                   if(retunrLogicGateInput(me.getX(),me.getY())>=0){
                       index=retunrLogicGateInput(me.getX(),me.getY());
                       index2=logicGate.get(index).returnInput(me.getX(),me.getY());
                       if(!logicGate.get(index).containInPoint(index2)){
                           logicGate.get(index).addObject(points.get(retunrPoint(beginingPoint.x, beginingPoint.y)).getIndex(),index2,linePoint.get(linePoint.size()-1).getIndex(), "POINT", "INPUT");
                           points.get(retunrPoint(beginingPoint.x, beginingPoint.y)).addObject(logicGate.get(index).getIndex(), -1, linePoint.get(linePoint.size()-1).getIndex(),"GATE", "OUTPUT");
                           ifAdd=true;
                           
                       for(int i=0;i<logicGate.get(index).inObject.size();i++){
                           int indexLine=returnPositonLines(logicGate.get(index).inObject.get(i).getIndexLine());
                           if(indexLine>=0) { 
                           linePoint.get(indexLine).setXY2(logicGate.get(index).in.get(logicGate.get(index).inObject.get(i).getIndexOfPosition()).x, logicGate.get(index).in.get(logicGate.get(index).inObject.get(i).getIndexOfPosition()).y);
                           }
                       }
                       for(int i=0;i<logicGate.get(index).outObject.size();i++){
                            int indexLine=returnPositonLines(logicGate.get(index).outObject.get(i).getIndexLine());
                           linePoint.get(indexLine).setXY1(logicGate.get(index).outputPositionX(), logicGate.get(index).outputPositionY());
                       }
                       indexPt=retunrPoint(beginingPoint.x, beginingPoint.y);
                       for(int i=0;i<points.get(indexPt).outObject.size();i++){
                            int indexLine=returnPositonLines(points.get(indexPt).outObject.get(i).getIndexLine());
                           linePoint.get(indexLine).setXY1(points.get(indexPt).x+points.get(indexPt).width,points.get(indexPt).y+(points.get(indexPt).height/2));
                       }
                       
                       
                       }
                        else{
                        ifAdd=false;   
                       }
                   }
               }
              else{
                   if(retunrLogicGateOutput(beginingPoint.x, beginingPoint.y)>=0){
                       if(retunrLogicGateInput(me.getX(),me.getY())>=0){
                          index=retunrLogicGateInput(me.getX(),me.getY());
                       index2=logicGate.get(index).returnInput(me.getX(),me.getY());
                       if(!logicGate.get(index).containInPoint(index2)){
                           logicGate.get(index).addObject(logicGate.get(retunrLogicGateOutput(beginingPoint.x, beginingPoint.y)).getIndex(),index2,linePoint.get(linePoint.size()-1).getIndex(), "GATE", "INPUT");
                           logicGate.get(retunrLogicGateOutput(beginingPoint.x, beginingPoint.y)).addObject(logicGate.get(index).getIndex(),-1,linePoint.get(linePoint.size()-1).getIndex() ,"GATE", "OUTPUT");
                           ifAdd=true;
                       }
                        else{
                        ifAdd=false;   
                       }                    
                       }
                        else{
                        ifAdd=false;   
                       }
                       }
                    else{
                        ifAdd=false;
                    }
               }
               if(!ifAdd){
                   linePoint.remove(linePoint.size()-1);
               }
               
           }
           ifDrawLine=false;
               repaint();
           }

           @Override
           public void mouseEntered(MouseEvent me) {
              
           }

           @Override
           public void mouseExited(MouseEvent me) {
              
           }
      } );
      addMouseMotionListener(this);
  }
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
        double maksimum=0;
        double minimum=10000;
        Graphics2D g2D = (Graphics2D) g;
        RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);        
         ((Graphics2D)g).setStroke(new BasicStroke(1.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
         ((Graphics2D)g).setRenderingHints(rh);
         if(siatka)
         {
            g2D.setColor(new java.awt.Color(173, 216, 230));
            for(int i=0;i<this.getHeight();i+=16)
            {
            g2D.drawLine(0, i,this.getWidth(),i);
            }
            for(int i=0;i<this.getHeight();i+=16)
            {
            g2D.drawLine(i,0,i,this.getHeight()); 
            } 
         }
         g2D.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
         g2D.setColor(Color.RED);
         for(int i=0;i<logicGate.size();i++){
             logicGate.get(i).setState(returnStateOutput(i));
              BufferedImage image= null;
        try {
            if(logicGate.get(i).getLabel().equals("NOT")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/not.png"));
            }
            if(logicGate.get(i).getLabel().equals("AND")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/and.png"));
            }
            if(logicGate.get(i).getLabel().equals("NAND")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/nand.png"));
            }
            if(logicGate.get(i).getLabel().equals("OR")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/or.png")); 
            }
            if(logicGate.get(i).getLabel().equals("NOR")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/nor.png")); 
            }
            if(logicGate.get(i).getLabel().equals("XOR")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/xor.png"));
            }
            if(logicGate.get(i).getLabel().equals("NXOR")){
               image = ImageIO.read(getClass().getResource("/apk/Resource/Gates/nxor.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
            g2D.drawImage(image,(int) logicGate.get(i).getX(),(int) logicGate.get(i).getY() , this);
            logicGate.get(i).drawGate(g2D);
            if(indexGate==i){
                logicGate.get(i).drawBorder(g2D);
            }
         }// koniec rysowania bramek logicznych
         for(int i=0;i<points.size();i++){
             if(indexPoint==i){
             g2D.setColor(new java.awt.Color(0, 127, 255));
             }
             else{
              g2D.setColor(Color.BLACK);   
             }
             points.get(i).drawPoint(g2D);
         }// koniec rysowania pointów
         for(int i=0;i<linePoint.size();i++){
             linePoint.get(i).drawLine(g2D);
         }
         
  }
 
           @Override
           public void mouseDragged(MouseEvent evt) {
               if(toolsDrawing.equals("LINE")){
                   if(ifDrawLine==true){
                       linePoint.get(linePoint.size()-1).setXY2(evt.getX(),evt.getY());
                   }
               }
               if(toolsDrawing.equals("TOUCH")){
                   if(indexGate>=0){
                       logicGate.get(indexGate).setXY(evt.getX()-moveX, evt.getY()-moveY);
                       for(int i=0;i<logicGate.get(indexGate).inObject.size();i++){
                           int indexLine=returnPositonLines(logicGate.get(indexGate).inObject.get(i).getIndexLine());
                           if(indexLine>=0) { 
                           linePoint.get(indexLine).setXY2(logicGate.get(indexGate).in.get(logicGate.get(indexGate).inObject.get(i).getIndexOfPosition()).x, logicGate.get(indexGate).in.get(logicGate.get(indexGate).inObject.get(i).getIndexOfPosition()).y);
                           }
                       }
                       for(int i=0;i<logicGate.get(indexGate).outObject.size();i++){
                            int indexLine=returnPositonLines(logicGate.get(indexGate).outObject.get(i).getIndexLine());
                           linePoint.get(indexLine).setXY1(logicGate.get(indexGate).outputPositionX(), logicGate.get(indexGate).outputPositionY());
                       }
                       repaint();
                   }
                   else{
                    if(indexPoint>=0){
                       points.get(indexPoint).setXY(evt.getX()-moveX, evt.getY()-moveY);
                        for(int i=0;i<points.get(indexPoint).outObject.size();i++){
                            int indexLine=returnPositonLines(points.get(indexPoint).outObject.get(i).getIndexLine());
                           linePoint.get(indexLine).setXY1(points.get(indexPoint).x+points.get(indexPoint).width,points.get(indexPoint).y+(points.get(indexPoint).height/2));
                       }
                    }
                   }
                   
               }
               repaint();
            }
        @Override
        public void mouseMoved(MouseEvent me) {
            
        }
        /**
         ** Metoda która sprawdza, czy na podanych współrzędnych znajduje się linia 
         * @param x współrzędna x
         * @param y współrzędna y
         * @return indeks obiektu znajdujący się na liście
         */
        public int returnLine(int x, int y){
            for(int i=0;i<linePoint.size();i++){
                if(linePoint.get(i).contains(x, y)){
                    return i;
                }
            }
            return -1;
        }
        /**
         ** Metoda która sprawdza, czy na podanych współrzędnych znajduje się bramka logiczna 
         * @param x współrzędna x
         * @param y współrzędna y
         * @return indeks obiektu znajdujący się na liście
         */
        public int retunrLogicGate(int x,int y){ 
               for(int i=0;i<logicGate.size();i++){
                      if(logicGate.get(i).contains(x, y)){
                       return i;
                   } 
               }
               return -1;
        }
        /**
         ** Metoda zwraca która sprawdza, czy podane wspołrzędne znajdują się na wyjściu bramki logicznej 
         * @param x współrzędna x
         * @param y współrzędna y
         * @return  indeks obiektu znajdujący się na liście
         */
        public int retunrLogicGateOutput(int x,int y){ 
               for(int i=0;i<logicGate.size();i++){
                      if(logicGate.get(i).containsOutput(x, y)){
                       return i;
                   } 
               }
               return -1;
        }
        /**
         * Metoda która zwraca, czy na podanycj współrzędnych znajduje się wejście do bramki logicznej 
         * @param x współrzędna x
         * @param y współrzędna y
         * @return indeks obiektu
         */
        public int retunrLogicGateInput(int x,int y){ 
               for(int i=0;i<logicGate.size();i++){
                      if(logicGate.get(i).containsInput(x, y)){
                       return i;
                   } 
               }
               return -1;
        }
        /**
         ** Metoda która sprawdza, czy na podanych wspołrzędnych znajduje się Punkt(Wejście) 
         * @param x współrzędna x
         * @param y współrzędna y
         * @return  indeks do obiektu
         */
        public int retunrPoint(int x,int y){ 
               for(int i=0;i<points.size();i++){
                      if(points.get(i).contains(x, y)){
                       return i;
                   } 
               }
               return -1;
        }
        /**
         ** Metoda zwraca nam pozycję na liście linii o podanym indeksie 
         * @param index
         * @return  
         */
        public int returnPositonLines(int index){
            for(int i=0;i<linePoint.size();i++){
                if(index==linePoint.get(i).getIndex()){
                    return i;
                }
            }
            return -1;
        }
        /**
         ** Metoda która zwraca stan logiczny( true, false) bramki logicznej  
         * @param i - położenie na liście bramki
         * @return stan logiczny true- jeżeli prawda false jeżeli nieprawda
         */
        public boolean returnStateOutput(int i){
            int counter=0,counterInput=0;
           // for(int i=0;i<=logicGate.size();i++){
                //if(logicGate.get(i).getIndex()==idGate){
                    for(int j=0;j<logicGate.get(i).inObject.size();j++){
                        if(logicGate.get(i).inObject.get(j).getTypeOfObject().equals("POINT")){
                            for(int k=0;k<points.size();k++){
                                if(points.get(k).getIndex()==logicGate.get(i).inObject.get(j).getIndexObject()){
                                    if(points.get(k).getState()==true){
                                        counterInput++;
                                    }
                                    counter++;
                                }
                            }
                        }
                        //
                        if(logicGate.get(i).inObject.get(j).getTypeOfObject().equals("GATE")){
                            for(int k=0;k<logicGate.size();k++){
                                if(logicGate.get(k).getIndex()==logicGate.get(i).inObject.get(j).getIndexObject()){
                                    if(logicGate.get(k).getState()==true){
                                        counterInput++;
                                    }
                                    counter++;
                                }
                            }
                        }
                    }
                if(logicGate.get(i).getLabel().equals("OR") || logicGate.get(i).getLabel().equals("NAND") ){
                return counterInput>=1;
                }
                if(logicGate.get(i).getLabel().equals("AND") || logicGate.get(i).getLabel().equals("NOR") ){
                return counterInput==counter;
                }
                if(logicGate.get(i).getLabel().equals("NOT")  ){// neguj stan logiczny
                return counterInput != 1;// jeżeli 1 to false, jeżeli 0 to true 
                }
                if(logicGate.get(i).getLabel().equals("XOR")  ){
                return counterInput%2!=0;
                }
                if(logicGate.get(i).getLabel().equals("NXOR")  ){
                return counterInput%2==0;
                }
                
                
                //}
                
            //}
            return false;
        }
    }	
    
    class ObszarRoboczy extends JTabbedPane implements SwingConstants, Accessible, Serializable  {
        JToolBar toolBar= new JToolBar();    
	private PanelObszaru PanelDoZamkniecia = new PanelObszaru(this);
        @Override
	public void paint(Graphics g){
		super.paint(g);
		PanelDoZamkniecia.paint(g);
	}
        @Override
	public void addTab(String title, Component component) {
		super.addTab(title+"     ", component);
	}
	public String getTabTitleAt(int index) {
		return super.getTitleAt(index).trim();
	}
private class PanelObszaru implements MouseListener, MouseMotionListener  {
    private ObszarRoboczy  obszar;
    private int Xzamkniecia = 0 ,Yzamkniecia = 0, pozycjaKursoraX = 0, pozycjaKursoraY = 0;
    private int zaznaczenie;
    private final int  szerokosc = 7, wysokosc = 7;
    private Rectangle rectangle = new Rectangle(0,0,szerokosc, wysokosc);
    private PanelObszaru(){}
    public PanelObszaru(ObszarRoboczy pane) 
    {
        obszar = pane;
        obszar.addMouseMotionListener(this);
        obszar.addMouseListener(this);
    }
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
    @Override
    public void mousePressed(MouseEvent me) {}
    @Override
    public void mouseClicked(MouseEvent me) {}
    @Override
    public void mouseDragged(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) 
    {
        if(me.getButton()==MouseEvent.BUTTON3)
        {

        }
        rectangle.x = Xzamkniecia;
        rectangle.y = Yzamkniecia;
        if(rectangle.contains(me.getX(),me.getY()))
        {
            if (zaznaczenie >=0){   
                workSpace.remove(zaznaczenie);
                obszar.removeTabAt(zaznaczenie);
            }
            zaznaczenie = obszar.getSelectedIndex(); 
        }
    }
    @Override
    public void mouseMoved(MouseEvent me){
    pozycjaKursoraX = me.getX();
    pozycjaKursoraY = me.getY();
    zaznaczenie=CzyObszarRysowania(pozycjaKursoraX, pozycjaKursoraY);
    if(zaznaczenie>=0){
        ustawKursor();
        obszar.repaint();
    } 
    }
    private void ustawKursor(){
    if(obszar.getTabCount()>0)
    {
        rectangle.x = Xzamkniecia;
	rectangle.y = Yzamkniecia;       
        if(rectangle.contains(pozycjaKursoraX, pozycjaKursoraY))
        {
            obszar.setCursor(new Cursor(Cursor.HAND_CURSOR));	
            if(zaznaczenie >=0)
            {
                obszar.setToolTipTextAt(zaznaczenie, "Zamknij " +obszar.getTitleAt(zaznaczenie));
            }
        }
            else
            {
                obszar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                if(!obszar.getTitleAt(zaznaczenie).equals("Diagram     ")){
                    if(zaznaczenie >=0)
                {
                    obszar.setToolTipTextAt(zaznaczenie,"Rysuj bramki logiczne");
                 }
                }				
            }
        }
    }
    public void paint(Graphics g){
        int tabCount = obszar.getTabCount();
        for(int j = 0; j < tabCount; j++)
        {
            Graphics2D g2 = (Graphics2D) g;
            int x = obszar.getBoundsAt(j).x + obszar.getBoundsAt(j).width -szerokosc-7;
            int y = obszar.getBoundsAt(j).y +5;
            RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHints(rh);
            g2.setColor( new java.awt.Color(102,102,102));
            g2.setStroke(new BasicStroke(2.0f, BasicStroke.JOIN_MITER, BasicStroke.CAP_ROUND));
            g2.drawLine(x, y+2, x + szerokosc, y+2 + wysokosc);
            g2.setStroke(new BasicStroke(2.0f, BasicStroke.JOIN_MITER, BasicStroke.CAP_ROUND));
            g2.drawLine(x + szerokosc, y+2, x, y+2 + wysokosc); 
            if(CzyObszarZamkniecia(x,y))
            {
                g2.setColor( new java.awt.Color(210,28,41));
                g2.fillOval(x-3, y-1, 14, 14);
                g2.setColor( Color.white);
             g2.setStroke(new BasicStroke(1.7f, BasicStroke.JOIN_MITER, BasicStroke.CAP_ROUND));
            g2.drawLine(x, y+2, x + szerokosc, y+2 + wysokosc);
            g2.drawLine(x + szerokosc, y+2, x, y+2 + wysokosc);  
            } 
           
        }
                        
    }		private boolean CzyObszarZamkniecia(int x, int y) {
			return  Math.abs(x-pozycjaKursoraX)<szerokosc && Math.abs(y-pozycjaKursoraY)<wysokosc;
		}        
		private int CzyObszarRysowania(int x, int y) {
			int licznikObszarowRysowania = obszar.getTabCount();
			for(int j = 0; j < licznikObszarowRysowania; j++)
                        {
                        if(obszar.getBoundsAt(j).contains(pozycjaKursoraX, pozycjaKursoraY))
                        {
                            Xzamkniecia = obszar.getBoundsAt(j).x + obszar.getBoundsAt(j).width -szerokosc-7;
                            Yzamkniecia = obszar.getBoundsAt(j).y +5;					
					return j;
			}
                        }
			return -1;
                }
      }	
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
