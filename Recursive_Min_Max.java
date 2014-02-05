
public class Recursive_Min_Max
{
    public int comparisons = 0;
    
    public int get_min(int num_1, int num_2){
        comparisons++;
        if(num_1<num_2)
            return num_1;
        return num_2;
    }
    
    public int get_max(int num_1, int num_2){
        comparisons++;
        if(num_1>num_2)
            return num_1;
        return num_2;
    }
    
    public int[] get_min_and_max(int[] source_array_1, int[] source_array_2){
        int[] return_array = new int[2];
        return_array[0] = get_min(source_array_1[0], source_array_2[0]);
        return_array[1] = get_max(source_array_1[1], source_array_2[1]);
        return return_array;
    }
    
    public int[] run_min_max(int[] source_array, int start_index, int stop_index){
        int n = stop_index - start_index + 1;
        int[] return_array = { source_array[start_index], source_array[start_index]}; 
        int k = 0;
        while(true){
            int two_to_the_k = (int)Math.pow(2,k);
            if(two_to_the_k==n)
                break; //This means it is a power of 2
            if(two_to_the_k>n){
                two_to_the_k = (two_to_the_k/2);
                return get_min_and_max(run_min_max(source_array, start_index, (start_index+two_to_the_k-1)),run_min_max(source_array, (start_index+two_to_the_k), stop_index));
            }
            k++;
        }
        switch(n){
            case 1: 
                return return_array;
            case 2:
                comparisons++;
                if(source_array[0] < source_array[1]){
                    return_array[0] = source_array[start_index];
                    return_array[1] = source_array[start_index+1];
                }
                else{
                    return_array[0] = source_array[start_index+1];
                    return_array[1] = source_array[start_index];
                }
                return return_array;
            default:
                int pivot_index = n/2;
                return get_min_and_max(run_min_max(source_array, start_index, start_index+pivot_index-1), run_min_max(source_array, start_index+pivot_index, stop_index));
        }
    }

}
