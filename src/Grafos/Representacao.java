package Grafos;

public class Representacao {
    private int numVert = 0;
    private int[][] matriz;
  
    public void init(int numVertices) {
        this.numVert = numVertices;
        matriz = new int[this.numVert][this.numVert];
        fillMatrizAdjacencia(0);
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
    
    public void imprimeRepresentacao(String mensagem) {
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
}

