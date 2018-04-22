package ctci.oop.Q7_6_Jigsaw;

public class PieceEdge {

    private static final PieceEdge WALL = new PieceEdge(true);

    private boolean isAttached = false;

    public PieceEdge(boolean isAttached) {
        this.isAttached = isAttached;
    }

    public boolean isOpen() {
        return !isAttached;
    }

    public void setAttached(boolean isAttached) {
        this.isAttached = isAttached;
    }
}
