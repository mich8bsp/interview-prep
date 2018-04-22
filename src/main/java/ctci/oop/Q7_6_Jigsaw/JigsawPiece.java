package ctci.oop.Q7_6_Jigsaw;

import java.util.Arrays;

public class JigsawPiece {

    private int pieceId;
    private PieceEdge topEdge;
    private PieceEdge rightEdge;
    private PieceEdge leftEdge;
    private PieceEdge bottomEdge;

    public JigsawPiece(int pieceId){
        this.pieceId = pieceId;
    }


    public int getId() {
        return pieceId;
    }

    public PieceEdge[] getEdges(){
        return new PieceEdge[]{topEdge, rightEdge, leftEdge, bottomEdge};
    }

    public boolean hasOpenEdges() {
        return Arrays.stream(getEdges())
                .anyMatch(PieceEdge::isOpen);
    }
}
