import java.util.ArrayList;

public class Flota {
    
    private ArrayList<Avion> aviones;
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
        if (this.tablero == null) {
            return false;
        }

        // Obtener la lista de todas las placas de los aviones enemigos en el tablero
        ArrayList<String> placasEnemigas = this.tablero.placasAvionesEnemigos(this);

        // Verifica si algún avión propio tiene una placa que coincida con las enemigas
        for (Avion miAvion : this.aviones) {
            if (placasEnemigas.contains(miAvion.getPlaca())) {
                return true;
            }
        }
        return false;
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
public class Avion {
    private String placa;
    private boolean enAire;
// Devuelve la placa que identifica el avión
    public String getPlaca() {
        return this.placa;
    }
}
public class Tablero {
    private ArrayList<Flota> flotas;
    //Retorna lista de placas de todos los aviones de las flotas excepto la flota que se está consultando.
    public ArrayList<String> placasAvionesEnemigos(Flota flotaActual) {
        ArrayList<String> placas = new ArrayList<String>();
        for (Flota flota : this.flotas) {
            if (flota != flotaActual) {
                for (Avion avion : flota.getAviones()) {
                    placas.add(avion.getPlaca());
                }
            }
        }
        return placas;
    }
}
