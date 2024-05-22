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
        int turno = 0;
        menu(input, tabuleiro, turno);
        
        

    }
    public static void menu(Scanner input, String[][] tabuleiro, int turno){
        int opcaoMenu;
        do {
            System.out.println("1 - JOGAR");
            System.out.println("2 - INSTRUÇÕES");

            System.out.print("Opção: ");
            opcaoMenu = input.nextInt();

            switch(opcaoMenu) {
                case 1:
                    System.out.println("\n=-=-=-=-=-= INICIANDO JOGO =-=-=-=-=-=");
                    opcaoMenu = 4;
                    jogar(tabuleiro, input, turno);
                    break;
                
                case 2:
                    instrucoes();
                    break;
            }
        }while (opcaoMenu > 2 || opcaoMenu < 1);

        System.out.println("[1] Usuário contra usuário - [2] Usuário contra máquina(Fácil) - [3] Usuário contra máquina(Difícil)");
        int opcao = input.nextInt();
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
        System.out.println("   A   B   C ");
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
            System.out.println("\n*=* Posição Válida! *=*\n");
            return true;
        }
}
    public static void modoJogo(String[][] tabuleiro, Scanner input){
        boolean validacao = true;
        System.out.println("*=* JOGADOR x JOGADOR *=*\n");
        System.out.print("Jogador 1: ");
        String jog1 = input.next();
        System.out.print("Jogador 2: ");
        String jog2 = input.next();

        
    }
    public static void jogar(String[][] tabuleiro, Scanner input, int turno){
        boolean jogoAcabou = false;
        int posicaoHorizontal = 3;
        int posicaoVertical = 3;
        boolean valida;
        while(!jogoAcabou){
            String jogador = " ";
            if(turno % 2 == 0){
                jogador = "X";
            }else{
                jogador = "O";
            }
            imprimirTabuleiro(tabuleiro);
            System.out.println("");
            do{

                do{

                    System.out.println("Posição Vertical [A] [B] [C]");
                    System.out.print("Opção: ");
                    String pVertical = input.next();
                    pVertical = pVertical.toLowerCase();

                    switch(pVertical){
                        case "a":
                            posicaoVertical = 0;
                            break;
                        case "b":
                            posicaoVertical = 1;
                            break;
                        case "c":
                            posicaoVertical = 2;
                            break;
                        default:
                            System.out.println("Posição Inválida!");
                    }


                }while(posicaoVertical < 0 || posicaoVertical > 2);
                do{

                    System.out.println("Posição Horizontal [0] [1] [2]");
                    System.out.print("Opção: ");
                    posicaoHorizontal = input.nextInt();

                    if(posicaoHorizontal < 0 || posicaoHorizontal > 2){
                        System.out.println("\n*=* Posição Inválida *=*\n");
                    }


                }while(posicaoHorizontal < 0 || posicaoHorizontal > 2);
               valida = posicaoValida(tabuleiro[posicaoHorizontal][posicaoVertical]);
            }while(valida == false);
            tabuleiro[posicaoHorizontal][posicaoVertical] = jogador;
            turno++;
            // FAZER FUNÇÃO DE VERIFICAR SE O JOGO ACABOU E CHAMAR AQUI
        }
        
    }
}