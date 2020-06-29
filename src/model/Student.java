//Reabaln
// Model object for the Student's survey. it has
//properties and setters/getters

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;
import javax.faces.bean.ManagedBean;

@Entity
@ManagedBean
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int surveyId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private Date dateOfSurvey;
	private String[] howLike;
	private String interests;
	private String recommendation;
	private String raffle;
	private Date startDate; 
	
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfSurvey() {
		return dateOfSurvey;
	}
	public void setDateOfSurvey(Date dateOfSurvey) {
		this.dateOfSurvey = dateOfSurvey;
	}
	public String[] getHowLike() {
		return howLike;
	}
	public void setHowLike(String[] howLike) {
		this.howLike = howLike;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
}
