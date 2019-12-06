#include <iostream>
#include <limits.h> 
#include <chrono>

using namespace std;

int max(int a, int b) { 
    return (a > b)? a : b; 
}

int max(int A, int B, int C) { 
    int largest;
    largest = A > B ? (A > C ? A : C) : (B > C ? B : C); 
    return largest; 
} 

int maxCrossingSum(int arr[], int l, int m, int h) 
{ 
    
    int sum = 0; 
    int lefSum = INT_MIN; 
    for (int i = m; i >= l; i--) 
    { 
        sum = sum + arr[i]; 
        if (sum > lefSum) 
          lefSum = sum; 
    } 
    //cout<<"Left Sum : " << lefSum<<endl ;
    
    sum = 0; 
    int ligSum = INT_MIN; 
    for (int i = m+1; i <= h; i++) 
    { 
        sum = sum + arr[i]; 
        if (sum > ligSum) 
          ligSum = sum; 
    } 
  
    //cout<<"Right Sum : " << ligSum<<endl ;
    return lefSum + ligSum; 
} 
  
 
int maxi_sum(int arr[], int l, int h) 
{ 
    //cout<<"in maxi_sum with :" << l << "   " << h<<endl;
   if (l == h) 
     return arr[l]; 
  
   
   int m = (l + h)/2; 
   int a =maxi_sum(arr, l, m);
   int b =maxi_sum(arr, m+1, h);
   int c =maxCrossingSum(arr, l, m, h);
   //cout << "Comparing  " <<a  << "   " <<  b << "   " << c << endl;
   return max(a, b, c); 
} 

int max_iterative(int arr[],int low,int high){
    int maxSum = INT_MIN;
    //int size = sizeof(arr)/sizeof(arr[0]);
    //cout <<size;
    for(int i=low;i<=high;i++){
        int sum = 0;
        if(arr[i] > maxSum){
            maxSum = arr[i];
            //start=i;
            //end =i;
        }
        for(int j=i;j<=high;j++){
            sum += arr[j];
            if(sum > maxSum){
                maxSum = sum;
                //start=i;
                //end =j;
            }
        }
    }
    return maxSum;
}

int maxi_sum_modified(int arr[], int l, int h) 
{ 
    int crossOverValue = 58;
   if (h-l > crossOverValue){
       //cout << "on some day i was here";
       return max_iterative(arr,l,h);
       
   }else{
       int m = (l + h)/2; 
       int a =maxi_sum(arr, l, m);
       int b =maxi_sum(arr, m+1, h);
       int c =maxCrossingSum(arr, l, m, h);
       //cout << "Comparing  " <<a  << "   " <<  b << "   " << c << endl;
       return max(a, b, c); 
   }
  
   
   
} 
  
int finding_crossover_automatically(int arr[]){
    int sample_size_confirmation = 1;
    for ( int j=0;j<100;j++){
       cout << "Recursive Approach ";
       auto start = chrono::steady_clock::now();
       int maxSum = maxi_sum(arr, 0, j); 
       auto end = chrono::steady_clock::now();
       auto diff = end - start;
       cout << chrono::duration <double, nano> (diff).count() << " ns" << endl;
       cout << "Maximum contiguous sum is " <<  maxSum <<endl; 
       
       
       cout << "Bruteforce Approach ";
       auto start2 = chrono::steady_clock::now();
       int maxSum2 = max_iterative(arr,0,j); 
       auto end2 = chrono::steady_clock::now();
       auto diff2 = end2 - start2;
       cout << chrono::duration <double, nano> (diff2).count() << " ns" << endl;
       cout << "Maximum contiguous sum is " <<  maxSum2 <<endl; 
   
        if(maxSum != maxSum2 ){
            cout << "Sum does not match";
            return -1;
            break;
        }
        if( diff < diff2){
            cout << "Break over found";
            return j;
            break;
        }
   }
}

int main() 
{ 
   int arr[] = {20, -21, 43, -23, -92, 45, -56, -5, 34, -17,
                    34, 65, 89, -109, 125, 2, -10, 89, 46, 65, -49, 
                    3, -45, 34, 76, 32, -76, -2, 3, -45, 44, 34, 67, 
                    -67, 99, -104, 11, -37, 44, 76, -90, 89, -32, 34, 
                    88, 56, -6, -89, -90, -34, -56, 23, 29, 2, 6, 9, 
                    2, -34, -45, 34, 22, -177, 44, 90, -45, -36, 55, 
                    23, 56, -56, -167, -54, 23, 45, 14, 62, -46, -56, 
                    -34, 45, 32, 20, -87, 39, 82, 95, -67, -45, 88, 
                    -36, 21, 18, 16, 81, -102, 99, -45, -67, -45, -76}; 
   int n = sizeof(arr)/sizeof(arr[0]); 
   
   //finding out cross over automatically 
   //int crossover = finding_crossover_automatically(arr);
   //cout << "Cross over : " << crossover;
   
   //finding out cross over manually 
   //crossover = 59;
   
   
   int sample_size = 50;
   int sample_size_confirmation = 10;
   for ( int j=0;j<sample_size_confirmation;j++){
       cout << "Recursive Approach "<< endl;
       auto start = chrono::steady_clock::now();
       int maxSum = maxi_sum(arr, 0, sample_size); 
       auto end = chrono::steady_clock::now();
       auto diff = end - start;
       cout << chrono::duration <double, nano> (diff).count() << " ns" << endl;
       cout << "Maximum contiguous sum is " <<  maxSum <<endl; 
       
       
       cout << "Bruteforce Approach "<< endl;
       auto start2 = chrono::steady_clock::now();
       int maxSum2 = max_iterative(arr,0,sample_size); 
       auto end2 = chrono::steady_clock::now();
       auto diff2 = end2 - start2;
       cout << chrono::duration <double, nano> (diff2).count() << " ns" << endl;
       cout << "Maximum contiguous sum is " <<  maxSum2 <<endl; 
   
        if(maxSum != maxSum2 || diff > diff2){
            cout << "=============================================ERROR=============================================";
            break;
        }
        
        cout << "Modified Recursive Approach "<< endl;
       auto start3 = chrono::steady_clock::now();
       int maxSum3 = maxi_sum_modified(arr,0,sample_size); 
       auto end3 = chrono::steady_clock::now();
       auto diff3 = end3 - start3;
       cout << chrono::duration <double, nano> (diff3).count() << " ns" << endl;
       cout << "Maximum contiguous sum is " <<  maxSum3 <<endl; 
   
        cout <<endl<<endl;
   }return 0; 
} 