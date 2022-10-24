package CNS;

import java.util.Random;

public class GeradorCns {
    public String CNS_gerado_aleatoriamente() {
        Random random = new Random();
        int inicial = random.nextInt((9 - 7) + 1) + 7;

        int[] numeros_meio = new int[10];
        for (int i = 0; i <= 9; i++) {
            numeros_meio[i] = random.nextInt(10);
        }

        StringBuilder concatenar = new StringBuilder(Integer.toString(inicial));
        for (int i = 0; i <= 9; i++) {
            concatenar.append(Integer.toString(numeros_meio[i]));
        }
        return(segundo_bloco(String.valueOf(concatenar)));
    }

    public static String segundo_bloco(String primeiro_bloco) {

        float soma;

        soma = ((Integer.valueOf(primeiro_bloco.substring(0, 1)).intValue()) * 15) +
                ((Integer.valueOf(primeiro_bloco.substring(1, 2)).intValue()) * 14) +
                ((Integer.valueOf(primeiro_bloco.substring(2, 3)).intValue()) * 13) +
                ((Integer.valueOf(primeiro_bloco.substring(3, 4)).intValue()) * 12) +
                ((Integer.valueOf(primeiro_bloco.substring(4, 5)).intValue()) * 11) +
                ((Integer.valueOf(primeiro_bloco.substring(5, 6)).intValue()) * 10) +
                ((Integer.valueOf(primeiro_bloco.substring(6, 7)).intValue()) * 9) +
                ((Integer.valueOf(primeiro_bloco.substring(7, 8)).intValue()) * 8) +
                ((Integer.valueOf(primeiro_bloco.substring(8, 9)).intValue()) * 7) +
                ((Integer.valueOf(primeiro_bloco.substring(9, 10)).intValue()) * 6) +
                ((Integer.valueOf(primeiro_bloco.substring(10, 11)).intValue()) * 5);

        int restante = (int) (soma / 11);
        restante = (int) ((11 * (restante + 1)) - soma);

        int[] digitos_restante = new int[15];

        //*Primeiro numero - multiplo de 4
        for (int i = 0; i <= 9; i++) {
            if (i * 4 <= restante) {
                restante = restante - (i * 4);
                digitos_restante[0] = i;
            }
        }

        //*Segundo numero
        for (int i = 0; i <= 9; i++) {
            if (i * 3 <= restante) {
                restante = restante - (i * 3);
                digitos_restante[1] = i;
            }
        }

        //*Terceiro numero
        for (int i = 0; i <= 9; i++) {
            if (i * 2 <= restante) {
                restante = restante - (i * 2);
                digitos_restante[2] = i;
            }
        }

        //*Quarto numero
        for (int i = 0; i <= 9; i++) {
            if (i * 1 <= restante) {
                digitos_restante[3] = i;
            }
        }

        //Concatena o valor enviado mais os ultimos 4 do calculo
        StringBuilder Cns_final = new StringBuilder(primeiro_bloco);
        for (int i = 0; i <= 3; i++) {
            Cns_final.append(Integer.toString(digitos_restante[i]));
        }
        return Cns_final.toString();
    }
}
