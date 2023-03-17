package com.javarush.cryptanalyzerconsole.kuznetsova;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    String myFile = "src/main/resources/input";
    String encodedFile = "src/main/resources/encoded";

    public void printFile (StringBuilder encodeString) {
        System.out.println("Текст для шифрования: ");
        System.out.println();
        System.out.println(encodeString);
        System.out.println();
    }
    public StringBuilder readingMyFile () {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)))) {

            StringBuilder encodeString = new StringBuilder();
            //есть ли доступные символы
            while (bufferedReader.ready()) {
                encodeString.append((char) bufferedReader.read());
            }

            printFile(encodeString);

            return encodeString;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StringBuilder readingYourText () throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Напишите пару предложений ниже:");
        StringBuilder yourText = new StringBuilder(bufferedReader.readLine());

        printFile(yourText);

        return yourText;
    }

    public StringBuilder readEncodedFile () {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(encodedFile)))) {

            StringBuilder myEncryptedFile = new StringBuilder();
            //есть ли доступные символы
            while (bufferedReader.ready()) {
                myEncryptedFile.append((char) bufferedReader.read());
            }

            printFile(myEncryptedFile);

            return myEncryptedFile;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}