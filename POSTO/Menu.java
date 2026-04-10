import java.util.Scanner;

public class Menu {
    public void exibirMenu(Scanner sc) {
        System.out.println("=== Cadastro do Cliente ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        
        Cliente cliente = new Cliente(nome, cpf, telefone, endereco);

        System.out.println("\nEscolha o Serviço:");
        System.out.println("1 - Combustivel (100)");
        System.out.println("2 - Lavagem (50)");
        System.out.println("3 - Estacionamento Rotativo (30)");
        System.out.println("4 - Estacionamento Mensal (300)");
        
        int opcao = sc.nextInt();
        sc.nextLine();

        Servico servico = null;
        switch (opcao) {
            case 1:
                servico = new Servico("Combustivel", 100, 0);
                break;
            case 2:
                servico = new Servico("Lavagem", 50, 0);
                break;
            case 3:
            servico = new Servico("Rotativo", 30, 0);
            break;
            case 4:
            servico = new Servico("Mensal", 300, 0);
            break;
            default:
                System.out.println("Opção Inválida!");
        }

        if (servico != null) {
            System.out.print("\nDeseja Desconto? (S/N): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("S")) {
                System.out.print("Valor do Desconto: ");
                double valorDesconto = sc.nextDouble();
                sc.nextLine();
                servico.aplicarDesconto(valorDesconto);
            }

            System.out.println("\nTipo de Cobrança (1- Automatica / 2- Mensal):");
            int tipo = sc.nextInt();
            sc.nextLine();
            String tipoCobranca = (tipo == 2) ? "Mensal" : "Automatico";
            Conta conta = new Conta(1, 0.0, tipoCobranca);
            conta.adiconarServico(servico);
            
            System.out.println("\n--- Resumo da Conta ---");
            conta.imprimirConta();

            System.out.println("\nForma de Pagamento:");
            System.out.println("1 - à Vista\n2 - Pix\n3 - Cartão\n4 - Debito Automatico");
            int pag = sc.nextInt();
            sc.nextLine();

            if (pag == 4) {
                System.out.println("\n=== Dados Bancários ===");
                System.out.print("Banco: ");
                int banco = sc.nextInt();
                System.out.print("Agência: ");
                int agencia = sc.nextInt();
                System.out.print("Conta Corrente: ");
                int cc = sc.nextInt();
                sc.nextLine();

                DadosBancario dados = new DadosBancario(banco, agencia, cc);
                DebitoAutomatico debito = new DebitoAutomatico(cliente, dados);
                debito.realizarDebito(conta.getValorTotal());
            } else {
                String tipoPagamento = switch (pag) {
                    case 1 -> "à Vista";
                    case 2 -> "Pix";
                    case 3 -> "Cartão";
                    default -> "Não especificado";
                };
                Pagamento pagamento = new Pagamento(tipoPagamento, conta.getValorTotal());
                pagamento.realizarPagamento();
            }
        }
    }
}