import java.util.Scanner;


public class puiss {
private final static int VIDE = 0;
private final static int JAUNE = 1;
private final static int ROUGE= 2;

static boolean joue(int[][] grille , int colonne , int couleur)
{
	// parcourir la colonne choisi 
	int ligne = grille.length - 1;
	
	boolean pleine = false;
	while ( (!pleine ) && grille[ligne][colonne] != VIDE) {
		if(ligne == 0) { pleine = true;}
		else {
		--ligne;}
	}
	//
	// on remplit la case vide trouver;
	if(!pleine) {
	grille[ligne][colonne] = couleur;
	return true;
	}else {
		return false;
	}
		
}

//méthode compte 

static int compte(int[][] grille, int ligneDepart , int colonneDepart,int dirLigne,int dirColonne)
{
	int compteur = 0;
	int ligne = ligneDepart;
	int colonne = colonneDepart;
	
	 while(grille[ligne][colonne] == grille[ligneDepart][colonneDepart]  && ligne>= 0 && ligne < grille.length && colonne >= 0 && colonne <grille[ligne].length  ) {
		compteur = compteur + 1;
		System.out.println("grille.length ="+ grille.length +" ligne = "+ligne+" colonne ="+colonne + " compteur = "+compteur+" ligne depart ="+ligneDepart+" colonneDepart = "+colonneDepart +" grille[ligne][colonne] ="+grille[ligne][colonne]);
		if(compteur == 4 ) {return compteur;}
		else {
		 ligne = ligne + dirLigne;
		 colonne = colonne + dirColonne;
		}
	 }
	 return compteur;
	 
}
//gagne = estceGagne(grille , couleurJoueur );
static boolean estCeGagne(int[][] grille , int couleurJoueur)
{
	for (int ligne = 0; ligne< grille.length;++ligne)
		for(int colonne = 0;colonne < grille[ligne].length;++colonne)
		{
			int couleurCase = grille[ligne][colonne];
			if (couleurCase == couleurJoueur)
			{
				if (
						//vers le haut et la droite :
						(ligne >= 3 && colonne <= grille[ligne].length-4 &&					
						compte(grille,ligne,colonne,-1,+1)>=4)||
						
						//horizentalement
						(colonne <= grille[ligne].length-4 &&
						compte(grille,ligne,colonne,0,+1)>=4)||
						
						//vers le bas et la droite
						(ligne<= grille.length-4 && colonne <= grille[ligne].length -4 &&
						compte(grille,ligne,colonne,+1,+1)>=4)||
						
						//verticalemnt , vers le bas 
						(ligne <= grille.length-4  &&
						compte(grille,ligne,colonne,+1,0)>=4))
					{
						return true;
					}
			}
		}
	return false ;
	}

			
	


public static void initialise(int[][] grille)
{
	int i=0,j=0;
	for(i = 0; i<grille.length;++i)
	{
		for(j=0;j< grille[i].length;++j) {
			grille [i][j] = 0;
			
		}
	}
}

public static void affiche(int[][]grille)
{
	int i=0,j=0;
	int[] num= {1,2,3,4,5,6,7};
	for(i = 0; i<grille.length;++i)
	{
		for(j=0;j< grille[i].length;++j) {
			System.out.print( grille [i][j] +"|");
			
		}
		System.out.println("");
	}
	
	
	for(i = 0; i<num.length;++i)
	{
		System.out.print(num[i] + "=");
	}
	System.out.println("");
		
}





	public static void main(String[] args)
	{
	//private static Scanner = new Scanner(System.in);
		 Scanner clavier = new Scanner(System.in);
		int[][] grille = new int[6][7];
		
		initialise(grille);
		affiche(grille);
	
		System.out.println("taille des ligne "+grille.length);
		int couleurJoueur= JAUNE;
		boolean valide,gagner;
		
		do {
		
			if(couleurJoueur == JAUNE) {
				System.out.println("Joueur J : entrez un numéro de colonne");
			}
			else  {
				System.out.println("Joueur R : entrez un numéro de colonne");
			}
			
			int colonne = clavier.nextInt();
			--colonne;
			
			 valide = joue(grille,colonne,couleurJoueur);
			if(!valide) {
				System.out.println("le coup n'est pas valide");
			}
			affiche(grille);
			
		gagner = estCeGagne(grille , couleurJoueur);
			if(gagner)
			{
				System.out.println("bravo vous avez gagner "+ couleurJoueur);
			}
			
		
			if (couleurJoueur == JAUNE) {
				couleurJoueur = ROUGE;
			} else { 
				couleurJoueur = JAUNE;
			}
		
		} while (valide && !gagner);
		
		
		
			}
		}
		
		
	
	

