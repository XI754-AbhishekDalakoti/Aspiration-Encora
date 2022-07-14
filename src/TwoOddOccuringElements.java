
public class TwoOddOccuringElements
{
    static void printTwoOddElements(int arr[], int size)
    {
        int z = arr[0];
        int bit_number;
        int i;
        int n = size - 2;
        int x = 0, y = 0;

        for(i = 1; i < size; i++)
            z= z ^ arr[i];
         bit_number = z & ~(z-1);
        for(i = 0; i < size; i++)
        {
            if((arr[i] & bit_number)>0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }

        System.out.println("Two odd occuring elements" + x + " & " + y);
    }
    public static void main (String[] args)
    {
        int arr[] = {10,20};
        int arr_size = arr.length;
        printTwoOddElements(arr, arr_size);
    }
}
