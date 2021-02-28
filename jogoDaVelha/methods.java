package jogoDaVelha;

import java.util.Scanner;

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

    public static boolean step (char M[][], int lin, int col, char gamer){ 
        
        boolean falseOrTrue = false;

        if(M[lin][col] == ' '){
            falseOrTrue = true;
            M[lin][col] = gamer;
        }

      return falseOrTrue;   
    }

    // ----------------------------------------------------------

    public static int askLine(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPor favor, informe em qual linha deseja fazer sua jogada. (0 a 2) ");
        int lin = sc.nextInt();
        while(lin > 2 || lin < 0){
            System.out.println("Valor inválido!");
            System.out.println("\nPor favor, informe em qual linha deseja fazer sua jogada. (0 a 2) ");
            lin = sc.nextInt();
        }

        return lin;
    
    }

    // ----------------------------------------------------------

    public static int askColumn(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, informe em qual coluna deseja fazer sua jogada. (0 a 2)");
        int col = sc.nextInt();
        while(col > 2 || col < 0){
            System.out.println("Valor inválido!");
            System.out.println("Por favor, informe em qual coluna deseja fazer sua jogada. (0 a 2) ");
            col = sc.nextInt();
        }

        return col;
    
    }

    // ----------------------------------------------------------

    public static int status (char M[ ][ ]){
        int value = 666;

        if (ganhou(M, 'O') == 'O'){
            value = 1;
        } 
        else if (ganhou(M, 'X') == 'X'){
            value = 2;
        }
        
        if (fullMatrix(M) == true && value != 1 && value != 2){ // se a matriz foi preenchida e ninguém ganhou, empate.
           value = 0;
        }

        if (fullMatrix(M) == false && value != 1 && value != 2){ // se a matriz não foi preenchida e ninguém ganhou, continua.
            value = -1;
        }

        switch (value){
            case 0:
                System.out.println("\n\nEmpate!");
                break;
            case 1:
                System.out.println("\n\nJogador O ganhou!");
                break;
            case 2:
                System.out.println("\n\nJogador X ganhou!");
                break; 
        }
            
        
        return value;
    }
    

    // ----------------------------------------------------------

    public static char ganhou (char M[ ][ ], char player){ // verifica se determinado jogador ganhou
        char result = 'N';

        for (int i=0; i < M.length; i++){
            if ((M[i][0] == player && M[i][1] == player && M[i][2] == player) || 
            (M[0][i] == player && M[1][i] == player && M[2][i] == player)) {
                result = player;
                  
            }
            
            }

        int count = 0;

        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                if(i == j){
                    if(M[i][j] == player){
                        count += 1;
                    }
                }
            }

        if (count == 3){
            result = player;
            }
        }

        if (M[0][2] == player && M[1][1] == player && M[2][0] == player){
            result = player;
        }

        return result;
    }

    // ----------------------------------------------------------

    public static boolean fullMatrix(char M[][]){ // verifica se a matriz já foi completamente preenchida
        boolean result;
        int count = 0;

        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                if(M[i][j] != ' '){
                    count +=1;
            }
        }
    }

        if (count == 9){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    // ----------------------------------------------------------

    public static void game(){
            
        char M[][] = methods.initialize();
        char player = 'N';

        System.out.println();
        showit(M);

        for (int i=0; i < 10; i++){
            if (i % 2 == 0){
                player = 'O';
            }
            else{
                player = 'X';

            }

            System.out.print("\n\nVez do jogador: " + player);

            boolean bool = step(M, methods.askLine(), methods.askColumn(), player);
            if (bool == false){
                do{
                    System.out.print("\nCampo já preenchido!");
                    bool = step(M, methods.askLine(), methods.askColumn(), player);
                }while(bool == false);
                
                
            }
            System.out.println();
            showit(M);
            int x = status(M);

            if (x == 1 || x == 2 || x == 0){
                break;
            }

        }

    }










    


    // ----------------------------------------------------------

}

    

    

 

