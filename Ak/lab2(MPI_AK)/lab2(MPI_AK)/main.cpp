#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 
#include "mpi.h"
#include <iostream>
#include <fstream>
#include <sys/timeb.h>

double realtime() {
	struct _timeb tp;
	_ftime(&tp);
	return((double)(tp.time) * 1000 + (double)(tp.millitm));
}

int main(int argc, char* argv[])
{
	int procsRank, procsCount;
	int i, j, n = 100, local_n;
	double* A, * b, * C, * a, * c;
	double t1, t2, t3, t4;
	t1 = realtime();
	MPI_Init(&argc, &argv); //инициализация MPI
	t2 = realtime();
	MPI_Comm_size(MPI_COMM_WORLD, &procsCount); //определение кол-ва процессов, записывает в procs_count
	MPI_Comm_rank(MPI_COMM_WORLD, &procsRank);	 //определение ранка вызывающего процесса, записывает в procs_rank
	local_n = n / procsCount;
	//выделение памяти под массивы
	A = (double*)malloc((local_n * n) * sizeof(double));
	b = (double*)malloc(n * sizeof(double));
	C = (double*)malloc(local_n * sizeof(double));
	c = (double*)malloc(n * sizeof(double));
	a = (double*)malloc((n * n) * sizeof(double));
	std::ifstream fin;
	//чтение из файла
	
	if (procsRank == 0)
	{
		fin.open("input.txt");
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
			{
				fin >> a[i * n + j];
			}
		for (i = 0; i < n; i++) {
			fin >> b[i];
		}
	
		fin.close();
	}
	

	double time_start = MPI_Wtime();
	MPI_Bcast(b, n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
	MPI_Scatter(a, n * local_n, MPI_DOUBLE, A, n * local_n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
	t3 = MPI_Wtime(); //время старта вычислений на одном процессе
	for (i = 0; i < local_n; i++)
	{
		C[i] = 0;
		for (j = 0; j < n; j++)
			C[i] +=  b[j]*A[i * n + j] ;
	}
	t4 = MPI_Wtime();
	MPI_Gather(C, local_n, MPI_DOUBLE, c, local_n, MPI_DOUBLE, 0, MPI_COMM_WORLD); //собирает данные со всех процессов, ответ лежит в векторе C
	double time_end = MPI_Wtime();

	//вывод результатов
	if (procsRank == 0)
	{
		std::ofstream fout("out.txt");
		for (auto i = 0; i < n; i++) {
			for (auto j = 0; j < n; j++)
				fout << C[i * n + j] << " ";
			fout << "\n";
		}

		std::cout << "init: " << t2 - t1 << "\n";
		std::cout << t4 - t3 <<"\n";
		std::cout << time_end - time_start<<"\n";
	}
	MPI_Finalize(); //завершение работы MPI
	return 0;
}
