/**
 * SI - POO - Prof. Fausto Ayres
 *
 */

package modelo;

import java.util.ArrayList;

public class Conta {
  private int id;
  private String chavepiks;
  private double saldo = 0;
  private Cliente cliente;
  private ArrayList<Lancamento> lancamentos = new ArrayList<>();

  public Conta(int id, String chave) throws Exception {
    if (chave == null)
      throw new Exception("Chave piks necessária para criação de conta");

    this.id = id;
    this.chavepiks = chave;
  }

  public void creditar(double valor) {
    saldo += valor;
  }

  public void debitar(double valor) throws Exception {
    if (saldo - valor < 0)
      throw new Exception("Saldo insuficiente");

    saldo -= valor;
  }

  public int getId() {
    return id;
  }

  public String getChavepiks() {
    return chavepiks;
  }

  public void setChavepiks(String chave) throws Exception {

    this.chavepiks = chave;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) throws Exception {
    if (saldo < 0)
      throw new Exception("Saldo inválido");
    this.saldo = saldo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) throws Exception {
    if (cliente == null)
      throw new Exception("Cliente inválido");
    this.cliente = cliente;
  }

  public ArrayList<Lancamento> getLancamentos() {
    return lancamentos;
  }

  public void adicionar(Lancamento lan) throws Exception {
    if (lan == null)
      throw new Exception("Lançamento inválido");
    lancamentos.add(lan);
  }

  public void transferir(double valor, Conta conta) throws Exception {
    if (conta == null)
      throw new Exception("Conta inválida");

    if (this.equals(conta))
      throw new Exception("Não pode transferir para a própria conta");

    if ((saldo - valor) < 0)
      throw new Exception("Valor inválido");

    this.debitar(valor);
    conta.creditar(valor);
  }

  @Override
  public String toString() {
    return "{id: " + id + ", chavepiks: " + chavepiks + ", saldo: " + saldo + ", cpf: " + cliente.getCpf() + ", nome: " + cliente.getNome() + "}";
  }
}
