/**
 * SI - POO - Prof. Fausto Ayres
 *
 */
package modelo;

import repositorio.Repositorio;

public class Cliente {
  private int cpf;
  private String nome;
  private Conta conta;

  public Cliente(Integer cpf, String nome) throws Exception {
    if (nome == null)
      throw new Exception("Cliente precisa de nome para ser criado");

    if (nome.isEmpty())
      throw new Exception("Nome inválido (vazio)");

    setCpf(cpf);
    this.nome = nome;
  }

  public int getCpf() {
    return cpf;
  }

  public void setCpf(int cpf) throws Exception {
    if (Integer.valueOf(cpf).toString().length() < 4)
      throw new Exception("Cpf inválido");

    if (Repositorio.localizarCliente(cpf) != null)
      throw new Exception("Cpf já registrado");

    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  @Override
  public String toString() {
    return "{cpf:" + cpf + ", nome:" + nome + ", contaId:" + conta.getId() + "}";
  }
}
