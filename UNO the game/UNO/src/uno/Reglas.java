
package uno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Reglas {
    private boolean reversa;
    private int jugadores;
    private int turno;
    private MasoDeCartas maso;
    private TableroJugadores tabJug;
    private ArrayList<CartaLogica>  cartasJugador1;
    private ArrayList<CartaLogica>  cartasJugador2;
    private ArrayList<CartaLogica>  cartasJugador3;
    private ArrayList<CartaLogica>  cartasJugador4;
    private CartaLogica jugadActual;
    private boolean come4;
    private boolean comodin;
    private CartaLogica temporal;
    private boolean banderaTemp;

    public void inicializar_Todo(){
        turno=0;
        banderaTemp=false;
        temporal= new CartaLogica();
        comodin=false;
        come4=false;
        jugadores = -1;
        reversa = false;
        maso = new MasoDeCartas();
        cartasJugador1 = new ArrayList<>();
        cartasJugador2 = new ArrayList<>();
        cartasJugador3 = new ArrayList<>();
        cartasJugador4 = new ArrayList<>();
        jugadActual = new CartaLogica();
        }
    
    public int getTamaño(int k){
       if (k==0){
            return cartasJugador1.size();
        }else if(k==1){
            return cartasJugador2.size();
        }else if(k==2){
            return cartasJugador3.size();
        }else{
            return cartasJugador4.size();
        }
    }
    
    public CartaLogica getJugadActual() {
        return jugadActual;
    }
    
    public void quitarCartaJugadores(int pos){
        if (turno==0){
            System.out.println("antes"+cartasJugador1.size());
            cartasJugador1.remove(pos);
            tabJug.quitarBoton(pos, turno);
            if (cartasJugador1.size()==0){
                JOptionPane.showMessageDialog(null,"EL GANADOR ES EL JUGADOR "+(turno+1));
                tabJug.dispose();
            }
            System.out.println("despues"+cartasJugador1.size());
        }else if(turno==1){
            System.out.println("antes"+cartasJugador2.size());
            cartasJugador2.remove(pos);
            tabJug.quitarBoton(pos, turno);
            if (cartasJugador2.size()==0){
                JOptionPane.showMessageDialog(null,"EL GANADOR ES EL JUGADOR "+(turno+1));
                tabJug.dispose();
            }
            System.out.println("despues"+cartasJugador2.size());
        }else if(turno==2){
            System.out.println("antes"+cartasJugador3.size());
            cartasJugador3.remove(pos);
            tabJug.quitarBoton(pos, turno);
            if (cartasJugador3.size()==0){
                JOptionPane.showMessageDialog(null,"EL GANADOR ES EL JUGADOR "+(turno+1));
                tabJug.dispose();
            }
            System.out.println("despues"+cartasJugador3.size());
        }else{
            System.out.println("antes"+cartasJugador4.size());
            cartasJugador4.remove(pos);
            tabJug.quitarBoton(pos, turno);
            if (cartasJugador4.size()==0){
                JOptionPane.showMessageDialog(null,"EL GANADOR ES EL JUGADOR "+(turno+1));
                tabJug.dispose();
            }
            System.out.println("despues"+cartasJugador4.size());
        }
    }

    public void setJugadActual(CartaLogica jugada) {
        this.jugadActual = jugada;
        tabJug.observer(jugada.getColor(), getReversa(),getJugadores());
    }
    public int getPosicion(String img){
        int j=0;
        if (turno==0){
            for(int i=0; i<cartasJugador1.size(); i++){
                if(cartasJugador1.get(i).getImagen().equals(img)){
                j=i; 
                i=900;
                }
            }
            
        }else if(turno==1){
            for(int i=0; i<cartasJugador2.size(); i++){
                if(cartasJugador2.get(i).getImagen().equals(img)){
                j=i;
                i=900;
                }
            }
            
        }else if(turno==2){
            for(int i=0; i<cartasJugador3.size(); i++){
                if(cartasJugador3.get(i).getImagen().equals(img)){
                j=i;  
                i=900;
                }
            }
            
        }else{
            for(int i=0; i<cartasJugador4.size(); i++){
                if(cartasJugador4.get(i).getImagen().equals(img)){
                j=i;
                i=900;
                }
            }
            
        }
        return j;
    }
    public CartaLogica getCartasJugador(String img, int k) {
        if(banderaTemp==true){
            return temporal;
        }else if (k==0){
            int pos = getPosicion(img);
            return cartasJugador1.get(pos);
        }else if(k==1){
            int pos = getPosicion(img);
            return cartasJugador2.get(pos);
        }else if(k==2){
            int pos = getPosicion(img);
            return cartasJugador3.get(pos);
        }else{
            int pos = getPosicion(img);
            return cartasJugador4.get(pos);
        }
        
    }
    
    public int getCartaParaBotar(String Img) {//funcion para cunado se le da en la imagen se compara
        int res=0;
        if (turno==0){                                 //con la imagen en el maso para saber cual cuarta se tiene quitar del maso 
            for(int i=0; i<cartasJugador1.size();i++){ // y pasarla al bote
                if (cartasJugador1.get(i).getImagen()==Img){
                    res=i;
                    i=109;
                    
                }
            }
            
        }else if(turno==1){
            for(int i=0; i<cartasJugador1.size();i++){
                if (cartasJugador2.get(i).getImagen()==Img){
                    res=i;
                    i=109;
                }
            }
        }else if(turno==2){
            for(int i=0; i<cartasJugador1.size();i++){
                if (cartasJugador2.get(i).getImagen()==Img){
                    res=i;
                    i=109;
                }
            }
            
        }else{
            for(int i=0; i<cartasJugador1.size();i++){
                if (cartasJugador4.get(i).getImagen()==Img){
                    res=i;
                    i=109;
                    
                }
            }
            
        }
        return res;
    }
    
    
    
    

    public void setCartasJugador(CartaLogica cartasJugador12){
        if (turno==0){
            cartasJugador1.add(cartasJugador12);
        }else if(turno==1){
            cartasJugador2.add(cartasJugador12);
        }else if(turno==2){
            cartasJugador3.add(cartasJugador12);
        }else{
            cartasJugador4.add(cartasJugador12);
        }
    }
    
    
    public int getTurno() {
        return turno;
    }

    
    
    public void setTurno(String a) {
        switch(a){
            case "++":
                turno++;
                break;
            case "--":
                turno--;
                break;
            case "=0":
                turno=0;
                break;
            case "==":
                turno=getJugadores()-1;
                break;
        }
    }
    
    
    public boolean getReversa() {
        return reversa;
    }

    public void setReversa(boolean reversa) {
        this.reversa = reversa;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int h) {
        this.jugadores = h;
    }
    
    
    
    Reglas(){
        inicializar_Todo();
				Integer[] opcionesJugadores = {2,3,4};
				ImageIcon icon = new ImageIcon("logoJuego.jpg");
				Object eleccion = JOptionPane.showInputDialog(null, "¿Cantidad de jugadores para esta partida?", "UNO the game", JOptionPane.QUESTION_MESSAGE, icon, opcionesJugadores, opcionesJugadores[0]);
				setJugadores(Integer.parseInt((String)eleccion.toString()));		
        tabJug=new TableroJugadores();
        prepararTurnos();
        tabJug.setBote(getJugadActual().getImagen());
        tabJug.setMaso();
        imprimirTurno1();
        tabJug.repaint();
        accion();
        
        
        
    }
    
    private void imprimirTurno1(){
        tabJug.imprimirBotonesAct(0);
        tabJug.imprimirBotonesAct(1);
        tabJug.imprimirBotonesAct(2);
        tabJug.imprimirBotonesAct(3);
        
        tabJug.quitarJugAnterior(1);
        tabJug.quitarJugAnterior(2);
        tabJug.quitarJugAnterior(3);
    }
    private void prepararTurnos(){
        if (getJugadores()==2){
            for(int i=0;i<7;i++){
                cartasJugador1.add(maso.sacarCarta());
                cartasJugador2.add(maso.sacarCarta());
                setBotones1(cartasJugador1.get(i).getImagen(), 0);
                setBotones1(cartasJugador2.get(i).getImagen(), 1);
                       }
        }else if (getJugadores()==3){
            for(int i=0;i<7;i++){
                cartasJugador1.add(maso.sacarCarta());
                cartasJugador2.add(maso.sacarCarta());
                cartasJugador3.add(maso.sacarCarta());
                setBotones1(cartasJugador1.get(i).getImagen(), 0);
                setBotones1(cartasJugador2.get(i).getImagen(), 1);
                setBotones1(cartasJugador3.get(i).getImagen(), 2);
            }
        }else if (getJugadores()==4){
            for(int i=0;i<7;i++){
                cartasJugador1.add(maso.sacarCarta());
                cartasJugador2.add(maso.sacarCarta());
                cartasJugador3.add(maso.sacarCarta());
                cartasJugador4.add(maso.sacarCarta());
                setBotones1(cartasJugador1.get(i).getImagen(), 0);
                setBotones1(cartasJugador2.get(i).getImagen(), 1);
                setBotones1(cartasJugador3.get(i).getImagen(), 2);
                setBotones1(cartasJugador4.get(i).getImagen(), 3);
            }
        }
        setJugadActual(maso.sacarCarta());
		while(jugadActual.getValor() == -1){
			maso.MeterCarta(jugadActual);
			setJugadActual(maso.sacarCarta());
		}
        
    }
    
    public void setBotones1(String img, int turnoo){
        JButton boton= new JButton();
        accionIndividualBoton(boton);
            tabJug.setBotones1(img, turnoo,boton);                        
        
    }
	
    public void accionIndividualBoton(JButton boton){
        boton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                System.out.println(""+((JButton)e.getSource()).getName());
                            validar(((JButton)e.getSource()).getName());
                            }
            });
    }
    public void accion(){
        tabJug.getBotonMaso().addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                TomarCarta(1);
                                tabJug.repaint();
                                
                                
                            }
            });
    }
    
    private boolean validarAux(CartaLogica carta){
        boolean a;
        if (carta.getColor()==jugadActual.getColor()){
           a=true;
        }else if (carta.getValor()== jugadActual.getValor()){
           a=true;
        }else if (carta.getEspecial()==jugadActual.getEspecial()&& carta.getEspecial()!= "NULL"){
           a=true;
        }else if (carta.getColor()=="negro"){
           a=true;
        }else{
           a=false;
        }
        return a;
    }
    public void control(CartaLogica a){
        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println(">< * * CONTROL * * ><><><><><><><><><><><><><><><><><><");
        System.out.println(" * * ");
        System.out.println("REVERSA = "+reversa);
        System.out.println("TURNO = "+turno);
        System.out.println(" * * ");
        System.out.println("**JUGADA ACTUAL**");
        System.out.println(" * * ");
        System.out.println("COLOR = "+jugadActual.getColor());
        System.out.println("VALOR = "+ jugadActual.getValor());
        System.out.println("ESPECIAL = "+jugadActual.getEspecial());
        System.out.println(" * * ");
        System.out.println("**CARTA A COLOCAR**");
        System.out.println(" * * ");
        System.out.println("COLOR = "+a.getColor());
        System.out.println("VALOR = "+ a.getValor());
        System.out.println("ESPECIAL = "+a.getEspecial());
        System.out.println(" * * ");
        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
        
    }
    public boolean validar (String t){
        boolean resp=true;
        System.out.println("ESTA ES LA IMAGEN-->"+t);
        CartaLogica a = getCartasJugador(t,turno);
        control(a);
        System.out.println("aqui "+a.getImagen());
        System.out.println("comoddiiin antes "+comodin);
        if (true==validarAux(a) || comodin==true){
            System.out.println("antes este es el turno #"+turno+"valoor aqui "+a.getValor());
            
            if(a.getValor()!=-1){
                comodin=false;
                resp=true;
                System.out.println("numero");
                //meter el jugadaactual al fondo del mazo y cambiar jugada actual por a 
                maso.MeterCarta(getJugadActual());
                setJugadActual(a);
                tabJug.setBote(t);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                tabJug.quitarJugAnterior(turno);
                PasarTurno();
                tabJug.imprimirBotonesAct(turno);
            }else if(a.getEspecial()=="Reversa"){
                comodin=false;
                resp=true;
                System.out.println("reversa");
                Reversa();
                maso.MeterCarta(getJugadActual());
                setJugadActual(a);
                tabJug.setBote(t);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                tabJug.quitarJugAnterior(turno);
                tabJug.quitarJugAnterior(turno);
                PasarTurno();
                tabJug.imprimirBotonesAct(turno);
            }else if(a.getEspecial()=="Salto"){
                comodin=false;
                resp=true;
                System.out.println("salto");
                tabJug.quitarJugAnterior(turno);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                tabJug.quitarJugAnterior(turno);
                BrincaDos();
                maso.MeterCarta(getJugadActual());
                setJugadActual(a);
                tabJug.setBote(t);
                
                tabJug.imprimirBotonesAct(turno);
            }else if(a.getEspecial()=="Toma2"){
                comodin=false;
                resp=true;
                System.out.println("toma 2");
                tabJug.quitarJugAnterior(turno);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                tabJug.quitarJugAnterior(turno);
                PasarTurno();
                TomarCarta(2);
                maso.MeterCarta(getJugadActual());
                setJugadActual(a);
                tabJug.setBote(t);
                
                PasarTurno();
                tabJug.imprimirBotonesAct(turno);
            }else if(a.getEspecial()=="ComodinColor"){
                resp=true;
                //seleccionar nueva carta 
                System.out.println("comodin");
                maso.MeterCarta(getJugadActual());
		setJugadActual(a);
                tabJug.setBote(t);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                JOptionPane.showMessageDialog(null, "Tiene que colocar otra carta");
                tabJug.imprimirBotonesAct(turno);
                comodin=true;
                
                
            }else if (a.getEspecial()=="ComodinToma4"){
                //seleccioar color y carta nueva 
		System.out.println("toma 4");		
                maso.MeterCarta(getJugadActual());
                setJugadActual(a);
                tabJug.setBote(t);
                if(banderaTemp==false){
                quitarCartaJugadores(getPosicion(t));
                }else{
                    banderaTemp=false;
                }
                come4=true;
                comodin=true;
				JOptionPane.showMessageDialog(null, "Tiene que colocar otra carta");
                tabJug.imprimirBotonesAct(turno);
            } 
        }else{
            if(banderaTemp==true){
                banderaTemp=false;
            }
            resp=false;
            //decir que no es valida o no..
        }
        System.out.println("este es el turno despues # "+turno);
        tabJug.repaint();
        //accion();
        return resp;
    }
    
    public void DevolverMaso(){
        
    }
    
    public void PasarTurno(){
        if (come4==true){
            tamaño();
            System.out.println("cominedo 4");
            if(getReversa()==false){
                if(getJugadores()-1>(turno)){
                    setTurno("++");
                }else{
                    System.out.println("entro =0");
                    setTurno("=0");
                }
            }else{
                 if((getTurno())>0){
                     setTurno("--");
                }else{
                    setTurno("==");
                }
            }
            
            TomarCarta(4);
            tamaño();
            come4=false;
            PasarTurno();
        }else
        if(getReversa()==false){
            if(getJugadores()-1>(turno)){
                setTurno("++");
            }else{
                System.out.println("entro =0");
                setTurno("=0");
            }
        }else{
            if((getTurno())>0){
                setTurno("--");
            }else{
                setTurno("==");
            }
        }
    }
    
    public void Reversa(){
        if(getReversa()==false){
            setReversa(true);
        }else{
            setReversa(false);
        }
    }
    
    public void BrincaDos(){
       PasarTurno();
       PasarTurno();
    }
    
    public void tamaño(){
        System.out.println("jug 1 "+cartasJugador1.size());
        System.out.println(" jug 2"+cartasJugador2.size());
        System.out.println(" jug 3"+cartasJugador3.size());
        System.out.println("jugg 4 "+cartasJugador4.size());
    }
    public void TomarCarta(int cantidad){
        for (int i=0; i < cantidad; i++){
            CartaLogica a = new CartaLogica();
            if (cantidad==1){
                /*tomar carta
                ver si le sirve y si la quiere usar sino;
                */
                a=maso.sacarCarta();
                ImageIcon icon = new ImageIcon(getClass().getResource(a.getImagen()));
                int eleccion = JOptionPane.showConfirmDialog(null, "Ha sacado esta carta del maso, desea usarla?", "UNO the game", 0, 0, icon);																	                              
                System.out.println("opcion"+eleccion);
                if (eleccion == 0){
                    temporal=a;
                    banderaTemp=true;
                    boolean valido = validar(a.getImagen());
                    if(valido!=true){
                        System.out.println("entro nooo####");
                        setCartasJugador(a);
                        setBotones1(a.getImagen(), turno);
                        tabJug.quitarJugAnterior(turno);
                        PasarTurno();
                        tabJug.imprimirBotonesAct(turno);
                    }
                }else{
                    setCartasJugador(a);
                    setBotones1(a.getImagen(), turno);
                    tabJug.quitarJugAnterior(turno);
                    PasarTurno();
                    tabJug.imprimirBotonesAct(turno);
                }
                //eleccion.equals("Si")...
                //PREGUNTAR SI LE SIRVE sino PASAR TURNO ** por las reglas del profe 
                //sino sirve se acumula al jugador y pasa turno 
            }else{
                a=maso.sacarCarta();
                setBotones1(a.getImagen(), turno);
                
                setCartasJugador(a);
            }
        }
    }
    
   
}
