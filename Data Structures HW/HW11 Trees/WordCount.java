
/**
 * Contains a word and it's associated count.
 * 
 * @author Max Goldberg
 */
public class WordCount implements Comparable<WordCount> {

    public String word;
    public int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return this.word + ":" + count;
    }
    
    
    @Override
    public int compareTo(WordCount o) {
        if (this.count < o.count) {
            return -1;
        } else if (this.count == o.count) {
            return 0;
        } else {
            return 1;
        }
    }
}
