package uno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import uno.Datos;

/**
 *
 * @author Cristopher
 *
 **/
public class MasoDeCartas {
	private
		LinkedList<CartaLogica> masoDeCartas;	
		final void iniciarMaso(){
			Random random = new Random();
			ArrayList<CartaLogica> temp = new ArrayList<>();
			String[] colores = {"rojo", "amarillo", "verde", "azul"};
			String[] comodines = {"Reversa", "Salto", "Toma2"};
                        String[][] Imagenes = {{Datos.Rojo_0, Datos.Rojo_1, Datos.Rojo_2, Datos.Rojo_3, Datos.Rojo_4, Datos.Rojo_5, Datos.Rojo_6, Datos.Rojo_7, Datos.Rojo_8, Datos.Rojo_9, Datos.Rojo_reversa, Datos.Rojo_salto, Datos.Rojo_toma2},
                                               {Datos.Amarillo_0, Datos.Amarillo_1, Datos.Amarillo_2, Datos.Amarillo_3, Datos.Amarillo_4, Datos.Amarillo_5, Datos.Amarillo_6, Datos.Amarillo_7, Datos.Amarillo_8, Datos.Amarillo_9, Datos.Amarillo_reversa, Datos.Amarillo_salto, Datos.Amarillo_toma2},
                                              {Datos.Verde_0, Datos.Verde_1, Datos.Verde_2, Datos.Verde_3, Datos.Verde_4, Datos.Verde_5, Datos.Verde_6, Datos.Verde_7, Datos.Verde_8, Datos.Verde_9, Datos.Verde_reversa, Datos.Verde_salto, Datos.Verde_toma2},
                                              {Datos.Azul_0, Datos.Azul_1, Datos.Azul_2, Datos.Azul_3, Datos.Azul_4, Datos.Azul_5, Datos.Azul_6, Datos.Azul_7, Datos.Azul_8, Datos.Azul_9, Datos.Azul_reversa, Datos.Azul_salto, Datos.Azul_toma2},
                                              {Datos.Toma4, Datos.Comodin, Datos.Atras, "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"}};
			int contador = 0;
			int contador2 = 1;
			while(contador < 4){
				while(contador2 <= 9){
					CartaLogica cartaTemp = new CartaLogica(contador2, colores[contador],Imagenes[contador][contador2]);
					temp.add(cartaTemp);
					temp.add(cartaTemp);
					contador2++;
				}
				temp.add(new CartaLogica(0, colores[contador], Imagenes[contador][0]));
				contador++;
				contador2 = 1;
			}
			contador = 0;
			contador2 = 0;
			while(contador < 4){
				while(contador2 < 3){
					CartaLogica cartaTemp = new CartaLogica(colores[contador], comodines[contador2], Imagenes[contador][contador2+10]);
					temp.add(cartaTemp);
					temp.add(cartaTemp);
					contador2++;
				}
				contador++;
				contador2 = 0;
			}
			for(int i = 0; i < 4; i++){
				CartaLogica cartaTemp = new CartaLogica("negro", "ComodinToma4", Imagenes[4][0]);
				CartaLogica cartaTemp2 = new CartaLogica("negro", "ComodinColor", Imagenes[4][1]);
				temp.add(cartaTemp);
				temp.add(cartaTemp2);
			}
			while(!temp.isEmpty()){
				int randomIndice = random.nextInt(temp.size());
				masoDeCartas.addFirst(temp.get(randomIndice));
				temp.remove(randomIndice);
			}
		}
	
	public
		MasoDeCartas(){
			masoDeCartas = new LinkedList<>();
			iniciarMaso();
		}	
		CartaLogica sacarCarta(){
                    return this.masoDeCartas.removeLast();
		}
		int getTamano(){
			return this.masoDeCartas.size();
		}
                void MeterCarta(CartaLogica x){
                    this.masoDeCartas.addFirst(x);
                }
}

