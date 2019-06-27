package Grafos;

import java.util.ArrayList;

public class Grafo {
    private int numVert;
    private static boolean ponderado = false;
    private static int[][] matriz;
    private static No[] vertices;
    
    public Grafo(int numVert){
        this.numVert = numVert;
        vertices = new No[numVert];
        matriz = new int[this.numVert][this.numVert];
        for (int i = 0; i < numVert; i++) {
            for (int j = 0; j < numVert; j++) {
                matriz[i][j] = -1;
            }
            vertices[i] = new No(i);
        }
    }

    public int getNumVert() {
        return numVert;
    }

    public void setNumVert(int numVert) {
        this.numVert = numVert;
    }

    public static boolean isPonderado(){
        return ponderado;
    }
    
    public void setPonderado(boolean pond){
        ponderado = pond;
    }
    
    public static int[][] getMatriz() {
        return matriz;
    }

    public static No[] getVertices() {
        return vertices;
    }

    public static void setVertices(No[] vertices) {
        Grafo.vertices = vertices;
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
        ArrayList<No> adj = new ArrayList<>();
        for(int i=0; i<matriz.length;i++){
            if(matriz[no][i] != -1)
                adj.add(new No(i));
        }
        return adj;
    }
}
