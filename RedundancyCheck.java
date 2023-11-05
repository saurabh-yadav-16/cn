import java.util.Scanner;

public class RedundancyCheck {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        System.out.println("Enter any string to find VRC, LRC, and 2D: ");
        str = sc.nextLine();
        // Initializing strings to store values of VRC and LRC
        String VRC = "", LRC = "";
        int n = 0, i = 0, j = 0, m = 0, count = 0;
        int[][] arr = new int[8][8]; // Array to store binary conversion of characters

        System.out.println("Char\t\tBinary Value\tVRC");
        for (i = 0; i < str.length(); i++) {
            n = str.charAt(i);
            System.out.print(n + "\t\t");
            char ch = str.charAt(i);
            j = 0;
            while (n > 0) {
                // RedundancyCheck to binary conversion
                arr[i][j] = n % 2;
                n = n / 2;
                j++;
            }
            for (m = arr[i].length - 1; m >= 0; m--) {
                System.out.print(arr[i][m]);
                if (arr[i][m] == 1) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                System.out.print("\t0");
                VRC = VRC + "0";
            } else {
                System.out.print("\t1");
                VRC = VRC + "1";
            }
            System.out.println("");
        }

        System.out.print("LRC\t\t");
        for (i = 7; i >= 0; i--) {
            count = 0;
            for (j = str.length() - 1; j >= 0; j--) {
                if (arr[j][i] == 1) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }

        count = 0;
        for (i = 0; i < VRC.length(); i++) {
            if (VRC.charAt(i) == '1') { // Corrected the comparison to '1'
                count++;
            }
        }

        if (count % 2 == 0) {
            System.out.println("\t1<-- 2D");
        } else {
            System.out.println("\t0<-- 2D");
        }
    }
}


//multi line comment
/* Enter any string to find VRC, LRC, and 2D: 
Saurabh
Char            Binary Value    VRC
83              01010011        0
97              01100001        1
117             01110101        0
114             01110010        0
97              01100001        1
98              01100010        0
104             01101000        1
LRC             01011110        0<-- 2D */