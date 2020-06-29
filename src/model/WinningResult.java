////Reabaln
// Model object for the Winning Result. it has
//properties and setters/getters

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean
public class WinningResult implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	float mean;
	double standardDeviation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getMean() {
		return mean;
	}
	public void setMean(float mean) {
		this.mean = mean;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
}
