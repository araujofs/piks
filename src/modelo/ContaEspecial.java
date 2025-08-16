/**
 * SI - POO - Prof. Fausto Ayres
 *
 */
package modelo;

public class ContaEspecial extends Conta {
  private double limite;

  public ContaEspecial(int id, String chave, double limite) throws Exception {
    super(id, chave);

    this.limite = limite;
  }

  public ContaEspecial(int id, String chave, double saldo, double limite) throws Exception {
    this(id, chave, limite);

    setSaldo(saldo);
  }
  
  @Override
  public void debitar(double valor) throws Exception {
    if ((getSaldo() + limite) < valor)
      throw new Exception("Saldo e/ou limite insuficiente");

    double novoSaldo = getSaldo() - valor;

    if (novoSaldo < 0) {
      this.limite -= Math.abs(novoSaldo);
      novoSaldo = 0;
    }
    setSaldo(novoSaldo);
  }

  public double getLimite() {
    return limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }

  @Override
  public String toString() {
    return "{id: " + getId() + ", chavepiks: " + getChavePiks() + ", saldo: " + getSaldo() + ", limite: " + limite + ", cpf: " + getCliente().getCpf() + ", nome: " + getCliente().getNome() + "}";
  }
}
