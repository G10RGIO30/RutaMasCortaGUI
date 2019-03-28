/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

/**
 *
 * @author Administrador
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Administrador
 */
public class GUI extends JFrame implements ActionListener {
    static String path="Data1.txt";
    static int source=0;
    static int destination=0;
    int j=0;
    static int[] split;
    Mapa ruta=new Mapa();
    static VisorNodos View=new VisorNodos();
    static DibujarRuta Trayecto;
    Archivo Croquis=new Archivo();
    //---------------------------------------------
    private JDesktopPane Ventana=new JDesktopPane();
    static public JFrame VentanaEmergente=new JFrame();
    JInternalFrame frame = new JInternalFrame("App",true,true,true,true);
    static JFrame Superior=new JFrame();
    private JLabel Etq1;
    static JPanel principal=new JPanel();
    private JLabel Origen;
    private JTextPane Direccion=new JTextPane();
    private JLabel Destino;
    private JLabel Ruta;
    private JList List1;
    private JList List2;
    private JButton OK;
    private JButton GRuta;
    private JButton Ver;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void crearGUI() {
        //----------------------------------------
        //super("InternalFrameDemo");
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int AnchoPreferible=1250;
        int AltoPreferible=900;
        int inset = 50;
        OK=new JButton("Generar Ruta");
        GRuta=new JButton("Guardar ruta");
        Ver=new JButton("Ver Nodos");
        GRuta.setVisible(true);
        String[] nodos={"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez"
                     ,"Once","Doce","Trece","Catorce","Quince","Diecisés","Diecisiete","Dieciocho","Diecinueve","Veinte"
                     ,"Veintiuno","Veintidos","Veintitres","Veinticuatro","Veinticinco","Veintiseis","Veintisiete","Veintiocho","Veintinueve","Treinta"
                     ,"Treinta y Uno","Treinta y Dos","Treinta y Tres","Treinta y Cuatro","Treinta y Cinco","Treinta y Seis","Treinta y Siete","Treinta y Ocho","Treinta y Nueve","Cuarenta"
                     ,"Cuarenta y Uno","Cuarenta y Dos","Cuarenta y Tres","Cuarenta y Cuatro","Cuarenta y Cinco","Cuarenta y Seis","Cuarenta y Siete","Cuarenta y Ocho","Cuarenta y Nueve","Cincuenta"};
        List1 = new JList(nodos);
        List1.setVisibleRowCount(5);
        JScrollPane Scroll = new JScrollPane(List1);
        List1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        List2 = new JList(nodos);
        List2.setVisibleRowCount(5);
        JScrollPane Scroll2 = new JScrollPane(List2);
        List2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Direccion.setEditable(false);
        Direccion.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        JScrollPane scroll2 = new JScrollPane(Direccion);
        scroll2.setBounds(new Rectangle(50,350,350,150));
        
        if(screenSize.getHeight()>AltoPreferible+100 && screenSize.getWidth()>AnchoPreferible+100){
           Superior.setSize(AnchoPreferible+100, AltoPreferible+100); 
        }else{
            Superior.setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
        }
        
		frame.setBackground(Color.darkGray);
                principal.setLayout(null);
		principal.setPreferredSize(new Dimension(1250,900));
                principal.setBackground(Color.LIGHT_GRAY);
                principal.add(scroll2);
        principal.add(OK);
        principal.add(GRuta);
        principal.add(Ver);
        Ver.setLocation(150, 600);
        Ver.setSize(150, 30);
        OK.setLocation(150, 260);
        OK.setSize(150, 30);
        GRuta.setLocation(150, 510);
        GRuta.setSize(150, 30);
        GRuta.addActionListener(this);
        OK.addActionListener(this);
        Ver.addActionListener(this);
        principal.add(Scroll);
        Scroll.setLocation(50, 50);
        Scroll.setSize(150, 200);
        principal.add(Scroll2);
        Scroll2.setLocation(250, 50);
        Scroll2.setSize(150, 200);
        principal.add(ruta);
        ruta.setLocation(500, 50);
        Etq1=new JLabel("Mapa");
        principal.add(Etq1);
        Etq1.setFont(new java.awt.Font("Tahoma", 1, 36));
        Etq1.setLocation(750, -25);
        Etq1.setSize(100, 100); 
        Origen=new JLabel("Seleccione origen");
        principal.add(Origen);
        Origen.setFont(new java.awt.Font("Tahoma", 1, 16));
        Origen.setLocation(50, -20);
        Origen.setSize(150, 100);
        Destino=new JLabel("Seleccione destino");
        principal.add(Destino);
        Destino.setFont(new java.awt.Font("Tahoma", 1, 16));
        Destino.setLocation(250, -20);
        Destino.setSize(160, 100);
        Ruta=new JLabel("Su camino a seguir...");
        principal.add(Ruta);
        Ruta.setForeground(Color.red);
        Ruta.setFont(new java.awt.Font("Tahoma", 1, 20));
        Ruta.setLocation(50, 270);
        Ruta.setSize(250, 100);
		//JScrollPane pane=new JScrollPane(principal,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//pane.setPreferredSize(principal.getPreferredSize());
		frame.add(principal/*pane*/);
                frame.setVisible(true);
                Ventana.add(frame);
                Superior.getContentPane().add(Ventana,BorderLayout.CENTER);
                Superior.setPreferredSize(new Dimension(1250,900));
                JScrollPane pane2=new JScrollPane(frame,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                Superior.add(pane2);
                Superior.setVisible(true);
                Superior.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
                //JFrame.setDefaultLookAndFeelDecorated(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 GUI scrollPaneTest = new GUI();
        scrollPaneTest.crearGUI();
        System.out.println("Alto: "+screenSize.getHeight()+" Ancho: "+screenSize.getWidth());
            }
        });
       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
       if(event.getSource() == OK)
         {
         source=List1.getSelectedIndex()+1;
        destination=List2.getSelectedIndex()+1;
             System.out.println("Origen: "+source+" Destino: "+destination);
             Dijkstra Camino=new Dijkstra(path);
             for( int i = 0 ; i <= Dijkstra.V ; ++i ) {Dijkstra.ady.add(new ArrayList<Dijkstra.Node>()) ;}
             Camino.CrearNodos();
             Dijkstra.dijkstra(source,destination);
             int cxo,cyo,cxd,cyd;
             System.out.println("Nodos Recorridos: "+Dijkstra.recorridos);
             cxo=Mapa.dnodo[source-1].getX();
             cyo=Mapa.dnodo[source-1].getY();
             cxd=Mapa.dnodo[destination-1].getX();
             cyd=Mapa.dnodo[destination-1].getY();
             ruta.setVisible(false);
             //----------------Preparando---------------------------------------
            String [] cam = Dijkstra.sruta.split("\\,+");//ruta.split("\\,+");
            split = new int[Dijkstra.recorridos];
            for(int k=0;k<Dijkstra.recorridos;k++){
                split[k]=Integer.parseInt(cam[k+1]);
            }
            String [] Dir=new String[Dijkstra.recorridos-1];
            for(int r=0;r<Dijkstra.recorridos-1;r++){
                Dir[r]=Dijkstra.ObtenerDireccion(split[r], split[r+1]);
            }
             //-----------------------------------------------------------------
             Trayecto=new DibujarRuta(cxo,cyo,cxd,cyd);
             principal.add(Trayecto);
             Trayecto.setLocation(500, 50);
             //Direccion.setText(Direccion.getText()+"\nEl botón ha sido apretado.\n* "+Dijkstra.ObtenerDireccion(3,2)+"\n* "+Dijkstra.ObtenerDireccion(1,2)+"\n* "+Dijkstra.ObtenerDireccion(2,6));
             for(int s=0;s<Dijkstra.recorridos-1;s++){
                 Direccion.setText(Direccion.getText()+"\n* "+Dir[s]);
             }
    }
        else if(event.getSource() == GRuta){
            Croquis.GuardarComo(Direccion.getText());
            System.out.println("Ruta"+Croquis.RutaImagen.getAbsolutePath());
            File fichero = new File(Croquis.RutaImagen.getAbsolutePath()+".jpg");
		String formato = "jpg";
                BufferedImage imagen = new BufferedImage(Trayecto.getWidth(),
				Trayecto.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics g = imagen.getGraphics();
                Trayecto.paint(g);
                try {
			ImageIO.write(imagen, formato, fichero);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
	}
       
        else if(event.getSource() == Ver){
            /*principal.setVisible(false);
             frame.add(View);
             View.setLocation(50, 50);
             View.setVisible(true);
            frameE.setVisible(true);*/
            //VentanaEmergente.setSize(Superior.getSize());
            VentanaEmergente.setBounds(Superior.getBounds());
            //Ventana.removeAll();
            Superior.setVisible(false);
            VentanaEmergente.setVisible(true);
            VentanaEmergente.add(View);
            //VentanaEmergente.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    
}