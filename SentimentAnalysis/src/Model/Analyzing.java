package Model;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;

import java.util.Properties;
import java.util.Scanner;

public class Analyzing {
    public static void main(String[] args) {
        // Initialize CoreNLP pipeline with default properties
        StanfordCoreNLP pipeline = new StanfordCoreNLP(new Properties());

        // Take user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence for sentiment analysis:");
        String inputText = scanner.nextLine();

        // Create an Annotation object
        Annotation annotation = new Annotation(inputText);

        // Analyze sentiment
        pipeline.annotate(annotation);

        // Get the root of the parse tree
        Tree tree = annotation.get(CoreAnnotations.SentencesAnnotation.class)
                .get(0)
                .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);

        // Get the sentiment score
        int sentiment = RNNCoreAnnotations.getPredictedClass(tree);

        // Call the convertSentiment method from SentimentUtility class to get the sentiment label
        String sentimentLabel = SentimentUtils.convertSentiment(sentiment);

        // Display the result
        Display.showSentimentResult(sentimentLabel);
    }
}
