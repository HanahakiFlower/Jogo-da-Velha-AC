package jogoDaVelha;

import java.util.Scanner;

public class methods {

    public static char [ ][ ] initialize() {
        char[][] M = new char[3][3];            // Cria a matrix 3x3.
        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                M[i][j] = ' ';                  // Preenche cada elemento da matriz com 1 espaçamento.
            }
        }
        return M;
    }
        
    // ----------------------------------------------------------

    public static void showit(char M[][]){      // Mostra a matriz em progresso.
        for (int i = 0; i < M.length; i++){
            if (i > 0 && i < 3){                // Executa os comando abaixo nas linhas[i] da matriz, fazendo exceção a primeira linha.
                System.out.println();           // Pula uma linha a cada linha diferente da matriz.
                System.out.println("─┼─┼─");    // Faz o design entre as linhas do meio.      
            }
            for (int j=0; j< M[0].length; j++){
                System.out.print(M[i][j]);      // Imprime cada elemento da linha[i].
                if(j < M.length-1){             // Executa o comando abaixo, fazendo exceção ao último elemento[j].
                    System.out.print("|");      // É imprimido como separador dos elementos.
                }
                
            }
        }
    }


    // ---------------------------------------------------------- 

    public static boolean step (char M[][], int lin, int col, char gamer){ 
        
        boolean falseOrTrue = false;        // Atribui o valor false como default ao return.

        if(M[lin][col] == ' '){         
            falseOrTrue = true;
            M[lin][col] = gamer;            // Faz a jogada caso o campo esteja livre.
        }

      return falseOrTrue;   
    }

    // ----------------------------------------------------------

    public static int askLine(){            // Pede a linha desejada ao jogador.
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

    public static int askColumn(){          // Pede a coluna desejada ao jogador.
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
        int value = 9;          // Atribui um valor qualquer para inicializar a variável.

        if (ganhou(M, 'O') == 'O'){     // Se 'O' ganhou, 1.
            value = 1;
        } 
        else if (ganhou(M, 'X') == 'X'){    // Se 'X' ganhou, 2.
            value = 2;
        }
        
        if (fullMatrix(M) == true && value != 1 && value != 2){ // Se a matriz foi preenchida e ninguém ganhou, empate.
           value = 0;
        }

        if (fullMatrix(M) == false && value != 1 && value != 2){ // Se a matriz não foi preenchida e ninguém ganhou, continua.
            value = -1;
        }

        switch (value){     // Diz aos jogadores o status final do jogo, de acordo com cada caso.
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

    public static char ganhou (char M[ ][ ], char player){     // Verifica se determinado jogador ganhou.
        char result = 'N';

        for (int i=0; i < M.length; i++){
            if ((M[i][0] == player && M[i][1] == player && M[i][2] == player) || 
            (M[0][i] == player && M[1][i] == player && M[2][i] == player)) {
                result = player;        // Jogador ganha se o valor de todas as linhas iguais ou colunas iguais estiverem preenchidas com o mesmo jogador.
                  
            }
            }

        int count = 0;      // Inicia uma contagem.

        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                if(i == j){            
                    if(M[i][j] == player){      
                        count += 1;             // Se o número da linha for igual ao número da coluna, adicione 1 á contagem.
                    }
                }
            }

        if (count == 3){
            result = player;        // Se a contagem de linhas e colunas equivalentes preenchidas pelo mesmo jogador chegou a 3, significa que este ganhou o jogo, pela linha vertical "\".
            }
        }

        if (M[0][2] == player && M[1][1] == player && M[2][0] == player){
            result = player;       // Se as determinadas posições forem preenchidas pelo mesmo jogador, significa que este ganhou o jogo, pela linha vertical "/".
        }

        return result;
    }

    // ----------------------------------------------------------

    public static boolean fullMatrix(char M[][]){      // Verifica se a matriz já foi completamente preenchida.
        boolean result;
        int count = 0;          // Inicia uma contagem.

        for (int i=0; i < M.length; i++){
            for (int j=0; j< M[0].length; j++){
                if(M[i][j] != ' '){
                    count +=1;      // Se o determinado elemento não estiver "vazio", adicione 1 a contagem.
            }
        }
    }

        if (count == 9){        // Se 9 elementos foram preenchidos, é true que a matriz foi completa.
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    // ----------------------------------------------------------

    public static void game(){
            
        char M[][] = methods.initialize();      // Dá inicio a uma matriz "vazia".
        char player = 'N';      // Inicializa player com um valor qualquer.

        System.out.println();
        showit(M);

        for (int i=0; i < 10; i++){     // Controla de quem é a vez da jogada (supondo que é sempre 'O' quem começa o jogo), assim como quantas jogadas acontecerão na rodada.
            if (i % 2 == 0){            
                player = 'O';           // Nas rodadas 0, 2, 4, 6 e 8, é a vez de 'O'.
            }
            else{
                player = 'X';           // Nas rodadas 1, 3, 5, 7 e 9, é a vez de 'X'.

            }

            System.out.print("\n\nVez do jogador: " + player);      // Informa de quem é a vez aos jogadores.

            boolean bool = step(M, methods.askLine(), methods.askColumn(), player);
            if (bool == false){
                do{
                    System.out.print("\nCampo já preenchido!");
                    bool = step(M, methods.askLine(), methods.askColumn(), player);
                }while(bool == false);      // Enquanto step() retornar falso ("O campo está vago?"), o método para perguntar o campo continua a ser chamado.
                
            }
            System.out.println();
            showit(M);
            int x = status(M);

            if (x == 1 || x == 2 || x == 0){        // Caso ocorra uma vitória ou um empate, pare a repetição de jogadas (pois o jogo já poderá ser encerrado).
                break;
            }
        }
    }
}

    

    

 

