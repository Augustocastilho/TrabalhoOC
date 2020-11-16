package Instrucoes;

/**
 * Contem todas as operacoes de tipo I e J
 */
public class TipoIeJ{
    
    public long addi(long val, long constante){
        return val + constante;
    }
    
    public long lw(long memoria, long registrador){
        registrador = memoria;
        return registrador;
    }
    
    public long sw(long memoria, long registrador){
        memoria = registrador;
        return memoria;
    }
    
    public long beq(long val, long val2, int destino){
        if(val == val2)
            return destino;
        return 0;
    }
    
    public long bne(long val, long val2, long destino){
        if(val != val2)
            return destino;
        return 0;
    }
}
