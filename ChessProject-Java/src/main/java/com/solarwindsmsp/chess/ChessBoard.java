package com.solarwindsmsp.chess;

/**
 * A class which represents a chessboard.
 */
public class ChessBoard {

    //This means the board is 7x7 not 8x8 like a chess board is supposed to be.
    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    //Would this be scalable with additional pieces?  Would need to be refactored to accept additional pieces and would
    // add complexity if not refactored.
    /**
     * A method to add a chess piece to the chess board.
     *
     * @param pawn
     * @param xCoordinate
     * @param yCoordinate
     * @param pieceColor
     */
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
    }

    //Why does this need to be public?  It could potentially be made private.  May need to make use of PowerMockito if
    //the unit tests testing this method were to be maintained.

    /**
     * A method to check if a specific coordinate is a valid board position.
     * @param xCoordinate
     * @param yCoordinate
     * @return
     */
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate <= 6) && (yCoordinate >= 0 && yCoordinate <= 6);
    }
}
