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

    public void generar2() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parserDB", "-symbols", "sym2", decodedPath + "/src/Analizadores/parserDB.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/LexerDB.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get(dP + "/src/Analizadores/sym2.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym2.java"),
                Paths.get(dP + "/src/Analizadores/sym2.java")
        );
        Path rutaSin = Paths.get(dP + "/src/Analizadores/parserDB.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parserDB.java"),
                Paths.get(dP + "/src/Analizadores/parserDB.java")
        );
        probar2();
    }
    
    public void generarAlmacenamiento() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parserALM", "-symbols", "symALM", decodedPath + "/src/Analizadores/parserALM.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/LexerALM.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/symALM.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/symALM.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/symALM.java")
        );
        Path rutaSin = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parserALM.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parserALM.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parserALM.java")
        );
        probarDB();
    }

    public void probar() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/prueba.txt";
        File archivo = new File(ruta1);
        Lexer nuevo = new Lexer(new FileReader(archivo));
        while (true) {
            Symbol n = nuevo.next_token();
            if (n.value == null) {
                break;
            } else {
                System.out.println("Valor del token: " + n.value + " Linea: " + n.right + " Columna: " + n.left);
            }
        }
        probarSintactico();
    }

    public void probarSintactico() throws UnsupportedEncodingException, FileNotFoundException {
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

    public void probar2() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/prueba2.txt";
        File archivo = new File(ruta1);
        LexerDB nuevo = new LexerDB(new FileReader(archivo));
        while (true) {
            Symbol n = nuevo.next_token();
            if (n.value == null) {
                break;
            } else {
                System.out.println("Valor del token: " + n.value + " Linea: " + n.right + " Columna: " + n.left);
            }
        }
        probarSintactico2();
    }

    public void probarSintactico2() throws UnsupportedEncodingException, FileNotFoundException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/prueba2.txt";
        File archivo = new File(ruta1);
        parserDB par = new parserDB(new LexerDB(new FileReader(archivo)));
        try {
            par.parse();
            System.out.println("analizado correctamente");
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
    }
    
    public void probarDB() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/pruebaUSER.txt";
        File archivo = new File(ruta1);
        LexerALM nuevo = new LexerALM(new FileReader(archivo));
        while (true) {
            Symbol n = nuevo.next_token();
            if (n.value == null) {
                break;
            } else {
                System.out.println("Valor del token: " + n.value + " Linea: " + n.right + " Columna: " + n.left);
            }
        }
        probarSintacticoDB();
    }

    public void probarSintacticoDB() throws UnsupportedEncodingException, FileNotFoundException {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String ruta1 = decodedPath + "/src/Analizadores/pruebaUSER.txt";
        File archivo = new File(ruta1);
        parserALM par = new parserALM(new LexerALM(new FileReader(archivo)));
        try {
            par.parse();
            System.out.println("analizado correctamente");
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
    }
    public void generarAmbos() throws IOException, SilentExit, Exception{
        generar4();
        generar3();
    }
    public void generar3() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parserDB", "-symbols", "sym2", decodedPath + "/src/Analizadores/parserDB.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/LexerDB.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/sym2.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym2.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/sym2.java")
        );
        Path rutaSin = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parserDB.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parserDB.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parserDB.java")
        );
    }
    
    public void generar4() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parser", "-symbols", "sym", decodedPath + "/src/Analizadores/parser.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/Lexer.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parser.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parser.java"),
                Paths.get("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/WForms/src/java/Analizadores/parser.java")
        );
    }
}
