package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CafeteraTest {

    Cafetera cafetera;

    @BeforeEach
    void setUp() {
        cafetera = new Cafetera();
    }

    @Test
    void constructorPorDefecto() {
        assertEquals(1000, cafetera.getCapacidadMaxima());
        assertEquals(0, cafetera.getCantidadActual());
    }

    @Test
    void constructorConCapacidad() {
        Cafetera c = new Cafetera(500);
        assertEquals(500, c.getCapacidadMaxima());
        assertEquals(500, c.getCantidadActual());
    }

    @Test
    void constructorCapacidadYCantidadValida() {
        Cafetera c = new Cafetera(500, 200);
        assertEquals(500, c.getCapacidadMaxima());
        assertEquals(200, c.getCantidadActual());
    }

    @Test
    void constructorCantidadMayorQueCapacidad() {
        Cafetera c = new Cafetera(500, 800);
        assertEquals(500, c.getCantidadActual());
    }

    @Test
    void setGetCapacidad() {
        cafetera.setCapacidadMaxima(1500);
        assertEquals(1500, cafetera.getCapacidadMaxima());
    }

    @Test
    void setGetCantidad() {
        cafetera.setCantidadActual(400);
        assertEquals(400, cafetera.getCantidadActual());
    }

    @Test
    void llenarCafetera() {
        cafetera.llenarCafetera();
        assertEquals(cafetera.getCapacidadMaxima(), cafetera.getCantidadActual());
    }

    @Test
    void vaciarCafetera() {
        cafetera.llenarCafetera();
        cafetera.vaciarCafetera();
        assertEquals(0, cafetera.getCantidadActual());
    }

    @Test
    void agregarCafeSinSuperarCapacidad() {
        cafetera.agregarCafe(300);
        assertEquals(300, cafetera.getCantidadActual());
    }

    @Test
    void agregarCafeSuperandoCapacidad() {
        cafetera.agregarCafe(1200);
        assertEquals(1000, cafetera.getCantidadActual());
    }

    @Test
    void servirTazaSinCafe() {
        int servido = cafetera.servirTaza(200);
        assertEquals(0, servido);
        assertEquals(0, cafetera.getCantidadActual());
    }

    @Test
    void servirTazaConMenosCafeQueLaTaza() {
        cafetera.setCantidadActual(100);
        int servido = cafetera.servirTaza(200);
        assertEquals(100, servido);
        assertEquals(0, cafetera.getCantidadActual());
    }

    @Test
    void servirTazaConCantidadJusta() {
        cafetera.setCantidadActual(200);
        int servido = cafetera.servirTaza(200);
        assertEquals(200, servido);
        assertEquals(0, cafetera.getCantidadActual());
    }

    @Test
    void servirTazaConSuficienteCafe() {
        cafetera.setCantidadActual(500);
        int servido = cafetera.servirTaza(200);
        assertEquals(200, servido);
        assertEquals(300, cafetera.getCantidadActual());
    }
}
