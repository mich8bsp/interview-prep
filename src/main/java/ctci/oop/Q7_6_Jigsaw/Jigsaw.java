package ctci.oop.Q7_6_Jigsaw;

import java.util.*;

public class Jigsaw {

    private Map<Integer, JigsawPiece> openPieces = new HashMap<>();
    private Stack<JigsawPiece> unusedPieces = new Stack<>();

    public void solve(){
        while(!unusedPieces.isEmpty()){
            JigsawPiece pieceToPlace = unusedPieces.pop();
            matchWithOpenPieces(pieceToPlace);
        }
        if(!openPieces.isEmpty()){
            System.out.println("Puzzle is unsolvable");
        }else{
            System.out.println("Yay! we solved the puzzle");
        }
    }

    private void matchWithOpenPieces(JigsawPiece pieceToPlace) {
        List<Integer> piecesToRemove = new LinkedList<>();
        for(JigsawPiece candidate : openPieces.values()){
            boolean shouldMoveToNextCandidate = false;
            for(PieceEdge edgeOfPiece : pieceToPlace.getEdges()){
                if(shouldMoveToNextCandidate){
                    break;
                }
                for(PieceEdge edgeOfCandidate : candidate.getEdges()){
                    if(edgeOfPiece.isOpen() && edgeOfCandidate.isOpen() && edgesFit(edgeOfPiece, edgeOfCandidate)){
                        edgeOfPiece.setAttached(true);
                        edgeOfCandidate.setAttached(true);

                        //if we attached an edge of our piece to the edge of the candidate - there is no need to check if
                        // any other two of their edges match since it's impossible, so we break
                        shouldMoveToNextCandidate = true;
                        break;
                    }
                }
            }



            if(!candidate.hasOpenEdges()){
                piecesToRemove.add(candidate.getId());
            }

            //we iterate over all candidates because it's possible the piece matches with more than one other piece (with different edges)
            //but if we already attached all edges - there is no need to continue
            if(!pieceToPlace.hasOpenEdges()){
                piecesToRemove.add(pieceToPlace.getId());
                break;
            }
        }

        //we remove pieces that have all edges attached because they will not serve as candidates so it's unnecessary step in iteration
        piecesToRemove.forEach(pieceId -> openPieces.remove(pieceId));

        if(pieceToPlace.hasOpenEdges()){
            openPieces.put(pieceToPlace.getId(), pieceToPlace);
        }
    }


    public static boolean edgesFit(PieceEdge piece1, PieceEdge piece2){
        return true;
    }
}
