//importing lists and array lists
import java.util.ArrayList;
import java.util.List;

class containChar {

    public static List<Integer> findWordsContaining(String[] words, char x) {

        /*if the word contains the specified character,
        *we will add this word to our array list*/
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (containsChar(words[i], x)) {
                indices.add(i);
            }
        }

        return indices; //we will return our array list after we're done
    }

    private static boolean containsChar(String word, char x) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //let's test my code now!

        String[] words = {"leet","code"};
        char x = 'e';
        List<Integer> result = findWordsContaining(words, x);
        System.out.println(result); //[0,1] meaning both contain letter 'e'

        String[] words2 = {"abc","bcd","aaaa","cbc"};
        char x2 = 'a';
        List<Integer> result2 = findWordsContaining(words2, x2);
        System.out.println(result2); //[0, 2] meaning only the first and third elements contain letter 'a'

        String[] words3 = {"Java","is", "fun"};
        char x3 = 'z';
        List<Integer> result3 = findWordsContaining(words3, x3);
        System.out.println(result3); //[] meaning none of the elements contain 'z'
    }

}
