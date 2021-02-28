package jogoDaVelha;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciar jogo? (y/n)");
        char userReply = sc.next().charAt(0);

        if(userReply == 'y' || userReply == 'Y'){
            do{
                methods.game();
                System.out.println("Jogar novamente? (y/n)");
                userReply = sc.next().charAt(0);
            }while(userReply == 'y' || userReply == 'Y');       // Continua a chamar game() enquanto o usuário queira jogar.
    
        }
        sc.close();
    }
}