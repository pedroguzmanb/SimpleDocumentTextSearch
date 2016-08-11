/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

// ----------------------------------------------------------------------------- //
// CLASS INDEX                                                                   //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase representa un índice de documentos sobre el cual se pueden realizar
 * búsquedas para determinar los coeficientes de similaridad entre documentos 
 * presentes y una consulta o query. Esta clase implementa el patrón de singleton
 * para poder optimizar el uso de memoria y así poder permitir que todos recursos
 * que utilizan el índice lo hagan por medio de referencias y no se duplique el 
 * índice lo cual es muy importante para mantener la consistencia.
 * 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 */
public class Index {
    
    // ========================================================================= //
    // ATRIBUTOS DE LA CLASE                                                     //
    // ========================================================================= //
    
    // Instancia global del índice
    private static Index globalIndex;
    
    // ========================================================================= //
    // CLASS CONSTRUCTORS                                                        //
    // ========================================================================= //
    /**
     * El constructor por defecto de la clase index es privado ya que este es un 
     * objeto que implementa el patrón de singleton y por lo tanto, no debe poder
     * ser instanciado desde afuera de la clase
     */
    private Index(){
        // Existe con el único propósito de evitar que la clase pueda ser 
        // instanciada desde afuera.
    } // CONSTRUCTOR METHOD ENDS ----------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD GET INSTANCE                                                       //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener una referencia de una instancia de Index
     * @return 
     */
    public static synchronized Index getInstance(){
        if(globalIndex == null){
            globalIndex = new Index();
        } // IF ENDS
        return globalIndex;
    } // METHOD GET INSTANCE ENDS ---------------------------------------------- //
    
    // TODO RESTO DEL ÍNDICE
    
} // CLASS INDEX ENDS ---------------------------------------------------------- //
