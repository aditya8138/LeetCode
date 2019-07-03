package other;

public class LongPressedName {
    static boolean subString(String str1, String str2, int length1, int length2) {
        // Base Cases
        if (length1 == 0) {
            return true;
        }
        if (length2 == 0) {
            return false;
        }

        // If last characters of two strings are matching
        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
            return subString(str1, str2, length1 - 1, length2 - 1);
        }

        // If last characters are not matching
        return subString(str1, str2, length1, length2 - 1);
    }

    public static boolean isLongPressedName(String name, String typed) {
        int nameL = name.length();
        int typedL = typed.length();
        boolean found = false;

        if (name == null || typed == null) {
            return false;
        }
        if ("".equals(name) || "".equals(typed)) {
            return false;
        }

        if (name.trim().length() > 0 && typed.trim().length() > 0) {

            found = subString(name, typed, nameL, typedL);

        }
        return found;
    }


}
