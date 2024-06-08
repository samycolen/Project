package com.SentimentAnalysis.Services;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class SentimentAnalysisServices {

    private static StanfordCoreNLP pipeline;

    public SentimentAnalysisServices() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public static String analyzeSentiment(String inputText) {
        Annotation annotation = pipeline.process(inputText);
        return annotation.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class).toString();
    }
}
