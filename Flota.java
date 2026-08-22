import java.util.ArrayList;

public class Flota {

    private ArrayList<Barco> barcos;


    // Consulta en la lista de Barcos(o unidades) si hay un barco aliado en la posición (longitud, latitud) 
    public boolean esBuenAtaque(int longitud, int latitud){
        for(Barco barco : barcos ){
            if(longitud == barco.getLongitud() && latitud == barco.getLatitud()){
                return false;
            }
        }
        return true;
    }

    //consulta si puede confundir aviones aliados con aviones enemigos considerando las placas de estos
    public boolean problemaEnAire(){
        return true;
    }

    // Devuelve la lista de barcos que serán destruidos en la posición (longitud, latitud)
    public ArrayList<Barco> seranDestruidos(int longitud, int latitud){
        ArrayList<Barco> destruidos = new ArrayList<Barco>;
        for (Barco barco : barcos) {
            if (longitud == barco.getLongitud() &&
                latitud == barco.getLatitud()){
                destruidos.add(barco);
            }
        }
        return destruidos;
    }
}
