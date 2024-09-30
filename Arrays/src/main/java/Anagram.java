import java.util.HashMap;

// https://leetcode.com/problems/valid-anagram/description/
public class Anagram {
    public static boolean isAnagram(String s, String t) {
        int[] atoz = new int[26];
        for(char c: s.toCharArray() ){
            atoz[c-'a']++;
        }
        for(char c: t.toCharArray()){
            atoz[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(atoz[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> track = new HashMap<>(){};
        for(char c : s.toCharArray()){
            if(track.containsKey(c)){
                track.put(c,track.get(c)+1);
            }else{
                track.put(c,1);
            }
        }
        for(char c: t.toCharArray()){
            if(track.containsKey(c) && track.get(c)>0){
                track.put(c,track.get(c)-1);
                if(track.get(c)==0){
                    track.remove(c);
                }`
            }else{
                return false;
            }
        }
        if(!track.isEmpty()){
            return false;
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println(isAnagram("ab","ba"));
    }
}