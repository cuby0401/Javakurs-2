package javakurs.jimmy.tag7.puzzle;

import java.util.*;
import java.util.function.Predicate;

/**
 * Implementiert diese Klasse aus, anhand der im Unterricht definierten Designentscheidungen, die ihr hoffentlich alle mitgeschrieben habt :-)
 */
public final class MyPuzzleSolver implements PuzzleSolver {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal) {

        final Map<PuzzleState, PuzzleState> parent = new HashMap<>();
        final Map<PuzzleState, Action> actionFromParent = new HashMap<>();
        final Queue<PuzzleState> workQueue = new LinkedList<>();
        final Set<PuzzleState> visited = new HashSet<>();
        PuzzleState goalState = null;
        visited.add(initialState);
        workQueue.add(initialState);

        while (goalState == null && !workQueue.isEmpty()) {
            if (goalState != null) {
                break;
            }
            final PuzzleState currentState = workQueue.poll();
            for (final Action nextAction : currentState.possibleActions()) {
                final PuzzleState nextState = currentState.step(nextAction);
                if (visited.contains(nextState)) {
                    continue;
                }
                visited.add(nextState);
                parent.put(nextState, currentState);
                actionFromParent.put(nextState, nextAction);
                workQueue.add(nextState);
                if (isGoal.test(nextState)) {
                    goalState = nextState;
                    break;
                }
            }
        }
        if (goalState == null) {
            return null;
        }

        final List<Action> result = new LinkedList<>();
        PuzzleState trackBack = goalState;

        while (!initialState.equals(trackBack)) {
            result.addFirst(actionFromParent.get(trackBack));
            trackBack = parent.get(trackBack);
        }

        return result;
    }

    
//
//    @Override
//    public List<Action> solve(PuzzleState initialState, Predicate<PuzzleState> isGoal) {
//        Queue<PuzzleState> queue = new LinkedList<>();
//        Set<PuzzleState> visited = new HashSet<>();
//        Map<PuzzleState, Integer> depth = new HashMap<>();
//
//        queue.add(initialState);
//        visited.add(initialState);
//        depth.put(initialState, 0);
//
//        int maxDepth = 0;
//        List<PuzzleState> leafNodes = new ArrayList<>();
//
//        while (!queue.isEmpty()) {
//            PuzzleState state = queue.poll();
//            int d = depth.get(state);
//
//            List<Action> actions = state.possibleActions();
//
//            // Falls ein Zustand KEINE Nachfolger hat → merken
//            if (actions.isEmpty()) {
//                leafNodes.add(state);
//            }
//
//            for (Action a : actions) {
//                PuzzleState next = state.step(a);
//                if (visited.contains(next)) {
//                    continue;
//                }
//
//                visited.add(next);
//                depth.put(next, d + 1);
//                queue.add(next);
//
//                if (d + 1 > maxDepth) {
//                    maxDepth = d + 1;
//                }
//            }
//        }
//
//        System.out.println("Anzahl erreichbarer Zustände: " + visited.size());
//        System.out.println("Maximale Tiefe (max. Moves): " + maxDepth);
//        System.out.println("Leaf nodes: " + leafNodes.size());
//
//        return List.of();
//    }
}
