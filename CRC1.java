import java.util.*;

class CRC1 {
    public static String CalculateCRC(String data, String GM) {
        int datalength = data.length();
        for (int i = 0; i < GM.length() - 1; i++) {
            data = data + '0';
        }
        StringBuilder remainder = new StringBuilder(data);
        for (int i = 0; i < datalength; i++) {
            if (remainder.charAt(i) == '1') {
                for (int j = 0; j < GM.length(); j++) {
                    char ch = xor(remainder.charAt(i + j), GM.charAt(j));
                    remainder.setCharAt(i + j, ch);
                }
            }
        }
        return remainder.substring(datalength);
    }
    public static char xor(char a, char b) {
        return (a == b) ? '0' : '1';
    }
    public static void main(String args[]) {
        String data = "1010101010001";
        String GM = "1001";
        System.out.println("Sent data: " + data);
        String senderCRC = CalculateCRC(data, GM);  
        System.out.println("Syndrome for the sent data is: " + senderCRC);
        String receiveddata = data + senderCRC;     
        System.out.println("Encoded codeword: " + receiveddata);
        String receivedCRC = CalculateCRC(receiveddata, GM);
        int flag = 0;
        for (int i = 0; i < receivedCRC.length(); i++) {
            if (receivedCRC.charAt(i) == '1') {
                flag = 1;
                break;
            }
        }
        
        if (flag == 1) {
            System.out.println("Error Detected....");
        } else {
            System.out.println("Data Transfer Successful.....");
            System.out.println("Actual data is " + receiveddata.substring(0, data.length()));
        }
    }
}
