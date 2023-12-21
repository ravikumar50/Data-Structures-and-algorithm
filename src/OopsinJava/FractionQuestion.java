package OopsinJava;

public class FractionQuestion {

    static int gcd(int num, int deno){
        int min=Math.min(num,deno);

        for(int i=min; i>0; i--){
            if(num%i==0 && deno%i==0) return i;
        }
        return 1;
    }

    static fraction add(fraction f1, fraction f2){
        int newnum=(f1.num*f2.deno) + (f1.deno*f2.num);
        int newdeno=(f1.deno*f2.deno);

        fraction ans = new fraction(newnum,newdeno);
        return ans;
    }

    static fraction multiply(fraction f1, fraction f2){
        int num = f1.num*f2.num;
        int deno = f1.deno*f2.deno;
        fraction ans = new fraction(num,deno);
        return ans;
    }






    public static class fraction{
        int num;
        int deno;

        public fraction(int num, int deno){
            this.num=num;
            this.deno=deno;
            simplify();
        }

        public void simplify(){
           int hcf=gcd(num,deno);

           num/=hcf;
           deno/=hcf;
        }


    }




    public static void main(String[] args) {
       fraction f1= new fraction(5,15);
       fraction f2 = new fraction(20,25);

       fraction f3 = multiply(f1,f2);
        System.out.println(f3.num+"/"+f3.deno);




    }
}
