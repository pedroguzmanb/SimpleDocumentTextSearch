/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class StatusFlyweight {

    private static StatusFlyweight status;

    private boolean isRunning;
    private boolean botRunning;

    private StatusFlyweight() {
        isRunning = true;
    }

    // ------------------------------------------------------------------------- //
    // METHOD STATUS FLYWEIGHT                                                   //
    // ------------------------------------------------------------------------- //
    /**
     *
     * @return
     */
    public static synchronized StatusFlyweight getInstance() {
        if (status == null) {
            status = new StatusFlyweight();
        } // IF ENDS
        return status;
    } // METHOD GET INSTANCE ENDS ---------------------------------------------- //

    public static StatusFlyweight getStatus() {
        return status;
    }

    public static void setStatus(StatusFlyweight status) {
        StatusFlyweight.status = status;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isBotRunning() {
        return botRunning;
    }

    public void setBotRunning(boolean botRunning) {
        this.botRunning = botRunning;
    }
    
    
    
    

}
