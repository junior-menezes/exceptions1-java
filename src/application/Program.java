package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data do Check-out tem que ser posterior a do Check-in ");
		}
		else {
			Reservation reserva = new Reservation(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Atualização da reserva: ");
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: A data da reserva tem de ser maior que a data atual");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data do Check-out tem que ser posterior a do Check-in ");
			}
			else {
				reserva.atualizacaoDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		
		sc.close();
	}

}
