/**
 * SI - POO - Prof. Fausto Ayres
 *
 */
package modelo;

public class Cliente {
  private int cpf;
  private String nome;
  private Conta conta;

  public Cliente(Integer cpf, String nome) throws Exception {
    if (cpf == null)
      throw new Exception("Cliente precisa de cpf para ser criado");

    if (cpf.toString().length() < 4)
      throw new Exception("Cpf inválido");

    if (nome == null)
      throw new Exception("Cliente precisa de nome para ser criado");

    if (nome.isEmpty())
      throw new Exception("Nome inválido (vazio)");

    this.cpf = cpf;
    this.nome = nome;
  }

  public int getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {    
    this.conta = conta;
  }
}
