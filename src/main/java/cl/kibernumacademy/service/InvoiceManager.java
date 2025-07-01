package cl.kibernumacademy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cl.kibernumacademy.model.Invoice;

public class InvoiceManager {
  private final List<Invoice> invoices = new ArrayList<>(); // Lista de facturas
  // las colecciones son dinamicas, pueden crecer y decrecer
  // los arrays son estaticos, no pueden crecer ni decrecer
  private int nextId = 1; // Simulación de ID autoincremental

  public Invoice createInvoice(String invoiceNumber, double amount) {
    Invoice invoice = new Invoice(nextId++, invoiceNumber, amount);
    invoices.add(invoice); // Agregar la factura a la lista
    return invoice; // Retornar la factura creada

  }

  public boolean updateStatus(int id, String status) {
    for (Invoice invoice : invoices) {
      if (invoice.getId() == id) {
        invoice.setStatus(status);
        return true;
      }
    }
    return false;
  }

  public boolean deleteInvoice(int id) {
    return invoices.removeIf(invoice -> invoice.getId() == id);
  }

  public List<Invoice> getAll() {
    return Collections.unmodifiableList(invoices);
  }

}
