package LE4Q1;

import com.sun.source.tree.Tree;

import java.io.File;
import java.util.*;

public class DasolExerciseOnFileMapSet {
    public static Scanner fileInput;
    public static void main(String[] args) throws Exception{
        myHeader(4, 1);

        TreeMap<String, Integer> lastNameMap = new TreeMap<>();
        lastNameMap = populateTreeMap(lastNameMap, 0);
        Set<Map.Entry<String, Integer>> lNameEntrySet = lastNameMap.entrySet();
        printSet(lNameEntrySet, "Last");

        TreeMap<String, Integer> firstNameMap = new TreeMap<>();
        firstNameMap = populateTreeMap(firstNameMap, 1);
        Set<Map.Entry<String, Integer>> fNameEntrySet = firstNameMap.entrySet();
        System.out.println("");
        printSet(fNameEntrySet, "First");

        myFooter(4, 1);
    }

    public static void printSet(Set<Map.Entry<String, Integer>> set, String name){
        System.out.printf("List of the Number of students with the same %s Names:\n", name);
        System.out.printf("\t\t%s-names\t\tNumbers\n", name);
        System.out.println("---------------------------------------");
        for (Map.Entry<String, Integer> entry: set){
            int value;
            if (entry.getValue() > 1) {
                value = entry.getValue();
                System.out.printf("%18s \t %4d\n", entry.getKey(), value);
            }
        }
    }

    public static TreeMap<String, Integer> populateTreeMap(TreeMap<String, Integer> map, int index) throws Exception{
        File file = new File("C:\\dlim67_LabExercise4\\SE2205Students.txt");
        fileInput = new Scanner(file);
        if (!file.exists()){
            System.out.println("File is not found! Bye Bye!");
            System.exit(0);
        }

        String[] words;
        String name;

        while (fileInput.hasNext()){
            words = fileInput.nextLine().split(" ");
            name = words[index];
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                int count = map.get(name);
                count++;
                map.put(name, count);
            }
        }

        fileInput.close();

        return map;
    }

    public static void myHeader (int labE_number, int q_number) {
        System.out.println("==========================================================");
        System.out.printf("Lab Exercise %d-Q%d\n", labE_number, q_number);
        System.out.printf("Prepared By: Dasol Lim\nStudent Number: 251224110\n");
        System.out.printf("Goal of this Exercise: Using TreeMaps and Sets to display!\n");
        System.out.println("==========================================================");
    }

    public static void myFooter (int labE_number, int q_number) {
        System.out.println("==========================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\nSigning off - Dasol\n", labE_number, q_number);
        System.out.println("==========================================================");
    }
}
