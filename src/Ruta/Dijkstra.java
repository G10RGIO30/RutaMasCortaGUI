/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

/**
 *
 * @author Administrador
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Dijkstra{
    int E , origen, destino , peso , inicial;
    ArrayList<int[]> matrix=new ArrayList();
    static List< List< Node > > ady = new ArrayList<  >();
    static Scanner sc = new Scanner( System.in );
    static int recorridos=0;
    static final int MAX = 10005;  //maximo numero de vértices
    static final int INF = 5000; 
    static String path="C:\\Data1.txt";
    Dijkstra(String path) {
        try{
             BufferedReader bis=new BufferedReader(new FileReader(path));
             String input;
        while((input=bis.readLine())!=null){
              String[] s=input.split("\\s");
              int[] rows= new int[s.length];
        for(int i=0;i<s.length;i++){ 
            rows[i]=Integer.parseInt(s[i]);
            }
            matrix.add(rows);
         }
}catch( IOException | NumberFormatException ex){
System.out.println(ex);
}
}
    //--------------------------------------------------------------------------
    static int distancia[ ] = new int[ MAX ];          //distancia[ u ] distancia de vértice inicial a vértice con ID = u
	static boolean visitado[ ] = new boolean[ MAX ];   //para vértices visitados
	static PriorityQueue< Node > Q = new PriorityQueue<>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope
	static int V=50;                                      //numero de vertices
	static int previo[] = new int[ MAX ];              //para la impresion de caminos
        static String sruta="";
        static int ruta[];
    static class Node implements Comparable<Node>{
		int first, second;
		Node( int d , int p ){							//constructor
			this.first = d;
			this.second = p;
		}
        @Override
		public int compareTo( Node other){				//es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
			if( second > other.second ) {return 1;}
			if( second == other.second ) {return 0;}
			return -1;
		}
	};
    //--------------------------------------------------------------------------
    //función de inicialización
	static void init(){
	    for( int i = 0 ; i <= V ; ++i ){
	        distancia[ i ] = INF;  //inicializamos todas las distancias con valor infinito
	        visitado[ i ] = false; //inicializamos todos los vértices como no visitados
	        previo[ i ] = -1;      //inicializamos el previo del vertice i con -1
	    }
	}

	//Paso de relajacion
	static void relajacion( int actual , int adyacente , int peso ){
	    //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
	    if( distancia[ actual ] + peso < distancia[ adyacente ] ){
	        distancia[ adyacente ] = distancia[ actual ] + peso;  //relajamos el vertice actualizando la distancia
	        previo[ adyacente ] = actual;                         //a su vez actualizamos el vertice previo
	        Q.add( new Node( adyacente , distancia[ adyacente ] ) ); //agregamos adyacente a la cola de prioridad
	    }
	}

	//Impresion del camino mas corto desde el vertice inicial y final ingresados
	static void print( int destino ){
	    if( previo[ destino ] != -1 )    //si aun poseo un vertice previo
            {print( previo[ destino ] );}  //recursivamente sigo explorando
	    System.out.printf("%d " , destino );        //terminada la recursion imprimo los vertices recorridos
            sruta=sruta+","+destino;
            recorridos=recorridos+1;
	}
        
	
	 static void dijkstra( int inicial,int destino ){
	    init(); //inicializamos nuestros arreglos
	    Q.add( new Node( inicial , 0 ) ); //Insertamos el vértice inicial en la Cola de Prioridad
	    distancia[ inicial ] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0
	    int actual , adyacente , peso;
	    while( !Q.isEmpty() ){                   //Mientras cola no este vacia
	        actual = Q.element().first;            //Obtengo de la cola el nodo con menor peso, en un comienzo será el inicial
	        Q.remove();                           //Sacamos el elemento de la cola
	        if( visitado[ actual ] ) {continue;} //Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola
	        visitado[ actual ] = true;         //Marco como visitado el vértice actual

	        for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ //reviso sus adyacentes del vertice actual
	            adyacente = ady.get( actual ).get( i ).first;   //id del vertice adyacente
	            peso = ady.get( actual ).get( i ).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )
	            if( !visitado[ adyacente ] ){        //si el vertice adyacente no fue visitado
	                relajacion( actual , adyacente , peso ); //realizamos el paso de relajacion
	            }
	        }
	    }

	    System.out.println("\n**************Impresion de camino mas corto**************");
	    print( destino );
	    System.out.printf("\n");
            System.out.println("Distancia: "+distancia[destino]);
	}
    //--------------------------------------------------------------------------
    public void CrearNodos(){
for(int i=0;i<matrix.size();i++){
int[] show=matrix.get(i);
for(int j=0;j<show.length;j++){
origen = i+1; destino = j+1; peso = show[j];
ady.get( origen ).add( new Node( destino , peso ) );
}
}
}
    
    public static String ObtenerDireccion(int origen,int destino){
        String dir="";
        if(origen==1 && destino==2 || origen==2 && destino==1){
            dir="Cruce con cuidado Eje Central Lázaro Cárdenas";
        }
        else if(origen==2 && destino==3){
            dir="Camine 160 metros sobre Pensador Mexicano hasta la calle 2 de Abril";
        }
        else if(origen==3 && destino==2){
            dir="Camine 160 metros sobre Pensador Mexicano hasta Eje Central Lázaro Cárdenas";
        }
        else if(origen==2 && destino==6){
            dir="Camine 97 metros sobre Eje Central Lázaro Cárdenas hasta la Av. Santa Veracruz";
        }
        else if(origen==6 && destino==2){
            dir="Camine 97 metros sobre Eje Central Lázaro Cárdenas hasta Pensador Mexicano";
        }
        else if(origen==3 && destino==4){
            dir="Camine 130 metros sobre Pensador Mexicano hasta el 2° Callejón de San Juan de Dios";
        }
        else if(origen==4 && destino==3){
            dir="Camine 130 metros sobre Pensador Mexicano hasta la calle 2 de Abril";
        }
        else if(origen==3 && destino==8){
            dir="Camine 92 metros sobre 2 de Abril hasta la Av. Santa Veracruz";
        }
        else if(origen==8 && destino==3){
            dir="Camine 92 metros sobre 2 de Abril hasta Pensador Mexicano";
        }
        else if(origen==4 && destino==5){
            dir="Camine 58 metros sobre Pensador Mexicano hasta la Av. Trujano";
        }
        else if(origen==5 && destino==4){
            dir="Camine 58 metros sobre Pensador Mexicano hasta el 2° Callejón de San Juan de Dios";
        }
        else if(origen==4 && destino==10){
            dir="Camine 87 metros sobre el 2° Callejón de San Juan de Dios hasta la Av. Santa Veracruz";
        }
        else if(origen==10 && destino==4){
            dir="Camine 87 metros sobre el 2° Callejón de San Juan de Dios hasta Pensador Mexicano";
        }
        else if(origen==5 && destino==11){
            dir="Camine 87 metros sobre la Av. Trujano hasta la Av. Santa Veracruz";
        }
        else if(origen==11 && destino==5){
            dir="Camine 87 metros sobre la Av. Trujano hasta Pensador Mexicano";
        }
        else if(origen==6 && destino==7){
            dir="Camine 150 metros sobre la Av. Santa Veracruz hasta la calle 2 de Abril";
        }
        else if(origen==7 && destino==6){
            dir="Camine 150 metros sobre la Av. Santa Veracruz hasta Eje Central Lázaro Cárdenas";
        }
        else if(origen==6 && destino==12){
            dir="Camine 90 metros sobre Eje Central Lázaro Cárdenas hasta la Av. Hidalgo";
        }
        else if(origen==12 && destino==6){
            dir="Camine 90 metros sobre Eje Central Lázaro Cárdenas hasta la Av. Santa Veracruz";
        }
        else if(origen==7 && destino==8){
            dir="Camine 20 metros sobre la Av. Santa Veracruz";
        }
        else if(origen==8 && destino==7){
            dir="Camine 20 metros sobre la Av. Santa Veracruz";
        }
        else if(origen==7 && destino==14){
            dir="Camine 90 metros sobre la calle 2 de Abril hasta la Av. Hidalgo";
        }
        else if(origen==14 && destino==7){
            dir="Camine 90 metros sobre la calle 2 de Abril hasta la Av. Santa Veracruz";
        }
        else if(origen==8 && destino==9){
            dir="Camine 81 metros sobre la calle 2 de Abril hasta el 1° Callejón de San Juan de Dios";
        }
        else if(origen==9 && destino==8){
            dir="Camine 81 metros sobre la calle 2 de Abril hasta la calle 2 de Abril";
        }
        else if(origen==9 && destino==10){
            dir="Camine 42 metros sobre el 1° Callejón de San Juan de Dios hasta el 2° Callejón de San Juan de Dios";
        }
        else if(origen==10 && destino==9){
            dir="Camine 42 metros sobre el 2° Callejón de San Juan de Dios hasta el 1° Callejón de San Juan de Dios";
        }
        else if(origen==9 && destino==15){
            dir="Camine 89 metros sobre el 1° Callejón de San Juan de Dios hasta la Av. Hidalgo";
        }
        else if(origen==15 && destino==9){
            dir="Camine 89 metros sobre el 1° Callejón de San Juan de Dios hasta la Av. Santa Veracruz";
        }
        else if(origen==10 && destino==11){
            dir="Camine 62 metros sobre la Av. Santa Veracruz hasta la Av. Trujano";
        }
        else if(origen==11 && destino==10){
            dir="Camine 62 metros sobre la Av. Santa Veracruz hasta el 1° Callejón de San Juan de Dios";
        }
        else if(origen==11 && destino==17){
            dir="Camine 89 metros sobre la Av. Trujano hasta la Av. Hidalgo";
        }
        else if(origen==17 && destino==11){
            dir="Camine 89 metros sobre la Av. Trujano hasta la Av. Santa Veracruz";
        }
        else if(origen==12 && destino==13){
            dir="Camine 140 metros sobre la Av. Hidalgo hasta la calle Angela Peralta";
        }
        else if(origen==13 && destino==12){
                dir="Camine 140 metros sobre la Av. Hidalgo hasta el Eje Central Lázaro Cárdenas";
        }
        else if(origen==12 && destino==25){
            dir="Camine 210 metros sobre el Eje Central Lázaro Cárdenas hasta la Av. Júarez";
        }
        else if(origen==25 && destino==12){
            dir="Camine 210 metros sobre el Eje Central Lázaro Cárdenas hasta la Av. Hidalgo";
        }
        else if(origen==13 && destino==14){
            dir="Camine 10 metros sobre la Av. Hidalgo hasta la calle 2 de Abril";
        }
        else if(origen==14 && destino==13){
            dir="Camine 10 metros sobre la Av. Hidalgo hasta la la calle Angela Peralta";
        }
        else if(origen==13 && destino==20){
            dir="Camine 99 metros sobre la calle Angela Peralta hasta la entrada a la Alameda";
        }
        else if(origen==20 && destino==13){
            dir="Camine 99 metros sobre la calle Angela Peralta hasta la Av. Hidalgo";
        }
        else if(origen==13 && destino==21){
            dir="Entre a la Alameda camine 275 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==13){
            dir="Camine 275 metros hasta la calle Angela Peralta";
        }
        else if(origen==14 && destino==15){
            dir="Camine 130 metros sobre la Av. Hidalgo hasta el 2° Callejón de San Juan de Dios";
        }
        else if(origen==15 && destino==14){
            dir="Camine 130 metros sobre la Av. Hidalgo hasta la calle 2 de Abril";
        }
        else if(origen==15 && destino==16){
            dir="Camine 87 metros sobre la Av. Hidalgo hasta la siguiente entrada a la Alameda";
        }
        else if(origen==16 && destino==15){
            dir="Camine 87 metros sobre la Av. Hidalgo hasta el 2° Callejón de San Juan de Dios";
        }
        else if(origen==16 && destino==17){
            dir="Camine 22 metros sobre la Av. Hidalgo hasta la Av. Trujano";
        }
        else if(origen==17 && destino==16){
            dir="Camine 22 metros sobre la Av. Hidalgo hasta la siguiente entrada a la Alameda";
        }
        else if(origen==16 && destino==21){
            dir="Entre a la Alameda y camine 115 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==16){
            dir="Camine 155 metros hasta la Av. Hidalgo";
        }
        else if(origen==17 && destino==18){
            dir="Camine 210 metros sobre la Av. Hidalgo hasta la calle Dr. Mora";
        }
        else if(origen==18 && destino==17){
            dir="Camine 210 metros sobre la Av. Hidalgo hasta la Av. Trujajo";
        }
        else if(origen==18 && destino==19){
            dir="Camine 100 metros sobre la Av. Hidalgo hasta la calle Balderas";
        }
        else if(origen==19 && destino==18){
            dir="Camine 100 metros sobre la Av. Hidalgo hasta la calle Dr. Mora";
        }
        else if(origen==18 && destino==21){
            dir="Entre a la Alameda y camine 275 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==18){
            dir="Camine 275 metros hasta la calle Dr. Mora";
        }
        else if(origen==18 && destino==22){
            dir="Camine 95 metros sobre la calle Dr. Mora hasta la próxima entrada a la Alameda";
        }
        else if(origen==22 && destino==18){
            dir="Camine 95 metros hasta la Av. Hidalgo";
        }
        else if(origen==19 && destino==24){
            dir="Camine 130 metros sobre la calle Balderas hasta la Av. Juárez";
        }
        else if(origen==24 && destino==19){
            dir="Camine 130 metros sobre la calle Balderas hasta la Av. Hidalgo";
        }
        else if(origen==20 && destino==27){
            dir="Camine 130 metros hasta la Av. Juárez";
        }
        else if(origen==27 && destino==20){
            dir="Camine 130 metros hasta la siguiente entrada a la Alameda";
        }
        else if(origen==20 && destino==21){
            dir="Entre a la Alameda y camine 230 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==20){
            dir="Camine 230 metros hasta la calle Angela Peralta";
        }
        else if(origen==21 && destino==22){
            dir="Camine 230 metros hasta la calle Dr. Mora";
        }
        else if(origen==22 && destino==21){
            dir="Entre a la Alameda y camine 230 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==27){
            dir="Camine 275 metros hasta la Av. Juárez";
        }
        else if(origen==27 && destino==21){
            dir="Entre a la Alameda y camine 275 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==30){
            dir="Camine 115 metros hasta la Av. Juárez";
        }
        else if(origen==30 && destino==21){
            dir="Entre a la Alameda y camine 115 metros hasta el centro de la misma";
        }
        else if(origen==21 && destino==33){
            dir="Camine 275 metros hasta la Av. Juárez";
        }
        else if(origen==33 && destino==21){
            dir="Entre a la Alameda y camine 275 metros hasta el centro de la misma";
        }
        else if(origen==22 && destino==23){
            dir="Camine 35 metros hasta la calle Cristobal Colón";
        }
        else if(origen==23 && destino==22){
            dir="Camine 35 metros hasta la siguiente entrada a la Alameda";
        }
        else if(origen==23 && destino==24){
            dir="Camine 99 metros sobre la calle Cristobal Colón hasta la calle Balderas";
        }
        else if(origen==24 && destino==23){
            dir="Camine 99 metros sobre la calle Cristobal Colón hasta la calle Dr. Mora";
        }
        else if(origen==23 && destino==33){
            dir="Camine 100 metros sobre la calle Dr. Mora hasta la Av. Júarez";
        }
        else if(origen==33 && destino==23){
            dir="Camine 100 metros sobre la calle Dr. Mora hasta la calle Cristobal Colón";
        }
        else if(origen==24 && destino==35){
            dir="Camine 86 metros sobre la calle Balderas hasta la Av. Júarez";
        }
        else if(origen==35 && destino==24){
            dir="Camine 86 metros sobre la calle Balderas hasta la calle Cristobal Colón";
        }
        else if(origen==25 && destino==26){
            dir="Camine 80 metros sobre la Av. Juárez hasta la calle López";
        }
        else if(origen==26 && destino==25){
            dir="Camine 80 metros sobre la Av. Juárez hasta el Eje Central Lázaro Cárdenas";
        }
        else if(origen==25 && destino==36){
            dir="Camine 160 metros sobre el Eje Central Lázaro Cárdenas hasta la Av. Independencia";
        }
        else if(origen==36 && destino==25){
            dir="Camine 160 metros sobre el Eje Central Lázaro Cárdenas hasta la Av. Juárez";
        }
        else if(origen==26 && destino==27){
            dir="Camine 15 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==27 && destino==26){
            dir="Camine 15 metros sobre la Av. Juárez hasta la calle López";
        }
        else if(origen==26 && destino==37){
            dir="Camine 160 metros sobre la calle López hasta la Av. Independencia";
        }
        else if(origen==37 && destino==26){
            dir="Camine 160 metros sobre la calle López hasta la Av. Juárez";
        }
        else if(origen==27 && destino==28){
            dir="Camine 92 metros sobre la Av. Juárez hasta la calle Dolores";
        }
        else if(origen==28 && destino==27){
            dir="Camine 92 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==28 && destino==29){
            dir="Camine 38 metros sobre la Av. Juárez hasta la calle Marroqui";
        }
        else if(origen==29 && destino==28){
            dir="Camine 38 metros sobre la Av. Juárez hasta la calle Dolores";
        }
        else if(origen==28 && destino==38){
            dir="Camine 160 metros sobre la calle Dolores hasta la Av. Independencia";
        }
        else if(origen==38 && destino==28){
            dir="Camine 160 metros sobre la calle Dolores hasta la Av. Juárez";
        }
        else if(origen==29 && destino==30){
            dir="Camine 90 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==30 && destino==29){
            dir="Camine 90 metros sobre la Av. Juárez hasta la calle Marroqui";
        }
        else if(origen==29 && destino==39){
            dir="Camine 160 metros sobre la calle Marroqui hasta la Av. Independencia";
        }
        else if(origen==39 && destino==29){
            dir="Camine 160 metros sobre la calle Marroqui hasta la Av. Juárez";
        }
        else if(origen==30 && destino==31){
            dir="Camine 90 metros sobre la Av. Juárez hasta la calle Luis Moya";
        }
        else if(origen==31 && destino==30){
            dir="Camine 90 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==31 && destino==32){
            dir="Camine 110 metros sobre la Av. Juárez hasta la calle Revillagigedo";
        }
        else if(origen==32 && destino==31){
            dir="Camine 110 metros sobre Av. Juárez hasta la calle Luis Moya";
        }
        else if(origen==31 && destino==40){
            dir="Camine 160 metros sobre la calle Luis Moya hasta la Av. Independencia";
        }
        else if(origen==40 && destino==31){
            dir="Camine 160 metros sobre la calle Luis Moya hasta la Av. Juárez";
        }
        else if(origen==32 && destino==33){
            dir="Camine 54 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==33 && destino==32){
            dir="Camine 54 metros sobre la Av. Juárez hasta la calle Revillagigedo";
        }
        else if(origen==32 && destino==41){
            dir="Camine 160 metros sobre la calle Revillagigedo hasta la Av. Independencia";
        }
        else if(origen==41 && destino==32){
            dir="Camine 160 metros sobre la calle Revillagigedo hasta la Av. Juárez";
        }
        else if(origen==33 && destino==34){
            dir="Camine 28 metros sobre Av. Juárez hasta la calle Azueta";
        }
        else if(origen==34 && destino==33){
            dir="Camine 28 metros sobre la Av. Juárez hasta la siguiente entrada a la Alameda";
        }
        else if(origen==34 && destino==35){
            dir="Camine 71 metros sobre la Av. Juárez hasta la calle Balderas";
        }
        else if(origen==35 && destino==34){
            dir="Camine 71 metros sobre la Av. Juárez hasta la calle Azueta";
        }
        else if(origen==34 && destino==42){
            dir="Camine 160 metros sobre la calle Azueta hasta la Av. Independencia";
        }
        else if(origen==42 && destino==34){
            dir="Camine 160 metros sobre la calle Azueta hasta la Av. Juárez";
        }
        else if(origen==35 && destino==43){
            dir="Camine 160 metros sobre la calle Balderas hasta la Av. Independencia";
        }
        else if(origen==43 && destino==35){
            dir="Camine 160 metros sobre la calle Balderas hasta la Av. Juárez";
        }
        else if(origen==36 && destino==37){
            dir="Camine 100 metros sobre la Av. Independencia hasta la calle López";
        }
        else if(origen==37 && destino==36){
            dir="Camine 100 metros sobre la Av. Independencia hasta el Eje Central Lázaro Cárdenas";
        }
        else if(origen==36 && destino==44){
            dir="Camine 87 metros sobre el Eje Central Lázaro Cárdenas hasta la calle Art. 123";
        }
        else if(origen==44 && destino==36){
            dir="Camine 87 metros sobre el Eje Central Lázaro Cárdenas hasta la Av. Independencia";
        }
        else if(origen==37 && destino==38){
            dir="Camine 89 metros sobre la Av. Independencia hasta la calle Dolores";
        }
        else if(origen==38 && destino==37){
            dir="Camine 89 metros sobre la Av. Independencia hasta la calle López";
        }
        else if(origen==37 && destino==45){
            dir="Camine 88 metros sobre la calle López hasta la calle Art. 123";
        }
        else if(origen==45 && destino==37){
            dir="Camine 88 metros sobre la calle López hasta la Av. Independencia";
        }
        else if(origen==38 && destino==39){
            dir="Camine 34 metros sobre la Av. Independencia hasta la calle Marroqui";
        }
        else if(origen==39 && destino==38){
            dir="Camine 34 metros sobre la Av. Independencia hasta la calle Dolores";
        }
        else if(origen==38 && destino==46){
            dir="Camine 88 metros sobre la calle Dolores hasta la calle Art. 123";
        }
        else if(origen==46 && destino==38){
            dir="Camine 88 metros sobre la calle Dolores hasta la Av. Independencia";
        }
        else if(origen==39 && destino==40){
            dir="Camine 190 metros sobre la Av. Independencia hasta la calle Luis Moya";
        }
        else if(origen==40 && destino==39){
            dir="Camine 190 metros sobre la Av. Independencia hasta la calle Marroqui";
        }
        else if(origen==39 && destino==47){
            dir="Camine 123 metros sobre la calle Marroqui hasta la calle Art. 123";
        }
        else if(origen==47 && destino==39){
            dir="Camine 123 metros sobre la calle Marroqui hasta la Av. Independencia";
        }
        else if(origen==40 && destino==41){
            dir="Camine 110 metros sobre la Av. Independencia hasta la calle Revillagigedo";
        }
        else if(origen==41 && destino==40){
            dir="Camine 110 metros sobre la Av. Independencia hasta la calle Luis Moya";
        }
        else if(origen==40 && destino==48){
            dir="Camine 95 metros sobre la calle Luis Moya hasta la calle Art. 123";
        }
        else if(origen==48 && destino==40){
            dir="Camine 95 metros sobre la calle Luis Moya hasta la Av. Independencia";
        }
        else if(origen==41 && destino==42){
            dir="Camine 76 metros sobre la Av. Independencia hasta la calle Azueta";
        }
        else if(origen==42 && destino==41){
            dir="Camine 76 metros sobre la Av. Independencia hasta la calle Revillagigedo";
        }
        else if(origen==41 && destino==49){
            dir="Camine 95 metros sobre la calle Revillagigedo hasta la calle Art. 123";
        }
        else if(origen==49 && destino==41){
            dir="Camine 95 metros sobre la calle Revillagigedo hasta la Av. Independencia";
        }
        else if(origen==42 && destino==43){
            dir="Camine 76 metros sobre la Av. Independencia hasta la calle Balderas";
        }
        else if(origen==43 && destino==42){
            dir="Camine 76 metros sobre la Av. Independencia hasta la calle Azueta";
        }
        else if(origen==43 && destino==50){
            dir="Camine 96 metros sobre la calle Balderas hasta la calle Art. 123";
        }
        else if(origen==50 && destino==43){
            dir="Camine 96 metros sobre la calle Balderas hasta la Av. Independencia";
        }
        else if(origen==44 && destino==45){
            dir="Camine 110 metros sobre la calle Art. 123 hasta la calle López";
        }
        else if(origen==45 && destino==44){
            dir="Camine 110 metros sobre la calle Art. 123 hasta el Eje Central Lázaro Cárdenas";
        }
        else if(origen==45 && destino==46){
            dir="Camine 87 metros sobre la calle Art. 123 hasta la calle Dolores";
        }
        else if(origen==46 && destino==45){
            dir="Camine 87 metros sobre la calle Art. 123 hasta la calle López";
        }
        else if(origen==46 && destino==47){
            dir="Camine 44 metros sobre la calle Art. 123 hasta la calle Marroqui";
        }
        else if(origen==47 && destino==46){
            dir="Camine 44 metros sobre la calle Art. 123 hasta la calle Dolores";
        }
        else if(origen==47 && destino==48){
            dir="Camine 190 metros sobre la calle Art. 123 hasta la calle Luis Moya";
        }
        else if(origen==48 && destino==47){
            dir="Camine 190 metros sobre la calle Art. 123 hasta la calle Marroqui";
        }
        else if(origen==48 && destino==49){
            dir="Camine 110 metros sobre la calle Art. 123 hasta la calle Revillagigedo";
        }
        else if(origen==49 && destino==48){
            dir="Camine 110 metros sobre la calle Art. 123 hasta la calle Luis Moya";
        }
        else if(origen==49 && destino==50){
            dir="Camine 150 metros sobre la calle Art. 123 hasta la calle Balderas";
        }
        else if(origen==50 && destino==49){
            dir="Camine 150 metros sobre la calle Art. 123 hasta la calle Revillagigedo";
        }
        return dir;
    }

}