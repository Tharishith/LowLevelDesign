package chessGame.model;

import chessGame.service.MovementStrategy;

public class Knight extends Piece{
    public Knight(boolean isWhitePiece, MovementStrategy movementStrategy) {
        super(isWhitePiece,movementStrategy);
    }
}
