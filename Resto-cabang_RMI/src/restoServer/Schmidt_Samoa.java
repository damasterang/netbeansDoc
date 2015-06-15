package restoServer;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import java.util.Random;

//
public class Schmidt_Samoa {

    private int p, q;
    private int public_key, private_key;

    private static final int BLOCK_SIZE = 6;			//1 char jadi x block size

    public Schmidt_Samoa() {
        int p = generatePrimeRandom(0);
        int q = generatePrimeRandom(p);
        reInitialize(p,q);
    }
    
    public int generatePrimeRandom(int o){
        
        int gen = 0;
        Random rand = new Random();
        gen = rand.nextInt(40) + 1;

        while (!isPrime(gen) || gen < 20 || gen == o) {          
            gen = rand.nextInt(40) + 1;
        }
        
        return gen;
        
    }

    /**
     * Checks to see if the requested value is prime.
     */
    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0) 
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }

    public void reInitialize(int p, int q) {
        this.p = p;
        this.q = q;
        public_key = computeN();
        generatePrivateKey(public_key);
    }
    
    public void generatePrivateKey(int public_Key){
        try {
            this.private_key = modular_Equation_Solver(public_Key, 1, lcm(p-1, q-1));
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
    
    public int getPublicKey(){
        return this.public_key;
    }
    
    public int getP(){
        return this.p;
    }
    
    public int getQ(){
        return this.q;
    }

    private int computeN() {
        return p * p * q;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int[] extendedEuclidsAlgo(int a, int b) {
        int[] result = new int[3];
        if (b == 0) {
            result[0] = a;// index 0 is x
            result[1] = 1;// index 1 is y
            result[2] = 0;// index 2 is d ... ax+by = d
            
            return result;
        }

        int[] result_temp = extendedEuclidsAlgo(b, a % b);
        int[] final_result = {result_temp[0], result_temp[2], result_temp[1] - (a / b) * result_temp[2]};
        
        return final_result;
    }

    private int modular_Equation_Solver(int a, int b, int n) throws InvalidAlgorithmParameterException {
        int[] solution = extendedEuclidsAlgo(a, n);
        int d = solution[0];
        int x1 = solution[1];
        int y1 = solution[2];

        if (b % d == 0) {
            int value = x1 * b / d;
            return correctValue(value, n);
        } else {
            throw new InvalidAlgorithmParameterException();
        }
    }

    private int correctValue(int value, int n) {
        while (value < 0) {

            value += n;
        }
//        System.out.println(value);
        return value % n;
    }

    public int modularExponentiator(int a, int b, int n) {
        int c = 0;
        int d = 1;
        String binaryB = Integer.toBinaryString(b);
//        System.out.println("binaryB : "+binaryB);

        for (int i = 0; i < binaryB.length(); i++) {
            c = 2 * c;
            d = (d * d) % n;
            if (binaryB.charAt(i) == '1') {
                c++;
                d = (d * a) % n;
            }
        }
        
//        System.out.println("d : " +d);

        return d;
    }

    private String toNLengthString(String str, int n) {
        if (str.length() == n) {
            return str;
        }

        String zeroes = new String(new char[n - str.length()]).replace("\0", "0");
        return zeroes + str;
    }

    public String encrypt(String message) {
        int[] cipher = new int[message.length()];
//        System.out.println("CHIPER 1st = " + cipher);
        String cipherString = "";
        for (int i = 0; i < message.length(); i++) {
            cipher[i] = encrypt(message.charAt(i));
            cipherString += toNLengthString("" + cipher[i], BLOCK_SIZE);
//            System.out.println("cipherString : "+cipherString);
        }

        return cipherString;
    }

    public int encrypt(int m) {
        return modularExponentiator(m, public_key, public_key);
    }

    public int decrypt(int c) {
        return modularExponentiator(c, private_key, p * q);
    }

    public String decrypt(String cipher) {
        String plaintext = "";
        int[] message = new int[cipher.length()];
        for (int i = 0; i < cipher.length() / BLOCK_SIZE; i++) {
            message[i] = Integer.parseInt(cipher.substring(i * BLOCK_SIZE, i * BLOCK_SIZE + BLOCK_SIZE));
            message[i] = decrypt(message[i]);
            plaintext += (char) message[i];
        }
        return plaintext;
    }

    public String display() {
        String message = "Algorithm details \n p = " + p + " q = " + q + "\nPublic Key is " + public_key
                + "\nPrivate Key is " + private_key + "\n";
        System.out.println(message);
        return message;
    }

//    public static void main(String args[]) throws InvalidAlgorithmParameterException {
//        Schmidt_Samoa encryptor = new Schmidt_Samoa();
//        encryptor.display();
//
//        //Constraint ----        0 < M < (p^2) *q
//        System.out.println("\n\nMessage (Block) Size Limit = p * q = " + encryptor.p * encryptor.q);
//        /*int ciphertext = encryptor.encrypt(210);
//         System.out.println("Encrypt = " + ciphertext);
//         System.out.println("Decrypt = " + encryptor.decrypt(ciphertext));*/
//
//        System.out.println("\nEncrypting String...");
//        String message = "abcd";
//        String ciphertext = encryptor.encrypt(message);
//        System.out.println(ciphertext.length());
//        System.out.println("Cipher text = " + ciphertext);
//        String plaintext = encryptor.decrypt(ciphertext);
//        System.out.println("Plaintext = " + plaintext);
//    }

    public String[][] preEncrypt(String plainText[][]){
        
        String chiperText[][] = null;
        
        for (int i = 0; i < plainText.length; i++) {
            for (int j = 0; j < 5; j++) {
                String chiperPar = encrypt(plainText[i][j]);
                chiperText[i][j] = chiperPar;
            }
        }
        
        return chiperText;
        
    }
    
    public String[][] preDecrypt(String cipherText[][]){
        
        String plainText[][] = null;
        
        for (int i = 0; i < cipherText.length; i++) {
            for (int j = 0; j < 5; j++) {
                String plainPar = decrypt(cipherText[i][j]);
                plainText[i][j] = plainPar;
            }
        }
        
        return plainText;
        
    }
}
