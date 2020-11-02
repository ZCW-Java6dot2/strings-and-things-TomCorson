package io.zipcoder;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        Integer totalCount = 0;
        for (int i = 1; i <= input.length() - 1; i++) {
            Character current = input.charAt(i);
            Character previous = input.charAt(i - 1);
            if (current.equals(' ') && previous.equals('y')) {
                totalCount += 1;
            } else if (current.equals(' ') && previous.equals('z')) {
                totalCount += 1;
            } else if (i == input.length() - 1 && current.equals('y')) {
                totalCount += 1;
            } else if (i == input.length() - 1 && current.equals('z')) {
                totalCount += 1;
            }
        }
        return totalCount;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        return base.replace(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        Pattern is = Pattern.compile("is");
        Pattern not = Pattern.compile("not");
        Matcher isMatcher = is.matcher(input);
        Matcher notMatcher = not.matcher(input);
        int isCount = 0;
        int notCount = 0;
        while (isMatcher.find()) {
            isCount++;
        }
        while (notMatcher.find()) {
            notCount++;
        }
        return isCount == notCount ? true : false;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        String gg = "gg";
        Pattern doubleG = Pattern.compile("gg");
        Matcher doubleGString = doubleG.matcher(input);

        if (doubleGString.find()) {
            String updated = input.replace(gg, "");
            if (updated.contains("g")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        Integer result = 0;
        for (int i = 0; i <= input.length() - 1; i++) {
            if (i < input.length() - 4) {
                Character current = input.charAt(i);
                Character second = input.charAt(i + 1);
                Character third = input.charAt(i + 2);
                if (current == second && second == third) {
                    result++;
                }
            }
        }
        return result;
    }
}