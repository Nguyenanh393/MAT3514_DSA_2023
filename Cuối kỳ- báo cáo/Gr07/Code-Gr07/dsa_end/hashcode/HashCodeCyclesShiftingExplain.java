package dsa_end.hashcode;

import java.io.*;

public class HashCodeCyclesShiftingExplain {
    public static void main(String[] args) {
        String s = "IEllo! Whut's ap?";
        int h = 0;

        writeFirstRow();

        for (int i = 0; i < s.length(); i++) {
            
            int h0 = h;
            int h1 = h << 5;
            int h2 = h >>> 27; 
            int h3 = h1 | h2;
            int h4 = (int) s.charAt(i);
            int h5 = h1 + h4; 
            h = h5; 
            
            writeCSV(s.charAt(i), h0, h1, h2, h3, h4, h5, h);
            printBin(s.charAt(i), h0, h1, h2, h3, h4, h5, h);
        }
        System.out.println(h);
    }

    static String printBin (int h) {
        return (String.format("%32s", 
                Integer.toBinaryString(h)).replace (' ','0'));
    }

    static void printBin (char c, int h0, int h1, int h2, int h3, int h4, int h5, int h) {
        System.out.println("char: " + c);
        System.out.println("h0: " + printBin(h0));
        System.out.println("h1: " + printBin(h1));
        System.out.println("h2: " + printBin(h2));
        System.out.println("h3: " + printBin(h3));
        System.out.println("h4: " + printBin(h4));
        System.out.println("h5: " + printBin(h5));
        System.out.println("h: " + printBin(h));
        System.out.println("h (int): " + h);
    }

    static void writeCSV (char c, int h0, int h1, int h2, int h3, int h4, int h5, int h) {
        try {
            FileWriter csvWriter = new FileWriter("hashcode\\hashcode_cycles_shifting.csv", true);
            csvWriter.append(c);
            csvWriter.append(",");
            csvWriter.append(printBin(h0));
            csvWriter.append(",");
            csvWriter.append(printBin(h1));
            csvWriter.append(",");
            csvWriter.append(printBin(h2));
            csvWriter.append(",");
            csvWriter.append(printBin(h3));
            csvWriter.append(",");
            csvWriter.append(printBin(h4));
            csvWriter.append(",");
            csvWriter.append(printBin(h5));
            csvWriter.append(",");
            csvWriter.append(printBin(h));
            csvWriter.append(",");
            csvWriter.append(Integer.toString(h));
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeFirstRow () {
        try {
            FileWriter csvWriter = new FileWriter("hashcode\\hashcode_cycles_shifting.csv");
            csvWriter.append("char");
            csvWriter.append(",");
            csvWriter.append("h (old)");
            csvWriter.append(",");
            csvWriter.append("h1 = h << 5");
            csvWriter.append(",");
            csvWriter.append("h2 = h >>> 27");
            csvWriter.append(",");
            csvWriter.append("h3 = h1 | h2");
            csvWriter.append(",");
            csvWriter.append("h4 = (int) s.charAt(i)");
            csvWriter.append(",");
            csvWriter.append("h5 = h3 + h4");
            csvWriter.append(",");
            csvWriter.append("h (new)");
            csvWriter.append(",");
            csvWriter.append("h (int)");
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
