/**
 * SI - POO - Prof. Fausto Ayres
 *
 */

package modelo;

import java.util.ArrayList;

import repositorio.Repositorio;

public class Conta {
  private int id;
  private String chavepiks;
  private double saldo = 0;
  private Cliente cliente;
  private ArrayList<Lancamento> lancamentos = new ArrayList<>();

  public Conta(int id, String chave) throws Exception {
    if (chave == null)
      throw new Exception("Chave piks necessária para criação de conta");
      
    setChavePiks(chave);
  }

  public Conta(int id, String chave, double saldo) throws Exception {
    this(id, chave);

    this.saldo = saldo;
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

  public String getChavePiks() {
    return chavepiks;
  }

  public void setChavePiks(String chave) throws Exception {
    if (Repositorio.localizarConta(chave) != null)
      throw new Exception("Chave PIKS já registrada");

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

  public void transferir(Conta conta, double valor) throws Exception {
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
