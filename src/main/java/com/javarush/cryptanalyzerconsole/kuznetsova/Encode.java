package com.javarush.cryptanalyzerconsole.kuznetsova;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.javarush.cryptanalyzerconsole.kuznetsova.Constants.ALPHABET;
import static com.javarush.cryptanalyzerconsole.kuznetsova.Menu.KEY;

public class Encode {
    String encodedFile = "src/main/resources/encoded";

    public void printTextAfterEncryption () {
        System.out.println("Текст после шифрования:");
        System.out.println();
    }

    public void printChoiceDecryption () {
        System.out.println();
        System.out.println("Каким способом хотите расшифровать текст? Выход - 0, Цезарь - 1, Грубая сила - 2");
        System.out.println();
    }

    public void encodingText (StringBuilder encodeString) {

        printTextAfterEncryption();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(encodedFile))) {

            char encodedText;

            for (int i = 0; i < encodeString.length(); i++) {

                //encodeString.charAt(i) - перевожу полученную строку в символы
                int encodeStringToChar = encodeString.charAt(i);

                //indexOf - возвращает положение символа в ALPHABET или -1, если его там нет
                int symbolIndex = ALPHABET.indexOf(encodeStringToChar);
                boolean symbolsInAlphabet = (symbolIndex != -1);

                //проверяю, есть ли символы в строке ALPHABET
                if (symbolsInAlphabet) {
                    //charAt - возвращаю символ из ALPHABET, который расположен на месте (encodeStringToChar) + key)
                    //% ALPHABET.length() - чтобы вернуться в начало и пойти по новому кругу
                    encodedText = ALPHABET.charAt((symbolIndex + KEY) % ALPHABET.length());

                    System.out.print(encodedText);
                    bufferedWriter.write(String.valueOf(encodedText));

                }
            }
            System.out.println();
            printChoiceDecryption();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}