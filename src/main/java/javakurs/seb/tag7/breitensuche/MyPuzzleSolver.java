package javakurs.seb.tag7.breitensuche;

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

        if (isGoal == null) {
            throw new IllegalArgumentException("isGoal must not be null");
        }

        final Queue<PuzzleState> workQueue = new LinkedList<>();
        final Set<PuzzleState> visited = new HashSet<>();
        final Map<PuzzleState, PuzzleState> parent = new HashMap<>();
        final Map<PuzzleState, Action> actionFromParent = new HashMap<>();

        workQueue.add(initialState);
        visited.add(initialState);

        PuzzleState goalState = null;

        while (!workQueue.isEmpty()) {
            PuzzleState current = workQueue.poll();

            // Zielprüfung
            if (isGoal.test(current)) {
                goalState = current;
                break;
            }

            // expandieren
            for (Action action : current.possibleActions()) {
                PuzzleState next = current.step(action);

                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, current);
                    actionFromParent.put(next, action);
                    workQueue.add(next);
                }
            }
        }

        // Kein Ziel gefunden
        if (goalState == null) {
            return null;
        }

        // Backtracking
        LinkedList<Action> result = new LinkedList<>();
        PuzzleState trackBack = goalState;

        while (!trackBack.equals(initialState)) {
            Action action = actionFromParent.get(trackBack);
            result.addFirst(action);
            trackBack = parent.get(trackBack);
        }

        return result;
    }

    //BFS

    public static class DepthAnalysisResult {
        public final int maxDepth;
        public final List<PuzzleState> states;

        public DepthAnalysisResult(int maxDepth, List<PuzzleState> states) {
            this.maxDepth = maxDepth;
            this.states = states;
        }
    }

    public static DepthAnalysisResult analyzeFromGoal(PuzzleState goalState) {

        final Queue<PuzzleState> queue = new LinkedList<>();
        final Map<PuzzleState, Integer> depth = new HashMap<>();

        queue.add(goalState);
        depth.put(goalState, 0);

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            PuzzleState current = queue.poll();
            int currentDepth = depth.get(current);

            for (Action action : current.possibleActions()) {
                PuzzleState next = current.step(action);

                if (!depth.containsKey(next)) {
                    int nextDepth = currentDepth + 1;
                    depth.put(next, nextDepth);
                    maxDepth = Math.max(maxDepth, nextDepth);
                    queue.add(next);
                }
            }
        }

        List<PuzzleState> farthest = new ArrayList<>();
        for (var entry : depth.entrySet()) {
            if (entry.getValue() == maxDepth) {
                farthest.add(entry.getKey());
            }
        }

        return new DepthAnalysisResult(maxDepth, farthest);
    }
}
