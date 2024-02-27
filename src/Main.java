
import java.util.*;

public class Main
{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int d[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                d[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(d[i][j]==-1) d[i][j] = 1000000;
            }
        }

        for(int k=0; k<n; k++){
            int newD[][] = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    newD[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
            d = newD;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(d[i][j]==1000000) d[i][j] = -1;
            }
        }


        for(var a : d){
            for(var b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}



/*

number of nodes = 5;
number of pairs = 9;

Pairs along with their cost

0 1 3
0 2 8
0 4 -4
1 3 1
1 4 7
2 1 4
3 2 -5
3 0 2
4 3 6

 */