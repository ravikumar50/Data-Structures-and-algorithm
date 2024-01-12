import java.util.*;
class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class new1 {


    static void insert(Node root, String s){
        int n = s.length();
        Node curr = root;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if((curr.left!=null && curr.left.data==ch)){
                curr = curr.left;
            }else if((curr.right!=null && curr.right.data==ch)){
                curr = curr.right;
            }else{
                Node x = new Node(ch);
                if(ch=='0'){
                    curr.left = x;
                    curr = curr.left;
                }else{
                    curr.right = x;
                    curr = curr.right;
                }
            }
        }
    }

    static int binaryToDecimal(String s){
        int n = s.length();
        int ans = 0;
        int x = 0;
        for(int i=n-1; i>=0; i--){
            int a = s.charAt(i)-48;
            ans = ans + a*(int)Math.pow(2,x);
            x++;
        }
        return ans;
    }



    public static void main(String[] args) {
        int arr[] = {14,70,53,83,49,91,36,80,92,51,66,70};
        int n = arr.length;
        int ans = 0;


        Node root = new Node('.');
        for(int i=0; i<n; i++){
            int num = arr[i];
            StringBuilder s = new StringBuilder();
            while(num!=0){
                int x = num%2;
                s.insert(0,String.valueOf(x));
                num=num/2;
            }
            int k = s.length();
            if(k!=32){
                s.insert(0,"0".repeat(32-k));
            }
            if(i==0){
                insert(root,s.toString());
            }else {
                String sum = "";
                Node curr = root;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (ch == '1') {
                        if (curr.left!=null) {
                            sum += "1";
                            curr = curr.left;
                        } else {
                            sum += "0";
                            curr = curr.right;
                        }
                    } else {
                        if (curr.right!=null) {
                            sum += "1";
                            curr = curr.right;
                        } else {
                            sum += "0";
                            curr = curr.left;
                        }
                    }
                }
                ans = Math.max(ans, binaryToDecimal(sum));
                insert(root, s.toString());
            }
        }
        System.out.println(ans);

    }
}
