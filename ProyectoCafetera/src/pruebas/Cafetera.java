package pruebas;

public class Cafetera {
    private int capacidadMaxima;
    private int cantidadActual;

    public Cafetera() {
        capacidadMaxima = 1000;
        cantidadActual = 0;
    }

    public Cafetera(int capacidad) {
        capacidadMaxima = capacidad;
        cantidadActual = capacidadMaxima;
    }

    public Cafetera(int capacidad, int cantidad) {
        capacidadMaxima = capacidad;
        if (cantidad > capacidadMaxima) {
            cantidadActual = capacidadMaxima;
        } else if (cantidad < 0) {
            cantidadActual = 0;
        } else {
            cantidadActual = cantidad;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int c) {
        capacidadMaxima = c;
        if (cantidadActual > capacidadMaxima) {
            cantidadActual = capacidadMaxima;
        }
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int c) {
        if (c > capacidadMaxima) {
            cantidadActual = capacidadMaxima;
        } else if (c < 0) {
            cantidadActual = 0;
        } else {
            cantidadActual = c;
        }
    }

    public void llenarCafetera() {
        cantidadActual = capacidadMaxima;
    }

    public int servirTaza(int cc) {
        int servido = 0;

        if (cantidadActual == 0) {
            servido = 0;
        } else {
            if (cantidadActual <= cc) {
                servido = cantidadActual;
                cantidadActual = 0;
            } else {
                servido = cc;
                cantidadActual -= cc;
            }
        }
        return servido;
    }

    public void vaciarCafetera() {
        cantidadActual = 0;
    }

    public void agregarCafe(int cc) {
        cantidadActual += cc;
        if (cantidadActual > capacidadMaxima) {
            cantidadActual = capacidadMaxima;
        }
        if (cantidadActual < 0) {
            cantidadActual = 0;
        }
    }
}
