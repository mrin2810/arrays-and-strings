import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * CSCI-142 Computer Science 2 Recitation Exercise
 * 07-ExceptionsIO
 * Mad Libs
 *
 * A program that generates a random Mad Libs from a template and a collection of
 * words.
 *
 * This is the student starter code.
 *
 * @author RIT CS
 */
public class MadLibs {
    /** the name of the file with the adjective words */
    private final static String ADJECTIVES = "adjectives.txt";
    /** the name of the file with the noun words */
    private final static String  NOUNS = "nouns.txt";
    /** the name of the file with the people words */
    private final static String PEOPLE = "people.txt";
    /** the name of the file with the story template */
    private final static String  TEMPLATE = "template.txt";
    /** the name of the file with the verb words */
    private final static String VERBS = "verbs.txt";

    /** the adjective marker string in the template */
    private final static String ADJECTIVE_MARKER = "<ADJECTIVE>";
    /** the noun marker string in the template */
    private final static String NOUN_MARKER = "<NOUN>";
    /** the person marker string in the template */
    private final static String PERSON_MARKER = "<PERSON>";
    /** the verb marker string in the template */
    private final static String VERB_MARKER = "<VERB>";

    /** how many characters to print on a line */
    private final static int LINE_LENGTH = 80;

    /** a dictionary that maps madlib marker strings to a list of potential words */
    private Map<String, List<String>> madlibs;

    /**
     * the template with regular words and marker words that gets tokenized
     * into a list of strings
     */
    private List<String> template;

    /**
     * Constructor of MadLib objects.
     *
     * @throws IOException if a file cannot be found or read
     */
    public MadLibs() throws IOException {
        // create the madlib dictionary that maps the madlib tags,
        // e.g. <NOUN> to a list of shuffled nouns as the key
        this.madlibs = new HashMap<>();

        // read in the adjectives, shuffle, and add to the map
        List<String> adjectives = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(ADJECTIVES));) {
            String str;
            while ((str = in.readLine()) != null) {
                adjectives.add(str);
            }
            Collections.shuffle(adjectives);
            this.madlibs.put(ADJECTIVE_MARKER, adjectives);
        }

        // read in the nouns, shuffle, and add to the map
        List<String> nouns = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(NOUNS));) {
            String str;
            while ((str = in.readLine()) != null) {
                nouns.add(str);
            }
            Collections.shuffle(nouns);
            this.madlibs.put(NOUN_MARKER, nouns);
        }

        // read in the people, shuffle, and add to the map
        List<String> people = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(PEOPLE));) {
            String str;
            while ((str = in.readLine()) != null) {
                people.add(str);
            }
            Collections.shuffle(people);
            this.madlibs.put(PERSON_MARKER, people);
        }

        // read in the verbs, shuffle, and add to the map
        List<String> verbs = new ArrayList<>();
        // TODO: Step 3

        // read the template into a list of strings
        this.template = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(TEMPLATE));) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] words = str.split(" ");
                this.template.addAll(Arrays.asList(words));
            }
        }
    }

    /**
     * Generate the random story now that the collections have been created.
     */
    public void produce() {
        // TODO: Step 2
    }

    /**
     * The main method.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        // TODO: Step 1
        try {
            MadLibs madLibs = new MadLibs();
            madLibs.produce();
        } catch (IOException fnfe) {
            System.out.println(fnfe.getMessage());
        } finally {
            System.out.println("\n\n\"We all float down here! \uD83C\uDF88");        }
    }
}