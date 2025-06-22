package chessGame.model;

import chessGame.service.MovementStrategy;

public class King extends Piece{
    public King(boolean isWhitePiece, MovementStrategy movementStrategy) {
        super(isWhitePiece,movementStrategy);
    }
}
