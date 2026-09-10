// Battle.java, feito por Willian, 2024-06-10
public class Battle {
    private int[] vetor;
    private int numOFhits = 0;

    public Battle(int[] grid) {
        vetor = grid;
    }

    public String checkHit(int gress) {
        String result = "miss";

        for (int i = 0; i < vetor.length; i++) {
            if (gress == vetor[i]) {
                result = "hit";
                numOFhits++;
                vetor[i] = -1;
                break;
            }

        }
        if (numOFhits == vetor.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }

    public int getHits() {
        return numOFhits;
    }
}