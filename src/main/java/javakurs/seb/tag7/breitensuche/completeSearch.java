package javakurs.seb.tag7.breitensuche;

import java.util.*;
import java.util.function.Predicate;

public class completeSearch implements PuzzleSolver {
    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal) {
        final Map<PuzzleState, PuzzleState> parent = new HashMap<>();
        final Map<PuzzleState, Action> actionFromParent = new HashMap<>();
        final Queue<PuzzleState> workQueue = new LinkedList<>();
        final Set<PuzzleState> visited = new HashSet<>();

        PuzzleState goalState = null;

        visited.add(initialState);
        workQueue.add(initialState);

        while (isGoal == null && !workQueue.isEmpty()) {
            final PuzzleState currentState = workQueue.poll();
            for (Action nextAction : currentState.possibleActions()) {
                final PuzzleState nextState = currentState.step(nextAction);

                if (visited.contains(nextState)) {
                    continue;
                }

                visited.add(nextState);
                parent.put(nextState, currentState);
                actionFromParent.put(nextState, nextAction);
                workQueue.add(nextState);

                //hier ist das Ziel
                if (isGoal.test(nextState)) {
                    goalState = nextState;
                    break;
                }
            }
        }

        if (goalState == null) {
            return null;
        }

        final LinkedList<Action> result = new LinkedList<>();

        //initialState (da komm ich her und möchte auch wieder hin)
        //goalState (da bin ich jetzt)

        PuzzleState trackBack = goalState;
        while (!initialState.equals(trackBack)) { //wo bin ich gerade?
            result.add(actionFromParent.get(trackBack));
            trackBack = parent.get(trackBack);
        }

        return result;
    }
}
