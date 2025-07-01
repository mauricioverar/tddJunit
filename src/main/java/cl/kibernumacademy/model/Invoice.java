package cl.kibernumacademy.model;

public class Invoice {
  private final int id; // final significa que no se puede cambiar una vez asignado
  private final String client; // valor por defecto null
  private final double amount;
  private String status;

  public Invoice(int id, String client, double amount) {
    this.id = id; // this hace referencia a la variable de instancia
    this.client = client;
    this.amount = amount;
    this.status = "Pendiente"; // Estado por defecto
  }

  public int getId() {
    return id;
  }

  public String getClient() {
    return client;
  }

  public double getAmount() {
    return amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
