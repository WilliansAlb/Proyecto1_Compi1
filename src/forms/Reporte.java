/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Reporte {
    private String id_consulta;
    private String consulta;
    private ArrayList<String> columnas;
    private ArrayList<String> datos;
    private int noColumnas;

    public Reporte(String id_consulta, String consulta, ArrayList<String> columnas, ArrayList<String> datos, int noColumnas) {
        this.id_consulta = id_consulta;
        this.consulta = consulta;
        this.columnas = columnas;
        this.datos = datos;
        this.noColumnas = noColumnas;
    }

    

    public Reporte() {
        id_consulta = "";
        consulta = "";
        columnas = new ArrayList<>();
        datos = new ArrayList<>();
        noColumnas = 0;
    }

    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public ArrayList<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<String> columnas) {
        this.columnas = columnas;
    }

    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public int getNoColumnas() {
        return noColumnas;
    }

    public void setNoColumnas(int noColumnas) {
        this.noColumnas = noColumnas;
    }
    
    
    
}
