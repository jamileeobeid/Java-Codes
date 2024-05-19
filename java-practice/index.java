class index {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        //storing the length of haystack and needle in a variable
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        //if haystack is shorter than needle, then needle does not exist in haystack
        if (haystackLength < needleLength) return -1;
        
        //we will loop through the haystack to find needle
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {

        // "sad" occurs at index 0 and 6.
        // The first occurrence is at index 0, so we return 0. */
        System.out.println(strStr("sadbutsad", "sad")); //0

        // "leeto" did not occur in "leetcode", so we return -1
        System.out.println(strStr("leetcode", "leeto")); //-1
        
    }
}
