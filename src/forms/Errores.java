/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author willi
 */
public class Errores {
    private int fila;
    private int columna;
    private String esperados;
    private String nombre;
    private String tipo;
    private String valor;

    public Errores(int fila, int columna, String esperados, String nombre, String tipo, String valor) {
        this.fila = fila;
        this.columna = columna;
        this.esperados = esperados;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public Errores() {
    
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getEsperados() {
        return esperados;
    }

    public void setEsperados(String esperados) {
        this.esperados = esperados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
