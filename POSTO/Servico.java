public class Servico {
    private String tipoServico;
    private double precoFixo;
    private double desconto;
    public Servico(String tipoServico, double precoFixo, double desconto){
        this.tipoServico = tipoServico;
        this.precoFixo = precoFixo;
        this.desconto = desconto;
    }
    public void aplicarDesconto(double desconto){
        this.desconto = desconto;
    }
    public double calcularPrecoFinal(){
        return precoFixo - desconto;
    }
    public String getTipoServico(){
        return tipoServico;
    }
}
