package com.solarwindsmsp.chess;

public class ChessBoard {

    //This means the board is 7x7 not 8x8 like a chess board is supposed to be!!!!!
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    //would this be scalable with additional pieces.  Would need to be refactored to accept additional pieces and would
    // add complexity if not refactored.
    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(isLegalBoardPosition(xCoordinate, yCoordinate)) {
            if (pieces[xCoordinate][yCoordinate] != null) {
                pawn.setYCoordinate(-1);
                pawn.setXCoordinate(-1);
            } else {
                pawn.setYCoordinate(yCoordinate);
                pawn.setXCoordinate(xCoordinate);
                pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = pawn;
            }
        } else {
            pawn.setYCoordinate(-1);
            pawn.setXCoordinate(-1);
        }

//        piec
//        pieces[xCoordinate][yCoordinate];
//        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    //Why does this need to be public??
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if((xCoordinate >= 0 && xCoordinate <= 6) && (yCoordinate >=0 && yCoordinate <=6)){
            return true;
        } else {
            return false;
        }
    }
}
