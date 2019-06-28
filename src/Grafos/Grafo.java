package Grafos;

public abstract class Grafo {
    public static int numVert;
    public static boolean grafo;
    public static boolean ponderado;
    public static int[][] matriz;
    public static No[] vertices;
    
    public static void init () {
        vertices = new No[numVert];
        for(int i=0; i<numVert; i++){
            for(int j=0; j<numVert; j++)
                matriz[i][j] = -1;
            vertices[i] = new No(i);
        }
    }

    public static void addAresta(int vIni, int vFim, int peso) {
        if(grafo) 
            matriz[vIni][vFim] = peso;
        else {
            matriz[vIni][vFim] = peso;
            matriz[vFim][vIni] = peso;
        }
    }
    
    public static void imprimeGrafo(String mensagem) {
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
