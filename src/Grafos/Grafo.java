package Grafos;

import java.util.ArrayList;

public class Grafo {
    private int numVert;
    private static boolean ponderado = false;
    private int[][] matriz;
    
    public Grafo(int numVert){
        this.numVert = numVert;
    }

    public int getNumVert() {
        return numVert;
    }

    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    public static boolean isPonderado(){
        return ponderado;
    }
    
    public static void setPonderado(boolean pond){
        ponderado = pond;
    }
    
    public void init(int numVertices) {
        this.numVert = numVertices;
        matriz = new int[this.numVert][this.numVert];
        fillMatrizAdjacencia(-1);
    }
    
    public void fillMatrizAdjacencia(int value) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = value;
            }
        }
    }
    
    public void addAresta(int vIni, int vFim, int peso) {
        int vi = vIni;
        int vj = vFim;

        matriz[vi][vj] = peso;
        matriz[vj][vi] = peso;
    }
    
    public void imprimeGrafo(String mensagem) {
        System.out.println("=================================");
        System.out.println(mensagem);
        System.out.println("=================================\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public ArrayList getAdjacentes(int no){
        ArrayList<No> adj = new ArrayList<No>();
        for(int i=0; i<this.matriz.length;i++){
            if(matriz[no][i] != -1)
                adj.add(new No(i));
        }
        return adj;
    }
}
