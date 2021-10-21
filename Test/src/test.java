
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.util.Version;
import org.tartarus.snowball.ext.PorterStemmer;
import org.apache.lucene.analysis.en.PorterStemFilter;


public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String s = " Today is sunny. She is a sunny girl. To be or not to be. She is in Berlin\r\n"
				+ "today. Sunny Berlin! Berlin is always exciting!\r\n"
				+ "";
		AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
		final List<String> stop_Words = Arrays.asList("is", "the");
		final CharArraySet stopSet = new CharArraySet(stop_Words, true);
		Tokenizer stdt = new StandardTokenizer();
		stdt.setReader(new StringReader(s));
		
		PorterStemmer stemmer = new PorterStemmer();
		TokenStream tokenStream = new StopFilter(stdt, stopSet);
		
		
		tokenStream = new PorterStemFilter(tokenStream);
	
		
		Analyzer ro = new MyAnalyzer();
		TokenStream t = ro.tokenStream(null,s);
		t.reset();
		
		CharTermAttribute attr = t.addAttribute(CharTermAttribute.class);
		while(t.incrementToken()) {
		    // Grab the term
		    String term = attr.toString();

		    System.out.println(term);
		    
		}

		
		

	}

	private static Collection<?> asSet(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return null;
	}

}
