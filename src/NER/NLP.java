package NER;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class NLP
{
    private static StanfordCoreNLP pipeline;
    static Properties properties;
    static String propertiesName ="tokenize, ssplit, pos, lemma, ner";

    static{
        properties = new Properties();
        properties.setProperty("annotators",propertiesName);
    }

    public static void initNER()
    {
        pipeline = new StanfordCoreNLP(properties);
    }

    public static CoreDocument namedEntityRecognition(String input)
    {
        CoreDocument doc = new CoreDocument(input);
        pipeline.annotate(doc);
        for (CoreEntityMention em : doc.entityMentions())
        {
            System.out.println("\t"+em.text()+"\t"+em.entityType()+"\t"+em.entityTypeConfidences());
        }

        return doc;
    }
}
