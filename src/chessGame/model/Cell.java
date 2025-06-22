package chessGame.model;

public class Cell {
    private int row,col;
    private Piece piece;

    public Cell(int row, int col,Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
