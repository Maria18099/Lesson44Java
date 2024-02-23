package org.example;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeInfo("info.txt");
        readInfo("info.txt");
    }
    public static void writeInfo(String fileName){
        //Task1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of persons:");
        int n = scanner.nextInt();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (int i = 0; i < n; i++) {
                System.out.println("Enter name:");
                String name = scanner.next();
                System.out.println("Enter age:");
                int age = scanner.nextInt();
                writer.write((i+1)+". "+name+" "+age+"\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readInfo(String fileName){
        //task 2
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int counter = 0;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
                String[] words = line.split(" ");//{"1.","Ann","23"}
                int age = Integer.parseInt(words[2]);
                if(age>25){
                    counter++;
                }
            }
            System.out.println("Counter = "+counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}