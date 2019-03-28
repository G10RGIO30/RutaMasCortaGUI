/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class VisorNodos extends JPanel {
    static String ruta="/Imagenes/Nodo";
    static int nodo;
    
    private JList List1;
    private JLabel etqImagen;
    private JLabel etqURLImagen;
    private JButton botonCarga;
    private JButton Anterior;
    private JScrollPane Scroll;
    public VisorNodos() {
        String[] nodos={"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez"
                     ,"Once","Doce","Trece","Catorce","Quince","Diecisés","Diecisiete","Dieciocho","Diecinueve","Veinte"
                     ,"Veintiuno","Veintidos","Veintitres","Veinticuatro","Veinticinco","Veintiseis","Veintisiete","Veintiocho","Veintinueve","Treinta"
                     ,"Treinta y Uno","Treinta y Dos","Treinta y Tres","Treinta y Cuatro","Treinta y Cinco","Treinta y Seis","Treinta y Siete","Treinta y Ocho","Treinta y Nueve","Cuarenta"
                     ,"Cuarenta y Uno","Cuarenta y Dos","Cuarenta y Tres","Cuarenta y Cuatro","Cuarenta y Cinco","Cuarenta y Seis","Cuarenta y Siete","Cuarenta y Ocho","Cuarenta y Nueve","Cincuenta"};
        this.List1 = new JList(nodos);
        this.List1.setVisibleRowCount(1);
        this.Scroll = new JScrollPane(List1);
        this.List1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.etqURLImagen = new JLabel("Seleccione un nodo: ");
        this.botonCarga = new JButton("Cargar imagen");
        this.Anterior = new JButton("Regresar a la ventana anterior...");
        this.botonCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                nodo=List1.getSelectedIndex()+1;
                ruta=ruta+nodo+".JPG";
                iniciaCargaImagen();
            }
        });
        this.Anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                GUI.VentanaEmergente.setVisible(false);
                GUI.Superior.setVisible(true);
            }
        });
        this.setLayout(new BorderLayout());
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new BorderLayout(10, 10));
        panelControles.add(this.etqURLImagen,BorderLayout.WEST);
        panelControles.add(this.Scroll,BorderLayout.CENTER);
        panelControles.add(this.botonCarga,BorderLayout.EAST);
        panelControles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelControles.add(this.Anterior,BorderLayout.PAGE_END);
        this.add(panelControles, BorderLayout.NORTH);
        this.etqImagen = new JLabel("<HTML><div align='center'>"+"No hay imagen cargada<BR><BR>"+"Seleccione un nodo y pulsa cargar</div>");
        this.etqImagen.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane sp = new JScrollPane(this.etqImagen);
        this.add(sp, BorderLayout.CENTER);
    }
    protected void iniciaCargaImagen() {
        this.botonCarga.setEnabled(false);
        this.etqImagen.setText("Cargando imagen");
        cargaImagen(ruta);
    }
    protected void cargaImagen(String path) {
        final Icon icono;
        
            icono = new ImageIcon(getClass().
                getResource(ruta));
        ruta="/Imagenes/Nodo";
            
        etqImagen.setText("");
        etqImagen.setIcon(icono);
        botonCarga.setEnabled(true);
    }
    
}