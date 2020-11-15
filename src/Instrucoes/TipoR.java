package Instrucoes;

/**
 * Define todas as caracteriscas de operacoes do tipo R e calcula tais operacoes
 */
public class TipoR extends Instrucoes{

    private int op; //6 bits
    private int rs; //5 bits
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
    
    registers.put("RegWrite", new Register(1));
			registers.put("MemToReg", new Register(1));
			registers.put("Branch", new Register(1));
			registers.put("MemRead", new Register(1));
			registers.put("MemWrite", new Register(1));
			registers.put("BranchAddress", new Register(32));
			registers.put("Zero", new Register(1));
			registers.put("ALUResult", new Register(32));
			registers.put("ReadData2", new Register(32));
			registers.put("Destination", new Register(5));
    
    public int add(int val, int val2){
        return val+val2;
    }
    
    public int sub(int val, int val2){
        return val-val2;
    }
    
    public int mult(int val, int val2){
        return val*val2;
    }
    
    public int div(int val, int val2){
        return val/val2;
    }
    
    public int and(int val, int val2){
        char[] valBits = String.valueOf( val ).toCharArray();
        char[] val2Bits = String.valueOf( val2 ).toCharArray();
        char[] resultado = null;
        
        for(int i=0; i<valBits.length-1; i++){
            if(valBits[i] == val2Bits[i]){
                resultado[i] = valBits[i];
            } else {
                resultado[i] = 0;
            }
        }
        
        int resultadoFinal = Integer.parseInt(resultado.toString());
        return resultadoFinal;
    }
    
    public int or(int val, int val2){
        char[] valBits = String.valueOf( val ).toCharArray();
        char[] val2Bits = String.valueOf( val2 ).toCharArray();
        char[] resultado = null;
        
        for(int i=0; i<valBits.length-1; i++){
            if(valBits[i] == 1 || val2Bits[i] == 1){
                resultado[i] = 1;
            } else {
                resultado[i] = 0;
            }
        }
        
        int resultadoFinal = Integer.parseInt(resultado.toString());
        return resultadoFinal;
    }
    
    public int slt(int val, int val2){
        if(val<val2)
            return 1;
        return 0;
    }
    
    public int sll(int val, int val2){
        return (int)Math.pow(2, val2)*val;
    }
    
    public int jr(int val, int val2){
        return val;
    }
}
