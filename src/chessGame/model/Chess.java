package chessGame.model;

public class Chess {
    private Board chessBoard;
    private Player player1;
    private Player player2;
    private boolean isWhiteTurn;
    private GameState gameState;

    public Chess(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameState = GameState.ACTIVE;
        isWhiteTurn = true;
    }

    public void startGame(){

        while(this.gameState == GameState.ACTIVE){
            if(isWhiteTurn){
                makeMove(new Move(startCell,endCell),player1);
            }
            else{
                makeMove(new Move(startCell,endCell),player2);
            }
        }
    }

}
