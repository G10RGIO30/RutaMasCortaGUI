/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrador
 */
public class Archivo {
    File RutaImagen;
    private JFileChooser fileChooser;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto","txt");
        private File file = null;

    private boolean isopen =false;//bandera de control para saber si se abrio un archivo
    private ArrayList contenido = new ArrayList();//almacena los registros leidos de *.txt
    //controles swing
    
    public void GuardarComo(String texto)
    {       
       fileChooser = new JFileChooser();
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){
                this.isopen = false;
                this.contenido.clear();
                //this.index=1;
                if ( escribir( fileChooser.getSelectedFile(),  texto) )
                {
                    JOptionPane.showMessageDialog(null, "Archivo '" + fileChooser.getSelectedFile().getName() + "' guardado ");
                    this.isopen=true;
                    RutaImagen=fileChooser.getSelectedFile();
                }
        }
    }
    
    private boolean escribir(File fichero, String texto)
    {
        boolean res=false;        
        PrintWriter writer = null;
        try {
            String f = fichero.toString();
            //verifica que extension exista sino lo agrega
            if(!f.substring( f.length()-4, f.length()).equals(".txt") )
            {
                f = f + ".txt";
                fichero = new File(f);
            }            
            writer = new PrintWriter( fichero );
            //si hay un archivo abierto
            if( this.isopen )
            {   //añade primero linea por linea conenido anterior
                Iterator It = contenido.iterator();
                while (It.hasNext())
                {
                    writer.println( It.next() );
                }
                //se añade fila de texto al archivo
                writer.println( texto );
                this.contenido.add(texto);
            }
            else //esta guardando por primera vez
            {
                this.contenido.add(texto);
                writer.println( texto );    
            }            
            this.file = fichero;
            writer.close();            
            res = true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            writer.close();
        }
        return res;
    }
    
}
