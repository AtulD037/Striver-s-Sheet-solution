package Day04;

import java.util.*;

public class ThreeSum {
    static List<List<Integer>> threeSumNaive(int[] arr){
        int n = arr.length;
        HashSet<ArrayList<Integer>> solutionSet = new HashSet<>(); // Create a hashset with arrayList for unique elements
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (arr[i]+arr[j]+arr[k]==0){
                        ArrayList<Integer> triplets = new ArrayList<>();
                        triplets.add(arr[i]);
                        triplets.add(arr[j]);
                        triplets.add(arr[k]);
                        Collections.sort(triplets);
                        solutionSet.add(triplets);
                    }
                }
            }
        }
        return new ArrayList<>(solutionSet);
    }

    static List<List<Integer>> threeSumOptimalApproach(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i+1;
            int k = n-1;
            if (i>0 && arr[i]==arr[i-1]){
                continue;
            }
            while (j<k){
                if (k<(n-1) && arr[k]==arr[k+1]){
                    k--;
                    continue;
                }
                if (arr[i]+arr[j]+arr[k]>0){
                    k--;
                } else if(arr[i] + arr[j] + arr[k] < 0) {
                    j++;
                }
                else {
                    ArrayList<Integer> triples = new ArrayList<Integer>();
                    triples.add(arr[i]);
                    triples.add(arr[j]);
                    triples.add(arr[k]);
                    Collections.sort(triples);
                    j++;
                    k--;
                    answer.add(triples);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSumNaive(nums));
        System.out.println(threeSumOptimalApproach(nums));
    }
}
