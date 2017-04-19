#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000
#define delUsed copy[token-line+strlen(token)+i]
//I declare upon my honor that I made this mp by myself
/*typedef struct elem{
    char dat[MAX];
    struct elem *next;
}node;

typedef struct{
    node *head,*tail;
    int size;
}list;*/


int main(){
    FILE *ifp, *ofp;
    ifp=fopen("sample-test-cases.txt","r");
    ofp=fopen("OUT.o","w");
    char line[MAX],delim[MAX]=";)(}{\n",temp[MAX],*token,*copy,For[]="for", delim2[MAX]=" ";
    int i;
    static int flag;
    //strcpy(For, "for");
    //printf("%s\n",For);

    if (ifp == NULL){
        perror("Error while opening the file.\n");
        exit(EXIT_FAILURE);
    }

    else{
        while(fgets(line,MAX,ifp)!=NULL){
            copy=strdup(line);
            //printf("%s\n",copy);
            token=strtok(line,delim);
            while(token!=NULL){
                for(i=0;delUsed==';'||delUsed=='}'||delUsed=='{'||delUsed==')'||delUsed=='(';i++){
                    //printf("%c\n",delUsed);
                    //printf("%s\n",token);
                    if(strncmp(token,For,3)==0) flag=0;
                    else{
                            //printf("tae\n");
                            //printf("%s\n",token);
                        if(delUsed==';'){
                            if(flag==0){
                                printf("\n\nINITIALIZER: %s\n",token);
                            }
                            if(flag==1){
                                printf("CONDITION: %s\n",token);
                            }
                        }
                        if(flag==2){
                            printf("OPERATION: %s\n",token);

                        }
                        if(flag>2){
                            printf("Other: %s\n",token);
                        }
                        flag++;
                    }

                }
                token=strtok(NULL,delim);
            }
        }
    }
    fclose(ifp);
    free(copy);
    return 0;
}
