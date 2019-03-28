/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrador
 */
public class Mapa extends javax.swing.JPanel{
    static public Circulo[] dnodo=new Circulo[50];
    public Mapa(){    
        this.setSize(689,712);
    }
    
    

    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/AlamedaCentralP.jpg"));        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        setOpaque(false);
        super.paintComponent(g);
        //Aqui comienza dibujar Nodos
        dnodo[0]=new Circulo(675,75);
        dnodo[0].setEtiqueta("1");
        dnodo[0].dibujarCirculo(g);
        dnodo[1]=new Circulo(625,93);
        dnodo[1].setEtiqueta("2");
        dnodo[1].dibujarCirculo(g);        
        dnodo[2]=new Circulo(523,75);
        dnodo[2].setEtiqueta("3");
        dnodo[2].dibujarCirculo(g);
        dnodo[3]=new Circulo(407,55);
        dnodo[3].setEtiqueta("4");
        dnodo[3].dibujarCirculo(g);
        dnodo[4]=new Circulo(360,47);
        dnodo[4].setEtiqueta("5");
        dnodo[4].dibujarCirculo(g);
        dnodo[5]=new Circulo(613,176);
        dnodo[5].setEtiqueta("6");
        dnodo[5].dibujarCirculo(g);
        dnodo[6]=new Circulo(527,160);
        dnodo[6].setEtiqueta("7");
        dnodo[6].dibujarCirculo(g);
        dnodo[7]=new Circulo(497,155);
        dnodo[7].setEtiqueta("8");
        dnodo[7].dibujarCirculo(g);
        dnodo[8]=new Circulo(428,144);
        dnodo[8].setEtiqueta("9");
        dnodo[8].dibujarCirculo(g);
        dnodo[9]=new Circulo(392,137);
        dnodo[9].setEtiqueta("10");
        dnodo[9].dibujarCirculo(g);
        dnodo[10]=new Circulo(347,130);
        dnodo[10].setEtiqueta("11");
        dnodo[10].dibujarCirculo(g);
        dnodo[11]=new Circulo(605,260);
        dnodo[11].setEtiqueta("12");
        dnodo[11].dibujarCirculo(g);
        dnodo[12]=new Circulo(480,270);
        dnodo[12].setEtiqueta("13");
        dnodo[12].dibujarCirculo(g);
        dnodo[13]=new Circulo(490,238);
        dnodo[13].setEtiqueta("14");
        dnodo[13].dibujarCirculo(g);
        dnodo[14]=new Circulo(415,223);
        dnodo[14].setEtiqueta("15");
        dnodo[14].dibujarCirculo(g);
        dnodo[15]=new Circulo(330,247);
        dnodo[15].setEtiqueta("16");
        dnodo[15].dibujarCirculo(g);
        dnodo[16]=new Circulo(332,207);
        dnodo[16].setEtiqueta("17");
        dnodo[16].dibujarCirculo(g);
        dnodo[17]=new Circulo(152,208);
        dnodo[17].setEtiqueta("18");
        dnodo[17].dibujarCirculo(g);
        dnodo[18]=new Circulo(54,195);
        dnodo[18].setEtiqueta("19");
        dnodo[18].dibujarCirculo(g);
        dnodo[19]=new Circulo(478,332);
        dnodo[19].setEtiqueta("20");
        dnodo[19].dibujarCirculo(g);
        dnodo[20]=new Circulo(320,308);
        dnodo[20].setEtiqueta("21");
        dnodo[20].dibujarCirculo(g);
        dnodo[21]=new Circulo(143,282);
        dnodo[21].setEtiqueta("22");
        dnodo[21].dibujarCirculo(g);
        dnodo[22]=new Circulo(110,297);
        dnodo[22].setEtiqueta("23");
        dnodo[22].dibujarCirculo(g);
        dnodo[23]=new Circulo(43,287);
        dnodo[23].setEtiqueta("24");
        dnodo[23].dibujarCirculo(g);
        dnodo[24]=new Circulo(587,437);
        dnodo[24].setEtiqueta("25");
        dnodo[24].dibujarCirculo(g);
        dnodo[25]=new Circulo(510,427);
        dnodo[25].setEtiqueta("26");
        dnodo[25].dibujarCirculo(g);
        dnodo[26]=new Circulo(473,400);
        dnodo[26].setEtiqueta("27");
        dnodo[26].dibujarCirculo(g);
        dnodo[27]=new Circulo(435,420);
        dnodo[27].setEtiqueta("28");
        dnodo[27].dibujarCirculo(g);
        dnodo[28]=new Circulo(400,416);
        dnodo[28].setEtiqueta("29");
        dnodo[28].dibujarCirculo(g);
        dnodo[29]=new Circulo(308,375);
        dnodo[29].setEtiqueta("30");
        dnodo[29].dibujarCirculo(g);
        dnodo[30]=new Circulo(228,395);
        dnodo[30].setEtiqueta("31");
        dnodo[30].dibujarCirculo(g);
        dnodo[31]=new Circulo(150,385);
        dnodo[31].setEtiqueta("32");
        dnodo[31].dibujarCirculo(g);
        dnodo[32]=new Circulo(133,358);
        dnodo[32].setEtiqueta("33");
        dnodo[32].dibujarCirculo(g);
        dnodo[33]=new Circulo(85,378);
        dnodo[33].setEtiqueta("34");
        dnodo[33].dibujarCirculo(g);
        dnodo[34]=new Circulo(33,373);
        dnodo[34].setEtiqueta("35");
        dnodo[34].dibujarCirculo(g);
        dnodo[35]=new Circulo(568,585);
        dnodo[35].setEtiqueta("36");
        dnodo[35].dibujarCirculo(g);
        dnodo[36]=new Circulo(492,575);
        dnodo[36].setEtiqueta("37");
        dnodo[36].dibujarCirculo(g);
        dnodo[37]=new Circulo(419,567);
        dnodo[37].setEtiqueta("38");
        dnodo[37].dibujarCirculo(g);
        dnodo[38]=new Circulo(384,564);
        dnodo[38].setEtiqueta("39");
        dnodo[38].dibujarCirculo(g);
        dnodo[39]=new Circulo(211,542);
        dnodo[39].setEtiqueta("40");
        dnodo[39].dibujarCirculo(g);
        dnodo[40]=new Circulo(132,531);
        dnodo[40].setEtiqueta("41");
        dnodo[40].dibujarCirculo(g);
        dnodo[41]=new Circulo(68,522);
        dnodo[41].setEtiqueta("42");
        dnodo[41].dibujarCirculo(g);
        dnodo[42]=new Circulo(15,517);
        dnodo[42].setEtiqueta("43");
        dnodo[42].dibujarCirculo(g);
        dnodo[43]=new Circulo(555,677);
        dnodo[43].setEtiqueta("44");
        dnodo[43].dibujarCirculo(g);
        dnodo[44]=new Circulo(480,668);
        dnodo[44].setEtiqueta("45");
        dnodo[44].dibujarCirculo(g);
        dnodo[45]=new Circulo(405,659);
        dnodo[45].setEtiqueta("46");
        dnodo[45].dibujarCirculo(g);
        dnodo[46]=new Circulo(360,653);
        dnodo[46].setEtiqueta("47");
        dnodo[46].dibujarCirculo(g);
        dnodo[47]=new Circulo(200,633);
        dnodo[47].setEtiqueta("48");
        dnodo[47].dibujarCirculo(g);
        dnodo[48]=new Circulo(120,624);
        dnodo[48].setEtiqueta("49");
        dnodo[48].dibujarCirculo(g);
        dnodo[49]=new Circulo(5,610);
        dnodo[49].setEtiqueta("50");
        dnodo[49].dibujarCirculo(g);
        /*Circulo prueba=new Circulo(50,50);
        prueba.setEtiqueta("prueba");
        prueba.dibujarCirculo(g);*/      
}
    
}
