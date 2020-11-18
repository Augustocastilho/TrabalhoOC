package Instrucoes;

/**
 * Contem todas as operacoes de tipo I e J
 */
public class TipoIeJ{
    
    
    public long addi(long val, long constante){
        return val + constante;
    }
    
    public long lw(long indice, long indiceAtual){
        long destino = indice + indiceAtual;
        return destino;
    }
    
    public long sw(long indiceAtual, long indice){
        long destino = indice + indiceAtual;
        return destino;
    }
    
    public long beq(long val, long val2, long destino, long pc){
        if(val == val2)
            return pc + (destino<< 2);
        return -1;
    }
    
    public long bne(long val, long val2, long destino, long pc){
        if(val != val2)
            return pc + (destino<< 2);
        return -1;
    }
    
    public long jump(long val){
        return val;
    }
    
    public long jal (long val){
        return val;
    }
}
