package brunojoaomariana;
 
import java.util.Scanner;
 
/*********************************************************************/
/** Centro Universitario Senac **/
/** TADS - 1o semestre de 2024 **/
/** Prof. Fernando Almeida **/
/** **/
/** Projeto SEMESTRAL I **/
/** Arquivo: JogoDaVelha **/
/** **/
/** Bruno Leonardo Silva **/
/** João Victor de Souza Cavalcanti**/
/** Mariana Vidal Vaz**/
/** **/
/** 27/05/2024**/
/*********************************************************************/
 
public class JogoDaVelha {
 
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] tabuleiro = inicializarTabuleiro();
        menu(input, tabuleiro);
        
        

    }
    public static void menu(Scanner input, String[][] tabuleiro){
        int opcaoMenu;
        do {
            System.out.println("1 - JOGAR");
            System.out.println("2 - INSTRUÇÕES");

            System.out.print("\nOpção: ");
            opcaoMenu = input.nextInt();

            switch(opcaoMenu) {
                case 1:
                    System.out.println("\n\n=-=-=-=-=-= INICIANDO JOGO =-=-=-=-=-=\n\n");
                    System.out.println("[1] Usuário contra usuário - [2] Usuário contra máquina(Fácil) - [3] Usuário contra máquina(Difícil)");
                    System.out.print("\nOpção: ");
                    int modoDeJogo = input.nextInt();
                    opcaoMenu = 0;
                    modoJogo(tabuleiro, input, modoDeJogo);
                    break;
                
                case 2:
                    instrucoes();
                    break;
                
            }
        }while (opcaoMenu > 2 || opcaoMenu < 1);

    }

    public static void instrucoes(){
        System.out.println("\nJOGADOR-USUÁRIO CONTRA JOGADOR-USUÁRIO:\nNesse modo, todas as jogadas serão feitas de forma alternada por jogadores-usuários. Sendo assim, um deles será o X e o outro o O\n");
        System.out.println("\nJOGADOR-USUÁRIO CONTRA A MÁQUINA - (NÍVEL FÁCIL):\nNesse modo, o jogador deve jogar contra a máquina. No modo fácil, a máquina não tem estratégia alguma, isto é, ela irá jogar aleatoriamente nas posições que estiverem disponíveis no tabuleiro\n");
        System.out.println("\nJOGADOR-USUÁRIO CONTRA A MÁQUINA - (NÍVEL DIFÍCIL):\nNesse modo, a máquina deve tentar seguir o raciocínio da Jogada Perfeita. Em suma, a não ser em condições especiais, o jogador deve ter preferência pela posição central, seguida pelos cantos, seguidos pelas bordas\n");
    }

    public static String[][] inicializarTabuleiro(){
        String[][] jogoDaVelha = new String[3][3];
        for(int i =0; i < jogoDaVelha.length; i++){
            for(int j = 0; j<jogoDaVelha[i].length; j++){
                jogoDaVelha[i][j]=" ";
            }
        }
        return jogoDaVelha;
    }
    public static void imprimirTabuleiro(String[][] tabuleiro){
        System.out.println("\n   A   B   C ");
        for(int i =0; i < tabuleiro.length; i++){
            if(i>0){
                System.out.println("");
            }
            System.out.printf("%d ", i);
            for(int j = 0; j<tabuleiro[i].length; j++){
                System.out.printf("[%s] ", tabuleiro[i][j]);
            } 
        }
        System.out.println("");
    }
    public static boolean posicaoValida(String posicao){
        if(!posicao.equals(" ")){
            System.out.println("\n*=* Posição Inválida! *=*\n");
            return false;
        }else{
            // System.out.println("\n*=* Posição Válida! *=*\n");
            return true;
        }
}
    public static void modoJogo(String[][] tabuleiro, Scanner input, int modoDeJogo){
        boolean validacao = true;
        System.out.println("*=* JOGADOR x JOGADOR *=*\n");
        
        if(modoDeJogo == 1){
            System.out.println("Insira os nomes dos jogadores: \n");
            System.out.print("Jogador 1: ");
            String jog1 = input.next();
            System.out.print("Jogador 2: ");
            String jog2 = input.next();
            System.out.println("");

            jogar(tabuleiro, input, jog1, jog2);
        }


        
    }
    public static void jogar(String[][] tabuleiro, Scanner input, String jogador1, String jogador2){
        boolean jogoAcabou = false;
        int turno = 0;
        int posicaoHorizontal = 3;
        int posicaoVertical = 3;
        boolean valida;
        String nomeJogador = " ";
        
        while(!jogoAcabou){
            String jogador = " ";
            if(turno % 2 == 0){
                jogador = "X";
                nomeJogador = jogador1;
            }else{
                jogador = "O";
                nomeJogador = jogador2;
            }
            imprimirTabuleiro(tabuleiro);
            System.out.println("");
            do{

                do{
                    
                    System.out.printf("\nVez de: %s (%s)%n", nomeJogador, jogador);
                    System.out.println("Posição Horizontal [A] [B] [C]");
                    System.out.print("Opção: ");
                    String pHorizontal = input.next();
                    pHorizontal = pHorizontal.toLowerCase();

                    switch(pHorizontal){
                        case "a":
                            posicaoHorizontal = 0;
                            break;
                        case "b":
                            posicaoHorizontal = 1;
                            break;
                        case "c":
                            posicaoHorizontal = 2;
                            break;
                        default:
                            System.out.println("Posição Inválida!");
                    }


                }while(posicaoHorizontal < 0 || posicaoHorizontal > 2);
                do{

                    System.out.println("Posição Vertical [0] [1] [2]");
                    System.out.print("Opção: ");
                    posicaoVertical = input.nextInt();

                    if(posicaoVertical < 0 || posicaoVertical > 2){
                        System.out.println("\n*=* Posição Inválida *=*\n");
                    }


                }while(posicaoVertical < 0 || posicaoVertical > 2);
               valida = posicaoValida(tabuleiro[posicaoVertical][posicaoHorizontal]);
            }while(!valida);
            
            tabuleiro[posicaoVertical][posicaoHorizontal] = jogador;
            turno++;
            
            if (verificaVencedor(tabuleiro, jogador1, jogador2)) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("\nJogo acabou!\n\n");
                jogoAcabou = true;
            } else if (verificaVelha(turno)) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("\n\nJogo acabou em empate!\n\n");
                jogoAcabou = true;
            }
        }
        
    }

    public static boolean verificaVencedor(String[][] tabuleiro, String jog1, String jog2){
        
        String nomeJogador = "null";
                
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (!tabuleiro[i][0].equals(" ") && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2])) {
                if(tabuleiro[i][0] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[i][0] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[i][0];
                }
                
                System.out.printf("\n\nJogador %s venceu!\n", nomeJogador);
                return true;
            }
        }
        
        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (!tabuleiro[0][i].equals(" ") && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i])) {
                if(tabuleiro[0][i] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[0][i] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[0][i];
                }
                System.out.printf("\n\nJogador %s venceu!\n\n", nomeJogador);
                return true;
            }
        }
        
        // Verifica diagonais
        if (!tabuleiro[0][0].equals(" ") && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2])) {
            if(tabuleiro[0][0] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[0][0] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[0][0];
                }
            System.out.printf("\n\nJogador %s venceu!\n\n", nomeJogador);
            return true;
        }
        if (!tabuleiro[0][2].equals(" ") && tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[0][2].equals(tabuleiro[2][0])) {
            if(tabuleiro[0][2] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[0][2] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[0][2];
                }
            System.out.printf("\n\nJogador %s venceu!\n\n", nomeJogador);
            return true;
        }
        
        return false;
    }
    
    public static boolean verificaVelha(int turno){
        return turno >= 9;
    }
}
