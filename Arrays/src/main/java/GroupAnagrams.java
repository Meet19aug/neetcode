import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collection = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String temp_2 = new String(temp);

            if (!collection.containsKey(temp_2)) {
                collection.put(temp_2, new ArrayList<>());
            }

            collection.get(temp_2).add(str);

        }

        return new ArrayList<>(collection.values());

    }
    public static List<List<String>> groupAnagrams4(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        char []temp;
        int []flag = new int[]{};
        for (int i = 0; i < flag.length ; i++) {
            flag[i]=0;
        }
        for (int i = 0; i < strs.length; i++) {
            if(flag[i]!=0){
               continue;
            }
            List<String> lst = new ArrayList<>();
            lst.add(strs[i]);
            temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String checkwith = Arrays.toString(temp);
            for (int j = 0; j < strs.length; j++) {
                if(i==j || flag[j]!=0){
                    continue;
                }
                char[] temp2 = strs[j].toCharArray();
                Arrays.sort(temp2);
                String checkto = Arrays.toString(temp2);
                if(checkto.equals(checkwith)){
                    lst.add(strs[j]);
                    flag[j]=1;
                }
            }
            ret.add(lst);
        }
        return ret;
    }
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
    public static List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        int flag[]=new int[len];
        for (int i = 0; i < len; i++) {
            flag[i]=0;
        }
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>(){};
            if(flag[i]!=0){
                continue;
            }
            temp.add(strs[i]);
            flag[i]=1;
            for (int j = i+1; j < strs.length; j++) {
                if(isAnagram(strs[i],strs[j]) && flag[j]==0){
                    temp.add(strs[j]);
                    flag[j]=1;
                }
            }
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args) {


    }
}
