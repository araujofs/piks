package modelo;

import java.time.LocalDateTime;

public class Lancamento {
  private LocalDateTime datahora;
  private double valor;
  private String tipo;

  public Lancamento(double valor, String tipo) throws Exception {
    if (valor <= 0)
      throw new Exception("Valor do lançamento inválido: valor <= 0");

    if (tipo == null)
      throw new Exception("Tipo não pode ser nulo");

    this.datahora = LocalDateTime.now();
    this.valor = valor;
    this.tipo = tipo;
  }

  public LocalDateTime getDatahora() {
    return datahora;
  }

  public double getValor() {
    return valor;
  }

  public String getTipo() {
    return tipo;
  }

  @Override
  public String toString() {
    return "{datahora: " + datahora + ", valor: " + valor + ", tipo: " + tipo + "}";
  }


}
