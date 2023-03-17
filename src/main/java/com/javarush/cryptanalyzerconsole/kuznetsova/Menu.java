package com.javarush.cryptanalyzerconsole.kuznetsova;

import java.io.IOException;
import java.util.Scanner;
public class Menu {
    public static int KEY;
    public void start () throws IOException {

        Reader reader = new Reader();
        Encode encode = new Encode();
        Decode decode = new Decode();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ключ(целое число) для шифрования: ");
        KEY = scanner.nextInt();
        System.out.println();

        System.out.println("Хотите зашифровать мой текст? Нет - 0, Да - 1");
        int encodeMyText = scanner.nextInt();
        if (encodeMyText == 1) {
            encode.encodingText(reader.readingMyFile());


            int answerAfterEncryption = scanner.nextInt();
            if (answerAfterEncryption == 1) {
                decode.decodeFileCaesarCipher(reader.readEncodedFile());

            } else if (answerAfterEncryption == 2) {
                decode.decodeBruteForceFile(reader.readEncodedFile());

            } else if (answerAfterEncryption == 0) {

                System.out.println("Для выхода их программы напишите \"Выход\"");
                String answerExit = scanner.next();

                if (answerExit.equals("Выход")) {
                    System.out.println("Чтобы выбрать другой метод шифрования, запустите программу еще раз");
                }
            }


        } else if (encodeMyText == 0) {
            System.out.println("Хотите зашифровать ваш текст? Нет - 0, Да - 1");

            int encodeYourText = scanner.nextInt();
            if (encodeYourText == 1) {

                encode.encodingText(reader.readingYourText());
                int answerAfterEncryptionYourText = scanner.nextInt();

                if (answerAfterEncryptionYourText == 1) {
                    decode.decodeFileCaesarCipher(reader.readEncodedFile());

                } else if (answerAfterEncryptionYourText == 2) {
                    decode.decodeBruteForceFile(reader.readEncodedFile());

                } else if (answerAfterEncryptionYourText == 0) {

                    System.out.println("Для выхода их программы напишите \"Выход\"");
                    String answerExit = scanner.next();

                    if (answerExit.equals("Выход")) {
                        System.out.println("Чтобы выбрать другой метод шифрования, запустите программу еще раз");
                    }
                }


            } else {
                System.out.println("Для выхода их программы напишите \"Выход\"");
                String answerExit = scanner.next();

                if (answerExit.equals("Выход")) {
                    System.exit(0);    //TODO
                }
            }
        }
    }
}