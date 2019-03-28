/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrador
 */
public class DibujarRuta  extends javax.swing.JPanel {
    Circulo origen;
    Circulo destino;
    int ox,oy,dx,dy;
    DibujarRuta(int cxco,int cyco,int cxcd,int cycd){
        this.setSize(689,712);
        ox=cxco; oy=cyco; dx=cxcd; dy=cycd;
    }
    
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/AlamedaCentralP.jpg"));        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        setOpaque(false);
        super.paintComponent(g);
        origen=new Circulo(ox,oy);
        origen.setColor(Color.red);
        origen.setEtiqueta("Usted está aquí");
        origen.dibujarCirculo(g);
        destino=new Circulo(dx,dy);
        destino.setColor(Color.GREEN);
        destino.setEtiqueta("Se dirige aquí");
        destino.dibujarCirculo(g);
        g.setColor(Color.BLUE);
        for(int w=0;w<Dijkstra.recorridos-1;w++){
            int src,dest,x1,x2,y1,y2;
            src=GUI.split[w];
            dest=GUI.split[w+1];
            x1=Mapa.dnodo[src-1].getX();
            y1=Mapa.dnodo[src-1].getY();
            x2=Mapa.dnodo[dest-1].getX();
            y2=Mapa.dnodo[dest-1].getY();
            g.drawLine(x1, y1, x2, y2);
        }
        
}
     
    
}
