package chess.pieces;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Queen extends Piece {

    public Queen(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);

    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
        Bishop bishop = new Bishop(this.getCurrentlyOnTheCell(), "temporaryBishop", this.getBelongsToOwner());
        Rook rook = new Rook(this.getCurrentlyOnTheCell(), "temporaryRook", this.getBelongsToOwner());

        return new ActionRequest("Queen moves",
                bishop.canItMove(toCell).isSuccessful || rook.canItMove(toCell).isSuccessful);
    }

    @Override
    public int[][] getPossibleLocations() {
        Bishop bishop = new Bishop(this.getCurrentlyOnTheCell(), "temporaryBishop", this.getBelongsToOwner());
        Rook rook = new Rook(this.getCurrentlyOnTheCell(), "temporaryRook", this.getBelongsToOwner());
        int[][] BishopArray = bishop.getPossibleLocations();
        int[][] RookArray = rook.getPossibleLocations();
        int[][] QueenArray = new int[BishopArray.length + RookArray.length][2];
        for (int i = 0; i < BishopArray.length; i++) {
            QueenArray[i] = BishopArray[i];
        }
        for (int i = 0; i < RookArray.length; i++) {
            QueenArray[i + BishopArray.length] = RookArray[i];
        }
        return QueenArray;
    }
}
