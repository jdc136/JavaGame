
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * A wrapper class for dealing with text files of words
 * 
 * @author Jared Collier, Allson Roldan
 * @version 2020
 */
public class WordFile {
    private ArrayList<String> list;

    /**
     * Creates a new word file from the default file ("words1500.txt");
     */
    public WordFile() {
        this("words1500.txt");
    }

    /**
     * Creates a new word file from the given file
     * 
     * @param filename The name of a local file (in the same directory) with a list
     *                 of words.
     */
    public WordFile(String filename) {
        list = new ArrayList<String>(); // to hold our list of words
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getClass().getResourceAsStream("/" + filename))); // so will also work in jar
                                                                                            // files
            String line = reader.readLine();
            while (line != null) // while is a line to read
            {
                list.add(line); // add the line to the list
                line = reader.readLine(); // grab the next line
            }
        } catch (Exception e) // if something goes wrong
        {
            System.out.println("Error reading file: \'" + filename + "'" + e);
        }
    }

    /**
     * Gets the words from the WordFile as an ArrayList
     * 
     * @return an ArrayList of the words (each represented as a String)
     */
    public ArrayList<String> getWordArrayList() {
        return list;
    }

    /**
     * Gets the words from the WordFile as an array
     * 
     * @return an array of the words (each represented as a String)
     */
    public String[] getWordArray() {
        return list.toArray(new String[0]); // convert to an array and return
    }

}
