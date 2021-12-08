package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modal.entities.Carrental;
import modal.entities.Veiculo;
import modal.services.BrasilTaxServices;
import modal.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.println("----------Enter rental car----------");
			
			System.out.println("Car model: ");
			String carModel = sc.nextLine();
			
			System.out.println("Pikcup (dd/MM/yyyy HH:mm) :");
			String dts = sc.nextLine();
			Date dtStart = sdf1.parse(dts);
			
			System.out.println("Return (dd/MM/yyyy HH:mm) :");
			String dtf = sc.nextLine();
			Date dtFinish = sdf1.parse(dtf);
			
			Carrental cr = new Carrental(dtStart, dtFinish, new Veiculo(carModel));
			
			System.out.println("Enter price per hours: ");
			double pricehr = sc.nextDouble();
			
			System.out.println("Enter price per day: ");
			double pricedy = sc.nextDouble();
			
			RentalService rentalService = new RentalService(pricedy, pricehr, new BrasilTaxServices());
			
			rentalService.processInvoice(cr);
			
			System.out.println("----------Invoice----------");
			
			System.out.println("Basica payment: "+String.format("%.2f", cr.getIv().getBasicPayment()));
			System.out.println("Tax: "+String.format("%.2f", cr.getIv().getTaxa()));
			System.out.println("Total Payment: "+String.format("%.2f", cr.getIv().totalPayment()));
			
			
		sc.close();
	}

}
