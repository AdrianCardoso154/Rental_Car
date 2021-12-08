package modal.services;

import java.util.concurrent.TimeUnit;

import modal.entities.Carrental;
import modal.entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;

	private BrasilTaxServices taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, BrasilTaxServices taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	public RentalService() {
	}

	public void processInvoice(Carrental carRentatl) {

		long diff = carRentatl.getFinish().getTime() - carRentatl.getStar().getTime();

		double diffEmMil = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
		double basicPayment;
		if (diffEmMil <= 12.0) {
			basicPayment = Math.ceil(diffEmMil) * this.pricePerHour;
		} else {
			basicPayment = Math.ceil(diff / 24) * this.pricePerDay;
		}

		double tax = taxService.tax(basicPayment);

		carRentatl.setIv(new Invoice(basicPayment, tax));

	}

}
