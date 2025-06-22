package chessGame.service;

import chessGame.model.Board;
import chessGame.model.Move;

public interface MovementStrategy {
    boolean canMove(Board board, Move move);
}
