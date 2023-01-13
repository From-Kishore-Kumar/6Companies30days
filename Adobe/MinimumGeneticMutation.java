//https://leetcode.com/problems/minimum-genetic-mutation/
//leetcode problem 433
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] seen = new boolean[bank.length];
        Queue<String> q = new LinkedList<>();
        int numMutations = 0;
        q.addAll(getNeighbors(startGene, bank, seen));
        while (!q.isEmpty()) {
            numMutations++;
            int size = q.size();
            while (size-- > 0) {
                String currGene = q.poll();
                if (currGene.equals(endGene))
                    return numMutations;
                q.addAll(getNeighbors(currGene, bank, seen));
            }
        }
        return -1;
    }
    
    private static List<String> getNeighbors(String gene, String[] bank, boolean[] seen) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            if (seen[i]) continue;
            int apart = 0;
            String next = bank[i];
            for (int j = 0; j < 8; j++)
                if (gene.charAt(j) != next.charAt(j))
                    apart++;
            if (apart == 1) {
                neighbors.add(next);
                seen[i] = true;
            }
        }
        return neighbors;
    }
}
