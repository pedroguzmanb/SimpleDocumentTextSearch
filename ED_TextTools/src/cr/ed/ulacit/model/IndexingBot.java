/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

import cr.ed.ulacit.dstructures.Queue;
import cr.ed.ulacit.texttools.TextPurifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 * El bot de indexación es un hilo que se ejecuta en segundo plato y lleva acabo
 * las tareas de indexar documentos
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class IndexingBot implements Runnable {

    private StatusFlyweight status;
    private Index index;
    private final Queue<DocumentContentLocation> workerQueue;
    private TextPurifier purifier;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR                                                               //
    // ------------------------------------------------------------------------- //
    /**
     *
     * @param workerQueue
     */
    public IndexingBot(Queue<DocumentContentLocation> workerQueue, final TextPurifier purifier) {
        status = StatusFlyweight.getInstance();
        index = Index.getInstance();
        this.workerQueue = workerQueue;
        this.purifier = purifier;
    } // CONSTRUCTOR ENDS ------------------------------------------------------ //

    /**
     *
     */
    @Override
    public void run() {
        status.setBotRunning(true);
        while (status.isIsRunning()) {
            System.out.println("BOT RUNNING");
            DocumentContentLocation l = this.workerQueue.dequeue();
            if (l != null) {
                System.out.println("DOC FOUND");
                this.work(l);
            } // IF ENDS
            else {
                System.out.println("NO PENDING DOCS... GOING TO SLEEP A WHILE... :-)");
                this.waitForWork(10);
            } // ELSE ENDS
        } // WHILE ENDS
        status.setBotRunning(false);
    }

    private void work(DocumentContentLocation l) {
        Document doc = new Document(l.getContent(), this.purifier);
        doc.setDocPath(l.getPath());
        // Agregamos el documento al índice global
        this.index.add(doc);
    }

    /**
     *
     * @param secs
     */
    public void waitForWork(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IndexingBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
