package Grafos;

import java.util.ArrayList;

public class Coloracao {
    private int cores[] = null;
    
    public void execute() {
        cores = new int[Grafo.numVert];
        for (int i=0; i<cores.length; i++){
            cores[i] = -1;
        }
        int vMaiorGrau = verticeMaiorGrau();
        System.out.println("Vertice de Maior Grau: " + vMaiorGrau);
        coloreVertice(vMaiorGrau);
    }

    private void coloreVertice(int vert) {
        cores[vert] = corApropriada(vert);
        ArrayList<No> adj = Grafo.vertices[vert].getAdjacentes();
        for(int i=0; i<adj.size();i++) {
            if (cores[adj.get(i).getVertID()] == -1) {
                coloreVertice(adj.get(i).getVertID());
            }
        }
    }
    
    private int corApropriada(int vert){
        int cor = -1;
        Boolean flag = false;        
        int i=0;
        while (!flag){
            cor++;
            ArrayList<No> adj = Grafo.vertices[vert].getAdjacentes();
            while (adj!=null && cores[adj.get(i).getVertID()] != cor){
                i++;
            }
            if (adj == null){
                flag = true;
            }            
        }        
        return cor;
    }

    private int verticeMaiorGrau(){
        int vert = 0;
        int maior = Integer.MIN_VALUE;
        for (int i=0; i<Grafo.numVert; i++){
            int cont = 0;
            ArrayList<No> aux = Grafo.vertices[i].getAdjacentes();
            if (aux.size() > maior){
                maior = aux.size();
                vert = i;
            }
        }
        return vert;
    }

    public int getNumCores(){
        int numComp = 0;
        int count[] = new int[cores.length];
        for (int i=0; i< count.length; i++){
            count[i] = 0;
        }

        for (int i=0; i<cores.length; i++){
            if (count[cores[i]] == 0){
                count[cores[i]]++;
            }
        }

        for (int i=0; i<count.length; i++){
            numComp = numComp + count[i];
        }

        return numComp;
    }

    public int[] getCores() {
        return cores;
    }    
}