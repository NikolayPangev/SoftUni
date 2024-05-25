import java.util.Scanner;

public class _05_KaminoFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dnaLength = Integer.parseInt(scanner.nextLine());

        int bestSequenceIndex = 0;
        int bestSequenceSum = 0;
        int bestSubsequenceLength = 0;
        int bestSubsequenceStartIndex = Integer.MAX_VALUE;
        String bestSequence = "";

        int sequenceIndex = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Clone them!")) {
                break;
            }

            sequenceIndex++;

            String[] parts = input.split("!+");
            int[] sequence = new int[dnaLength];
            int sum = 0;

            for (int i = 0; i < dnaLength; i++) {
                sequence[i] = Integer.parseInt(parts[i]);
                sum += sequence[i];
            }

            int currentSubsequenceLength = 0;
            int currentSubsequenceStartIndex = -1;

            int maxSubsequenceLength = 0;
            int maxSubsequenceStartIndex = -1;

            for (int i = 0; i < dnaLength; i++) {
                if (sequence[i] == 1) {
                    if (currentSubsequenceLength == 0) {
                        currentSubsequenceStartIndex = i;
                    }
                    currentSubsequenceLength++;
                } else {
                    if (currentSubsequenceLength > maxSubsequenceLength) {
                        maxSubsequenceLength = currentSubsequenceLength;
                        maxSubsequenceStartIndex = currentSubsequenceStartIndex;
                    }
                    currentSubsequenceLength = 0;
                }
            }

            if (currentSubsequenceLength > maxSubsequenceLength) {
                maxSubsequenceLength = currentSubsequenceLength;
                maxSubsequenceStartIndex = currentSubsequenceStartIndex;
            }

            boolean isBetterSequence = false;

            if (maxSubsequenceLength > bestSubsequenceLength) {
                isBetterSequence = true;
            } else if (maxSubsequenceLength == bestSubsequenceLength) {
                if (maxSubsequenceStartIndex < bestSubsequenceStartIndex) {
                    isBetterSequence = true;
                } else if (maxSubsequenceStartIndex == bestSubsequenceStartIndex) {
                    if (sum > bestSequenceSum) {
                        isBetterSequence = true;
                    }
                }
            }

            if (isBetterSequence) {
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sum;
                bestSubsequenceLength = maxSubsequenceLength;
                bestSubsequenceStartIndex = maxSubsequenceStartIndex;
                bestSequence = String.join(" ", parts);
            }
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        System.out.println(bestSequence);
    }
}
