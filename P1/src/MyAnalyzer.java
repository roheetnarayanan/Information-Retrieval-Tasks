import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.RemoveDuplicatesTokenFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.util.Version;

public class MyAnalyzer extends Analyzer{
	@Override
    protected TokenStreamComponents createComponents(String fieldName) {
       // public TokenStream tokenStream(String fieldName, Reader reader) {
        Tokenizer tokenizer = new StandardTokenizer();
        TokenStream tokenStream = tokenizer;
       
        final List<String> stop_Words = Arrays.asList("is", "was","in","to","be");
		final CharArraySet stopSet = new CharArraySet(stop_Words, true);
		
		tokenStream = new LowerCaseFilter(tokenStream);
		tokenStream = new StopFilter(tokenStream, stopSet);
	
		
		
		
	     //Adding Porter Stemming filtering
        tokenStream = new PorterStemFilter(tokenStream);
        
        //return tokenStream;
        return new TokenStreamComponents(tokenizer, tokenStream);
    }
	
    }
