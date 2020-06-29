// Reab Alnitaifi
// Managed bean for Survey.xhtml that has a reference for Student model
package swe645.hw3.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import swe645.hw3.dao.StudentService;
import swe645.hw3.model.Student;
import swe645.hw3.model.WinningResult;

@ManagedBean
public class SurveyBean {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private Date dateOfSurvey;
	private List howLike;
	private String interests;
	private String recommendation;
	private String raffle;
	private Date startDate; 
	private WinningResult winningresult;
	
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
	public List getHowLike() {
		return howLike;
	}
	public void setHowLike(List howLike) {
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
	

	public WinningResult getWinningresult() {
		return winningresult;
	}
	public void setWinningresult(Object result) {
		this.winningresult = (WinningResult) result;
	}
	public String addNewresult() {
		// StudentService.createNewResult();
		 return("Survey");}
	
	public  String createNewSurvey(Student s) {
	    	
	    	  StudentService.createNewSurvey(s);
	    	  Object[] result = StudentService.computeRaffle(s.getRaffle());
	    	  //filling the placeholder for the returned data from business logic (WinningResult object) 
	    	  this.setWinningresult(result[1]);
	    	  if (result[0]=="Winner") {
	    		  return ("WinnerAcknowledgement");
	    	  } else
	    	  return ("SimpleAcknowledgement");
	    }
	
	  // Method To Fetch The Existing survey List From The Database
		public List schoolListFromDb() {
			return StudentService.getAllSurveys();		
		}
		
		// Method that auto-complete the checkbox value for the user recommendation field 
		  public List<String> AutoListLiklely() {         
		        ArrayList<String> autoList = new ArrayList<String>();  
		        autoList.add("Very Likely");  
		        autoList.add("Likely");  
		        autoList.add("UnLikely");  
		       
		        return autoList;  
		    }
		  
		  // Method to Validate that expected start date is in the future
		  public void validateDate (FacesContext context, UIComponent componentToValidate, Object value) {
			  Date currentDate = new Date(); 
			  Date expectedStartDate = (Date) value;
			  if (expectedStartDate.before(currentDate)) {
				  FacesMessage message = new FacesMessage ("Start Date must be in future") ;
				  throw new ValidatorException (message);
			  }
			  
		  }
	    

}
