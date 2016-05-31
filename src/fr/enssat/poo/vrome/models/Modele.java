package fr.enssat.poo.vrome.models;

public class Modele {
	int N;
	int M;
	int tab[][];
	int i;
	int j;
	
	//Constructeur
	public Modele(int n, int m){
		this.N=n;
		this.M=m;
		this.tab = new int[n][m];		
	}
		
	//Methode permettant de créer et initialiser une matrice
		public static Modele creerMatrice(int n, int m, int v){
			Modele mat = new Modele(n,m);
			mat.intialisation(v);
			return mat;
		}
		
		//Fonction permettant d'initialiser la matrice
		public void intialisation(int v){
			for(i=0;i<N;i++){
				for(j=0;j<M;j++){
					tab[i][j]=v;
				}
			}
		}
		
		//Methode pour afficher la matrice
		public void afficheMatrice(){
			
			int i, j;
			System.out.print("[");
			
			for(i = 0; i < N; i++) {
				System.out.print("\t"+ tab[i][0]);
				
				for(j = 1; j < M; j++) {
					System.out.print(", " + tab[i][j]);
				}
				
				if (i != N-1)
					System.out.print("\n");
			}
			
			System.out.println("\t]\n");
		}
	
		//Methode permettant de changer une valeur dans la matrice
		public int setel(int ni, int mj, int var){
			return tab[ni][mj]=var;
		}
}
