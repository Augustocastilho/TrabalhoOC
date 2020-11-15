/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instrucoes;

/**
 *
 * @author Augusto
 */
public class Instrucoes {

    /*private int add;
    private int sub;
    private int mult;
    private int div;
    private int and;
    private int or;
    private int slt;
    private int sll;
    private int addi;
    private int lw;
    private int sw;
    private int beq;
    private int bne;
    private int j;
    private int jr;
    private int jal;
     */
    private String valor;
    private double valorDecimal;

    public Instrucoes() {
        this.valor = "00000000000000000000000000000000";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void converteValor() {
        for (int i = 0; i < this.valor.length(); i++) {
            char y = this.valor.charAt(this.valor.length() - 1 - i);
            if (y == '1') {
                double z = Math.pow(2, i);
                valorDecimal = valorDecimal + z;
            }
        }
    }

}
