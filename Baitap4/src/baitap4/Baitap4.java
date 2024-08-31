
package baitap4;

import java.util.Arrays;
import java.util.Scanner;


public class Baitap4 {

   
    
    public static float[] importData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        float[] arrays = new float[n];
        
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextFloat();
        }
        
        return arrays;
    }

   
    public static void printData(float[] arrays) {
        System.out.println("Mang hien tai:");
        for (float value : arrays) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    
    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mang it nhat phai co 2 phan tu.");
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float value : arrays) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            } else if (value > max2 && value < max1) {
                max2 = value;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new IllegalStateException("Khong tim thay gia tri lon thu 2.");
        }

        return max2;
    }

    
    public static void deleteOddNumber(float[] arrays) {
        int count = 0;
        for (float value : arrays) {
            if (Math.floor(value) % 2 == 0) {
                arrays[count++] = value;
            }
        }

        
        arrays = Arrays.copyOf(arrays, count);

    
        System.out.println("Mang sau khi xoa cac phan tu le:");
        printData(arrays);
    }

    public static void main(String[] args) {
        float[] data = importData();

        
        printData(data);

        
        try {
            float max2 = findMax2(data);
            System.out.println("Gia tri lon thu 2 la: " + max2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        deleteOddNumber(data);
    }
}

    
    

