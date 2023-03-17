package com.javarush.cryptanalyzerconsole.kuznetsova;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptanalyzerconsole.kuznetsova.Constants.ALPHABET;
import static com.javarush.cryptanalyzerconsole.kuznetsova.Menu.KEY;

public class Decode {

    public void printBeforeDecodedText () {
        System.out.println("Расшифрованный текст:");
        System.out.println();
    }

    public void decodeFileCaesarCipher (StringBuilder myEncryptedFile) {

        printBeforeDecodedText();

        char decodedText;

        for (int i = 0; i < myEncryptedFile.length(); i++) {

            int decodeStringToChar = myEncryptedFile.charAt(i);
            int symbolIndex = ALPHABET.indexOf(decodeStringToChar);
            boolean symbolsInAlphabet = (symbolIndex != -1);
            int symbolsShift = (symbolIndex - KEY);

            if (symbolsInAlphabet) {
                decodedText = ALPHABET.charAt(symbolsShift % ALPHABET.length());
                System.out.print(decodedText);
            }
        }
    }

    public void decodeBruteForceFile (StringBuilder encryptedFile) {

        StringBuilder decodeBruteForceFile = new StringBuilder();
        StringBuilder decodeFile = new StringBuilder();

        for (int i = 0; i < ALPHABET.length(); i++) {

            char decodedText;

            for (int j = 0; j < encryptedFile.length(); j++) {

                int encodeStringToChar = encryptedFile.charAt(j);
                int symbolIndex = ALPHABET.indexOf(encodeStringToChar);
                boolean symbolsInAlphabet = (symbolIndex != -1);

                if (symbolsInAlphabet) {
                    decodedText = ALPHABET.charAt((symbolIndex + i) % ALPHABET.length());
                    decodeBruteForceFile.append(decodedText);

                }
            }
        }
        System.out.println(decodeFile.append(regE(decodeBruteForceFile)));
    }

    public StringBuilder regE (StringBuilder decodeBruteForceFile) {

        StringBuilder regE = new StringBuilder();

        Pattern pattern = Pattern.compile("([А-ЯЁ]{1}[^\\.]+\\.+\\s+[А-ЯЁ]{1}[^\\.]+\\.+\\s+[А-ЯЁ]{1}[^\\.]+\\.+.+)");
        Matcher matcher = pattern.matcher(decodeBruteForceFile);

        while(matcher.find()) {
            regE.append(matcher.group());
        }
        return regE;
    }
}
