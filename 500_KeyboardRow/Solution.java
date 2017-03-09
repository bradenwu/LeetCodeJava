/*
   Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

   Example 1:
        Input: ["Hello", "Alaska", "Dad", "Peace"]
        Output: ["Alaska", "Dad"]
   Note:
        You may use one character in the keyboard more than once.
        You may assume the input string will only contain letters of alphabet.
 */

public class Solution {
    //TODO: 1. 初始化map太笨拙了, 编码太多, 必须降低此处的代码量!!!
    private static Map<Character, Integer> char2Line = new HashMap<Character, Integer>() {{
        put('q', 1);
        put('w', 1);
        put('e', 1);
        put('r', 1);
        put('t', 1);
        put('y', 1);
        put('u', 1);
        put('i', 1);
        put('o', 1);
        put('p', 1);
        put('a', 2);
        put('s', 2);
        put('d', 2);
        put('f', 2);
        put('g', 2);
        put('h', 2);
        put('j', 2);
        put('k', 2);
        put('l', 2);
        put('z', 3);
        put('x', 3);
        put('c', 3);
        put('v', 3);
        put('b', 3);
        put('n', 3);
        put('m', 3);
    }};

    public String[] findWords(String[] words) {
        List<String> result = new LinkedList<String>();

        for (String word : words) {
            String uniWord = word.toLowerCase();
            int lastLineNumber = 0;
            boolean allInTheSameLine = true;
            for (int i = 0; i < uniWord.length(); ++i) {
                Character ch = uniWord.charAt(i);
                int lineNumber = char2Line.get(ch);
                if (lastLineNumber != 0) {
                    if (lastLineNumber != lineNumber) {
                        //TODO: 2. boolean flag 如何去掉不用???
                        allInTheSameLine = false;
                        break;
                    }
                }
                lastLineNumber = lineNumber;
            }
            if (allInTheSameLine) {
                result.add(word);
            }
        }
        String[] resultArray = new String[result.size()];
        return result.toArray(resultArray);
    }

    public String[] findWords2(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

   public static void main(String[] args) {
        Solution so = new Solution();
        String[] testArray = {"Hello", "Alaska", "Dad", "Peace"};
        String[] results = so.findWords(testArray);
        for (String result : results) {
            System.out.println(result.toString());
        }
    }

}


/*
收获: 
1. String.toCharArray() 用法熟练运用
2. boolean flag 如何去掉不用
*/

/*
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    //2. boolean flag 如何去掉不用
                    index = -1; //don't need a boolean flag. 
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }
*/
