package interview;
import java.util.*;
class Team{											
	String Name;										 //here i'm creating instance variables to hold name,points,result of the teams
	int points;
	int[] result;
	public Team(String name, int points, int[] result) {  //i'm creating this constructor to store the team data
		super();
		this.Name = name;
		this.points = points;
		this.result = result;
	}
}
public class IPL {
	public static void main(String args[]) {
		
		List<Team> allteams=new ArrayList<Team>();        //This list contains the information about all the team.
		List<Team> finalteam=new ArrayList<Team>();		  //This list contains the information about the team which has consecutive losses
		
		Scanner sc=new Scanner(System.in);
		int[] res1 = {1,1,0,0,1},
			  res2 = {1,0,0,1,1},						 //This array contains the results of each teams   											       
			  res3 = {1,0,1,0,0},						 //Here 1 represent wins 0 represents losses 
			  res4 = {1,1,0,1,0},
			  res5 = {0,1,1,0,0},
			  res6 = {0,1,1,0,1},
			  res7 = {0,1,0,1,0},
			  res8 = {1,0,0,0,0},
			  res9 = {0,0,1,0,1},
			  res10= {0,1,0,1,1};
		
		allteams.add(new Team("GT",20,res1));			 //Here i'm passing values to the constructor as well as adding that into the list 
		allteams.add(new Team("LSG",18,res2));
		allteams.add(new Team("RR",16,res3));
		allteams.add(new Team("DC",14,res4));
		allteams.add(new Team("RCB",14,res5));
		allteams.add(new Team("KKR",12,res6));
		allteams.add(new Team("PBKS",12,res7));
		allteams.add(new Team("SRH",12,res8));
		allteams.add(new Team("CSK",8,res9));
		allteams.add(new Team("MI",8,res10));
		
		System.out.println("enter how many consecutive losses do you want");
		int n=sc.nextInt();
		
		for(Team t:allteams) {
			int count=0;
			
			for(Integer c:t.result) {					//Here i'm Traversing the result array in the allteams list
				
				if(c==0) {
					count++;							//If the result is 0 it will incremented count by 1.
					
				}
				else {
					count=0;							//If the result is not 0 then count will becomes 0
					
				}
				if(count==n) {							//if we get the n consecutive losses then it will add into the finalteam list
					finalteam.add(t);
					break;
				}
			}
		}
		
		int totalteam=0;
		int totalmatches=0;
		double avg=0;
		if(finalteam.size()==0) {
			System.out.println("no consecutive losses");
		}
		for(Team f:finalteam) {	
		    
				totalmatches=f.result.length;				        
				for(Integer rs:f.result) {
					avg=(double)f.points/totalmatches;				//here i'm calculating the average points of individual team..
				}
				System.out.println(f.Name+" average poits = "+avg);
		}
		
		
	}
}
