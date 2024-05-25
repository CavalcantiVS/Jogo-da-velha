package jogodavelha;
 
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
        imprimeMenuPrincipal(input);
        
        

    }
    public static void imprimeMenuPrincipal(Scanner input){
        int opcaoMenu;
        do {
            System.out.println("1 - JOGAR");
            System.out.println("2 - INSTRUÇÕES");

            System.out.print("\nOpção: ");
            opcaoMenu = input.nextInt();
            int modoDeJogo;

            switch(opcaoMenu) {
                case 1:
                    System.out.println("\n\n=-=-=-=-=-= INICIANDO JOGO =-=-=-=-=-=\n");
                    do{
                        String[][] tabuleiro = inicializarTabuleiro();
                        System.out.println("\n[1] Usuário contra usuário - [2] Usuário contra máquina(Fácil) - [3] Usuário contra máquina(Difícil)");
                        System.out.print("\nOpção: ");
                        modoDeJogo = input.nextInt();
                        opcaoMenu = 0;
                        if(modoDeJogo == 1){
                            modoJogador(tabuleiro, input, modoDeJogo);
                        }else if(modoDeJogo == 2){
                            
                        }else if(modoDeJogo == 3){
                            modoDificil(tabuleiro, input, modoDeJogo);
                        }
                        
                    }while(modoDeJogo < 1 || modoDeJogo > 3);
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
            // System.out.println("\n*=* Posição Inválida! *=*\n");
            return false;
        }else{
            // System.out.println("\n*=* Posição Válida! *=*\n");
            return true;
        }
}
    public static void modoJogador(String[][] tabuleiro, Scanner input, int modoDeJogo){
        boolean validacao = true;
        System.out.println("\n\n*=* JOGADOR x JOGADOR *=*\n");
        
        if(modoDeJogo == 1){
            System.out.println("Insira os nomes dos jogadores\n");
            System.out.print("Jogador 1: ");
            String jog1 = input.next();
            System.out.print("Jogador 2: ");
            String jog2 = input.next();
            System.out.println("");

            jogar(tabuleiro, input, jog1, jog2, modoDeJogo);
        }
        
    }
    public static void modoDificil(String[][] tabuleiro, Scanner input, int modoDeJogo){
        boolean validacao = true;
        System.out.println("\n\n*=* JOGADOR x MÁQUINA - NÍVEL DIFÍCIL *=*\n");
        
        System.out.println("Insira o seu nome\n");
        System.out.print("Jogador: ");
        String jog1 = input.next();
        String jog2 = "Computador";
        System.out.println("");

        jogar(tabuleiro, input, jog1, jog2, modoDeJogo);
        
    }
    public static void jogar(String[][] tabuleiro, Scanner input, String jogador1, String jogador2, int modoJogo){
        boolean jogoAcabou = false;
        int turno = 0;
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
            
            if(modoJogo == 1){
                jogadaUsuario(input, tabuleiro, jogador, nomeJogador);
                turno++;
            }else if(modoJogo == 2){
                //jogadaMaquinaFacil
                if(turno % 2 == 0){
                    jogadaUsuario(input, tabuleiro, jogador, nomeJogador);
                    turno++;
                }else{
                    //jogadaMaquinaFacil(tabuleiro, jogador, nomeJogador);
                    turno++;
                }
            }else if(modoJogo == 3){
                //jogadaMaquinaDificil
                if(turno % 2 == 0){
                    jogadaUsuario(input, tabuleiro, jogador, nomeJogador);
                    turno++;
                }else{
                    jogadaMaquinaDificil(tabuleiro, jogador, nomeJogador);
                    turno++;
                }
            }
                        
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

    public static String[][] jogadaUsuario(Scanner input, String[][] tabuleiro, String jogador, String nomeJogador){
        boolean valida;
        do{
                System.out.printf("\nVez de: %s (%s)%n", nomeJogador, jogador);
                int posicaoHorizontal = leiaCoordenadaColuna(input);
                int posicaoVertical = leiaCoordenadaLinha(input);
                
                valida = posicaoValida(tabuleiro[posicaoVertical][posicaoHorizontal]);
                if(valida){
                    tabuleiro[posicaoVertical][posicaoHorizontal] = jogador;
                }
                
            }while(!valida);
        
        return tabuleiro;
    }
    
    public static String[][] jogadaMaquinaDificil(String[][] tabuleiro, String jogador, String nomeJogador) {
    boolean valida;
    int posicaoHorizontal = -1;
    int posicaoVertical = -1;

    // Verifica se consegue ganhar de cada jeito
    for (int i = 0; i < 3; i++) {
        if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(" ")) {
            posicaoHorizontal = 2;
            posicaoVertical = i;
            break;
        }
        if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][2].equals(jogador) && tabuleiro[i][1].equals(" ")) {
            posicaoHorizontal = 1;
            posicaoVertical = i;
            break;
        }
        if (tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador) && tabuleiro[i][0].equals(" ")) {
            posicaoHorizontal = 0;
            posicaoVertical = i;
            break;
        }        if (tabuleiro[0][i].equals(jogador) && tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 2;
            break;
        }
        if (tabuleiro[0][i].equals(jogador) && tabuleiro[2][i].equals(jogador) && tabuleiro[1][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 1;
            break;
        }
        if (tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(jogador) && tabuleiro[0][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 0;
            break;
        }
    }

    // Agora nas diagonais
    if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(" ")) {
        posicaoHorizontal = 2;
        posicaoVertical = 2;
    }
    if (tabuleiro[0][0].equals(jogador) && tabuleiro[2][2].equals(jogador) && tabuleiro[1][1].equals(" ")) {
        posicaoHorizontal = 1;
        posicaoVertical = 1;
    }
    if (tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador) && tabuleiro[0][0].equals(" ")) {
        posicaoHorizontal = 0;
        posicaoVertical = 0;
    }
    if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(" ")) {
        posicaoHorizontal = 0;
        posicaoVertical = 2;
    }
    if (tabuleiro[0][2].equals(jogador) && tabuleiro[2][0].equals(jogador) && tabuleiro[1][1].equals(" ")) {
        posicaoHorizontal = 1;
        posicaoVertical = 1;
    }
    if (tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador) && tabuleiro[0][2].equals(" ")) {
        posicaoHorizontal = 2;
        posicaoVertical = 0;
    }

    // Se encontrou um jeito, vai coloca rla
    if (posicaoHorizontal != -1 && posicaoVertical != -1) {
        tabuleiro[posicaoVertical][posicaoHorizontal] = jogador;
        return tabuleiro;
    }

    // Se não pode ganhar ele vê se consegue bloquear a vitória do jogador
    String adversario = (jogador.equals("X")) ? "O" : "X";

    for (int i = 0; i < 3; i++) {
        if (tabuleiro[i][0].equals(adversario) && tabuleiro[i][1].equals(adversario) && tabuleiro[i][2].equals(" ")) {
            posicaoHorizontal = 2;
            posicaoVertical = i;
            break;
        }
        if (tabuleiro[i][0].equals(adversario) && tabuleiro[i][2].equals(adversario) && tabuleiro[i][1].equals(" ")) {
            posicaoHorizontal = 1;
            posicaoVertical = i;
            break;
        }
        if (tabuleiro[i][1].equals(adversario) && tabuleiro[i][2].equals(adversario) && tabuleiro[i][0].equals(" ")) {
            posicaoHorizontal = 0;
            posicaoVertical = i;
            break;
        }
    }

    for (int i = 0; i < 3; i++) {
        if (tabuleiro[0][i].equals(adversario) && tabuleiro[1][i].equals(adversario) && tabuleiro[2][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 2;
            break;
        }
        if (tabuleiro[0][i].equals(adversario) && tabuleiro[2][i].equals(adversario) && tabuleiro[1][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 1;
            break;
        }
        if (tabuleiro[1][i].equals(adversario) && tabuleiro[2][i].equals(adversario) && tabuleiro[0][i].equals(" ")) {
            posicaoHorizontal = i;
            posicaoVertical = 0;
            break;
        }
    }

    if (tabuleiro[0][0].equals(adversario) && tabuleiro[1][1].equals(adversario) && tabuleiro[2][2].equals(" ")) {
        posicaoHorizontal = 2;
        posicaoVertical = 2;
    }
    if (tabuleiro[0][0].equals(adversario) && tabuleiro[2][2].equals(adversario) && tabuleiro[1][1].equals(" ")) {
        posicaoHorizontal = 1;
        posicaoVertical = 1;
    }
    if (tabuleiro[1][1].equals(adversario) && tabuleiro[2][2].equals(adversario) && tabuleiro[0][0].equals(" ")) {
    posicaoHorizontal = 0;
    posicaoVertical = 0;
    }
    if (tabuleiro[0][2].equals(adversario) && tabuleiro[1][1].equals(adversario) && tabuleiro[2][0].equals(" ")) {
    posicaoHorizontal = 0;
    posicaoVertical = 2;
    }
    if (tabuleiro[0][2].equals(adversario) && tabuleiro[2][0].equals(adversario) && tabuleiro[1][1].equals(" ")) {
    posicaoHorizontal = 1;
    posicaoVertical = 1;
    }
    if (tabuleiro[1][1].equals(adversario) && tabuleiro[2][0].equals(adversario) && tabuleiro[0][2].equals(" ")) {
    posicaoHorizontal = 2;
    posicaoVertical = 0;
    }

    // Se encontrou uma posição para bloquear, ele bloqueia
    if (posicaoHorizontal != -1 && posicaoVertical != -1) {
        tabuleiro[posicaoVertical][posicaoHorizontal] = jogador;
    } else {
        // Se não há jogada para bloquear ou ganhar, segue a lógica de posição
        if (tabuleiro[1][1].equals(" ")) {
            posicaoHorizontal = 1;
            posicaoVertical = 1;
        } else {
            for (int i = 0; i < tabuleiro.length; i += 2) {
                for (int j = 0; j < tabuleiro[i].length; j += 2) {
                    if (tabuleiro[i][j].equals(" ")) {
                        posicaoHorizontal = j;
                        posicaoVertical = i;
                        break;
                    }
                }
            }
        }
        tabuleiro[posicaoVertical][posicaoHorizontal] = jogador;
    }

    return tabuleiro;
}
    
    public static boolean verificaVencedor(String[][] tabuleiro, String jog1, String jog2){
        
        String nomeJogador = "null";
                
        for (int i = 0; i < 3; i++) {
            if (!tabuleiro[i][0].equals(" ") && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2])) {
                if(tabuleiro[i][0] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[i][0] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[i][0];
                }
                
                System.out.printf("\n\nJogador(a) %s venceu!\n", nomeJogador);
                return true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (!tabuleiro[0][i].equals(" ") && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i])) {
                if(tabuleiro[0][i] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[0][i] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[0][i];
                }
                System.out.printf("\n\nJogador(a) %s venceu!\n\n", nomeJogador);
                return true;
            }
        }
        
        if (!tabuleiro[0][0].equals(" ") && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2])) {
            if(tabuleiro[0][0] == "X"){
                    nomeJogador = jog1;
                }else if(tabuleiro[0][0] == "O"){
                    nomeJogador = jog2;
                }else{
                    nomeJogador = tabuleiro[0][0];
                }
            System.out.printf("\n\nJogador(a) %s venceu!\n\n", nomeJogador);
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
            System.out.printf("\n\nJogador(a) %s venceu!\n\n", nomeJogador);
            return true;
        }
        
        return false;
    }
    
    public static int leiaCoordenadaLinha(Scanner input) {
        System.out.print("Digite a coordenada da linha (0|1|2): ");
        while (true) {
            try {
                int linha = input.nextInt();
                if (linha >= 0 && linha <= 2) {
                    return linha;
                } else {
                    System.out.print("\nCoordenada inválida. Valores 0|1|2: \n");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite número 0, 1 ou 2: ");
            }
        }
    }
    
    public static int leiaCoordenadaColuna(Scanner input) {
        System.out.print("Digite a coordenada da coluna (A|B|C): ");
        while (true) {
            String inputColuna = input.next().toUpperCase();
            switch (inputColuna) {
                case "A":
                    return 0;
                case "B":
                    return 1;
                case "C":
                    return 2;
                default:
                    System.out.print("\nCoordenada inválida. Digite A, B ou C: \n");
            }
        }
    }
    
    public static boolean verificaVelha(int turno){
        return turno >= 9;
    }
}
