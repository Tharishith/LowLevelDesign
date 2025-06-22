package chessGame.model;

public class Board {
    private static Board instance;
    private Cell[][] board;

    private Board(int rows){
        initializeBoard(rows);
    }

    public static Board getInstance(int rows) {
        if (instance == null) {
            instance = new Board(rows);
        }
        return instance;
    }

    private void initializeBoard(int rows){
        board = new Cell[rows][rows];

        // for a black
        setPieceRow(0,true);
        setPawnRow(1,rows,true);

        setPieceRow(rows-1,false);
        setPawnRow(rows-2,rows,false);

        for(int row = 2; row < rows-2;row++){
            for(int col = 0;col< rows;col++){
                board[row][col] = new Cell(row,col,null);
            }
        }
    }

    private void setPieceRow(int row,boolean isWhitePiece){
        Piece king = PieceFactory.createPiece("king",isWhitePiece);
        Piece rook = PieceFactory.createPiece("Rook",isWhitePiece);
        Piece bishop = PieceFactory.createPiece("bishop",isWhitePiece);
        Piece knight = PieceFactory.createPiece("knight",isWhitePiece);
        Piece queen = PieceFactory.createPiece("queen",isWhitePiece);
        board[row][0] = new Cell(row,0,rook);
        board[row][1] = new Cell(row,1,knight);
        board[row][2] = new Cell(row,2,bishop);
        board[row][3] = new Cell(row,3,king);
        board[row][4] = new Cell(row,4,queen);
        board[row][5] = new Cell(row,5,bishop);
        board[row][6] = new Cell(row,6,knight);
        board[row][7] = new Cell(row,7,rook);
    }

    private void setPawnRow(int row, int rows,boolean isWhite){

        Piece pawn = PieceFactory.createPiece("Pawn",isWhite);
        for(int col = 0; col < rows;col++){
            board[row][col] = new Cell(row,col,pawn);
        }
    }

}
