package basicAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Binominal {

    static long binomi(int n, int k){
        if ((n==k) || (k==0)){
            return 1;
        }
        else {
            return binomi(n-1,k)+binomi(n-1,k-1);
        }
    }

    public static void main(String[] args) throws IOException {

        String inputLine;
        List<Integer> numbers = new ArrayList<Integer>();
        String matchedLine = null;

        Reader input = new InputStreamReader(System.in);
        BufferedReader bufferredReader = new BufferedReader(input);
        System.out.println("Input two int num with space");
        inputLine = bufferredReader.readLine();
        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher mat = pat.matcher(inputLine);
        while (mat.find()){
            matchedLine =mat.group();
        }
        String[] numArray = matchedLine.split(" ");

        for(String i:numArray){
            numbers.add(Integer.parseInt(i));
        }
        int n = numbers.get(0);
        int k = numbers.get(1);

        long result = binomi(n,k);
        System.out.println("Number combinations: " + result);
    }
}
