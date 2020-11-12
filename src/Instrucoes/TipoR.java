package Instrucoes;

public class TipoR extends Instrucoes {

    private int op ; //6 bits
    private int rs ; //5 bits
    private int rt; //5 bits
    private int rd; //5 bits
    private int shamt; //5 bits
    private int funct; //6 bits
    
    private void atribuiValores(){
        this.op = 0; //recebe os 6 primeiros bits de valor
        this.rs = 0;
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
