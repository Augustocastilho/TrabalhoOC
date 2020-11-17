package Processamento;

import Arquivos.Escrita;
import Instrucoes.Instrucoes;
import Instrucoes.TipoR;
import java.util.HashMap;
import java.util.Map;

/**
 * simula o procedimento feito por um porcessador MIPS
 */
public class Processador {

    private Instrucoes memoriaInstrucao;
    private Map<String, Long> memoriaDados;
    private Map<Integer, String> mapaInstrucoes;
    private String nomeInstrucao;
    private Map<String, Long> sinaisDeControle;
    private String caminhoDoArquivo;
    private Map<String, Long> registradores;
    private Map<String, Long> saidasRegistrador;

    private long aluOut = 0;
    private long aluControl = 0;

    private long indice;

    /**
     *
     * @param pc inicia o processador MIPS
     */
    public Processador(Instrucoes pc, String caminho) {
        memoriaInstrucao = new Instrucoes();
        this.caminhoDoArquivo = caminho;
        this.memoriaInstrucao = pc;
        memoriaInstrucao.atribuiValores();
        this.sinaisDeControle = new HashMap<>();
        if (memoriaInstrucao.getOp() == 0) {
            criaSinaisControleR();
        } else {
            criaSinaisControleIeJ();
        }
        this.registradores = new HashMap<>();
        this.memoriaDados = new HashMap<>();
        this.mapaInstrucoes = new HashMap<>();
        this.saidasRegistrador = new HashMap<>();
    }

    //MÉTODOS GETS
    public String getNomeInstrucao() {
        return this.nomeInstrucao;
    }

    public long getIndice() {
        return this.indice;
    }

    public String getCaminhoDoArquivo() {
        return this.caminhoDoArquivo;
    }

    public Instrucoes getMemoriaInstrucao() {
        return memoriaInstrucao;
    }

    public Map<String, Long> getMemoriaDados() {
        return memoriaDados;
    }

    public Map<Integer, String> getMapaInstrucoes() {
        return mapaInstrucoes;
    }

    public Map<String, Long> getSinaisDeControle() {
        return sinaisDeControle;
    }

    public Map<String, Long> getRegistradores() {
        return registradores;
    }

    public Map<String, Long> getSaidasRegistrador() {
        return saidasRegistrador;
    }

    public long getAluOut() {
        return aluOut;
    }

    public long getAluControl() {
        return aluControl;
    }

    //Processamento    
    public void criaSinaisControleR() {

        sinaisDeControle.put("ALUOp", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(30, 31)));
        sinaisDeControle.put("ALUSrc", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("RegWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("RegDst", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("MemWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("MemToReg", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("MemRead", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("RegWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(31, 31)));
        sinaisDeControle.put("Jump", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("Branch", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));

    }

    public void criaSinaisControleIeJ() {

        sinaisDeControle.put("ALUOp", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 1)));
        sinaisDeControle.put("ALUSrc", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("RegWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("RegDst", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("MemWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("MemToReg", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("MemRead", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("RegWrite", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("Jump", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));
        sinaisDeControle.put("Branch", memoriaInstrucao.converteValor(memoriaInstrucao.getValor().substring(0, 0)));

    }

    /**
     * cria um dicionario com todas as operacoes possiveis do tipo R
     */
    private void criaMapR() {
        mapaInstrucoes.put(32, "add");
        mapaInstrucoes.put(34, "sub");
        mapaInstrucoes.put(24, "mult");
        mapaInstrucoes.put(26, "div");
        mapaInstrucoes.put(36, "and");
        mapaInstrucoes.put(37, "or");
        mapaInstrucoes.put(42, "slt");
        mapaInstrucoes.put(0, "sll");
        mapaInstrucoes.put(8, "jr");
    }

    /**
     * cria um dicionario com todas as operacoes possiveis do tipo I e J
     */
    private void criaMapIeJ() {
        mapaInstrucoes.put(8, "addi");
        mapaInstrucoes.put(35, "lw");
        mapaInstrucoes.put(43, "sw");
        mapaInstrucoes.put(4, "beq");
        mapaInstrucoes.put(5, "bne");
        mapaInstrucoes.put(2, "j");
        mapaInstrucoes.put(3, "jal");
    }

    private void setNomeInstrucao() {
        switch ((int) memoriaInstrucao.getOp()) {
            case 0:
                for (Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()) {
                    if (memoriaInstrucao.getFunct() == map.getKey()) {
                        this.nomeInstrucao = map.getValue();
                    }
                }
                break;
            default:
                for (Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()) {
                    if (memoriaInstrucao.getOp() == map.getKey()) {
                        this.nomeInstrucao = map.getValue();
                    }
                }
                break;
        }
    }

    /**
     * @param entrada1 recebe o primeiro valor vindo do registrador ou PC
     * @param entrada2 recebe o segundo valor vindo do registrador
     * @param controleAlu indica qual operacao logica/aritimetica sera realizada
     * @return retorna o resultado da operacao
     */
    private long alu(long entrada1, long entrada2, long controleAlu) {
        TipoR funcoes = new TipoR();
        long resultado = 0;
        int zero = (int) funcoes.sub(entrada1, entrada2) + 1;
        switch (zero) {
            case 1:
                return 0;
            default:
                switch ((int) controleAlu) {
                    case 32:
                        resultado = funcoes.add(entrada1, entrada2);
                        break;
                    case 34:
                        resultado = funcoes.sub(entrada1, entrada2);
                        break;
                    case 24:
                        resultado = funcoes.mult(entrada1, entrada2);
                        break;
                    case 26:
                        resultado = funcoes.div(entrada1, entrada2);
                        break;
                    case 36:
                        resultado = funcoes.and(entrada1, entrada2);
                        break;
                    case 37:
                        resultado = funcoes.or(entrada1, entrada2);
                        break;
                    case 42:
                        resultado = funcoes.slt(entrada1, entrada2);
                        break;
                    case 0:
                        resultado = funcoes.sll(entrada1, entrada2);
                        break;
                    case 8:
                        resultado = funcoes.jr(entrada1);
                        break;
                    default:
                        break;
                }
                break;
        }
        return resultado;
    }

    private Long memoriaDeDados(long address, long writeData, long memWrite, long memRead) {
        memoriaDados.put("address", address);
        memoriaDados.put("writeData", writeData);
        memoriaDados.put("MemWrite", memWrite);
        memoriaDados.put("MemRead", memRead);

        switch ((int) memWrite) {
            case 1:
                memoriaDados.put("ReadData", writeData);
                break;
            default:
                break;
        }

        switch ((int) memRead) {
            case 1:
                memoriaDados.put("ReadData", address);
                break;
            default:
                break;
        }

        return memoriaDados.get("ReadData");
    }

    /**
     * @param numRegistrador recebe o numero do registrador que vai ser
     * utilizado
     * @param readRegister1 Recebe IR[25:21]
     * @param readRegister2 Recebe IR[20:16]
     * @param writeRegister Recebe IR[15:11]
     * @param writeData
     */
    private void registrador(
            int numRegistrador,
            long readRegister1,
            long readRegister2,
            long writeRegister,
            long writeData
    ) {

        long regWrite = sinaisDeControle.get("RegWrite");

        registradores.put("Read register 1", readRegister1);
        registradores.put("Read register 2", readRegister2);
        switch ((int) regWrite) {
            case 1:
                writeRegister = writeData;
                registradores.put("Write register", writeRegister);
                registradores.put("Write Data", writeData);
                break;
            default:
                registradores.put("Write register", (long) 0);
                registradores.put("Write Data", (long) 0);
                break;
        }

        saidasRegistrador.put("Read data 1", readRegister1);
        saidasRegistrador.put("Read data 2", readRegister2);
    }

    /**
     * Se address for positivo soma 0s, se for negativo adiciona 1s
     *
     * @return valor acrescido de 0s ou 1s
     */
    private long singextend() {
        char aux = memoriaInstrucao.getValor().charAt(16);
        long val = 0;
        switch (aux) {
            case '1':
                for (int i = 16; i < 32; i++) {
                    long y = (long) Math.pow(2, i);
                    val = val + y;
                }
                return val + memoriaInstrucao.getAddress();
            default:
                return memoriaInstrucao.getAddress();
        }
    }

    public int iniciaProcessador(int pc) {
        this.indice = pc;
        memoriaDeDados(memoriaInstrucao.getValorDecimal(), (long) -1, sinaisDeControle.get("MemWrite"), sinaisDeControle.get("MemRead"));
        if (memoriaInstrucao.getOp() == 0) {
            criaMapR();
            setNomeInstrucao();
            long regDst = sinaisDeControle.get("RegDst");
            switch ((int) regDst) {
                case 0:
                    registrador(pc,
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getValorDecimal() //verificar, por causa da entrada do multiplexidor
                    );
                    break;
                default:
                    registrador(pc,
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRd(),
                            memoriaInstrucao.getValorDecimal()
                    );
                    memoriaInstrucao.setValorDecimal(regDst);
                    break;
            }
            long aluSrc = sinaisDeControle.get("ALUSrc");
            switch ((int) aluSrc) {
                case 0:
                    //consertar para os ALUSrcB
                    //desconsiderei o valor de AluOp por já estar fazendo apenas instrucoews do tipo R
                    aluOut = alu(memoriaInstrucao.getValorDecimal(), saidasRegistrador.get("Read data 2"), memoriaInstrucao.getFunct());
                    break;
                default:
                    aluOut = alu(saidasRegistrador.get("Read data 1"), saidasRegistrador.get("Read data 2"), memoriaInstrucao.getFunct());
                    break;
            }
        } else {
            criaMapIeJ();
        }
        Escrita escrita = new Escrita();
        escrita.ImpressaoTipoR(this);
        return pc = pc + 1;
    }
}
