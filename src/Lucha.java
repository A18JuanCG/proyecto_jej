import java.util.Scanner;

class Lucha{
	public static void main(String[] args) {
		
		// Creamos objetos
		Scanner sca = new Scanner(System.in);
		Personaje prs = new Personaje();
		
		// Creamos varios contadores
		int contadorEnemigo, numero;
		
		// Variable para elegir opcion
		int opcion;
		
		// Pruebas
		int saludEnemigo = 500;
		
		// Creamos el personaje
		System.out.println("Como te llamas:");
		prs.setNombre(sca.nextLine());
		prs.setSalud(500);
		int danoProducido = 0, danoRecibido = 0;
		prs.ataque1();
		prs.ataque2();
		prs.ataque3();
		prs.ultra(danoRecibido, danoProducido);
		prs.pocion(prs.getSalud());
		
		while(true) {
			
			//Generamos un n�mero aleatorio
			numero = (int) (Math.random() * 100);
			
			if(numero <= 50) {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
			
					System.out.printf("========================Salud enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3===\n");
					System.out.printf("(4) Ultra================================\n");
					System.out.printf("(5) Poci�n===============================\n");
					System.out.printf("Tu salud: %d=============================\n", prs.getSalud());
				
					numero = (int) (Math.random() * 100);
				
					if(numero <= 30) {
						// Realiza el ataque 1
					}else if (numero <= 60) {
						// Realiza el ataque 2
					}else if (numero <= 100) {
						// Realiza el ataque 3
					}
				
					if(prs.getSalud() == 0){
						break;
					}
				
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.println("Elige una acci�n a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							// Realiza la acci�n (1)
						}else if (opcion == 2) {
							// Realiza la acci�n (2)
						}else if (opcion == 3) {
							// Realiza la acci�n (3)
						}else if (opcion == 4) {
							// Realiza la acci�n (4)
						}else if (opcion == 5) {
							// Realiza la acci�n (5)
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo == 0){
						break;
					}
				}
				
			}else {
				System.out.println("Turno del personaje");
			}
			
			if(prs.getSalud() == 0 || saludEnemigo == 0){
				break;
			}
		}
		
		System.out.println("Salimos del bucle");
	}
}