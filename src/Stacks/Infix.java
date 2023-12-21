package Stacks;

import java.sql.Struct;
import java.util.Scanner;
import java.util.Stack;

public class Infix {

    static int BODMAS(String str) {
        int n = str.length();

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int a = ch - 48;
            if (a >= 0 && a <= 9) val.push(a);
            else if (op.size() == 0) op.push(ch);
            else {
                if (ch == '+' || ch == '-') {
                    while (val.size() > 1) {
                        int v1 = val.pop();
                        int v2 = val.pop();
                        char op1 = op.pop();
                        int v;
                        if (op1 == '+') v = v2 + v1;
                        else if (op1 == '-') v = v2 - v1;
                        else if (op1 == '*') v = v2 * v1;
                        else v = v2 / v1;

                        val.push(v);
                    }
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v1 = val.pop();
                        int v2 = val.pop();
                        char op1 = op.pop();
                        int v;

                        if (op1 == '*') v = v2 * v1;
                        else v = v2 / v1;

                        val.push(v);
                        op.push(ch);

                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        while (val.size() > 1) {
            int v1 = val.pop();
            int v2 = val.pop();
            char op1 = op.pop();
            int v;
            if (op1 == '+') v = v2 + v1;
            else if (op1 == '-') v = v2 - v1;
            else if (op1 == '*') v = v2 * v1;
            else v = v2 / v1;

            val.push(v);
        }
        return val.peek();
    }

    static int infinxWithBrackets(String str) {
        int n = str.length();

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int a = ch - 48;
            if (a >= 0 && a <= 9) val.push(a);
            else if (op.size() == 0 || ch=='(' || op.peek()=='('){
                op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    int v1 = val.pop();
                    int v2 = val.pop();
                    char op1 = op.pop();
                    int v;
                    if (op1 == '+') v = v2 + v1;
                    else if (op1 == '-') v = v2 - v1;
                    else if (op1 == '*') v = v2 * v1;
                    else v = v2 / v1;

                    val.push(v);
                }
                op.pop();
            }
            else {
                if (ch == '+' || ch == '-') {
                    while (val.size() > 1) {
                        int v1 = val.pop();
                        int v2 = val.pop();
                        char op1 = op.pop();
                        int v;
                        if (op1 == '+') v = v2 + v1;
                        else if (op1 == '-') v = v2 - v1;
                        else if (op1 == '*') v = v2 * v1;
                        else v = v2 / v1;

                        val.push(v);
                    }
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v1 = val.pop();
                        int v2 = val.pop();
                        char op1 = op.pop();
                        int v;

                        if (op1 == '*') v = v2 * v1;
                        else v = v2 / v1;

                        val.push(v);
                        op.push(ch);

                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        while (val.size() > 1) {
            int v1 = val.pop();
            int v2 = val.pop();
            char op1 = op.pop();
            int v;
            if (op1 == '+') v = v2 + v1;
            else if (op1 == '-') v = v2 - v1;
            else if (op1 == '*') v = v2 * v1;
            else v = v2 / v1;

            val.push(v);
        }
        return val.peek();
    }

    static String infixToPrefix(String str){
        int n = str.length();

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);

            int a =ch-48;
            if(a>=0 && a<=9) val.push(String.valueOf(ch));
            else if(op.size()==0 || ch=='(' || op.peek()=='('){
                op.push(ch);
            }else if(ch==')'){
                while(op.peek()!='('){
                    String v1 = val.pop();
                    String v2 = val.pop();
                    char op1 = op.pop();
                    String v;
                     v = op1+v2+v1;
                     val.push(v);
                }
                op.pop();
            }else{
                if (ch == '+' || ch == '-') {
                    while (val.size() > 1) {
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char op1 = op.pop();
                        String v;
                        v=op1+v2+v1;

                        val.push(v);
                    }
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char op1 = op.pop();
                        String v;
                        v=op1+v2+v1;

                        val.push(v);
                        op.push(ch);

                    } else {
                        op.push(ch);
                    }
            }
        }
    }

        while(val.size()>1){
            String v1 = val.pop();
            String v2 = val.pop();
            char op1 = op.pop();

            String v = op1+v2+v1;
            val.push(v);
        }
        return val.peek();
    }

    static String infixToPostfix(String str){
        int n = str.length();

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);

            int a = ch-48;

            if(a>=0 && a<=9) val.push(String.valueOf(ch));
            else if(op.size()==0 || ch=='(' || op.peek()=='('){
                op.push(ch);
            }else if(ch==')'){
                while(op.peek()!='('){
                    String v1 = val.pop();
                    String v2 = val.pop();
                    char op1 = op.pop();

                    String v = v2+v1+op1;
                    val.push(v);
                }
                op.pop();
            }else{
                if(ch=='+' || ch=='-') {
                    while (val.size() > 1) {
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char op1 = op.pop();

                        String v = v2 + v1 + op1;
                        val.push(v);
                    }
                    op.push(ch);
                }
                else if(ch=='*' || ch=='/'){
                    if(op.peek()=='*' || op.peek()=='/'){
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char op1 = op.pop();

                        String v = v2+v1+op1;
                        val.push(v);
                        op.push(ch);
                    }else{
                        op.push(ch);
                    }
                }
            }
        }

        while(val.size()>1){
            String v1 = val.pop();
            String v2 = val.pop();
            char op1 = op.pop();

            String v = v2+v1+op1;
            val.push(v);
        }
        return val.peek();
    }

    static int evaluationOfPostfix(String str){
        int n = str.length();

        Stack<Integer> val = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            int a = ch-48;
            if(a>=0 && a<=9) val.push(a);
            else{
                int x = val.pop();
                int y = val.pop();
                int v;

                if(ch=='+') v = y+x;
                else if(ch=='-') v = y-x;
                else if(ch=='*') v = y*x;
                else v = y/x;

                val.push(v);
            }
        }
        return val.pop();
    }

    static int evaluationOfPrefix(String str){
        int n = str.length();

        Stack<Integer> val = new Stack<>();

        for(int i=n-1; i>=0; i--){
            char ch = str.charAt(i);
            int a = ch-48;

            if(a>=0 && a<=9) val.push(a);
            else{
                int x = val.pop();
                int y = val.pop();
                int v;
                if(ch=='+') v = x+y;
                else if(ch=='-') v = x-y;
                else if(ch=='*') v = x*y;
                else v = x/y;

                val.push(v);
            }

        }
        return val.pop();
    }

    static String prefixToPostfix(String str){
        int n = str.length();

        Stack<String> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            char ch = str.charAt(i);
            int a = ch-48;
            if(a>=0 && a<=9) st.push(String.valueOf(ch));
            else{
                String s1=st.pop();
                String s2=st.pop();

                st.push(s1+s2+ch);
            }
        }
        return st.peek();
    }

    static String postfixToPrefix(String str){
        int n = str.length();

        Stack<String> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            int a = ch-48;

            if(a>=0 && a<=9) st.push(String.valueOf(ch));
            else{
                String s1 = st.pop();
                String s2 = st.pop();

                st.push(ch+s2+s1);
            }
        }
        return st.peek();
    }

    static String postfixToInfix(String str){
        int n = str.length();

        Stack<String> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            int a = ch-48;

            if(a>=0 && a<=9) st.push(String.valueOf(ch));
            else{
                String s1 = st.pop();
                String s2 = st.pop();

                st.push("("+s2+ch+s1+")");
            }
        }
        return st.peek();
    }

    static String prefixToInfix(String str){
        int n = str.length();

        Stack<String> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            char ch = str.charAt(i);
            int a = ch-48;

            if(a>=0 && a<=9) st.push(String.valueOf(ch));
            else{
                String s1 = st.pop();
                String s2 = st.pop();

                st.push("("+s1+ch+s2+")");
            }
        }
        return st.peek();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "4*(5+6)";
        System.out.println(infixToPostfix(str));
    }
}
