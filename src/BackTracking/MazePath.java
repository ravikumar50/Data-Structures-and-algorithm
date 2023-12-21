package BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePath {

    static int mazePathfForwardDownward(int m, int n){
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;

        return mazePathfForwardDownward(m-1,n)+mazePathfForwardDownward(m,n-1);
    }

    static void printMazePathForwardDownward(int m, int n, String s){
        if(m==1 && n==1){
            System.out.println(s);
            return;
        }
        if(m==0 || n==0) return;

        printMazePathForwardDownward(m-1,n,s+"R");
        printMazePathForwardDownward(m,n-1,s+"D");
    }


    static int maze(int a, int b, int c, int d){
        if(a==c && b==d) return 1;        // 1 based Indexing
        if(a>c || b>d) return 0;

        return maze(a+1,b,c,d) + maze(a,b+1,c,d);
    }

    static int mazeIn4Direction(int a , int b, int c, int d, boolean isVisited[][]){

        int ans=0;
        if(a<0 || b<0 || a>c || b>d) return 0;
        if(isVisited[a][b]==true) return 0;
        if(a==c && b==d) return 1;       // 0 based Indexing

        isVisited[a][b]=true;
        ans+=mazeIn4Direction(a+1,b,c,d,isVisited);
        ans+=mazeIn4Direction(a-1,b,c,d,isVisited);
        ans+=mazeIn4Direction(a,b+1,c,d,isVisited);
        ans+=mazeIn4Direction(a,b-1,c,d,isVisited);

        isVisited[a][b]=false;    // backTracking;
        return ans;

    }

    static void printMazePathIn4Direction(int a, int b, int c, int d, String s,boolean isVisited[][]){

        if(a<0 || b<0 || a>c || b>d) return;
        if(isVisited[a][b]==true) return;
        if(a==c && b==d){
            System.out.println(s);
            return;
        }
        isVisited[a][b]=true;
        printMazePathIn4Direction(a+1,b,c,d,s+"D",isVisited);  //Down
        printMazePathIn4Direction(a,b+1,c,d,s+"R",isVisited);  //Right
        printMazePathIn4Direction(a-1,b,c,d,s+"U",isVisited);  //Up
        printMazePathIn4Direction(a,b-1,c,d,s+"L",isVisited);  //Left

        isVisited[a][b]=false;   // backTracking
    }

    static int deadMazeForwardDownWard(int a, int b, int c, int d, int maze[][]){

        int ans=0;
        if(a>c || b>d) return 0;
        if(a==c && b==d) return 1;
        if(maze[a][b]==0) return 0;

        ans=+deadMazeForwardDownWard(a+1,b,c,d,maze);
        ans+=deadMazeForwardDownWard(a,b+1,c,d,maze);

        return ans;

    }


    static void printDeadMazeForwardDownWard(int a , int b, int c , int d, String s, int maze[][]){

        if(a>c || b>d) return;
        if(a==c && b==d){
            System.out.println(s);
            return;
        }
        if(maze[a][b]==0) return;

        printDeadMazeForwardDownWard(a+1,b,c,d,s+"D",maze);
        printDeadMazeForwardDownWard(a,b+1,c,d,s+"R",maze);

    }

    static int deadMazeIn4Direction(int a, int b, int c, int d,int maze[][]){
        int ans = 0;
        if(a<0 || b<0 || a>c || b>d) return 0;
        if(a==c || b==d){
            return 1;
        }
        if(maze[a][b]==0) return 0;   // blocked
        if(maze[a][b]==-1) return 0;   // visited
        maze[a][b]=-1;

        ans+=deadMazeIn4Direction(a+1,b,c,d,maze);
        ans+=deadMazeIn4Direction(a-1,b,c,d,maze);
        ans+=deadMazeIn4Direction(a,b+1,c,d,maze);
        ans+=deadMazeIn4Direction(a,b-1,c,d,maze);

        maze[a][b]=1;  // backtracking
        return ans;
    }
    static void printDeadMazeIn4Direction(int a, int b, int c, int d, String s, int maze[][]){
        if(a<0 || b<0 || a>c || b>d) return;
        if(a==c || b==d){
            System.out.println(s);
            return;
        }
        if(maze[a][b]==0) return;     // blocked
        if(maze[a][b]==-1) return;    // visited;
        maze[a][b]=-1;

        printDeadMazeIn4Direction(a+1,b,c,d,s+"D",maze);
        printDeadMazeIn4Direction(a-1,b,c,d,s+"U",maze);
        printDeadMazeIn4Direction(a,b+1,c,d,s+"R",maze);
        printDeadMazeIn4Direction(a,b-1,c,d,s+"L",maze);

        maze[a][b]=1;   // backtracking
        return;
    }






    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

    }
}
