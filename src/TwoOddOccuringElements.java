
public class TwoOddOccuringElements
{
    static void printTwoOddElements(int arr[], int size)
    {
        int firstXORSecond= arr[0];
        int bit_number;
        int i;
        int first = 0, second = 0;
        for(i = 1; i < size; i++)
            firstXORSecond= firstXORSecond ^ arr[i];
         bit_number = firstXORSecond & ~(firstXORSecond-1);
        for(i = 0; i < size; i++)
        {
            if((arr[i] & bit_number)>0)
                first = first ^ arr[i];
            else
                second = second ^ arr[i];
        }

        System.out.println("Two odd occurring elements" + first + " & " + second);
    }
    public static void main (String[] args)
    {
        int arr[] = {10,20};
        int arr_size = arr.length;
        printTwoOddElements(arr, arr_size);
    }
}
