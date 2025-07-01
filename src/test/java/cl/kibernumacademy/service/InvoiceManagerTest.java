package cl.kibernumacademy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.kibernumacademy.model.Invoice;
import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceManagerTest {
  private InvoiceManager manager; // servicio

  @BeforeEach
  void setUp() {
    // preparacion
    // Arrange
    // Inicializar el manager de facturas
    // Esto se ejecuta antes de cada prueba
    manager = new InvoiceManager();
  }

  @Test
  void deberiaCrearUnaFactura() {

    String expectedInvoiceNumber = "Technova S.A. Factura 001";
    double expectedAmount = 1500.0;

    // Act accion
    // Crear una factura usando el manager
    Invoice invoice = manager.createInvoice(expectedInvoiceNumber, expectedAmount);

    // Assert verificacion
    // Verificar que la factura se haya creado correctamente
    assertThat(invoice.getId()).isEqualTo(1);
    assertThat(manager.getAll()).hasSize(1);//1
  }
  
  @Test
  void deberiaActualizarEstado() {

    String expectedInvoiceNumber = "Technova";
    double expectedAmount = 1500.0;

    // Act accion
    // Crear una factura usando el manager
    Invoice invoice = manager.createInvoice(expectedInvoiceNumber, expectedAmount);

    boolean updated = manager.updateStatus(invoice.getId(), "Pagada");
    // Assert verificacion
    // Verificar que la factura se haya creado correctamente
    assertThat(updated).isTrue();
    assertThat(invoice.getStatus()).isEqualTo("Pagada");
  }

  @Test
  void deberiaEliminarFactura() {

    String expectedInvoiceNumber = "Technova S.A. Factura 001";
    double expectedAmount = 1500.0;

    // Act accion
    // Crear una factura usando el manager
    Invoice invoice = manager.createInvoice(expectedInvoiceNumber, expectedAmount);

    boolean removed = manager.deleteInvoice(invoice.getId());
    // Assert verificacion
    // Verificar que la factura se haya creado correctamente
    assertThat(removed).isTrue();
    assertThat(manager.getAll()).isEmpty();
  }

}
