import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.tartarus.snowball.ext.PorterStemmer;

public class Main {
	
	 public static void PrintStream(TokenStream t) throws IOException {
		CharTermAttribute attr = t.addAttribute(CharTermAttribute.class);
		t.reset();
		while(t.incrementToken()) {
			    // Grab the term
			    String term = attr.toString();

			    System.out.println(term);
			    
			}
		t.close();
			
		}
	 
	 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String s = " Today is sunny. She is a sunny girl. To be or not to be. She is in Berlin\r\n"
				+ "today. Sunny Berlin! Berlin is always exciting!\r\n"
				+ "";
		AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
		final List<String> stop_Words = Arrays.asList("is", "was","in","to","be");
		final CharArraySet stopSet = new CharArraySet(stop_Words, true);
		
		// Task 1
		 System.out.println("-----Task 1 (Tokenizer)-----");
		 System.out.println("\n");
		Tokenizer std = new StandardTokenizer();
		std.setReader(new StringReader(s));
		TokenStream stdtoken = std;
		System.out.println("~~Standard Tokenizer~~");
		PrintStream(stdtoken);
		System.out.println("\n");
		
		Tokenizer wst = new WhitespaceTokenizer();
		wst.setReader(new StringReader(s));
		TokenStream wstoken = wst;
		System.out.println("~~WhiteSpace Tokenizer~~");
		System.out.println("\n");
		PrintStream(wstoken);
		System.out.println("\n");;
		
		// Task 2
		System.out.println("-----Task 2 (Stop Words Removal)-----");
		System.out.println("\n");
		Tokenizer t2 = new StandardTokenizer();
		t2.setReader(new StringReader(s));
		TokenStream ts = t2;
		ts = new StopFilter(ts, stopSet);
		PrintStream(ts);
		System.out.println("\n");;
		
		// Task 3s
		System.out.println("-----Task 3 (Custom Analyzer)-----"); 
		System.out.println("\n");
		Analyzer ro = new MyAnalyzer();
		TokenStream t = ro.tokenStream(null,s);
		PrintStream(t);
		
	 

	}

}
