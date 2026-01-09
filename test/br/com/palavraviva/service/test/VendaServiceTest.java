package br.com.palavraviva.service.test;

import br.com.palavraviva.service.VendaService;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaServiceTest {
    
    public double calcularTotal(double valorUnitario, int quantidade) {
    if (quantidade <= 0) {
        throw new IllegalArgumentException("Quantidade inválida");
    }
    return valorUnitario * quantidade;
}


    @Test
    public void deveCalcularTotalCorretamente() {
        VendaService service = new VendaService(null, null, null);
        double total = service.calcularTotal(50.0, 2);
        assertEquals(100.0, total, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarErroParaQuantidadeInvalida() {
        VendaService service = new VendaService(null, null, null);
        service.calcularTotal(50.0, 0);
    }
}
