#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000
//I declare upon my honor that I made this mp by myself
typedef struct elem{
    char dat[MAX];
    struct elem *next;
}node;

typedef struct{
    node *head,*tail;
    int size;
}list;

void init(list*);
void append(list*,char*);
int scan(list,char*);
void header(FILE*,char*,list*);

int main(){
    FILE *ifp,*ofp;
    ifp = fopen("inputFile.cpp","r");
    ofp = fopen("results.out","w");
    char line[MAX],delim[MAX]=" \"",temp[MAX],*token;
    list l;
    init(&l);

    if(ifp==NULL) printf("ERR");
    else{
        while(fgets(line,MAX,ifp)!=NULL){
            strcpy(temp,line);
            token=strtok(temp,delim);
            if(strcmp(token,"#include")==0){
                token=strtok(NULL,delim);
                if(scan(l,token)){
                    append(&l,token);
                    header(ofp,token,&l);
                }
            }
            else fprintf(ofp,"%s",line);
        }
    }
    fclose(ifp);
    fclose(ofp);
    return 0;
}

void init(list *l){
    l->size=0;
    l->head=l->tail=NULL;
}

void append(list *l, char *st){
    node *tmp=malloc(sizeof(node));
    strcpy(tmp->dat,st);
    tmp->next=NULL;

    if(l->size==0)
        l->head=l->tail=tmp;
    else{
        l->tail->next=tmp;
        l->tail=tmp;
    }
    l->size++;
}

int scan(list l,char *st){
    node *tmp = l.head;
    if(l.size==0) return 1;
    while(tmp->next!=NULL){
        if(strcmp(tmp->dat,st)==0)
            return 0;
        tmp=tmp->next;
    }
    return 1;
}

void header(FILE *fp,char *st, list* l){
    FILE *afp=fopen(st,"r");
    char delim[MAX]=" \"",*token,temp[MAX],line[MAX];

    while(fgets(line,MAX,afp)!=NULL){
            strcpy(temp,line);
            token=strtok(temp,delim);
            if(strcmp(token,"#include")==0){
                token=strtok(NULL,delim);
                if(scan(*l,token)){
                    append(l,token);
                    header(fp,token,l);
                }
            }
            else fprintf(fp,"%s",line);
    }
    fclose(afp);
}
