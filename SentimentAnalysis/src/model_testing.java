import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;

import java.util.Properties;
import java.util.Scanner;

public class model_testing {

    public static void main(String[] args) {
        // Initialize CoreNLP
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Take user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence for sentiment analysis:");
        String inputText = scanner.nextLine();

        // Analyze sentiment
        Annotation annotation = new Annotation(inputText);
        pipeline.annotate(annotation);

        // Get the root of the parse tree
        Tree tree = annotation.get(CoreAnnotations.SentencesAnnotation.class)
                .get(0)
                .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);

        // Get the sentiment score (converts to human-readable form using convertSentiment method)
        int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
        String sentimentLabel = convertSentiment(sentiment);

        // Display the result
        System.out.println("Sentiment: " + sentimentLabel);
    }

    private static String convertSentiment(int sentiment) {
        switch (sentiment) {
            case 0:
                return "Very negative";
            case 1:
                return "Negative";
            case 2:
                return "Neutral";
            case 3:
                return "Positive";
            case 4:
                return "Very positive";
            default:
                return "Unknown";
        }
    }
}
