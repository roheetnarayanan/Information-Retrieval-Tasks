import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.tartarus.snowball.ext.PorterStemmer;

public class Task1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     
        String s = " Today's is sunny. She is a sunny girl. To be or not to be. She is in Berlin\r\n"
				+ "today. Sunny Berlin! Berlin is always exciting!"
				+ "";
        
        PorterStemmer stemmer = new PorterStemmer();
        Tokenizer tokenizer = new StandardTokenizer();
        Tokenizer wt = new WhitespaceTokenizer();
		
        final List<String> stop_Words = Arrays.asList("is", "was", "in", "to", "be");
		final CharArraySet stopSet = new CharArraySet(stop_Words, true);
		
		
		tokenizer.setReader(new StringReader(s));
		TokenStream tok = tokenizer;
		
		tok = new StopFilter(tok, stopSet);
		tok.reset();
		
		CharTermAttribute attr = tok.addAttribute(CharTermAttribute.class);
		
		
		while(tok.incrementToken()) {
		    // Grab the term
		    String term = attr.toString();

		    System.out.println(term);
		    
		}
		
	}

}
