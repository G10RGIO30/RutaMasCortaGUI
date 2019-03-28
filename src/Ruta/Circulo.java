/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Administrador
 */
public class Circulo {
    // instance variables - replace the example below with your own
    int x,y;
    private Color color;
    private int diametro;
    private String etiqueta;
    private Font fuente;
    private int izquierda;
    private int grosorBorde;
    /**
     * Constructor for objects of class Circulo
     */
    public Circulo(int x, int y){
        // initialise instance variables
        this.x=x; this.y=y;
        color = Color.yellow;
        diametro = 10;
        etiqueta = "";
        fuente = null;
        izquierda = 0;
        grosorBorde = 2;
    }
    public void dibujarCirculo(Graphics g){
            ((Graphics2D)g).setColor(color);

            ((Graphics2D)g).setStroke(new BasicStroke(getGrosorBorde()));

            ((Graphics2D)g).fillOval(x,y,diametro,diametro);
            ((Graphics2D)g).setColor(Color.black);
            ((Graphics2D)g).drawOval(x,y,diametro,diametro);
            if(!"".equals(etiqueta)){
                if(fuente != null){
                    g.setFont(fuente);
                }

                    ((Graphics2D)g).drawString(etiqueta,x - (izquierda),y);


                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
            }
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public void setDiametro(int diametro){
        this.diametro = diametro;
    }
    public int getDiametro(){
        return diametro;
    }
    public void setEtiqueta(String etiqueta){
        this.etiqueta= etiqueta;
    }
    public void setEtiqueta(String etiqueta,boolean izquierda){
        this.etiqueta= etiqueta;
    }
    public String getEtiqueta(){
        return etiqueta;
    }
    
    public int getX(){
        if(x >0 && y > 0){
            return x;
        }else{
            return -1;
        }
    }
    public int getY(){
        if(x >0 && y > 0){
            return y;
        }else{
            return -1;
        }
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }

    public int isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(int izquierda) {
        this.izquierda = izquierda;
    }

    public int getGrosorBorde() {
        return grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = grosorBorde;
    }
    
}
