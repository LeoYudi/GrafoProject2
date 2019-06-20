package Grafos;

public class Grafo {
    private int numVertices;
    private Representacao representacao;
    private static boolean ponderado = false;
    
    public Grafo(int numVert, Representacao representacao){
        this.numVertices = numVert;
        this.representacao = representacao;
        this.representacao.init(numVert);
    }

    public void addAresta(int vIni, int vFim, int peso){
        representacao.addAresta(vIni, vFim, peso);
    }

    public Representacao getRepresentacao(){
        return representacao;
    }

    public void imprimeRepresentacao(String mensagem){
        representacao.imprimeRepresentacao(mensagem);
    }
    
    public static boolean isPonderado(){
        return ponderado;
    }
    
    public static void setPonderado(boolean pond){
        ponderado = pond;
    }
}
