package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			//Exception personalizada abaixo
			throw new DomainException("A data do Check-out tem que ser posterior a data do Check-in ");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			//throw new IllegalArgumentException("Erro na reserva: A data da reserva tem de ser maior que a data atual");
			//Exception personalizada abaixo
			throw new DomainException("Erro na reserva: A data da reserva tem de ser maior que a data atual");
		}
		
		if(!checkOut.after(checkIn)) {
			//throw new IllegalArgumentException("Erro na reserva: A data do Check-out tem que ser posterior a data do Check-in ");
			//Exception personalizada abaixo
			throw new DomainException("Erro na reserva: A data do Check-out tem que ser posterior a data do Check-in ");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Reservation: Quarto:" 
				+ numeroQuarto 
				+ ", checkIn: " 
				+ sdf.format(checkIn)
				+ ", checkOut: " 
				+ sdf.format(checkOut)
				+ ", "
				+ duracao() 
				+ " noites";
	}
	
}
