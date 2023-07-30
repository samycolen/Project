package coreNLP;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class CoreNLP {
    public static StanfordCoreNLP createPipeline() {
        // Initialize CoreNLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, split, pos, lemma, parse, sentiment");
        return new StanfordCoreNLP(props);
    }
}
