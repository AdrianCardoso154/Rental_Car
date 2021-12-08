package modal.entities;

public class Invoice {
	private Double basicPayment;
	private Double taxa;

	public Invoice() {
		super();
	}

	public Invoice(double basicPayment, double taxa) {
		super();
		this.basicPayment = basicPayment;
		this.taxa = taxa;
	}

	public double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public Double totalPayment() {
		return this.getTaxa() + this.getBasicPayment();
	}

}
