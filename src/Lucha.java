import java.io.IOException;
import java.util.Scanner;

class Lucha{
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Constante salud
		final int SALUD_MAX = 500;
		
		// Creamos objetos
		Scanner sca = new Scanner(System.in);
		Personaje prs = new Personaje();
		Terminal cmd = new Terminal();
		Texto txt = new Texto();
		
		// Creamos varios contadores
		int contadorEnemigo = 0, numero;
		
		// Variable para elegir opcion
		int opcion, saludPocion;
		
		// Pruebas
		int saludEnemigo = 500, ataqueEnemigo = 100;
		String frase;
		
		// Creamos el personaje
		System.out.println("Como te llamas:");
		prs.setNombre(sca.nextLine());
		int danoProducido = 0, danoRecibido = 0;
	
		while(true) {
			
			//Generamos un n�mero aleatorio
			numero = (int) (Math.random() * 100);
			
			
			txt.enemigoMiguelSaludo();
			cmd.pressReturn(sca);
			
			if(numero <= 0) {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
					
					cmd.clearScreen();
			
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
				
					//Turno enemigo
					numero = (int) (Math.random() * 90);
				
					if(numero <= 30) {
						
						// Realiza el ataque 1
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {							
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 60) {
						
						// Realiza el ataque 2
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el da�o producido en esta acci�n
							//Asignar el da�o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo +25));
							//Almacenar en la variable danoProducio el da�o producido en esta acci�n
							//Asignar el da�o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el da�o producido en esta acci�n
							//Asignar el da�o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el da�o producido en esta acci�n
							//Asignar el da�o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}
					
					
				
					if(prs.getSalud() <= 0){
						break;
					}
					
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
					
					//Turno personaje
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.println("Elige una accion a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la acci�n (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque1();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el da�o producido en esta acci�n
								prs.setDanoProducido(prs.ataque1());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque1() + 25);
								//Almacenar en la variable danoProducio el da�o producido en esta acci�n
								prs.setDanoProducido(prs.ataque1() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque2();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque2() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque3();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el da�o producido en esta acci�n
								prs.setDanoProducido(prs.ataque3());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque3() + 25);
								//Almacenar en la variable danoProducio el da�o producido en esta acci�n
								prs.setDanoProducido(prs.ataque3() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la accion (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
								prs.ultra();
							}else {
								//Ataque critico
								
								if(prs.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", prs.getNombre());
									saludEnemigo = saludEnemigo - prs.ultra();
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", prs.getNombre());
							saludPocion = prs.pocion(prs.getSalud());
							if(prs.getSalud() + saludPocion > SALUD_MAX) {
								prs.setSalud(SALUD_MAX);
							}else {
								prs.setSalud(prs.getSalud() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
				}
			}else {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
					
					cmd.clearScreen();
			
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
					
					//Turno personaje
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.println("Elige una accion a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la accion (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque1();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque1());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque1() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque1() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque2();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque2() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque3();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el da�o producido en esta acci�n
								prs.setDanoProducido(prs.ataque3());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque3() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque3() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la acci�n (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
								prs.ultra();
							}else {
								//Ataque critico
								
								if(prs.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", prs.getNombre());
									saludEnemigo = saludEnemigo - prs.ultra();
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", prs.getNombre());
							saludPocion = prs.pocion(prs.getSalud());
							if(prs.getSalud() + saludPocion > SALUD_MAX) {
								prs.setSalud(SALUD_MAX);
							}else {
								prs.setSalud(prs.getSalud() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Poci�n===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
					
					//Turno enemigo
					numero = (int) (Math.random() * 90);
				
					if(numero <= 30) {
						
						// Realiza el ataque 1
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 60) {
						
						// Realiza el ataque 2
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dan recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}
				
					if(prs.getSalud() <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
					System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
				}
			}
			
			if(prs.getSalud() <= 0) {
				txt.victoriaMiguel();
				break;
			}else {
				txt.derrotaMiguel();
				contadorEnemigo ++;
			}
			
			if(saludEnemigo <= 0) {
				break;
			}
		}
		
		System.out.println("salimos del bucle principal");
		
		if(prs.getSalud() <= 0) {
			System.out.println("YOU LOSE");
			System.out.printf("Puntos conseguidos: %d\n", prs.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}else {
			System.out.println("YOU WIN");
			System.out.printf("Puntos conseguidos: %d\n", prs.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}
	}
}