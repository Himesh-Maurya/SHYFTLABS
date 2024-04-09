// Implementation of Entities in a Game of Chess

import java.util.Arrays;

enum PieceType {
    KING,
    QUEEN,
    ROOK,
    BISHOP,
    KNIGHT,
    PAWN
}

enum PieceColor {
    WHITE,
    BLACK
}

class ChessPiece {
    private final PieceType type;
    private final PieceColor color;

    public ChessPiece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }
}


class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];

    public void placePiece(ChessPiece piece, int x, int y) {
        board[x][y] = piece;
    }

    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }
}


class ChessPlayer {
    private final PieceColor color;

    public ChessPlayer(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }
}


class ChessGame {
    private final ChessBoard board = new ChessBoard();
    private final ChessPlayer player1;
    private final ChessPlayer player2;

    public ChessGame(ChessPlayer player1, ChessPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void placePiece(ChessPiece piece, int x, int y) {
        board.placePiece(piece, x, y);
    }

    public void makeMove(int startX, int startY, int endX, int endY) {
        ChessPiece piece = board.getPiece(startX, startY);

        if (piece.getColor() == player1.getColor()) {
            board.placePiece(piece, endX, endY);
        } else if (piece.getColor() == player2.getColor()) {
            board.placePiece(piece, endX, endY);
        }
    }
}


public class Question2 {
    public static void main(String[] args) {
        ChessPlayer player1 = new ChessPlayer(PieceColor.WHITE);
        ChessPlayer player2 = new ChessPlayer(PieceColor.BLACK);

        ChessGame game = new ChessGame(player1, player2);

    
        ChessPiece whitePawn = new ChessPiece(PieceType.PAWN, PieceColor.WHITE);
        game.placePiece(whitePawn, 0, 0);

     
        game.makeMove(0, 0, 1, 0);
    }
}