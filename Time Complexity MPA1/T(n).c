#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000
#define delUsed copy[token-line+strlen(token)+i]

//I declare upon my honor that I made this mp by myself
void checkerInit(char*,char**);
void checkerCond(char*,char**);
void checkerOp(char*,char**);
int checkerOt(char*,char**);
void evaluate(char**,int);
bool signCheck(char);

void checkerInit(char *s,char **inp){
    int i,j,flag=0;
    char num[MAX];

    for(i=0;*(s+i)!='\0'&&flag==0;i++){
        if(*(s+i)=='=') flag=1;
    }
    for(j=0;*(s+i)!='\0';i++){
        if(*(s+i)!=' '){
            inp[0][j]=*(s+i);
            j++;
        }
    }
    inp[0][j]='\0';
}

void checkerCond(char* s,char** inp){
    int i,ctr=0,j,flag=0;
    for(i=0;*(s+i)!='\0'&&flag==0;i++){
        if(*(s+i)=='i') ctr++;
        if(*(s+i)=='='||*(s+i)=='<'||*(s+i)=='>'||*(s+i)=='!') flag=1;
    }
    inp[1][0]=ctr+48;
    for(j=1;*(s+i)!='\0';i++){
        if(*(s+i)!='='&&*(s+i)!='<'&&*(s+i)!='>'&&*(s+i)!='!'&&*(s+i)!=' '){
            inp[1][j]=*(s+i);
            j++;
        }
    }
    inp[1][j]='\0';
}

bool signCheck(char c){
    if(c == '+' || c == '-' || c == '/' || c == '*' || c == '=') return true;
    return false;
}

void checkerOp(char* s,char** inp){
    int i, flag = 0, j;
    char *a = "+=", *b = "-=", *c = "*=", *d = "/=", *e = "++", *f = "--";
    if(strstr(s,a) != NULL || strstr(s,b) != NULL) {
        inp[2][0] = '1';
        for(i = 0; *(s+i) != '=' ; i++){}

        for(j = 1, ++i;*(s+i) != '\0'; i++){
            if(*(s+i) != ' ' && *(s+i) != '\n' && *(s+i) != '\t'){
                inp[2][j++] = *(s+i);
            }
        }
    }
    if(strstr(s,c) != NULL || strstr(s,d) != NULL){
        inp[2][0] = '4';
        for(i = 0; *(s+i) != '=' ; i++){}

        for(j = 1, ++i;*(s+i) != '\0'; i++){
            if(*(s+i) != ' ' && *(s+i) != '\n' && *(s+i) != '\t'){
                inp[2][j++] = *(s+i);
            }
        }
    }
    if(strstr(s,e) != NULL || strstr(s,f) != NULL){
        inp[2][0] = '0';
        inp[2][1] = '0';
    }
}

int checkerOt(char *s, char **inp){
    int count = 0;
    int i, j;
    char c;

    for(i = 0; *(s+i) != '\0'; i++){
        if(signCheck(*(s+i))){
            if(signCheck(*(s+i+1))){
                i++;
            }
            count++;
        }

    }
    return count;
}

void evaluate(char **inp,int C){
    int ans = 0, ten = 1, i, total, answer;
    int I = 0, N = 0, X = 1, cons = 0;
    bool root = false, log = false, frac = false, var = false;
    if(inp[0][0] >= 'a' && inp[0][0] >= 'z' || inp[0][0] >= 'A' && inp[0][0] >= 'Z'){
        I = 1;
        var = true;
    }
    else{
        for(i = 0; inp[0][i] != '\0'; i++, ten *= 10){
            total += (inp[0][i] - '0') * ten;
        }
        I = total;
    }
    if(inp[1][0] - '0' > 1) {
        root = true;
        X = inp[1][0] - '0';
    }
    if(inp[1][1] >= 'a' && inp[1][1] <= 'z' || inp[1][1] >= 'A' && inp[1][1] <= 'Z'){
        var = true;
    }
    else{
        for(i = 1, ten = 1, total = 0; inp[1][i] != '\0'; i++, ten *= 10){
            total = total*ten + (inp[1][i] - '0');
        }
        N = total;
    }

    if(inp[2][0] == '4') {
        log = true;
        for(i = 1, ten = 1, total = 0; inp[2][i] != '\0'; i++, ten *= 10){
            total = total*ten + (inp[2][i] - '0');
        }
        cons = total;
    }
    if(inp[2][0] == '1') {
        frac = true;
        for(i = 1, ten = 1, total = 0; inp[2][i] != '\0'; i++, ten *= 10){
            total = total*ten + (inp[2][i] - '0');
        }
        cons = total;
    }
    if(!(log || frac || root || var)){
        answer = C*(N - I + 1) + 2;
        printf("T(n) = %d \n",answer);
    }
    if(log){
        answer = C*(-I + 1) + 2;
        if(answer > 0) printf("T(n) = %d log(%d) n + %d\n", C, cons, answer);
        else printf("T(n) = %d log(%d) n - %d\n", C, cons, answer*-1);
    }
    if(frac){
        answer = C*(-I + 1) + 2;
        if(answer > 0) printf("T(n) = %dn/%d + %d\n", C, cons, answer);
        else printf("T(n) = %dn/%d - %d\n", C, cons, answer*-1);
    }
    if(root){
        answer = X - 1 + 2;
        if(X == 2){
            if(answer > 0) printf("T(n) = %d sqrt(n) + %d\n", C + 1, answer);
            else printf("T(n) = %d sqrt(n) - %d\n", C + 1, answer);
        }
        if(X == 3){
            if(answer > 0) printf("T(n) = %d cubert(n) + %d\n", C + 2, answer);
            else printf("T(n) = %d cubert(n) - %d\n", C + 2, answer);
        }
    }
    if(var && !log && !frac && !root){
        answer = C*(-I + 1) + 2;
        if(answer > 0) printf("T(n) = %dn + %d\n", C, answer);
        else printf("T(n) = %dn - %d\n", C, answer*-1);
    }


}

int main(){
    FILE *ifp, *ofp;
    ifp = fopen("sample-test-cases.txt","r");
    ofp = fopen("OUT.o","w");
    bool check = false;
    int i, ctr = 0, x = 0, a, b;
    char line[MAX],delim[MAX]=";)(}{\n",temp[MAX],*token,*copy,For[]="for", delim2[MAX]=" ", c;
    char **inputs = (char**) calloc(MAX, sizeof(char*));
        for ( i = 0; i < MAX; i++ ){
            inputs[i] = (char*) calloc(MAX, sizeof(char));
        }
    static int flag;

    if (ifp == NULL){
        perror("Error while opening the file.\n");
        exit(EXIT_FAILURE);
    }

    else{
        while(fgets(line,MAX,ifp)!=NULL){
            copy=strdup(line);
            token=strtok(line,delim);
            while(token!=NULL){
                for(i=0;delUsed==';'||delUsed=='}'||delUsed=='{'||delUsed==')'||delUsed=='(';i++){
                    if(strncmp(token,For,3)==0){
                        flag=0;
                        if(check)
                          evaluate(inputs,x+2);

                        x = 0;
                    }

                    else{
                        if(delUsed==';'){
                            if(flag==0){
                                checkerInit(token,inputs);
                                check = true;
                            }
                            if(flag==1)
                                checkerCond(token,inputs);
                        }

                        if(flag==2)
                            checkerOp(token,inputs);

                        if(flag>2)
                            x += checkerOt(token,inputs);

                        flag++;
                    }
                }
                token=strtok(NULL,delim);
            }
            ctr++;
        }
        evaluate(inputs,x+2);
    }
    fclose(ifp);
    free(copy);
    for ( i = 0; i < MAX; i++ ){
        free(inputs[i]);
    }

    free(inputs);
    return 0;
}
