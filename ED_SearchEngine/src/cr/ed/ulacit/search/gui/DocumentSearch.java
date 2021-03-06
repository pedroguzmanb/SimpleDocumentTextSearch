/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.search.gui;

import com.ulacit.ocheckers.connect.HttpSimpleRestClient;
import cr.ed.ulacit.dstructures.Iterator;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.Queue;
import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedQueue;
import cr.ed.ulacit.model.Document;
import cr.ed.ulacit.model.DocumentContentLocation;
import cr.ed.ulacit.model.Index;
import cr.ed.ulacit.model.IndexingBot;
import cr.ed.ulacit.model.Query;
import cr.ed.ulacit.model.ScoreResult;
import cr.ed.ulacit.model.StatusFlyweight;
import cr.ed.ulacit.search.gui.external.Dictionary;
import cr.ed.ulacit.texttools.TextPurifier;
import cr.ed.ulacit.texttools.util.DirectorySweeper;
import cr.ed.ulacit.texttools.util.TextFileReader;
import java.util.concurrent.ExecutorService;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import javax.swing.DefaultListModel;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class DocumentSearch extends javax.swing.JFrame {

    
    private ExecutorService threadPool;
    private final Queue<DocumentContentLocation> workerQueue;
    private final Index index;
    private final StatusFlyweight status;
    private final TextPurifier purifier;
    private final DefaultListModel<String> elements;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR MEHTOD                                                        //
    // ------------------------------------------------------------------------- //
    /**
     * Creates new form DocumentSearch
     */
    public DocumentSearch() {
        elements = new DefaultListModel<String>();
        
        initComponents();
        this.results.setModel(elements);
        this.threadPool = Executors.newFixedThreadPool(10);
        this.workerQueue = new ConcurrentLinkedQueue<DocumentContentLocation>();
        this.index = Index.getInstance();
        this.status = StatusFlyweight.getInstance();
        HttpSimpleRestClient client = new HttpSimpleRestClient();
        Dictionary d = client.get();
        this.purifier = new TextPurifier(d.export());
    } // METHOD DOCUMENT SEARCH ENDS ------------------------------------------- //

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queryBox = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        results = new javax.swing.JList<>();
        progress = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        btnScan = new javax.swing.JButton();
        progressIndex = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Document Search");
        setBackground(new java.awt.Color(77, 77, 106));
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        setForeground(java.awt.Color.darkGray);
        setResizable(false);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 74));
        jLabel1.setText("Simple Document Search 1.0");

        results.setFont(new java.awt.Font("Segoe WP", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(results);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Programación Concurrente Cliente Servidor");
        jLabel2.setToolTipText("");

        btnScan.setText("Scan");
        btnScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanActionPerformed(evt);
            }
        });

        jLabel3.setText("Load");

        jLabel4.setText("Indexing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(progressIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(129, 129, 129)
                                .addComponent(btnScan)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(queryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn)
                                .addGap(278, 278, 278))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnScan)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progressIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel3)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ========================================================================= //
    // METHOD BUTTON SCAN ACTION PERFORMED                                       //
    // ========================================================================= //
    /**
     * Este método se ejecuta cuando el evento de presionar el botón scan de la
     * interfaz de usuario es presionado. El boton scan despliega una serie de
     * diálogos al usuario que le permiten al usuario seleccionar un directorio
     * nuevo como fuente de archivos de texto que pueden ser indexados.
     *
     * @param evt referencia a la instancia del evento
     */
    private void btnScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanActionPerformed
        // Bloqueamos el acceso al botón para prevenir que se generen nuevos 
        // eventos mientras el programa se encuentra en ejecución
        this.btnScan.setEnabled(false);
        this.searchBtn.setEnabled(false);
        String directory = "";
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choose document source folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                directory = chooser.getCurrentDirectory().getAbsolutePath();
                List<Path> docsFound = DirectorySweeper.sweep(directory);
                System.out.println("Docs Found: " + docsFound.size());
                System.out.println("docsFound : " + docsFound);

                this.threadPool.submit(new Thread() {
                    @Override
                    public void run() {
                        Iterator<Path> pathIter = docsFound.iterator();
                        System.out.println("DOC IN THREAD: " + docsFound.size());
                        while (pathIter.hasNext()) {
                            System.out.println("hasNext: " + pathIter.hasNext());
                            try {
                                String f = pathIter.next().toString();
                                System.out.println("Reading: " + f);
                                if (!f.contains("StopWords")) {
                                    
                                    String txt = TextFileReader.readAnyFile(f);
                                    DocumentContentLocation dl = new DocumentContentLocation(f, txt);
                                    // Colocamos en la cola de indexado los datos para que el worker 
                                    // los procese
                                    workerQueue.queue(dl);
                                    System.out.println("Documento Colocado en la Cola...");
                                } // IF ENDS
                            } // TRY ENDS
                            catch (Exception e) {
                                System.out.println("ERROR leyendo archivos: " + e.getMessage());
                            }
                            //this.progress.setValue(step);
                            //step = step * 2;
                        } // WHILE ENMDS
                        DocumentSearch.this.btnScan.setEnabled(true);
                        DocumentSearch.this.searchBtn.setEnabled(true);
                    } // RUN ENDS
                });
                this.progress.setValue(this.progress.getMaximum());
            } else {
                System.out.println("No Selection ");
            }
        }// TRY ENDS
        catch (Exception e) {

        } // CATCH ENDS
        System.out.println("BOT RUNNING: " + this.status.isBotRunning());
        if (!this.status.isBotRunning()) {
            // Creamos dos hilos indexador
            this.threadPool.submit(new IndexingBot(this.workerQueue, this.purifier));
            System.out.println("BOT RUNNING: " + this.status.isBotRunning());
        }
        this.progressIndex.setIndeterminate(true);
    }//GEN-LAST:event_btnScanActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed


        if (!this.queryBox.getText().isEmpty()) {

            this.threadPool.submit(new Thread() {

                @Override
                public void run() {
                    System.out.println("Query Executed!");
                    String q = DocumentSearch.this.queryBox.getText();
                    Query query = new Query(q, purifier);

                    // Ocupamos una calificación para cada documento
                    ScoreResult[] results = new ScoreResult[index.getDocs().size()];
                    System.out.println("Calculando distancia de coseno entre documentos...");
                    for (int i = 0; i < index.getDocs().size(); ++i) {
                        Document d = index.getDocs().get(i);
                        results[i] = new ScoreResult(d, query.computeCosineDistance(d, index.getDocs().size()));
                        System.out.println("Tarea[" + i + "] completa ----------------------------------");
                    } // METHOD FOR ENDS
                    bubbleSort(results);
                    DocumentSearch.this.elements.removeAllElements();
                    for (int j = 0; j < results.length; ++j) {
                        System.out.println(results[j]);
                        DocumentSearch.this.elements.addElement(results[j].toString());
                        System.out.println("Result Added -----------------------------------------------");
                    } // FOR ENDS
                }
            });

        } // IF ENDS

    }//GEN-LAST:event_searchBtnActionPerformed

    // Ordena los resultados de la búsqueda
    public void bubbleSort(ScoreResult[] array) {
        boolean swapped = true;
        int j = 0;
        ScoreResult tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i].getScore() > array[i + 1].getScore()) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    // ------------------------------------------------------------------------- //
    // METHOD MAIN                                                               //
    // ------------------------------------------------------------------------- //
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
            java.util.logging.Logger.getLogger(DocumentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentSearch().setVisible(true);
            }
        });
    } // METHOD MAIN ENDS ------------------------------------------------------ //

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnScan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JProgressBar progressIndex;
    private javax.swing.JTextField queryBox;
    private javax.swing.JList<String> results;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
