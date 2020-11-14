package Instrucoes;

public class Instrucoes {

    /*
    private int add;
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
    private int jal;*/

    private String valor;
   
    public Instrucoes(){
        this.valor = "00000000000000000000000000000000";
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
