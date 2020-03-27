import java.util.*;

public class GroupAnagramWords {

    public static void main(String[] args) {

        String[] anagramWords = new String[]{"ram", "bebe", "appa", "papa", "arm", "mar"};
        //groupAnagramWords(anagramWords);
        groupAnagramWordsInArray(anagramWords);
    }

    private static void groupAnagramWords(String[] anagramWords) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : anagramWords) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                List<String> al = new ArrayList<>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());
        System.out.println("Result: " + result);
    }

    private static void groupAnagramWordsInArray(String[] words){
        List<String> wordList = new ArrayList<>();
        //sort each word in array
        for(String w:words){
            wordList.add(sort(w));
        }
        //map to hold the word as key and the respective indexes
        Map<String, List<Integer>> wordMap = new HashMap<>();

        for(int i=0;i<wordList.size();i++){
            wordMap.putIfAbsent(wordList.get(i),new ArrayList<>());
            wordMap.get(wordList.get(i)).add(i);
        }

        //Print the group of Anagram words
        for(Map.Entry<String, List<Integer>> entry: wordMap.entrySet()){
            System.out.print("[");
            entry.getValue().stream().forEach(i->System.out.print("" + words[i] + ","));
            System.out.println("]");
        }
    }

    private static String sort(String w) {
        char[] chars = w.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}
