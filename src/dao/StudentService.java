//Reabaln
// Class that encapsulates business logic to store and read the
//Survey data to/from a database table.

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import swe645.hw3.model.Student;
import swe645.hw3.model.WinningResult;



public class StudentService {
	
    private static final String PERSISTENCE_UNIT_NAME = "name";   
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    
    
    public StudentService() {}

  
    
  
	public static void createNewResult(WinningResult result) {
    	
    	
    	   if(!transactionObj.isActive()) {
               transactionObj.begin();
           }
       
        entityMgrObj.persist(result);
        transactionObj.commit();
    }
	
	// Method to add new survey record to database
	public static void createNewSurvey(Student s) {
		 if(!transactionObj.isActive()) {
             transactionObj.begin();
         }
		
      entityMgrObj.persist(s);
      transactionObj.commit();		
	}
	
	//Method to compute Mean and Standard Deviation and then stores the result 
	// to the database
	public static Object[] computeRaffle(String raffle) {
		
		String [] myarray = raffle.split(",");
		int[] intarray = new int [10];
		for (int i=0 ; i<myarray.length ; i++) {
			
			intarray[i]= Integer.parseInt(myarray[i]);
			System.out.println(intarray[i]);
 
		}
		
		float  sum=0;
		float mean; 
		double standardDev = 0; 
		 for(int i = 0; i <intarray.length; i++) {
	         sum+=intarray[i];
	      }
		 mean = sum/intarray.length;	
		 for(double num: intarray) {
				standardDev += Math.pow(num - mean, 2);
	        }
		 standardDev = Math.sqrt(standardDev/intarray.length);
		 
		 if(!transactionObj.isActive()) {
             transactionObj.begin();
         }
		 WinningResult newResult = new WinningResult();
		 newResult.setMean(mean);
		 newResult.setStandardDeviation(standardDev);
		 entityMgrObj.persist(newResult);
	     transactionObj.commit();
	     
	     if (newResult.getMean()>=90) {
	    	 return new Object[] {"Winner", newResult};
	     }
    	 return new Object[] {"Simple", newResult};
		
	}
	
	
	// Method To Fetch All Surveys From The Database
		@SuppressWarnings("unchecked")
		public static List getAllSurveys() {
			Query queryObj = entityMgrObj.createQuery("SELECT s FROM Student s");
			List surveyList = queryObj.getResultList();
			if (surveyList != null && surveyList.size() > 0) {			
				return surveyList;
			} else {
				return null;
			}
		}
    
   



}


