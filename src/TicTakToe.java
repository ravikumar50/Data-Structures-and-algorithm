
import java.util.Scanner;

public class TicTakToe {

    static boolean check(String arr[][]){

        for(int i=0; i<3; i++){
            if(arr[i][0]=="*" && arr[i][1]=="*" && arr[i][2]=="*"){
                return true;
            }
        }
        for(int j=0; j<3; j++){
            if(arr[0][j]=="*" && arr[1][j]=="*" && arr[2][j]=="*"){
                return true;
            }
        }

        if(arr[0][0]=="*" && arr[1][1]=="*" && arr[2][2]=="*") return true;
        if(arr[0][2]=="*" && arr[1][1]=="*" && arr[2][0]=="*") return true;

        return false;
    }

    static void draw(){
        System.out.println("It's a Draw");
    }

    static void theGame(String arr[][], int numberOfElements){

        Scanner sc = new Scanner(System.in);

        while(numberOfElements<9){
            System.out.println("It's your turn");
            System.out.println("Enter the row and column number where you want to write");
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b]="0";

            if(a==1 && b==1){
                numberOfElements++;
                if(numberOfElements<9){
                    arr[0][2]="*";
                    numberOfElements++;
                }else{
                    draw();
                    return;
                }
            }else if(a==0 && b==1){
                numberOfElements++;
                if(numberOfElements<9){
                    arr[2][1]="*";
                    numberOfElements++;
                }else{
                    draw();
                    return;
                }
            }else if(a==2 && b==2){
                numberOfElements++;
                if(numberOfElements<9){
                    arr[0][0]="*";
                    numberOfElements++;
                }else{
                    draw();
                    return;
                }
            }else if(a==1 && b==0){
                numberOfElements++;
                if(numberOfElements<9){
                    arr[1][2]="*";
                    numberOfElements++;
                }else{
                    draw();
                    return;
                }
            }else if(a==2 && b==0){
                numberOfElements++;
                if(numberOfElements<9){
                    arr[2][1]="*";
                    numberOfElements++;
                }else{
                    draw();
                    return;
                }
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }

            if(check(arr)){
                System.out.println("You lose bro");
                System.out.println("Better luck next time");
                return;
            }
        }
        draw();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String arr[][] = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[i][j]="_";
            }
        }

        theGame(arr,0);





    }
}
