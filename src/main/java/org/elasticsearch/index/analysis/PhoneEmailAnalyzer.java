package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.miscellaneous.UniqueTokenFilter;

/**
 * Analyzer for fields that may contain email addresses or phone numbers.
 */
public class PhoneEmailAnalyzer extends Analyzer {
    
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        TermExtractorTokenizer tokenizer = new TermExtractorTokenizer(new PhoneTermExtractor(), new EmailTermExtractor());
        return new TokenStreamComponents(tokenizer, new UniqueTokenFilter(tokenizer));
    }
}
