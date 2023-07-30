package Model;

public class SentimentUtils {
    public static String convertSentiment(int sentiment) {
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
