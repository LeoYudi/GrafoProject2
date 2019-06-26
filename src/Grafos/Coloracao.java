package Grafos;

import java.util.ArrayList;

public class Coloracao {
    private int cores[] = null;
    
    public void execute(Grafo grafo) {
        Representacao rep = grafo.getRepresentacao();
        cores = new int[rep.getNumVert()];
        for (int i=0; i<cores.length; i++){
            cores[i] = -1;
        }
        int vMaiorGrau = verticeMaiorGrau(rep);
        System.out.println("Vertice de Maior Grau: " + vMaiorGrau);
        coloreVertice(rep, vMaiorGrau);
    }

    private void coloreVertice(Representacao rep, int vert) {
        cores[vert] = corApropriada(rep, vert);
        ArrayList<No> adj = rep.getAdjacentes(vert);
        for(int i=0; i<adj.size();i++) {
            if (cores[adj.get(i).getVertID()] == -1) {
                coloreVertice(rep, adj.get(i).getVertID());
            }
        }
    }
    
    private int corApropriada(Representacao rep, int vert){
        int cor = -1;
        Boolean flag = false;        
        int i=0;
        while (!flag){
            cor++;
            ArrayList<No> adj = rep.getAdjacentes(vert);
            while (adj!=null && cores[adj.get(i).getVertID()] != cor){
                i++;
            }
            if (adj == null){
                flag = true;
            }            
        }        
        return cor;
    }

    private int verticeMaiorGrau(Representacao rep){
        int vert = 0;
        int maior = Integer.MIN_VALUE;
        for (int i=0; i<rep.getNumVert(); i++){
            int cont = 0;
            ArrayList<No> aux = rep.getAdjacentes(i);
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