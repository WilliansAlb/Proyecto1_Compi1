/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Analizadores.Generadores;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author willi
 */
public class Forms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, Exception {
        Generadores generar = new Generadores();
        generar.generar();
    }
}
