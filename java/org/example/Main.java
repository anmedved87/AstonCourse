package org.example;

public class Main {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }


    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static void arraySize(String[][] arr, String name) {
        try {
            if (arr.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Массив должен быть размером 4x4");
                }
            }
            System.out.println("Массив " + name + " правильного размера 4x4");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка " + name + e.getMessage());
        }
    }

    public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int value = Integer.parseInt(arr[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("Ошибка данных в ячейке [" + i + "][" + j + "]: '" + arr[i][j] + "'");
                }
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        String[][] array1 = {
                {"87", "93", "15", "8"},
                {"3", "3", "3", "3"},
                {"1", "2", "3", "4"},
                {"99", "14", "15", "16"}
        };

        String[][] array2 = {
                {"87", "93", "15", "8"},
                {"a", "3", "3", "3"},
                {"1", "2", "3", "4"},
                {"99", "14", "15", "16"}
        };

        String[][] array3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"99", "14", "15"}
        };
        arraySize(array1, "array1");
        arraySize(array2, "array2");
        arraySize(array3, "array3");

        try {
            int resultArray1 = arraySum(array1);
            System.out.println("Сумма (array1): " + resultArray1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка (array1): " + e.getMessage());
        }

        try {
            int resultArray2 = arraySum(array2);
            System.out.println("Сумма (array2): " + resultArray2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка (array2): " + e.getMessage());
        }
        try {
            int resultArray3 = arraySum(array3);
            System.out.println("Сумма (array3): " + resultArray3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка (array3): " + e.getMessage());
        }

        try {
            int[] nums = {1, 2, 3};
            System.out.println(nums[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
