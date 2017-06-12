package pl.itblues;

import org.apache.lucene.analysis.payloads.PayloadHelper;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.util.BytesRef;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.schema.SimilarityFactory;

/**
 * Created by Mikolaj Kania on 12.06.2017.
 */
public class PayloadSimilarityFactory extends SimilarityFactory {
    @Override
    public void init(SolrParams params) {
        super.init(params);
    }

    @Override
    public Similarity getSimilarity() {
        return new PayloadSimilarity();
    }
}

class PayloadSimilarity extends ClassicSimilarity {

    //Here's where we actually decode the payload and return it.
    @Override
    public float scorePayload(int doc, int start, int end, BytesRef payload) {
        if (payload == null) return 1.0F;
        return PayloadHelper.decodeFloat(payload.bytes, payload.offset);
    }
}
