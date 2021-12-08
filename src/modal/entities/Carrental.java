package modal.entities;

import java.util.Date;

public class Carrental {

	private Date star;
	private Date finish;
	private Veiculo car;
	private Invoice iv;

	public Carrental() {
		super();
	}

	public Carrental(Date star, Date finish, Veiculo car) {
		super();
		this.star = star;
		this.finish = finish;
		this.car = car;
	}

	public Invoice getIv() {
		return iv;
	}

	public void setIv(Invoice iv) {
		this.iv = iv;
	}

	public Date getStar() {
		return star;
	}

	public void setStar(Date star) {
		this.star = star;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Veiculo getCar() {
		return car;
	}

	public void setCar(Veiculo car) {
		this.car = car;
	}

}
