import java.util.ArrayList;

/**
 * Creates a Binary Search Tree used to organize the words alphabetically
 *
 * @author Max Goldberg
 */
public class WordCountMap {

    private class Node {

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public String word;
        public int count;
        public Node left;
        public Node right;
    }
    // Instance variables:
    private Node root;

    public WordCountMap() {
        this.root = null;
    }

    /**
     * If the specified word is already in this WordCountMap, then its count is increased by one.
     * Otherwise, the word is added to this map with a count of 1.
     *
     * @param word String specified word
     */
    public void incrementCount(String word) {
        word = word.toLowerCase();
        word = word.replaceAll("[^a-zA-Z]", "");
        if (word.equals("")) {
            return;
        }
        if (this.root == null) {
            this.root = new Node(word, 1);
        } else {
            incrementCountHelper(word, this.root);
        }
    }

    private void incrementCountHelper(String word, Node curr) {
        if (word.compareTo(curr.word) < 0) {
            if (curr.left == null) {
                curr.left = new Node(word, 1);
            } else {
                incrementCountHelper(word, curr.left);
            }
        } else if (word.compareTo(curr.word) > 0) {
            if (curr.right == null) {
                curr.right = new Node(word, 1);
            } else {
                incrementCountHelper(word, curr.right);
            }
        } else {
            curr.count++;
        }
    }

    /**
     * Returns an array list of WordCount objects, one per word stored in this WordCountMap, sorted
     * in decreasing order by count.
     *
     * @return ArrayList of WordCounts
     */
    public ArrayList<WordCount> getWordCountsByCount() {
        ArrayList<WordCount> arr = new ArrayList<WordCount>();
        ArrayList<WordCount> returnArr = new ArrayList<WordCount>();
        arr = getWordCountsByWord();
        WordCount emptyWord = new WordCount("", 0);
        WordCount largest = emptyWord;
        int index = -1;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).compareTo(largest) > 0) {
                    largest = arr.get(j);
                    index = j;
                }
            }
            returnArr.add(largest);
            arr.remove(index);
            largest = emptyWord;
            index = -1;
        }
        return returnArr;
    }

    /**
     * Returns an array list of WordCount objects, one per word stored in this WordCountMap, sorted
     * alphabetically by word.
     *
     * @return ArrayList of WordCounts
     */
    public ArrayList<WordCount> getWordCountsByWord() {
        //In Order traversal
        ArrayList<WordCount> arr = new ArrayList<WordCount>();
        inOrder(this.root, arr);
        return arr;
    }

    private void inOrder(Node curr, ArrayList<WordCount> arr) {
        if (curr != null) {
            inOrder(curr.left, arr);
            arr.add(new WordCount(curr.word, curr.count));
            inOrder(curr.right, arr);
        }
    }

}
