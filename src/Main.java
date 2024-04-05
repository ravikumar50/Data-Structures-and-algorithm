
import java.util.*;
class Node{
    char ch;
    HashMap<Character,Node> hp;

    Node(char ch){
        this.ch = ch;
        hp = new HashMap<>();
    }
}




class Solution {

    static Node root;

    public void insert(String s) {
        int n = s.length();
        Node curr = root;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(curr.hp.containsKey(ch)){
                curr = curr.hp.get(ch);
            }else{
                Node x = new Node(ch);
                curr.hp.put(ch,x);
                curr = x;
            }
        }
    }


    public String longestCommonPrefix(String[] arr) {
        root = new Node('.');
        int n = arr.length;
        for(int i=0; i<n; i++){
            insert(arr[i]);
        }

        String ans = "";
        Node curr = root;
        System.out.println(root.hp.size());
        while(curr.hp.size()==1){
            String ch = "";
            for(var a : curr.hp.keySet()){
                ch = a+"";
                break;
            }
            curr = curr.hp.get(ch.charAt(0));
            ans = ans+curr.ch;
        }
        return ans;
    }
}