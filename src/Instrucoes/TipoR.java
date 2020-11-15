package Instrucoes;

/**
 * Contem todas as operacoes de tipo R
 */
public class TipoR{
     
    public long add(long val, long val2){
        return val+val2;
    }
    
    public long sub(long val, long val2){
        return val-val2;
    }
    
    public long mult(long val, long val2){
        return val*val2;
    }
    
    public long div(long val, long val2){
        return val/val2;
    }
    
    public long and(long val, long val2){
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
    
    public long or(long val, long val2){
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
    
    public long slt(long val, long val2){
        if(val<val2)
            return 1;
        return 0;
    }
    
    public long sll(long val, long val2){
        return (int)Math.pow(2, val2)*val;
    }
    
    public long jr(long val, long val2){
        return val;
    }
}
