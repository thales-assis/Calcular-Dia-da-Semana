package br.com.calculardiadasemana.application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite uma data para mostrar qual foi o seu respectivo dia da semana! Exemplo: 04/03/1998");
        System.out.print("Data: ");

        String data = input.nextLine();

        String[] valores = data.split("/");

        calcularDiaDaSemana(Integer.valueOf(valores[0]), Integer.valueOf(valores[1]), Integer.valueOf(valores[2]));
    }

    public static void calcularDiaDaSemana(int dia, int mes, int ano) {

        int diaDaSemana = -1;

        // Verifica se é um ano Bissexto, se o dia está entre ( 01 - 31 ) e se o mês está entre ( 01 - 12 )
        if ((ano % 4 == 0 && (ano % 400 == 0 || ano % 100 != 0)) && (dia > 0 && dia <= 31) && (mes > 0 && mes <= 12)) {

            // Verifica se os meses de até 30 dias não estão corretos.
            if (mes == 2 && dia > 29 || (( mes == 4 || mes == 6 || mes == 9 || mes == 11 ) && dia > 30) ) {
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " não existe no calendário gregoriano");
            }
            // Se os valores informados estiverem corretos, realiza o cálculo do dia da semana.
            else {
                diaDaSemana = realizarCalculo(dia, mes, ano);
            }
        }
        // Verifica se não é um ano Bissexto, se o dia está entre ( 01 - 31 ) e se o mês está entre ( 01 - 12 )
        else if (!(ano % 4 == 0 && (ano % 400 == 0 || ano % 100 != 0)) && (dia > 0 && dia <= 31) && (mes > 0 && mes <= 12)) {

            // Verifica se os meses de até 30 dias não estão corretos.
            if (mes == 2 && dia > 28 || (( mes == 4 || mes == 6 || mes == 9 || mes == 11 ) && dia > 30) ) {
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " não existe no calendário gregoriano!");
            }
            // Se os valores informados estiverem corretos, realiza o cálculo do dia da semana.
            else {
                diaDaSemana = realizarCalculo(dia, mes, ano);
            }
        }
        // Se a data não existir no calendário gregoriano.
        else {
            System.out.println("A data: " + dia + "/" + mes + "/" + ano + " não existe no calendário gregoriano!");
        }

        switch (diaDaSemana) {
            case 0:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em um Sábado (Saturday)");
                break;

            case 1:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em um Domingo (Sunday)");
                break;

            case 2:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em uma Segunda-feira (Monday)");
                break;

            case 3:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em uma Terca-feira (Tuesday)");
                break;

            case 4:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em uma Quarta-feira (Wednesday)");
                break;

            case 5:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em uma Quinta-feira (Thursday)");
                break;

            case 6:
                System.out.println("A data: " + dia + "/" + mes + "/" + ano + " cai em uma Sexta-feira (Friday)");
                break;
        }


    }

    private static int realizarCalculo(int dia, int mes, int ano) {

        int auxMes;
        int auxAno;

        // Mês de Janeiro será o mês 13 do ano anterior.
        if (mes == 1) {
            auxMes = 13;
            auxAno = ano - 1;
        }
        // Mês de Fevereiro será o mês 14 do ano anterior.
        else if(mes == 2) {
            auxMes = 14;
            auxAno = ano - 1;
        }
        else {
            auxMes = mes;
            auxAno = ano;
        }

        // Formula para calcular o dia da semana
        int formula = dia + 2 * auxMes + (3 * (auxMes + 1) / 5) + auxAno + auxAno / 4 - auxAno / 100 + auxAno / 400 + 2;

        // Encontra o dia da semana correspondente – sendo 0 - Sábado (Saturday) até 6 - Sexta-feira (Friday) – através do resto da divisão por 7.
        int diaDaSemana = formula % 7;

        return diaDaSemana;
    }

}
