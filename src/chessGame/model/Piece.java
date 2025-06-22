package chessGame.model;

import chessGame.service.MovementStrategy;

public abstract class Piece {
    private boolean isWhitePiece;
    private boolean isKilled = false;
    private MovementStrategy movementStrategy;

    public Piece(boolean isWhitePiece,MovementStrategy movementStrategy) {
        this.isWhitePiece = isWhitePiece;
        this.movementStrategy = movementStrategy;
    }

    public boolean isWhitePiece() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setIsKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public boolean canMove(Board board,Move move){
        return movementStrategy.canMove(board,move);
    }

}
