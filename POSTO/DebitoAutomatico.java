public class DebitoAutomatico{
    private Cliente cliente;
    private DadosBancario dados;
    public DebitoAutomatico(Cliente cliente, DadosBancario dados){
        this.cliente =  cliente;
        this.dados = dados;
    }
    public void realizarDebito(double valor){
        if (cliente.isCadastrado()){
            dados.validarDadosBancario();
            System.out.println("Debito automático realizado no valor de R$" + valor);
        }else{
            System.out.println("Cliente não cadastrado. ");
        }
    }
}