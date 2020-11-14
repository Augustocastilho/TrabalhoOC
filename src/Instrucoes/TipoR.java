package Instrucoes;

public class TipoR extends Instrucoes{

    private int op ; //6 bits
    private int rs ; //5 bits
    private int rt; //5 bits
    private int rd; //5 bits
    private int shamt; //5 bits
    private int funct; //6 bits
    
    private void atribuiValores(){
        this.op = Integer.parseInt(getValor().substring(0, 5));
        this.rs = Integer.parseInt(getValor().substring(6, 10));
        this.rt = Integer.parseInt(getValor().substring(11, 15));
        this.rd = Integer.parseInt(getValor().substring(16, 20));
        this.shamt = Integer.parseInt(getValor().substring(21, 25));
        this.funct = Integer.parseInt(getValor().substring(26, 31));
    }
    
    private void add(){}
    private void sub(){}
    private void mult(){}
    private void div(){}
    private void and(){}
    private void or(){}
    private void slt(){}
    private void sll(){}
    private void jr(){}

}
