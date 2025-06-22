package chessGame.model;

import chessGame.service.impl.KingMovementStrategy;
import chessGame.service.impl.KnightMovementStrategy;

public class PieceFactory {
    public static  Piece createPiece(String pieceType,boolean isWhitePiece){
        switch (pieceType.toLowerCase()){
            case "king":
                return new King(isWhitePiece,new KingMovementStrategy());
            case "rook":
                return new Rook(isWhitePiece);
            case "bishop":
                return new Bishop(isWhitePiece);
            case "pawn":
                return new Pawn(isWhitePiece);
            case "knight":
                return new Knight(isWhitePiece,new KnightMovementStrategy());
            default:
                throw  new IllegalArgumentException("Unknown Piece : "+ pieceType);
        }
    }
}
