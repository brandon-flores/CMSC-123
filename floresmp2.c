#include <stdio.h>
#include <stdlib.h>
/**Work of
  *Brandon Flores
  */
int linearSearch(int,int[]);
int binarySearch(int,int[]);

int main(){
    int size,i=0;
    scanf("%d",&size);
    int A[size];

    while(i<size){
        scanf("%d",&A[i]);
        i++;
    }
    linearSearch(size,A);
    binarySearch(size,A);

    return 0;
}

int linearSearch(int x,int A[]){
    int i;
    for(i=0;i<x;i++){
        if(A[i]==i){
            printf("%d, index %d\n\n",i,i);
            return 0;
        }
    }
    printf("None\n\n");
}

int binarySearch(int x,int A[]){
    int a,b,c;
    for(a=0,b=x-1,c=(a+b)/2;a<=b;c=(a+b)/2){
        if(A[c]==c){
            printf("%d, index %d\n\n",c,c);
            return 0;
        }
        else if(A[c]<c) a=c+1;
        else b=c-1;
    }
    printf("None\n\n");
}
