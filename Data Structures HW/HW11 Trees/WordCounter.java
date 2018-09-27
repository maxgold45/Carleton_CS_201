import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Max Goldberg
 */
public class WordCounter {

    private static ArrayList<String> addStopWords() throws FileNotFoundException {
        File stopWordsFile = new File("Stopwords.txt");
        ArrayList<String> ret = new ArrayList<String>();

        Scanner scan = new Scanner(stopWordsFile);
        while (scan.hasNext()) {
            ret.add(scan.next().toLowerCase());
        }
        return ret;
    }

    private static void addToWMap(WordCountMap wMap, File book, ArrayList<String> stopWords) throws FileNotFoundException {
        Scanner bookSc = new Scanner(book);
        while (bookSc.hasNext()) {
            String word = bookSc.next();
            if (!stopWords.contains(word.toLowerCase())) {
                wMap.incrementCount(word.toLowerCase());
            }
        }
    }

    public static void main(String[] args) {
        WordCountMap wMap = new WordCountMap();
        try {
            addToWMap(wMap, new File(args[1]), addStopWords());
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        }

        switch (args[0]) {
            case "alphabetical":
                ArrayList<WordCount> arrByWord = wMap.getWordCountsByWord();
                for (int i = 0; i < arrByWord.size(); i++) {
                    System.out.println(arrByWord.get(i));
                }
                break;
            case "frequency":
                ArrayList<WordCount> arrByCount = wMap.getWordCountsByCount();
                for (int i = 0; i < arrByCount.size(); i++) {
                    System.out.println(arrByCount.get(i));
                }
                break;
            case "cloud":
                arrByCount = wMap.getWordCountsByCount();
                // No number was entered, show 10 elements in the cloud.
                if (args.length == 2) {
                    System.out.println(WordCloudMaker.getWordCloudHTML(args[1].substring(0, args[1].lastIndexOf(".")), arrByCount.subList(0, 10)));
                }
                // Number was entered, show args[2] elements in the cloud.
                else{
                    System.out.println(WordCloudMaker.getWordCloudHTML(args[1].substring(0, args[1].lastIndexOf(".")), arrByCount.subList(0, Integer.parseInt(args[2]))));
                }
                break;
        }
    }

}
