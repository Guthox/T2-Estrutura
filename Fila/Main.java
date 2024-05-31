import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        Estacionamento estacionamento;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do estacionamento: ");
        int op = Integer.parseInt(sc.nextLine());
        estacionamento = new Estacionamento(op);
        String placa;
        Carro carro;
        Date saida;
        long diff;
        do {
            System.out.println("1) Adicionar Carro");
            System.out.println("2) Remover Carro");
            System.out.println("3) Consultar Carro");
            System.out.println("4) Mostrar estacionamento");
            System.out.println("0) Sair");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Digite a placa do carro: ");
                    placa = sc.nextLine();
                    if (estacionamento.estacionar(placa)){
                        System.out.println("Carro adicionado com sucesso");
                    }
                    else{
                        System.out.println("Não foi possivel estacionar. Estacionamento está cheio.");
                    }
                    break;
                case 2:
                    System.out.println("Digite a placa do carro: ");
                    placa = sc.nextLine();
                    carro = estacionamento.pegarCarro(placa);
                    if (carro == null){
                        System.out.println("Carro não está no estacionamento");
                    }
                    else{
                        System.out.println("Carro removido: " + carro.toString());
                        System.out.println("Numero de manobras ate remover: " + estacionamento.sair(placa).getManobras());
                        saida = new Date();
                        diff = TimeUnit.SECONDS.convert(saida.getTime() - carro.getEntrada().getTime(), TimeUnit.MILLISECONDS);
                        System.out.println("Saida: " + saida + " - Permanencia: " + formatarDiferenca(diff));
                    }
                    break;
                case 3:
                    System.out.println("Digite a placa do carro: ");
                    placa = sc.nextLine();
                    System.out.println(estacionamento.verificarCarro(placa));
                    break;
                case 0:
                    break;
                case 4:
                    System.out.println(estacionamento.toString());
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        } while(op != 0);
        sc.close();
    }



    private static String formatarDiferenca(long segundos) {
        long horas = segundos / 3600;
        long minutos = (segundos % 3600) / 60;
        segundos = segundos % 60;
        
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
