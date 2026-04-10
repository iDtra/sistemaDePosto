public class Conta {
    private int numeroConta;
    private double valorTotal;
    private String tipoCobranca;
    
    public Conta(int numeroConta, double valorTotal, String tipoCobranca){
        this.numeroConta = numeroConta;
        this.valorTotal = valorTotal;
        this.tipoCobranca = tipoCobranca;
    }
    public void adiconarServico(Servico servico){
        valorTotal += servico.calcularPrecoFinal();
    }
    public void imprimirConta(){
        System.out.println("Conta N: " + numeroConta);
        System.out.println("Tipo: " + tipoCobranca);
        System.out.println("Total:" + valorTotal);
    }
    public double getValorTotal(){
        return valorTotal;
    }
}
