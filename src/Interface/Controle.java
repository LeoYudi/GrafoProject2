package Interface;

import Grafos.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Controle extends javax.swing.JFrame {

    public Controle() {
        this.view = new ViewPanel();
        //this.view.setGraph(this.graph);
        initComponents();
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane(this.view);
        ID = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MICriarGrafos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MICompConex = new javax.swing.JMenuItem();
        MIColor = new javax.swing.JMenuItem();
        MIAGM = new javax.swing.JMenuItem();
        MICamMin = new javax.swing.JMenuItem();
        MIConex = new javax.swing.JMenuItem();
        MITransp = new javax.swing.JMenuItem();
        MIOrdemTop = new javax.swing.JMenuItem();
        MIBusca = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MIHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(690, 524));

        ID.setEditable(false);
        ID.setForeground(new java.awt.Color(204, 204, 204));
        ID.setText("(Tipo de Grafo)");
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jMenu1.setText("Opções");

        MICriarGrafos.setText("Criar grafos");
        MICriarGrafos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICriarGrafosActionPerformed(evt);
            }
        });
        jMenu1.add(MICriarGrafos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Algoritmos");

        MICompConex.setText("Componentes conexas");
        MICompConex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICompConexActionPerformed(evt);
            }
        });
        jMenu2.add(MICompConex);

        MIColor.setText("Coloração");
        jMenu2.add(MIColor);

        MIAGM.setText("AGM");
        jMenu2.add(MIAGM);

        MICamMin.setText("Caminho mínimo");
        MICamMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICamMinActionPerformed(evt);
            }
        });
        jMenu2.add(MICamMin);

        MIConex.setText("Conectividade");
        MIConex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIConexActionPerformed(evt);
            }
        });
        jMenu2.add(MIConex);

        MITransp.setText("Transposição");
        MITransp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MITranspActionPerformed(evt);
            }
        });
        jMenu2.add(MITransp);

        MIOrdemTop.setText("Ordem Topológica");
        jMenu2.add(MIOrdemTop);

        MIBusca.setText("Busca em largura");
        MIBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIBuscaActionPerformed(evt);
            }
        });
        jMenu2.add(MIBusca);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        MIHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        MIHelp.setText("Ajuda");
        MIHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIHelpActionPerformed(evt);
            }
        });
        jMenu3.add(MIHelp);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MIHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIHelpActionPerformed
        System.out.println("Im helping :)");
    }//GEN-LAST:event_MIHelpActionPerformed

    private void MICriarGrafosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICriarGrafosActionPerformed
        JFileChooser fc = new JFileChooser();
        int result;
        String tipo;
        result = fc.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getAbsolutePath();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(filename));
                int aux = Integer.parseInt(in.readLine());
                // le se eh grafo ou digrafo
                if (aux == 0) {
                    Grafo.grafo = true;
                    tipo = "Grafo ";
                }
                    else {
                    Grafo.grafo = false;
                    tipo = "Digrafo ";
                }
                    
                // le numero de vertices
                int nVert =  Integer.parseInt(in.readLine());
                // desenho - adiciona numero de vertices
                this.graph = new Graph(nVert); 
                // estrutura - adiciona numero de vertices
                Grafo.numVert = nVert; 
                // estrutura - inicializa matriz e vetor de vertices 
                Grafo.init();   

                // le as arestas
                String line;
                while ((line = in.readLine()) != null && line.trim().length() > 0) {
                    StringTokenizer t1 = new StringTokenizer(line, " ");
                    // vertice inicial
                    int vIni = Integer.parseInt(t1.nextToken().trim()); 
                    // vertice final
                    int vFim = Integer.parseInt(t1.nextToken().trim()); 
                    // peso da aresta
                    int peso = Integer.parseInt(t1.nextToken().trim()); 
                    // estrutura - cria aresta lida
                    Grafo.addAresta(vIni, vFim, peso); 
                    // desenho - cria vertices
                    Vertex vS = this.graph.getVertex().get(vIni);   
                    Vertex vT = this.graph.getVertex().get(vFim);
                     // desenho - cria aresta lida
                    Edge e = new Edge(vS, vT);
                    // desenho - desenha setas de orientacao
                    if (aux == 1) e.setDirected(true);  
                    // desenho - nao desenha setas de orientacao
                    else e.setDirected(false);     
                    // desenho - adiciona aresta criada
                    this.graph.addEdge(e);
                }
                // desenho - desenha os grafos na tela
                this.view.setGraph(graph);
                // verificando se o grafo eh ponderado ou nao
                Boolean flag = false;
                for (int i=0; i<nVert; i++)
                    for (int j=0; j<nVert; j++)
                        if (Grafo.matriz[i][j] != -1 && 
                                Grafo.matriz[i][j] != 0) {
                            flag = true;
                            break;
                        }
                if (flag) {
                    Grafo.ponderado = true;
                    tipo += "Ponderado";
                }
                else {
                    Grafo.ponderado = false;
                    tipo += "Nao-Ponderado";
                }
                ID.setText(tipo);
                ID.setForeground(Color.black);             
            } catch (IOException ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                //fechar o arquivo
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_MICriarGrafosActionPerformed

    private void MICompConexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICompConexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MICompConexActionPerformed

    private void MIConexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIConexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MIConexActionPerformed

    private void MICamMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICamMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MICamMinActionPerformed

    private void MIBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MIBuscaActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        
    }//GEN-LAST:event_IDActionPerformed

    private void MITranspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MITranspActionPerformed
        Grafo.matriz = Util.transposicao(this.graph);
        this.view.setGraph(graph);
    }//GEN-LAST:event_MITranspActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle().setVisible(true);
            }
        });
    }
    
    public class ViewPanel extends JPanel {

        public ViewPanel() {
            this.setBackground(java.awt.Color.WHITE);
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            ////configuração do rendering para obeter melhor qualidade
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

            if (graph != null && this.imageBuffer == null) {
                this.imageBuffer = new BufferedImage(graph.getSize().width + 1,
                        graph.getSize().height + 1, BufferedImage.TYPE_INT_RGB);

                java.awt.Graphics2D g2Buffer = this.imageBuffer.createGraphics();
                g2Buffer.setColor(this.getBackground());
                g2Buffer.fillRect(0, 0, graph.getSize().width + 1, graph.getSize().height + 1);

                g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                graph.draw(g2Buffer);
                g2Buffer.dispose();
            }

            if (this.imageBuffer != null) {
                g2.drawImage(this.imageBuffer, 0, 0, null);
            }
        }

        public void setGraph(Graph graph) {
            if (graph != null) {
                this.setPreferredSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));
                this.setSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));

                this.cleanImage();
                this.repaint();
            }
        }

        public Vertex getMarkedVertex() {
            return markedVertex;
        }

        public void cleanImage() {
            this.imageBuffer = null;
        }

        public void adjustPanel() {
            float iniX = graph.getVertex().get(0).getX();
            float iniY = graph.getVertex().get(0).getY();
            float max_x = iniX, max_y = iniX;
            float min_x = iniY, min_y = iniY;
            int zero = graph.getVertex().get(0).getRay() * 5 + 10;

            for (int i = 1; i < graph.getVertex().size(); i++) {
                float x = graph.getVertex().get(i).getX();
                if (max_x < x) {
                    max_x = x;
                } else if (min_x > x) {
                    min_x = x;
                }

                float y = graph.getVertex().get(i).getY();
                if (max_y < y) {
                    max_y = y;
                } else if (min_y > y) {
                    min_y = y;
                }
            }

            for (Vertex v : graph.getVertex()) {
                v.setX(v.getX() + zero - min_x);
                v.setY(v.getY() + zero - min_y);
            }

            Dimension d = this.getSize();
            d.width = (int) max_x + zero;
            d.height = (int) max_y + zero;
            this.setSize(d);
            this.setPreferredSize(d);
        }

        public void markVertices(ArrayList<Vertex> vertices) {
            if (vertices != null) {
                this.cleanMarkedVertices(false);

                //change the vertices' colors
                for (Vertex v : vertices) {
                    v.setSelected(true);
                }

                this.cleanImage();
                this.repaint();
            }
        }

        public void cleanMarkedVertices(boolean cleanVertex) {
            if (graph != null) {
                this.markedVertex = null;

                for (Vertex vertex : graph.getVertex()) {
                    vertex.setSelected(false);

                }
            }

            this.cleanImage();
            this.repaint();
        }

        @Override
        public void setFont(java.awt.Font font) {
            //
        }

        @Override
        public java.awt.Font getFont() {
            return null;// colocar alguma fonte
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);

        }
        private java.awt.Color color = java.awt.Color.RED;
        //Used to color based on a document
        private Vertex markedVertex;
        //Used to move the points
        private Vertex selectedVertex;
        //contain the selected vertices which will be moved
        private ArrayList<Vertex> selectedVertices;
        //The image which will be drawn as a graph
        private BufferedImage imageBuffer;
    }
    private ViewPanel view;
    private Graph graph;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JMenuItem MIAGM;
    private javax.swing.JMenuItem MIBusca;
    private javax.swing.JMenuItem MICamMin;
    private javax.swing.JMenuItem MIColor;
    private javax.swing.JMenuItem MICompConex;
    private javax.swing.JMenuItem MIConex;
    private javax.swing.JMenuItem MICriarGrafos;
    private javax.swing.JMenuItem MIHelp;
    private javax.swing.JMenuItem MIOrdemTop;
    private javax.swing.JMenuItem MITransp;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
