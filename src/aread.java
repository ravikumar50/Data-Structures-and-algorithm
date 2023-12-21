public class aread {

    static boolean contains(int ax1, int ay1, int ax2, int ay2, int a, int b){

        if(a>=ax1 && a<=ax2 && b>=ay1 && b<=ay2) return false;
        return true;
    }

    static int numberOfFalse(boolean arr[]){
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]==false) ans++;
        }

        return ans;
    }

    static int area(int a, int b, int c, int d){
        int l1 = Math.abs(a-c);
        int b1 = Math.abs(b-d);
        return l1*b1;
    }

    public static void main(String[] args) {



      int ax1=-2;
      int ay1=-2;
      int ax2=2;
      int ay2=2;
      int bx1=-2;
      int by1=-4;
      int bx2=2;
      int by2=-2;

        float l1 = (float)Math.abs(ax1-ax2);
        float bx = (float)Math.abs(ay2-ay1);
        float l2 = (float)Math.abs(bx1-bx2);
        float by = (float)Math.abs(by1-by2);

        float A1 = l1*bx;
        float A2 = l2*by;
        System.out.println(A1);
        System.out.println(A2);

        boolean b1 = contains(ax1,ay1,ax2,ay2,bx1,by1);
        boolean b2 = contains(ax1,ay1,ax2,ay2,bx2,by2);
        boolean b3 = contains(ax1,ay1,ax2,ay2,bx2,by1);
        boolean b4 = contains(ax1,ay1,ax2,ay2,bx1,by2);


        boolean a1 = contains(bx1,by1,bx2,by2,ax1,ay1);
        boolean a2 = contains(bx1,by1,bx2,by2,ax2,ay2);
        boolean a3 = contains(bx1,by1,bx2,by2,ax2,ay1);
        boolean a4 = contains(bx1,by1,bx2,by2,ax1,ay2);

        boolean arr1[] = {a1,a2,a3,a4};
        boolean arr2[] = {b1,b2,b3,b4};

        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        for(int i=0; i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        }

        if(a1 && a2 && a3 && a4 && b1 && b2 && b3 && b4){
            System.out.println((A1+A2));
            return;
        }else if(!a1 && !a2 && !a3 && !a4 && b1 && b2 && b3 && b4){
            System.out.println((int)A2);
            return;
        }else if(a1 && a2 && a3 && a4 && !b1 && !b2 && !b3 && !b4){
            System.out.println((int)A1);
            return;
        } else if(!a1 && !a2 && !a3 && !a4 && !b1 && !b2 && !b3 && !b4){
            System.out.println(A1);
        } else{
            if(numberOfFalse(arr1)==1 && numberOfFalse(arr2)==1){
                if(a1==false && b2==false){
                    int common = area(ax1,ay1,bx2,by2);
                    System.out.println((int)(A1+A2)-common);
                    return;
                }else if(a3==false && b4==false){
                    int common = area(ax2,ay1,bx1,by2);
                    System.out.println((A1+A2)-common);
                    return;
                }else if(a2==false && b1==false){
                    int common = area(ax2,ay2,bx1,by1);
                    System.out.println((A1+A2)-common);
                    return;
                }else if(a4==false && b3==false){
                    int common = area(ax1,ay2,bx2,by1);
                    System.out.println((A1+A2)-common);
                    return;
                }
            }else{
                if(a1 && a2 && a3 && a4){
                    if(b2==false && b4==false){
                        int a = Math.abs(bx2-bx1);
                        int b = Math.abs(by2-ay1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(b1==false && b4==false){
                        int a = Math.abs(by2-by1);
                        int b = Math.abs(bx1-ax2);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(b1==false && b3==false){
                        int a = Math.abs(bx2-bx1);
                        int b = Math.abs(ay2-by1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(b2==false && b3==false){
                        int a = Math.abs(by2-by1);
                        int b = Math.abs(bx2-ax1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }
                }else if(b1 && b2 && b3 && b4){
                    if(a2==false && a4==false){
                        int a = Math.abs(ax2-ax1);
                        int b = Math.abs(ay2-by1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(a1==false && a4==false){
                        int a = Math.abs(ay2-ay1);
                        int b = Math.abs(ax1-bx2);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(a1==false && a3==false){
                        int a = Math.abs(ax2-ax1);
                        int b = Math.abs(by2-ay1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }else if(a2==false && a3==false){
                        int a = Math.abs(ay2-ay1);
                        int b = Math.abs(ax2-bx1);
                        int common = a*b;
                        System.out.println((A1+A2)-common);
                        return;
                    }
                }
            }
        }

        }
}
