#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>
//-------CONSTANTES--------
#define N 5 
#define LEFT (i+N-1)%N 
#define RIGHT (i+1)%N 
#define THINKING 0 
#define HUNGRY 1 
#define EATING 2 
int state[N];
//---------GLOBAL-----
sem_t mutex;
sem_t s[N];
//--------PROTOTIPACAO---------
void take_forks(int i);
void put_forks(int i);
void test(int i);
void think (int i);
void eat (int i);

//------ACOES DO FILOSOFO (WHILE INFINITO)----
void *philosopher(void  *iparam) 
{
    while (1) { 
        int *id = (int *) (iparam);
        think(*id); 
        take_forks(*id); 
        eat(*id); 
        put_forks(*id); 
    }   
}
//------FUNCAO PEGAR GARFO-----
void take_forks(int i) 
{
    sem_wait(&mutex); 
    printf("Filosofo %d está faminto\n", i);
    state[i] = HUNGRY; 
    test(i); 
    sem_post(&mutex); 
    sem_wait(&s[i]); 
}
//------FUNCAO DEVOLVER GARFO-----
void put_forks(int i) 
{
    sem_wait(&mutex); 
    printf("Filosofo %d está pensando\n", i);
    state[i] = THINKING; 
    test(LEFT); 
    test(RIGHT); 
    sem_post(&mutex); 
}
//-----FUNCAO PARA TESTAR SE O FILOSOFO I PODE COMER------
void test(int i)
{
    if (state[i] == HUNGRY && state[LEFT] != EATING && state[RIGHT] != EATING) {
        state[i] = EATING;
    printf("Filosofo %d está comendo\n", i);
        sem_post(&s[i]);
    }
}
//-----FUNCAO PENSAR COM O INTERVALO DE 4SEGUNDOS PENSANDO-----
void think (int i) {
    printf("Filosofo %d pensou por 4 segundos\n", i);
    sleep(4);
}
//-----FUNCAO COMER COM O INVERTAVELO DE 3SEGUNDOS PENSANDO
void eat (int i) {
    printf("Filosofo %d comeu por 3 segundos\n", i);
    sleep(3);
}
//-------FUNCAO MAIN------
int main () {
    long cont;
    pthread_t thread_id[N];
    int numeroDeFilosofos[N] = {1, 2, 3, 4, 5};
    
    for (cont = 1; cont < 6; cont++)
        printf("Filosofo %d sentou à mesa\n", cont);

  //INICIALIZACAO DOS SEMAFOROS
    sem_init(&mutex, 0, 1);
    for (cont = 0; cont < N; cont++) {
        sem_init(&s[cont], 0, 0);
    }
    for (cont = 0; cont < N; cont++) {
    //CRIACAO DOS FILOSOFOS
        pthread_create(&thread_id[cont], NULL, philosopher, (&numeroDeFilosofos[cont]));
    }
    
    printf("Todos os filosofos estavam pensando\n");

    for (cont = 0; cont < N; cont++) {
        pthread_join(thread_id[cont], NULL);
    }
}

