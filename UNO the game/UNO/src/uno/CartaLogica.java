package uno;


public class CartaLogica {
	private
		int valor;
		String color;
		String especial;
                String imagen;
		
		CartaLogica(){  // crea una carta vacia sin nada
			this.valor = -1;
			this.color = "NULL";
			this.especial = "NULL";
						this.imagen = "NULL";
                        
		}
	
	public		
		CartaLogica(int pValor, String pColor, String pImagen) { // crea una carta de un numero con un color (0-9)
			this.valor = pValor;
			this.color = pColor;
                        this.imagen = pImagen;
			this.especial = "NULL";
		}
		CartaLogica(String pColor, String pEspecial, String pImagen){ // crea una carta especial con color y el valor especial (salta rojo, reversa verde... )
			this.valor = -1;						   // si son los +4 o cambia color, el pColor == "negro" 
			this.color = pColor; // ruta de la imagen 
			this.especial = pEspecial; // caso especial (+4, reversa, salta,cambia color)
                        this.imagen = pImagen;
		}
		int getValor(){
			return this.valor;
		}
		String getColor(){
			return this.color;
		}
		String getEspecial(){
			return this.especial;
		}
                String getImagen(){
                    return this.imagen;
                }
}