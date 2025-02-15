package Interface;

import Grafos.Grafo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Edge {

    private Color color = Color.BLACK; //Cor da aresta
    private Vertex source; //primeiro vetice da aresta
    private Vertex target; //segundo vertice da aresta
    private Boolean directed = false; //se a aresta é direcionada
    private Boolean selected = false; //se a aresta está selecionada

    public Edge(Vertex source, Vertex target) {
        this.source = source;
        this.target = target;
    }

    public void draw(java.awt.Graphics2D g2) {
        //Combines the color of the two vertex to paint the edge

        if (selected) {
            g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
            g2.setStroke(new java.awt.BasicStroke(3.0f));
        } else {
            g2.setStroke(new java.awt.BasicStroke(1.0f));
            if ((this.target.isSelected() && this.source.isSelected())) { //se os vertices estao selecionados
                g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.5f));
            } else {//se os vertices nao estao selecionados
                g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.2f));
            }
        }

        this.color = new Color((this.source.getColor().getRed() + this.target.getColor().getRed()) / 2,
                (this.source.getColor().getGreen() + this.target.getColor().getGreen()) / 2,
                (this.source.getColor().getBlue() + this.target.getColor().getBlue()) / 2);

        g2.setColor(this.color);

        g2.drawLine(((int) this.source.getX()), ((int) this.source.getY()),
                ((int) this.target.getX()), ((int) this.target.getY()));
        g2.setStroke(new java.awt.BasicStroke(1.0f));

        if (isDirected()) {
            drawArrow(g2, new Point((int) source.getX(), (int) source.getY()),
                    new Point((int) target.getX(), (int) target.getY()),
                    6.0f);
        }
//        if (Grafo.ponderado) {
//            drawText(g2, new Point((int) source.getX(), (int) source.getY()),
//                    new Point((int) target.getX(), (int) target.getY()),
//                    Integer.toString(Grafo.matriz[this.source.getID()][this.target.getID()]),
//                    70);
//        }
        g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1.0f));
    }

    private void drawText(Graphics2D g2, Point s, Point t, String text, int deslocamento) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / r;
        float sen = (t.y - s.y) / r;

        Point pc = new Point(Math.round(deslocamento * -cos) + t.x, Math.round(deslocamento * -sen) + t.y);

        g2.setColor(Color.BLACK);
        g2.rotate(Math.acos(cos), pc.x, pc.y);
        g2.drawString(text, pc.x, pc.y);
        g2.rotate(-Math.acos(cos), pc.x, pc.y);
    }

    private void drawArrow(Graphics2D g2, Point s, Point t, float size) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));
        float cos = (t.x - s.x) / (r);
        float sen = (t.y - s.y) / (r);

        //rotação e translação
        int transX = (int) ((t.x + s.x) * 0.5f); //metade da reta
        int transY = (int) ((t.y + s.y) * 0.5f); //metade da reta

        Point pa = new Point(Math.round(-sen * size) + (transX), Math.round(cos * size) + (transY));
        Point pb = new Point(Math.round(-sen * -size) + (transX), Math.round(cos * -size) + (transY));
        Point pc = new Point(Math.round(cos * size) + (transX), Math.round(sen * size) + (transY));

        g2.drawLine(pa.x, pa.y, pc.x, pc.y);
        g2.drawLine(pb.x, pb.y, pc.x, pc.y);

        g2.setFont(new Font("Verdana", Font.BOLD, 10));
        java.awt.FontMetrics metrics = g2.getFontMetrics(g2.getFont());
//        g2.drawString("T", pc.x, pc.y);
    }

    public Boolean isDirected() {
        return directed;
    }

    public void setDirected(Boolean directed) {
        this.directed = directed;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }
    
    
}
