package Instrucoes;

/**
 * Define todas as caracteriscas de operacoes do tipo R e calcula tais operacoes
 */
public class TipoR extends Instrucoes{
     
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
