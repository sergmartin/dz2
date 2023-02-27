

package dz2_java;



import java.io.IOException;
import java.util.logging.*;


public class task2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("logTask2.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Сортируемый массив: ");
        int [] array = {2, 5, 1, -7, 3, 64, 0};
        printArrayInt(array);
        int[] newArr = listSort(array);
        System.out.printf("\n Отсортированный массив: \n");
        printArrayInt(newArr);
    }
    public static int[] listSort(int [] arr){
        for(int k = 0; k < arr.length-1; k++) {
            
            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }
     // Печать массива чисел 
     public static void printArrayInt(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.print(arr[arr.length-1]);
    }
    
    public static void printArraeString(String [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}