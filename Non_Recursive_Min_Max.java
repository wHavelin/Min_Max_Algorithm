
public class Non_Recursive_Min_Max
{
    public int comparisons = 0;

    public int[] run_min_max(int[] source_array){
        int[] return_array = new int[2];
        int n = source_array.length;
        int temp_min;
        int temp_max;
        if(n%2==1){ //This checks to see if n is odd
            return_array[0] = source_array[n-1]; //sets initial min to the last array element
            return_array[1] = source_array[n-1]; //sets initial max to the last array element
            --n; //now the program now longer has to check the last array element, making the array now of even size
        }
        else if(n>=2){ //This block of code makes the first pair of elements only take one comparison
            if(source_array[n-1]<source_array[n-2]){
                return_array[0] = source_array[n-1];
                return_array[1] = source_array[n-2];
            }
            else{
                return_array[0] = source_array[n-2];
                return_array[1] = source_array[n-1];
            }
            comparisons++;
            n-=2;
        }
        while(true){
            if(n==0)
                return return_array;
            comparisons+=3;
            if(source_array[n-1]<source_array[n-2]){
                temp_min = source_array[n-1];
                temp_max = source_array[n-2];
            }
            else{
                temp_min = source_array[n-2];
                temp_max = source_array[n-1];
            }
            if(temp_min<return_array[0])
                return_array[0] = temp_min;
            if(temp_max>return_array[1])
                return_array[1] = temp_max;
            n-=2;
        }
    }
}
