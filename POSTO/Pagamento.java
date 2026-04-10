public class Pagamento {
    private String tipoPagamento;
    private double valor;
    public Pagamento(String tipoPagamento, double valor){
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
    }
    public void realizarPagamento(){
        System.out.println("Pagamento realizado via " + tipoPagamento + " no valor de R$ "+ valor);
    }
}
