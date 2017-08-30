/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TableroJugadores extends JFrame{
    private ArrayList<JButton> botones1;
    private ArrayList<JButton> botones2;
    private ArrayList<JButton> botones3;
    private ArrayList<JButton> botones4;
    public JButton[] masoBote;
    private Reglas reglas;
    private JButton[] atras;
    private JLabel observer;
    private JLabel fondo = new JLabel();
    
    private void inicializador(){
        
        observer=new JLabel();
        botones1=new ArrayList<>();
        botones2=new ArrayList<>();
        botones3=new ArrayList<>();
        botones4=new ArrayList<>();
        masoBote=new JButton[2];
        atras = new JButton[4];
        atras[0]= new JButton();
        masoBote[1]= new JButton();
        masoBote[0]= new JButton();
        atras[1]= new JButton();
        atras[2]= new JButton();
        atras[3]= new JButton();
        atras[0].setIcon(new ImageIcon(getClass().getResource(Datos.Atras)));
        atras[1].setIcon(new ImageIcon(getClass().getResource(Datos.Atras)));
        atras[2].setIcon(new ImageIcon(getClass().getResource(Datos.Atras)));
        atras[3].setIcon(new ImageIcon(getClass().getResource(Datos.Atras)));
	}
	
    public JButton getBotonMaso(){
        return masoBote[0];
    }
	
    public JButton getBotones1(int k, int pos) {
        if (k==0){
            return botones1.get(pos); 
        }else if(k==1){
            return botones2.get(pos);
        }else if(k==2){
            return botones3.get(pos);
        }else{
            return botones4.get(pos);
        }
    }

    public void setBotones1(String img, int k, JButton boton) {
        if (k==0){
           boton.setIcon(new ImageIcon(getClass().getResource(img)));
           boton.setName(img);
           botones1.add(boton);
        }else if(k==1){
           boton.setName(img); 
           boton.setIcon(new ImageIcon(getClass().getResource(img)));
           botones2.add(boton);
        }else if(k==2){
            boton.setName(img);
           boton.setIcon(new ImageIcon(getClass().getResource(img)));
           botones3.add(boton);
        }else{
            boton.setName(img);
           boton.setIcon(new ImageIcon(getClass().getResource(img)));
           botones4.add(boton);
        }
    }
    
    TableroJugadores(){
        inicializador();        
        new JFrame("UNO");
        setVisible(true);
        setSize(1200, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //No borrar esto por si el profe se pone en varas con los botones le decimos mae espere un toque y descomentamos esto q funciona perfecto
        //getContentPane().setBackground(Color.BLACK);
        repaint();//esto es lo nuevo
    }
    
    public void paint( Graphics g ) {
        super.paintComponents(g);
        Dimension tamanio = getSize();//sabe siempre la dimencion de la ventana
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource(Datos.Fondo));//jala la imagen
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);//imprime la imagen
        //validate(); 
    }
        
    public void observer(String color, boolean reversa, int jug){
		observer.setBounds(200, 15, 900, 70);
		observer.setForeground(Color.red);
		observer.setFont(new Font("Verdana", Font.ITALIC, 20));
		String var = "";
		if(!reversa){
			var = " (Direccion: hacia abajo)";
		}else{
			var = " (Direccion: hacia arriba)";
		}
		observer.setText("Color actual: "+color+"   Reversa: "  +reversa+var +"   " + jug + " Jugadores");
		add(observer);
    }
    
    
    public void reimprimirTablerosJug(int k){
        for(int j=0; j<4; j++){
            if(k==j){
                imprimirBotonesAct(k);
            }else{
                
            }
        }
    }
    public void quitarBoton(int pos, int turno){
    if (turno==0){
            botones1.get(pos).setVisible(false);
            remove(botones1.get(pos));
            botones1.remove(pos);
        }else if(turno==1){
            botones2.get(pos).setVisible(false);
            remove(botones2.get(pos));
            botones2.remove(pos);
        }else if(turno==2){
            botones3.get(pos).setVisible(false);
            remove(botones3.get(pos));
            botones3.remove(pos);
        }else{
            botones4.get(pos).setVisible(false);
            remove(botones4.get(pos));
            botones4.remove(pos);
        }
    }
    
    public void imprimirBotonesAct(int k){
        System.out.println("colocando cartas jug #"+k);
        if (k==0){
              for( int i=0; i < botones1.size();i++){
               botones1.get(i).setBounds(63*i, 200, 60, 90);
               add(botones1.get(i));
            }
        }else if (k==1){
            for( int i=0; i < botones2.size();i++){
               botones2.get(i).setBounds(63*i, 300, 60, 90);
               add(botones2.get(i));
            }
        }else if (k==2){
            for( int i=0; i < botones3.size();i++){
               botones3.get(i).setBounds(63*i, 400, 60, 90);
               add(botones3.get(i));
            }
        }else if (k==3){
            for( int i=0; i < botones4.size();i++){
               botones4.get(i).setBounds(63*i, 500, 60, 90);
               add(botones4.get(i));
            }
        }
        atras[k].setVisible(false);
        remove(atras[k]);
    }
     public void quitarJugAnterior(int k){
         if (k==0){
             for(int i=0; i<botones1.size(); i++){
                remove(botones1.get(i));
                
             }
         }else if(k==1){
             for(int i=0; i<botones2.size(); i++){
                remove(botones2.get(i));
             }
         }else if(k==2){
             for(int i=0; i<botones3.size(); i++){
                remove(botones3.get(i));
             }
         }else if (k==3){
            for(int i=0; i<botones4.size(); i++){
                remove(botones4.get(i));
            }
         }
         
         System.out.println("quitamos cartas jug # "+k);
         atras[k].setBounds(63, 200+(100*k), 60, 90);
         atras[k].setVisible(true);
         add(atras[k]);
         
     }
     
     
    
     
     public void setMaso(){
         masoBote[0].setIcon(new ImageIcon(getClass().getResource(Datos.Atras)));
         masoBote[0].setBounds(25, 60, 60, 90);
         add(masoBote[0]);
         
     }
     
     public  void setBote(String img){
         
         masoBote[1].setBounds(125, 60, 60, 90);
         masoBote[1].setIcon(new ImageIcon(getClass().getResource(img)));
         add(masoBote[1]);
         
     }
}


