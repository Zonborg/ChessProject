package com.solarwindsmsp.chess;

/**
 * A class to deal with pawns.  Could make use of an interface to create a generic piece interface which over classes
 * can implement.
 */
public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    /**
     * Moves the chess piece.  Currently only MOVE is supported.  CAPTURE will be added later
     * @param movementType
     * @param newX
     * @param newY
     */
    public void move(MovementType movementType, int newX, int newY) {
        if (isValidMove(movementType, newX, newY)) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
    }

    //Split valid move checks out to a separate method in order to aid readability.
    private boolean isValidMove(MovementType movementType, int newX, int newY) {

        chessBoard = new ChessBoard();
        if(!getChessBoard().isLegalBoardPosition(newX, newY)){
            return false;
        }

        if(getPieceColor().equals(PieceColor.WHITE)) {
            if (movementType == MovementType.MOVE && (newX == getXCoordinate() && newY == getYCoordinate() + 1)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (movementType == MovementType.MOVE && (newX == getXCoordinate() && newY == getYCoordinate() - 1)) {
                return true;
            } else{
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
