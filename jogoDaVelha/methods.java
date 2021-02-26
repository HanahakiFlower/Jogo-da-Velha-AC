package jogoDaVelha;

import java.util.Arrays;

public class methods {

    public static char [ ][ ] initialize() {
        char[][] M = new char[3][3];            // cria a matrix 3x3.
        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                M[i][j] = ' ';                  // preenche cada elemento da matriz com 1 espaçamento.
            }
        }
        return M;
    }
        
    // ----------------------------------------------------------

    public static void showit(char M[][]){      // mostra a matriz em progresso
        for (int i = 0; i < M.length; i++){
            if (i > 0 && i < 3){                // executa os comando abaixo nas linhas[i] da matriz, fazendo exceção a primeira linha.
                System.out.println();           // pula uma linha a cada linha diferente da matriz.
                System.out.println("─┼─┼─");    // faz o design entre as linhas do meio.      
            }
            for (int j=0; j< M[0].length; j++){
                System.out.print(M[i][j]);      // imprime cada elemento da linha[i]
                if(j < M.length-1){             // executa o comando abaixo, fazendo exceção ao último elemento[j].
                    System.out.print("|");      // é imprimido como separador dos elementos.
                }
                
            }
        }
    }


    // ---------------------------------------------------------- 






}