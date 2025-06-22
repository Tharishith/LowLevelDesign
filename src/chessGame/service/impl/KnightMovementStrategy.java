package chessGame.service.impl;

import chessGame.model.Board;
import chessGame.model.Move;
import chessGame.service.MovementStrategy;

public class KnightMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Move move) {
        return false;
    }
}
