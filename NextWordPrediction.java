import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NextWordPrediction {

    static class NGramModel {
        private Map<String, Map<String, Integer>> model;

        public NGramModel() {
            model = new HashMap<>();
        }

        public void train(String[] words) {
            for (int i = 0; i < words.length - 1; i++) {
                String currentWord = words[i];
                String nextWord = words[i + 1];

                model.putIfAbsent(currentWord, new HashMap<>());
                Map<String, Integer> nextWordCounts = model.get(currentWord);
                nextWordCounts.put(nextWord, nextWordCounts.getOrDefault(nextWord, 0) + 1);
            }
        }

        public String predictNextWord(String currentWord) {
            Map<String, Integer> nextWordCounts = model.getOrDefault(currentWord, new HashMap<>());

            String predictedWord = "";
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : nextWordCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    predictedWord = entry.getKey();
                }
            }

            return predictedWord;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence for training: ");
        String trainingSentence = scanner.nextLine();
        String[] trainingWords = trainingSentence.split("\\s+");

        NGramModel nGramModel = new NGramModel();
        nGramModel.train(trainingWords);

        System.out.print("Enter the current word for prediction: ");
        String currentWord = scanner.next();

        String predictedNextWord = nGramModel.predictNextWord(currentWord);
        System.out.println("Predicted next word: " + predictedNextWord);
    }
}
