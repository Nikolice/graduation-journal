/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MVS19
 */
public class Graduation {

    static DataBase DB;
    static Candidate candidate;
    static Scanner scanner;
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        if (args.length == 0) {
            throw new FileNotFoundException("Ошибка: не указано имя файла!");
        } else if (args.length == 1) {
            DB = new DataBase(args[0]);
            scanner = new Scanner(System.in);
            menu();
        }

    }

    public static void menu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1. Все мероприятия и отметки;");
        System.out.println("2. Кандидат: выбрать для отображения отметок;");
        System.out.println("3. Кандидат: показать отметки;");
        System.out.println("4. Кандидат: есть ли низкие отметки;");
        System.out.println("5. Выйти из программы.");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                DB.printTestsAndMarks(DB.getTests());
                menu();
                break;
            }

            case 2: {
                DB.printCandidates(DB.getCandidates());
                int candidateIndex = scanner.nextInt();
                candidate = DB.getCandidates().get(candidateIndex - 1);
                menu();
                break;
            }

            case 3: {
                candidate.sortByMarks();
                candidate.divideTestsByPass();
                candidate.printSortedMarks();
                menu();
                break;
            }

            case 4: {
                candidate.printAboutLowMarks();
                menu();
                break;
            }

            case 5: {
                System.out.println("Всего Вам доброго!");
                break;
            }

            default: {
                menu();
                break;
            }

        }
        
        System.out.println();
        
    }
    
}
