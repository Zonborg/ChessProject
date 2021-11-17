# Chess Java Project
##Overview
This is a very basic beginning of a chess application as stated in the 
instructions.  At present the only piece that has some functionality is the pawn 
and only to move.  All tests were made to pass.

##Instructions to build
1.  A version of Java installed on your machine.  I used OpenJDK 11.0.10.
2.  An IDE/code editor of your choice.  It should run in any IDE which supports 
    Java.  I made used of IntelliJ Community Edition.
    
## Further Improvements
1.  Some refactor work could be done.  Pawn could implement an interface to
    allow abstraction and to make sure all the various future pieces could have
    different implementations of the same methods.
2.  isValidMove() in Pawn should be fixed in a future version so that the Pawn (or any other 
    piece class) is not reliant on using the ChessBoard class to check if a
    move is valid.  Could potentially have a class which stores the 
    chessboard state, while another class handles the logic.
    
## Questions
1.  Needed to adjust one of the jUnit tests as well as it was invalid.  Was this 
    correct or were tests supposed to be unchanged?  Test had a position outwith
    the chessboard.
2.  How board is currently coded is that it has a 7x7 chess board whereas a 
    standard chessboard is 8x8.  Is this intentional?
