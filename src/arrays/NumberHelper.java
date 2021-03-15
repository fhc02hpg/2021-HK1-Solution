package arrays;

import java.util.Arrays;

public class NumberHelper {

  public static int[] getFlatArray(int[][] numbers) {
    int dim1 = numbers.length;
    int dim2 = numbers[0].length;
    int[] flat = new int[dim1 * dim2];
    //fill array elements with -1
    Arrays.fill(flat, -1);
    //or fill with -1 manually using a loop like below
    /*
    for(int i = 0;i < flat.length; i++) {
      flat[i] = -1;
    }*/
    int index = 0;
    for(int r=0; r < numbers.length; r++) {
      for(int c=0; c < numbers[r].length; c++) {
        if(!arrayContains(flat,numbers[r][c])) {
          flat[index++] = numbers[r][c];
        }
      }
    }
    return flat;
  }

  private static boolean arrayContains(int[] array, int number) {
    for(int i : array) {
      if(i == number)
        return true;
    }
    return false;
  }


  public static void main(String[] args) {

    int[][] test1 = {
        {0,1,9},
        {6,3,2}
    };

    System.out.println(Arrays.toString(getFlatArray(test1)));

    int[][] test2 = {
        {3,5,8},
        {4,5,6}
    };

    System.out.println(Arrays.toString(getFlatArray(test2)));

  }

}
