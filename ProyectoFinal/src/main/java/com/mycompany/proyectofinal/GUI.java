package com.mycompany.proyectofinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer; //

/**
 *
 * @author andrea jazmin pacheco
 */
public class GUI extends javax.swing.JFrame {
    
    private GrafoDirigidoAciclico grafo;
    private String listadoAristas = "";
    private String ruta = "grafo.txt";
    private int a = -1, b = -1;
    private int indice = 1, totalGrafos;
    
    /**
     * Creates new form GUI
     */
    public GUI() throws IOException {
        initComponents();
        inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generarGrafoBttn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAdyLabel = new javax.swing.JTextArea();
        graphPanel = new javax.swing.JPanel();
        verticesField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        matrizAdyLabel = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        confirmarVerticesBttn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        aristasField = new javax.swing.JTextField();
        eliminarAristasBttn = new javax.swing.JButton();
        agregarAristaBttn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listadoAristasField = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        parametrosGrafo = new javax.swing.JTextArea();
        generarGrafoRandomBttn = new javax.swing.JButton();
        GuardarBttn = new javax.swing.JButton();
        CargarBttn = new javax.swing.JButton();
        retrocederBttn = new javax.swing.JButton();
        avanzarBttn = new javax.swing.JButton();
        indiceLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        historialGrafos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        generarGrafoBttn.setText("Generar Grafo");
        generarGrafoBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarGrafoBttnActionPerformed(evt);
            }
        });
        getContentPane().add(generarGrafoBttn);
        generarGrafoBttn.setBounds(910, 930, 170, 30);

        listaAdyLabel.setColumns(20);
        listaAdyLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listaAdyLabel.setRows(5);
        jScrollPane1.setViewportView(listaAdyLabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 120, 340, 446);

        graphPanel.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );

        getContentPane().add(graphPanel);
        graphPanel.setBounds(530, 50, 751, 561);

        verticesField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        verticesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticesFieldActionPerformed(evt);
            }
        });
        verticesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                verticesFieldKeyTyped(evt);
            }
        });
        getContentPane().add(verticesField);
        verticesField.setBounds(850, 622, 110, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Adyacencia");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 80, 150, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Matriz de Adyacencia");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1560, 90, 150, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Grafo Dirigido Aciclico");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(800, 10, 270, 40);

        matrizAdyLabel.setColumns(20);
        matrizAdyLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        matrizAdyLabel.setRows(5);
        jScrollPane2.setViewportView(matrizAdyLabel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1430, 126, 350, 450);

        jLabel4.setText("Cantidad de vertices:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(720, 630, 120, 16);

        confirmarVerticesBttn.setText("Confirmar vertices");
        confirmarVerticesBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarVerticesBttnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmarVerticesBttn);
        confirmarVerticesBttn.setBounds(980, 623, 200, 30);

        jLabel5.setText("Arista [a,b] :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(760, 680, 70, 20);

        aristasField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aristasField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aristasFieldKeyTyped(evt);
            }
        });
        getContentPane().add(aristasField);
        aristasField.setBounds(840, 670, 140, 30);

        eliminarAristasBttn.setText("Eliminar Aristas");
        eliminarAristasBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAristasBttnActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarAristasBttn);
        eliminarAristasBttn.setBounds(730, 930, 170, 30);

        agregarAristaBttn.setText("Agregar arista");
        agregarAristaBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAristaBttnActionPerformed(evt);
            }
        });
        getContentPane().add(agregarAristaBttn);
        agregarAristaBttn.setBounds(1000, 670, 180, 30);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listadoAristasField.setColumns(20);
        listadoAristasField.setRows(5);
        jScrollPane3.setViewportView(listadoAristasField);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(840, 710, 140, 200);

        parametrosGrafo.setColumns(20);
        parametrosGrafo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        parametrosGrafo.setRows(5);
        jScrollPane4.setViewportView(parametrosGrafo);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(70, 620, 380, 330);

        generarGrafoRandomBttn.setText("Generar de 4 vertices Aleatorio");
        generarGrafoRandomBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarGrafoRandomBttnActionPerformed(evt);
            }
        });
        getContentPane().add(generarGrafoRandomBttn);
        generarGrafoRandomBttn.setBounds(520, 800, 240, 30);

        GuardarBttn.setText("Guardar Grafo");
        GuardarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(GuardarBttn);
        GuardarBttn.setBounds(1230, 710, 160, 23);

        CargarBttn.setText("Cargar Grafo");
        CargarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(CargarBttn);
        CargarBttn.setBounds(1230, 750, 160, 23);

        retrocederBttn.setText("<");
        retrocederBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrocederBttnActionPerformed(evt);
            }
        });
        getContentPane().add(retrocederBttn);
        retrocederBttn.setBounds(1250, 790, 23, 120);

        avanzarBttn.setText(">");
        avanzarBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarBttnActionPerformed(evt);
            }
        });
        getContentPane().add(avanzarBttn);
        avanzarBttn.setBounds(1350, 790, 23, 120);

        indiceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        indiceLabel.setText("0/0");
        getContentPane().add(indiceLabel);
        indiceLabel.setBounds(1300, 830, 40, 40);

        historialGrafos.setColumns(20);
        historialGrafos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        historialGrafos.setRows(5);
        jScrollPane5.setViewportView(historialGrafos);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(1420, 620, 370, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarGrafoBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarGrafoBttnActionPerformed
        mostrarGrafo();
        parametrosGrafo.setText(actualizarParametros());
        actualizarIndiceLabel();
    }//GEN-LAST:event_generarGrafoBttnActionPerformed

    private void verticesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verticesFieldActionPerformed

    private void confirmarVerticesBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarVerticesBttnActionPerformed
        String verticesString = verticesField.getText();
        int vertices = Integer.parseInt(verticesString);
        grafo = new GrafoDirigidoAciclico(vertices);
        System.out.println("Tamaño: " + vertices + " vertices, rango de 0 a " + (vertices-1));
    }//GEN-LAST:event_confirmarVerticesBttnActionPerformed

    private void eliminarAristasBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAristasBttnActionPerformed
        grafo.eliminarAristas();
        listadoAristas = "";
        listadoAristasField.setText("");
        String verticesString = verticesField.getText();
        int vertices = Integer.parseInt(verticesString);
        grafo = new GrafoDirigidoAciclico(vertices);
        System.out.println("Eliminadas");
        mostrarGrafo();
        parametrosGrafo.setText(actualizarParametros());
    }//GEN-LAST:event_eliminarAristasBttnActionPerformed

    private void agregarAristaBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAristaBttnActionPerformed
        String arista = aristasField.getText();
        extraerVertices(arista);
        System.out.println("a: " + a + "    b: " + b);
        if(a != -1 && b != -1){
            grafo.insertarArista(a, b);
            listadoAristas += a + " -> " + b + "\n";
            listadoAristasField.setText(listadoAristas);
        }
        parametrosGrafo.setText(actualizarParametros());
    }//GEN-LAST:event_agregarAristaBttnActionPerformed

    private void verticesFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verticesFieldKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_verticesFieldKeyTyped

    private void aristasFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aristasFieldKeyTyped
        char enter = evt.getKeyChar();
        if(enter != ',' && !Character.isDigit(enter)){
            evt.consume();
        }
    }//GEN-LAST:event_aristasFieldKeyTyped

    private void generarGrafoRandomBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarGrafoRandomBttnActionPerformed
        grafo = new GrafoDirigidoAciclico();
        mostrarGrafo();
    }//GEN-LAST:event_generarGrafoRandomBttnActionPerformed

    private void GuardarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBttnActionPerformed
        grafo.guardarGrafo(ruta);
        actualizarIndiceLabel();
    }//GEN-LAST:event_GuardarBttnActionPerformed

    private void CargarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarBttnActionPerformed
        // Cargar el grafo
        historialGrafos.setText(grafo.cargarGrafoPorIndice(ruta, indice));
    }//GEN-LAST:event_CargarBttnActionPerformed

    private void retrocederBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrocederBttnActionPerformed
        indice--;
        if(indice < 1){
            indice = totalGrafos;
        }
        actualizarIndiceLabel();
    }//GEN-LAST:event_retrocederBttnActionPerformed

    private void avanzarBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarBttnActionPerformed
        indice++;
        if(indice > totalGrafos)
        {
            indice = 1;
        }
        actualizarIndiceLabel();
    }//GEN-LAST:event_avanzarBttnActionPerformed

    public void inicializar(){
        listaAdyLabel.setEditable(false);
        listaAdyLabel.setEditable(false);
        listadoAristasField.setEditable(false);
        parametrosGrafo.setEditable(false);
        historialGrafos.setEditable(false);
    }
    
    public void actualizarIndiceLabel(){
        totalGrafos = grafo.contarGrafos(ruta);
        indiceLabel.setText(indice + "/" + totalGrafos);
    }
    
    public void mostrarGrafo(){
        Viewer viewer = new Viewer(grafo.crearGrafoGraphStream(), Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);

        graphPanel.removeAll();
           graphPanel.setPreferredSize(new Dimension(800, 560));
         graphPanel.setLayout(new BorderLayout());
         graphPanel.add(viewPanel, BorderLayout.CENTER);
        graphPanel.revalidate();
         graphPanel.repaint();
        
        listaAdyLabel.setText(grafo.mostrarEstructura());
        matrizAdyLabel.setText(grafo.matrizDeAdyacencia());
    }
    
    public void extraerVertices(String cadena) {
        String[] partes = cadena.split(",");
        
        a = -1;
        b = -1;
        int count = 0;
        
        for (String parte : partes)
        {
        if (!parte.trim().isEmpty())
            { 
                if (count == 0)
                
                {
                    a = Integer.parseInt(parte.trim()); 
                } else if (count == 1) 
                {
                    b = Integer.parseInt(parte.trim());  
                    break;
                }
                count++;
            }
        }
    }
    
    public String actualizarParametros(){
        String parametros = "Ordenamiento topologico: " + grafo.topologicalSort() +
                            "\nEl grafo tiene ciclos? " + grafo.tieneCiclos() +
                            "\nGrado de entrada de 0: " + grafo.gradoDeEntrada(0) +
                            "\nGrado de salida de 0: " + grafo.gradoDeSalida(0) +
                            "\nHay " + grafo.cuantasAristasHay() + " aristas" +
                            "\n0 y 1 son adyacentes: " + grafo.adyacente(0, 1) +
                            "\nExiste un camino directo entre 0 y 2: " + grafo.conectados(0, 2);
        return parametros;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarBttn;
    private javax.swing.JButton GuardarBttn;
    private javax.swing.JButton agregarAristaBttn;
    private javax.swing.JTextField aristasField;
    private javax.swing.JButton avanzarBttn;
    private javax.swing.JButton confirmarVerticesBttn;
    private javax.swing.JButton eliminarAristasBttn;
    private javax.swing.JButton generarGrafoBttn;
    private javax.swing.JButton generarGrafoRandomBttn;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JTextArea historialGrafos;
    private javax.swing.JLabel indiceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea listaAdyLabel;
    private javax.swing.JTextArea listadoAristasField;
    private javax.swing.JTextArea matrizAdyLabel;
    private javax.swing.JTextArea parametrosGrafo;
    private javax.swing.JButton retrocederBttn;
    private javax.swing.JTextField verticesField;
    // End of variables declaration//GEN-END:variables
}