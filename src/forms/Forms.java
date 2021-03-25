/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Analizadores.Generadores;
import java.io.IOException;
import jflex.exceptions.SilentExit;

/**
 *
 * @author willi
 */
public class Forms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SilentExit, Exception {
        Generadores generar = new Generadores();
        generar.generar4();
    }
}
