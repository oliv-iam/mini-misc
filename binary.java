import java.util.Scanner;
public class binary {
    public static void main(String[] args) {
        //take in number of digits as command-line argument
        if(args.length < 1) {
            System.err.println("provide number of binary digits as argument");
            System.exit(1);
        }
        int numdigs = Integer.parseInt(args[0]);
        game(numdigs);
    }

    public static void game(int numdigs) {
        //choose decimal and find binary version
        int dec = (int)(Math.random() * (Math.pow(2, numdigs)));
        int dec_tmp = dec;
        String tmp = "";
        for(int i = (int)Math.pow(2, numdigs-1); i >= 1; i /= 2) {
            tmp += dec_tmp / i;
            dec_tmp %= i;
        }
        int bin = Integer.parseInt(tmp);

        //randomly select problem type
        if(Math.random() < 0.5) {realgame(dec, bin, 0, numdigs);}
        else {realgame(bin, dec, 1, numdigs);}
    }

    public static void realgame(int question, int ans, int ver, int numdigs) {
        //game introduction
        System.out.println("---------------------------");
        if(ver == 0) {
            System.out.println("lets play DECIMAL -> BINARY");
            System.out.println("decimal representation: " + question);
            System.out.println("binary representation: [???]");
        } else {
            System.out.println("lets play BINARY -> DECIMAL");
            System.out.println("binary representation: " + question);
            System.out.println("decimal representation: [???]");
        }

        //read user input and compare to correct response
        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        if(response == ans) {
            System.out.println("yay");
            game(numdigs);
        } else {
            System.out.println("try again..");
            realgame(question, ans, ver, numdigs);
        }
        sc.close();
    }
}