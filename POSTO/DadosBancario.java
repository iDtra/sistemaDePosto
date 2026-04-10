public class DadosBancario{
    private int numeroBanco;
    private int agencia;
    private int contaCorrente;
    public DadosBancario(int numeroBanco, int agencia, int contaCorrente){
        this.numeroBanco = numeroBanco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
    }
    public void validarDadosBancario(){
        System.out.println("Dados Bancarios Validados!");
    }
}