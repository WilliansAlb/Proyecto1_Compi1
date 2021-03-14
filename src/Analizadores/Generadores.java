/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java_cup.runtime.Symbol;
import jflex.exceptions.SilentExit;

/**
 *
 * @author willi
 */
public class Generadores {

    public Generadores() {

    }

    public void generar() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parser", decodedPath + "/src/Analizadores/parser.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/Lexer.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get(dP + "/src/Analizadores/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym.java"),
                Paths.get(dP + "/src/Analizadores/sym.java")
        );
        Path rutaSin = Paths.get(dP + "/src/Analizadores/parser.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parser.java"),
                Paths.get(dP + "/src/Analizadores/parser.java")
        );
        probar();
    }

    public void probar() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/prueba.txt";
        File archivo = new File(ruta1);
        Lexer nuevo = new Lexer(new FileReader(archivo));
        while(true){
            Symbol n = nuevo.next_token();
            if (n.value==null){
                break;
            } else {
                System.out.println("Valor del token: "+n.value+" Linea: "+n.right+" Columna: "+n.left);
            }
        }
        probarSintactico();
    }
    public void probarSintactico() throws UnsupportedEncodingException, FileNotFoundException{
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/prueba.txt";
        File archivo = new File(ruta1);
        parser par = new parser(new Lexer(new FileReader(archivo)));
        try {
            par.parse();
            System.out.println("analizado correctamente");
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
    }
}
