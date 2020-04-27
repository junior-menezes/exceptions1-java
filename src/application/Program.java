package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		Reservation reserva = new Reservation(numeroQuarto, checkIn, checkOut);
		System.out.println("Reserva: " + reserva);
		
		System.out.println();
		System.out.println("Atualização da reserva: ");
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		
		reserva.atualizacaoDatas(checkIn, checkOut);
		
		System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválida");
		}
		catch (DomainException e) {
			System.out.println ("Erro na reservar: " + e.getMessage());
		}
		catch (RuntimeException e) { //feito upcasting para RuntimeException
			System.out.println("Erro inesperado");
			//main(args); Testar posteriormente por chamar a propria classe main para o programa reiniciar caso ocorra algum erro.
		}
		
		sc.close();
	}

}
