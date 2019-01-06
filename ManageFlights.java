import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManageFlights
{

  
   private static Flight[] flights = new Flight[100];
   private static Flight[] Rflights = new Flight[100];
   private static Passenger[] passenger = new Passenger[100];
 
  
  
   private static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) throws IOException
   {
     
      createFlights();
  
      String input;
      char option = ' ';

      do
      {
         System.out.printf("\n%18s\n", "Flight Menu");
         
         System.out.printf("%-25s%d\n", "Display All Flights", 1);
         System.out.printf("%-25s%d\n", "Open Flight", 2);
         System.out.printf("%-25s%d\n", "Book seats on a Flight", 3);
         System.out.printf("%-25s%d\n", "Close Flight", 4);
         System.out.printf("%-25s%d\n", "Delay Flight", 5);
         System.out.printf("%-25s%d\n", "Create A Flight", 6);
         System.out.printf("%-25s%d\n", "Check-In A Passenger", 7);
         System.out.printf("%-25s%d\n", "Passenger Details", 8);
         System.out.printf("%-25s%d\n", "Read File", 9 );
         System.out.printf("%-25s%d\n\n", "Exit", 0);
        
         System.out.print("Enter your selection: ");
        
         input = sc.nextLine();
         
         if (input.length() == 1)
         {
            option = input.charAt(0);
            
            switch(option)
            
            {
           
               case '1':
            	   try{
                  viewAllFlights();
            	   }catch (Exception e){System.out.println("");}
                  
            	  
            	  break;
               case '2':
            	 
                  openFlight();
                  
                  break;
                  
               case '3':
                  reserveSeats();
                  break;
                  
               case '4':
                  closeFlight();
                  break;
                  
               case '5':
                  delayFlight();
                  break;
               case '6':
                  inputFlight();
                   break;
               case'7':
            	   inputPassenger();
            	   break;
               case'8':
            	   try{
            	 disprint();
            }catch (Exception e){System.out.println("");}
            	   break;
               case'9':
            	 read();
            	   break;
               case '0':
            	   try{
            	  save();
            	  save2();}catch (Exception e){System.out.println("");}
                  System.out.println("Have a nice day.  :)");
                  break;
                  
               default:
                  System.out.printf(
                        "Error - %c is not a valid option, please try again.",
                        option);
            }
         }
      } while (option != '0');
   }
   public static void save()
   {              
           FileOutputStream out; 
           PrintStream p; 
           try
           {
                  
                   out = new FileOutputStream("Pass.txt");

                  
                   p = new PrintStream( out );
	
                  

                   p.printf("\n%30s\n\n", "(Passenger List)");
                   p.println ("");
                   p.printf("%-13s", "Flight No.");
                   p.printf("%-15s", "Pass ID");
                   p.printf("%-15s", "Name");
                   p.printf("%-7s\n\n", "Meal");
                   p.println ("");
                   p.printf("%-13s", "-----------");
                   p.printf("%-15s", "----------");
                   p.printf("%-15s", "------------");
                   p.printf("%-7s\n\n", "-----");
                   p.println ("");
                 	 
                 	 
                  
                   for(int i = 0;i <passenger.length;i++){
                	   if(passenger[i].getFlightNo()!= null){
            		   
                		   p.printf("%-13s",  passenger[i].getFlightNo());
                		   p.printf("%-15s",  passenger[i].passsengerID());
                		   p.printf("%-15s\n\n",  passenger[i].name());
                		   p.println ("");
                	   }  
                	   else
                	   {
                		   break;
                	   }
                   }
           }
           catch (Exception e)
           {
                   System.out.println ("Pass.txt Saved");
           }
   }
   public static void read(){
	   int userChoice;  
	   do
	   {
		   
		     System.out.printf("\n%18s\n", "Please Choose Passenger or Flight File: ");
	         System.out.printf("%-25s%d\n", "Passenger", 1);
	         System.out.printf("%-25s%d\n", "Flight", 2);
	         System.out.printf("%-25s%d\n", "Exit", 0);
	         System.out.print("Enter your selection: ");
	         userChoice = sc.nextInt();
	         
	         switch (userChoice) {
     
	         case 1:
	        	
	        	 try{
	        			 
	        		   FileInputStream fstream = new FileInputStream("Pass.txt");
	        		   
	        		   DataInputStream in = new DataInputStream(fstream);
	        		   BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        		   String strLine;
	        		   
	        		   while ((strLine = br.readLine()) != null)   {
	        		   
	        		   System.out.println (strLine);
	        		   }
	        		   
	        		   in.close();
	        		     }catch (Exception e){
	        		   System.err.println("Error: " + e.getMessage());
	        		   }
	        	   break;
   	
	        	
	         case 2:
	        	
	        	 try{
	        			 
	        		   FileInputStream fstream = new FileInputStream("Flights.txt");
	        		   
	        		   DataInputStream in = new DataInputStream(fstream);
	        		   BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        		   String strLine;
	        		   
	        		   while ((strLine = br.readLine()) != null)   {
	        		   
	        		   System.out.println (strLine);
	        		   }
	        		   
	        		   in.close();
	        		     }catch (Exception e){
	        		   System.err.println("Error: " + e.getMessage());
	        		   }
	        	   
						break;
					
			        	  	
			        	  	
       default:
             System.out.println("");
             break;
       }  
       System.out.println();
     
	   } while (userChoice != 0);
	   
	
	   
	   
   }
   public static void save2()
   {              
           FileOutputStream out; 
           PrintStream p; 
           try
           {
                  
                   out = new FileOutputStream("Flights.txt");

                  
                   p = new PrintStream( out );
	
                  

                  
                   p.printf("\n%30s\n\n", "(Current Flight Schedule)");
                   p.println("");
                   p.printf("%-13s", "Flight No.");
                   p.printf("%-15s", "Departing");
                   p.printf("%-15s", "Destination");
                   p.printf("%-7s", "Time");
                   p.printf("%-11s", "Date");
                   p.printf("%8s", "Length");
                   p.printf("%10s", "Capacity");
                   p.printf("%11s", "Bookings");
                   p.printf("%12s", "Status");
                   p.printf("%9s\n", "Layover");
                   p.println("");
                   p.printf("%-13s%-15s%-15s%-7s%-11s%8s%10s%11s%12s%9s\n",
                         "-----------", "----------", "------------", "-----", "---------",
                         "------", "--------", "--------", "---------", "-------");
                   p.println("");
                 	 
                  
                   for(int i = 0;i <flights.length;i++){
                	   if(flights[i].getFlightNo()!= null){
                		   p.printf("%-13s",flights[i].getFlightNo());
                		      p.printf("%-15s", flights[i].getDeparturePoint());
                		      p.printf("%-15s", flights[i].getDestination());
                		      p.printf("%-7s", flights[i].getFlightTime());
                		      p.printf("%-12s", flights[i].getFlightDate());
                		      p.printf("%7.2f", flights[i].getFlightLength());
                		      p.printf("%10d", flights[i].getflightCapacity());
                		      p.printf("%11d",flights[i].getseatsBooked());
                		      
                		      switch(flights[i].getStatus())
                		      {
                		         case 'S':
                		            p.printf("%12s", "Scheduled");
                		            p.println("");
                		            break;
                		         case 'B':
                		            p.printf("%12s", "Boarding");
                		            p.println("");
                		            break;
                		         case 'D':
                		            p.printf("%12s", "Departed");
                		            p.println("");
                		            break;
                		         case 'C':
                		            p.printf("%12s", "Cancelled");
                		            p.println("");
                		            break;
                		      }
                		  
                	   			}   else{  throw new Exception("");}
                	   
                  
                   
                 }
                	   			 p.printf("\n%30s\n\n", "(Regional)");
                                 p.println("");
                                 p.printf("%-13s", "Flight No.");
                                 p.printf("%-15s", "Departing");
                                 p.printf("%-15s", "Destination");
                                 p.printf("%-7s", "Time");
                                 p.printf("%-11s", "Date");
                                 p.printf("%8s", "Length");
                                 p.printf("%10s", "Capacity");
                                 p.printf("%11s", "Bookings");
                                 p.printf("%12s", "Status");
                                 p.printf("%9s\n", "Layover");
                                 p.println("");
                                 p.printf("%-13s%-15s%-15s%-7s%-11s%8s%10s%11s%12s%9s\n",
                                       "-----------", "----------", "------------", "-----", "---------",
                                       "------", "--------", "--------", "---------", "-------");
                                 p.println("");
                                 for(int a = 0;a <Rflights.length;a++){
                              	   if(Rflights[a].getFlightNo()!= null){
                              		   	p.printf("%-13s",Rflights[a].getFlightNo());
                              		      p.printf("%-15s", Rflights[a].getDeparturePoint());
                              		      p.printf("%-15s", Rflights[a].getDestination());
                              		      p.printf("%-7s", Rflights[a].getFlightTime());
                              		      p.printf("%-12s",Rflights[a].getFlightDate());
                              		      p.printf("%7.2f", Rflights[a].getFlightLength());
                              		      p.printf("%10d", Rflights[a].getflightCapacity());
                              		      p.printf("%11d",Rflights[a].getseatsBooked());
                              		      
                              		      switch(Rflights[a].getStatus())
                              		      {
                              		         case 'S':
                              		            p.printf("%12s", "Scheduled");
                              		            p.println("");
                              		            break;
                              		         case 'B':
                              		            p.printf("%12s", "Boarding");
                              		            p.println("");
                              		            break;
                              		         case 'D':
                              		            p.printf("%12s", "Departed");
                              		            p.println("");
                              		            break;
                              		         case 'C':
                              		            p.printf("%12s", "Cancelled");
                              		            p.println("");
                              		            break;
                              		      }
                              			}   
                                 			}
                           
           						} 
           		
           							catch (Exception e)
           						{
           						System.out.println ("Flights.txt Saved");
 
           						}
   								}

private static void disprint() throws Exception{
	 String fno;
	 System.out.println("Please Enter Flight Number: ");
	 fno = sc.next();
	 try{
	  		boolean result5 = samefl1(fno);
	  		
	  		if(result5 == true){
              System.out.println("The Flight Number is VALID :"+ fno);
	  		  System.out.printf("\n%30s\n\n", "(Passenger List)");
	  	      System.out.printf("%-13s", "Flight No.");
	  	      System.out.printf("%-15s", "Pass ID");
	  	      System.out.printf("%-15s", "Name");
	  	      System.out.printf("%-7s\n", "Meal");

	  	      System.out.printf("%-13s", "-----------");
	  	      System.out.printf("%-15s", "----------");
	  	      System.out.printf("%-15s", "------------");
	  	      System.out.printf("%-7s\n", "-----");

	  		}else{
	  			System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno);
	  	
	  			
	  		}
				}catch (Exception e){System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno);
				
				}
				
	
      for(int i = 0;i < passenger.length;i++){
    	  if(passenger[i].getFlightNo()!= null){
    	  if(passenger[i].getFlightNo().compareTo(fno)== 0){
    		  	passenger[i].printInRow();
        	  	System.out.println();
        	  
    		 }
    	
    	  	}
    	  else{
    		  System.out.print("There are not Flights with the Flight Number :"+ fno);
    		  break;
    	  }
   
      }  
  }
   private static void createFlights()
   {
	   //test data//
	   passenger[0]= new BusinessPassenger("QJ101","4321","Sean","cow");
	   passenger[1]= new BusinessPassenger("QQ111","1234","Lee","chicken");
	   passenger[2]= new EconomyPassenger("QJ101","1234","Lee");
    
	   
	   
	   
	   Rflights[0] = new Flight("QR511", "Sydney", "Newcastle",
            1.00, "1/1/2011", "14:00", 80);
     Rflights[1] = new Flight("QR613", "Perth", "Broome", 4.00,
            "1/1/2011", "17:30", 100);

      flights[0] = new Flight("QJ101", "Melbourne", "Sydney", 2.00, "1/1/2011",
            "08:00", 80);

      flights[1] = new Flight("QJ302", "Melbourne", "Brisbane", 3.50,
            "1/1/2011", "09:00", 100);

      flights[2] = new RegionalFlight("QJ510", "Melbourne", "Sydney", 2.00,
            "1/1/2011", "10:00", 80, Rflights[0]);

      flights[3] = new RegionalFlight("QR612", "Melbourne", "Perth", 5.00,
            "1/1/2011", "11:00", 100, Rflights[1]);

      flights[4] = new Flight("QJ303", "Brisbane", "Melbourne", 4.00,
            "1/1/2011", "12:00", 100);

      flights[5] = new Flight("QJ102", "Sydney", "Melbourne", 2.50, "1/1/2011",
            "15:30", 100);
      
   }

 
   public static Flight getFlight(String flightNo)
   {
      Flight f = null;

      for (int i = 0; i < flights.length; i++)
      {
    	if (flights[i].getFlightNo().equals(flightNo))
         {
            f = flights[i];
            break;
         }
      }
      return f;
   }
   
   
   
   private static void inputPassenger(){

	   int userChoice;
	   int a = 0 ;
	   do
	   {
		   
		     System.out.printf("\n%18s\n", "Please Choose Passenger Type:");
	         System.out.printf("%-25s%d\n", "Economy", 1);
	         System.out.printf("%-25s%d\n", "Business", 2);
	         System.out.printf("%-25s%d\n", "Exit", 0);
	         System.out.print("Enter your selection: ");
	         userChoice = sc.nextInt();
	         
	         switch (userChoice) {
     
	         case 1:
	        	 String fno;
	        	 String passid;
	        	 String passname;
	        	 String bag;
	        	 
	        	
	        	 System.out.println("You have chosen Economy Class");
	        	
	        	 	System.out.println("Please Enter the Flight No: ");
	        	  	fno = sc.next();
	        	  
	        		try{
	        	  		boolean result5 = samefl(fno);
	        	  		
	        	  		if(result5 == true){
	        	
	        	  			System.out.println("The Flight Number is VALID :"+ fno);
	        	  			
	        	  		}else{
	        	  			System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno);
	        	  			break;
	        	  			
	        	  		}
							}catch (Exception e){System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno);
							break;}
							
							try{
			        	  	
			        	  		boolean result1 = flightboarding(fno);
			        	  		if(result1 == true){
			        	
			        	  			System.out.println("The Flight is Currently Boarding :"+ fno);
			        	  			
			        	  		}else{
			        	  			System.out.println("The flight is NOT Currently Boarding "+ fno);
			        	  			break;
			        	  			
			        	  		}
									}catch (Exception e){System.out.println("The flight is NOT Currently Boarding "+ fno);
									break;}
	        	
	        	  		System.out.println("Pleass Enter Passenger-ID: ");
	        	  	passid = sc.next();
	        	  
	        	  	System.out.println("Please Enter Passenger Name: ");
	        	  	passname = sc.next();
	        	  	
	        		System.out.println("Please Enter weight of Baggage: ");
	        	  	bag = sc.next();
	        	  	
	        	  	int yy = Integer.parseInt(bag);
	        	  	 double hh = Double.parseDouble(bag);
	        	  	
	        	  
	        	  	
	        	  	if(yy > 20){
	        	  		System.out.println("Economy Passenger has exceeded the 20kg limit");
	        	  		break;
	        	  	}
	        	  	 System.out.println(passname + " has to pay an accesss of: $"+passenger[a].checkInBaggage(hh)) ;
	        	  	
	        	
	        		passenger[a] = new EconomyPassenger(fno,passid,passname);	
    	  			
	        	
	        	  	a++;
    	  			break;
	        		
   	
	        	
	         case 2:
    	   
	        	 String fno2;
	        	 String passid2;
	        	 String passname2;
	        	 String mealtype;
	        	
	        	
	        	 System.out.println("You have chosen Business Class");
	        	
	        	 	System.out.println("Please Enter the Flight No: ");
	        	  	fno2 = sc.next();
	        	
	        	    
	        		try{
	        	  		boolean result5 = samefl(fno2);
	        	  	
	        	  		if(result5 == true){
	        	
	        	  			System.out.println("The Flight Number is VALID :"+ fno2);
	        	  			
	        	  		}else{
	        	  			System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno2);
	        	  			break;
	        	  			
	        	  		}
							}catch (Exception e){System.out.println("The Flight Number entered is INVALID, there are not flights with the Flight Number: "+ fno2);
							break;
							}
							try{
				        	  	
			        	  		boolean result1 = flightboarding(fno2);
			        	  		if(result1 == true){
			        	
			        	  			System.out.println("The Flight is Currently Boarding :"+ fno2);
			        	  			
			        	  		}else{
			        	  			System.out.println("The flight is NOT Currently Boarding "+ fno2);
			        	  			break;
			        	  			
			        	  		}
									}catch (Exception e){System.out.println("The flight is NOT Currently Boarding "+ fno2);
									break;}
							
							
							
							System.out.println("Pleass Enter Passenger-ID: ");
			        	  	passid2 = sc.next();
			        	  
			        	  	System.out.println("Please Enter Passenger Name: ");
			        	  	passname2 = sc.next();
			        	  	System.out.println("Please Enter weight of Baggage: ");
			        	  	bag = sc.next();
			        	  	
			        	  	int yy2 = Integer.parseInt(bag);
			        	  	 double hh2 = Double.parseDouble(bag);
			        	  	
			        	  
			        	  	
			        	  	if(yy2 < 20){
			        	  		System.out.println("Business Passenger did not go above the specified limit.");
			        	  		
			        	  	}
			        	  	if(yy2>20){
			        	  	 System.out.println(passname2 + " has to pay an accesss of: $"+passenger[a].checkInBaggage2(hh2)) ;
			        	  	}
			        	 	System.out.println("Please Enter Choice of Meal: ");
			        	  	mealtype = sc.next();
			        	  	passenger[a] = new BusinessPassenger(fno2,passid2,passname2,mealtype);	
		    	  			a++;
			        	  	break;
			        	  	
			        	  	
			        	  	
       default:
             System.out.println("");
             break;
       }  
       System.out.println();
     
	   } while (userChoice != 0);
	   System.out.println("Bye!");

   
   }
   // Flights will be inputed to array as long as user does not re-choose the Create A flight which is option 6 because it will reset the data into the first array that is not hard coded by me.
   public static void inputFlight()
   {
	   int userChoice;
	   int y = 6;
	   int l = 3;
	   do
	   {
		   
		     System.out.printf("\n%18s\n", "Please Choose Flight Type:");
	         System.out.printf("%-25s%d\n", "Flight", 1);
	         System.out.printf("%-25s%d\n", "Regional Flight", 2);
	         System.out.printf("%-25s%d\n", "Exit", 0);
	         System.out.print("Enter your selection: ");
	         userChoice = sc.nextInt();
	         
	         switch (userChoice) {
     
	         case 1:
	        	 String fno;
	        	 String dep;
	        	 String dest;
	        	 String time;
	        	 String fdate;
	        	 int fca;
	        	 String fle;
	        	
	        	 System.out.println("You have chosen to create a new FLIGHT");
	        	
	        	 	System.out.println("Please Enter the Flight No: ");
	        	  	fno = sc.next();
	        	
	        	  		try{
	        	  		boolean result = uniqueFlightNo(fno);

	        	  		if(result == true){
	        	  			
	        	  			System.out.println("The Flight Number is VALID :"+ fno);
	        	  			
	        	  			
	        	  		}else{
	        	  			System.out.println("The Flight Number entered is INVALID due to another flight with the same FLIGHT number :"+ fno);
	        	  			break;
	        	  			
	        	  		}
	        	  		}catch (Exception e){System.out.println("The Flight Number is VALID");}
	        	  	System.out.println("Please Enter the Departing City: ");
	        	  	dep = sc.next();
	        	  
	        	  	System.out.println("Please Enter the Destination: ");
	        	  	dest = sc.next();
	        	  	 System.out.println("Please Enter the Flight Length: ");
	        		  fle = sc.next();
	        		  double aDouble3 = Double.parseDouble(fle);
	        	  	
	        	 
	        		  System.out.println("Please Enter the Departure Time: ");
	        		  time = sc.next();
	        			
	        		  try{
		        			
		        			boolean result3 = timeformat(time);
		        	  		if( result3 == true){
		        	  			
		        	  			System.out.println("Time format is Correct : "+ time);
		        	  			
		        	  			
		        	  		}else{
		        	  			System.out.println("The time format is INVALID. It must have 5 characters, have a : symbol and must be before Mid-Night: "+ time);
		        	  			break;
		        	  			
		        	  		}
		        	  		
		        	  		
	        		 	}catch (Exception e){System.out.println("Departure Time is Invalid!! Restart Program");}
	        		 
	        			 try{
		        		 		boolean pop = arrivalTime( time, aDouble3 );
		        		 	
		        		 	if(pop == true){
		        	  			System.out.println("Arrival Time is not past Mid-Night. Arrival Time is : " + arrivalTime2(  time, aDouble3  ) );
		        	  		}	else{
		        	  			System.out.println("The Arrival Time is Past Mid-Night Flight cannot be Created");
		        	  			break;
		        	  			
		        	  		}
		        			}catch (Exception e){System.out.println("Departure Time is Invalid!!!Restart Program field Departure time must have the first two characters be integers");}
		        	
	        		 
        		 	
	        		
	        	
	        		  System.out.println("Please Enter the Flight Date: ");
	        		  fdate = sc.next();
	        	 
	        		 
	        		  
	        		  System.out.println("Please Enter the Capacity: ");
	        	  		fca = sc.nextInt();
	        	  	
	        	  			
	        	  			flights[y] = new Flight(fno,dep,dest,aDouble3,fdate,time,fca);	
	        	  			y++;
	        	 break;
	        	
	        	 
	        	 
   	
	        	
	         case 2:
    	   
	        	 String fno2;
	        	 String dep2;
	        	 String dest2;
	        	 String time2;
	        	 String fdate2;
	        	
	        	
	        	 int fca2;
	        	 String fle2;
	        	 System.out.println("You have chosen to create a new REGIONAL FLIGHT");
	        	 
	        	
	        	 	System.out.println("Please Enter the Flight No: ");
	        	  	fno2 = sc.next();
	        		try{
	        	  		boolean result = uniqueFlightNo(fno2);

	        	  		if(result == true){
	        	  			
	        	  			System.out.println("The Flight Number is VALID :"+ fno2);
	        	  			
	        	  			
	        	  		}else{
	        	  			System.out.println("The Flight Number entered is INVALID due to another flight with the same FLIGHT number :"+ fno2);
	        	  			break;
	        	  			
	        	  		}
	        	  		}catch (Exception e){System.out.println("The Flight Number is VALID");}
	        	  
	        	  	System.out.println("Please Enter the Departing City: ");
	        	  	dep2 = sc.next();
	        	  
	        	  	System.out.println("Please Enter the Destination: ");
	        	  	dest2 = sc.next();
	        	  
	        	  	
	        	  	System.out.println("Please Enter the Flight Length: ");
	        	  	fle2 = sc.next();
	        	  	 double aDouble = Double.parseDouble(fle2);
	        	  	System.out.println("Please Enter the Departure Time: ");
	        	  	time2 = sc.next();
	        	  		try{
	        			
	        			boolean result3 = timeformat(time2);
	        	  		if( result3 == true){
	        	  			
	        	  			System.out.println("Time format is Correct : "+ time2);
	        	  			
	        	  			
	        	  		}else{
	        	  			System.out.println("The time format is INVALID. It must have 5 characters, have a : symbol and must be before Mid-Night: "+ time2);
	        	  			break;
	        	  			
	        	  		}
	        	  		}catch (Exception e){System.out.println("Departure Time is Invalid!!!Restart Program field Departure time must have the first two characters be integers");}
		        		
	        		
	        	 
	        	  	
	        	  	 try{
	        		 		boolean pop1 = arrivalTime( time2, aDouble );
	        		 	
	        		 	if(pop1 == true){
	        	  			System.out.println("Arrival Time is not past Mid-Night. Arrival Time is : " + arrivalTime2(  time2, aDouble  ) );
	        	  		}	else{
	        	  			System.out.println("The Arrival Time is Past Mid-Night Flight cannot be Created");
	        	  			break;
	        	  			
	        	  		}
	        			}catch (Exception e){System.out.println("Departure Time is Invalid!!");}
	        	  	
	        	  	
	  	
	        	  	System.out.println("Please Enter the Flight Date: ");
	        	  	fdate2 = sc.next();
	        	
	        	  	
	        		  
	        	  	System.out.println("Please Enter the Capacity: ");
	        	  	fca2 = sc.nextInt();
	        	  	
	        	  	System.out.println("Please Enter the Details Of the Connecting Flight:");
	        	 	String fno3;
	        	 	String dep3;
	        	 	String dest3;
	        	 	String time3;
	        	 	
	        	 	String fle3;
	        	 
	        	 
	        	
	        	 	System.out.println("Please Enter the Flight No of the Connecting Flight: ");
	        	  	fno3 = sc.next();
	        	  	
	        		try{
	        	  		boolean result = uniqueFlightNo2(fno3);

	        	  		if(result == true){
	        	  			
	        	  			System.out.println("The Flight Number is VALID :"+ fno3);
	        	  			
	        	  			
	        	  		}else{
	        	  			System.out.println("The Flight Number entered is INVALID due to another flight with the same FLIGHT number :"+ fno3);
	        	  			break;
	        	  			
	        	  		}
	        	  		}catch (Exception e){System.out.println("The Flight Number is VALID");}
	        	  
	        	  	System.out.println("Please Enter the Departing City of the Connecting Flight: ");
	        	  	dep3 = sc.next();
	        	  
	        	  	System.out.println("Please Enter the Destination of the Connecting Flight: ");
	        	  	dest3 = sc.next();
	        	  
	        	  	 System.out.println("Please Enter the Flight Length: ");
	        		  fle3 = sc.next();
	        		 
	        		  double aDouble2 = Double.parseDouble(fle3);
	        	  	
	        		  System.out.println("Please Enter the Departure Time of the Connecting Flight: ");
	        		  time3 = sc.next();
	        		  try{
		        			
		        			boolean result3 = timeformat(time3);
		        	  		if( result3 == true){
		        	  			
		        	  			System.out.println("Time format is Correct : "+ time3);
		        	  			
		        	  			
		        	  		}else{
		        	  			System.out.println("The time format is INVALID. It must have 5 characters, have a : symbol and must be before Mid-Night: "+ time3);
		        	  			break;
		        	  			
		        	  		}
	        		 	}catch (Exception e){System.out.println("Departure Time is Invalid!!!Restart Program field Departure time must have the first two characters be integers");}
	        		
	        		  try{
	        		 		boolean pop2 = arrivalTime( time3, aDouble2 );
	        		 	
	        		 	if(pop2 == true){
	        	  			System.out.println("Arrival Time is not past Mid-Night. Arrival Time is : " + arrivalTime2(  time3, aDouble2  ) );
	        	  		}	else{
	        	  			System.out.println("The Arrival Time is Past Mid-Night Flight cannot be Created");
	        	  			break;
	        	  			
	        	  		}
	        			}catch (Exception e){System.out.println("Departure Time is Invalid!!");}
	        		try{
	        			boolean pop3 = RegboardingTime(time2 , aDouble, time3 );
	        			
	        		 	if(pop3 == true){
	        	  			System.out.println("Boarding time for Connecting Flight doesnt overlap with the ETA of the first Flight" + arrivalTime2(  time3, aDouble2  ) );
	        	  		}	else{
	        	  			System.out.println("The Arrival Time is Past Mid-Night Flight cannot be Created");
	        	  			break;
	        	  			
	        	  		}
	        			
	        			
	        			
	        		}catch (Exception e){System.out.println("Departure Time is Invalid!!");}
	        		  
      	  		
	        	  		Rflights[l] =  new Flight(fno3, dep3, dest3,
	        	  	            aDouble2, fdate2, time3, fca2);
	        	  		flights[y] = new RegionalFlight(fno2, dep2, dest2, aDouble,
	        	  	            fdate2, time2, fca2, Rflights[l]);	
	        	  		l++;
	        	  		y++;
	        	  		
	        	 break;
  
       default:
             System.out.println("Invalid Number.");
             break;
       }  
       System.out.println();
     
	   } while (userChoice != 0);
	   System.out.println("Bye!");

   }
   
   private static void transferPassengers(){
	  
	   System.out.println("Please Enter The REGIONAL FLIGHT NUMBER: ");
	 
	   
	
		
		
	}
	 

   
 
   public static boolean uniqueFlightNo2(String fno)
   {
     for (int i = 0; i < flights.length;i ++)
     {
     if (Rflights[i].getFlightNo().compareTo(fno)== 0)
       {
         return false;
         
       }
     }
     return true; 
   }
   
   public static boolean samefl1(String fno) throws Exception
   {
	     for (int i = 0; i < passenger.length;i ++)
	     {
	     if (passenger[i].getFlightNo().compareTo(fno)== 0)
	       {
	    	 return true;
	       
	        
	       }
	     }
	     
	     return false; 
	   
	   }
   
   public static boolean uniqueFlightNo(String fno)
   {
     for (int i = 0; i < flights.length;i ++)
     {
     if (flights[i].getFlightNo().compareTo(fno)== 0)
       {
         return false;
         
       }
     }
     return true; 
   
   } 
   public static boolean samefl(String fno) throws Exception
   {
	     for (int i = 0; i < flights.length;i ++)
	     {
	     if (flights[i].getFlightNo().compareTo(fno)== 0)
	       {
	    	 return true;
	       
	        
	       }
	     }
	     
	     return false; 
	   
	   }
   public static boolean flightboarding(String fno) throws Exception
   {
	     for (int i = 0; i < flights.length;i ++)
	     {
	     if (flights[i].getFlightNo().compareTo(fno)== 0)
	       {
	    	 if(flights[i].getStatus() == 'B')
	    	 return true;
	       
	        
	       }
	     }
	     
	     return false; 
	   
	   }
   public static boolean timeformat(String fno)
   { 
	   int hours = Integer.parseInt(fno.substring(0,2)); 
	   
   int as = fno.length();
   if(hours > 24){
	
	   return false;
   }else if(as !=5 ){
  	 
  	 return false;
   }
   else if(fno.indexOf(":")!= 2){
  	 return false;
   }
   else{
  	 return true;
   }
   
   }
  
   public static boolean arrivalTime(String arv, double doub ){
	   
 	  int hours = Integer.parseInt(arv.substring(0,2));
 	  int minutes = Integer.parseInt(arv.substring(3,5));
 	  
 	  int hoursmin = hours * 60;
 	  int minutesmin = minutes;
 	  
 	  int allmins = hoursmin + minutesmin;
 	  double flightlength = (doub *60) + allmins;
 	 
 	  double flightlengthfinal = flightlength / 60;
 	 
 	  if (flightlengthfinal> 24){
 		  return false;
 	  }else{
 		  return true;
 		  }
 	 
 	  
   }
   public static boolean RegboardingTime(String arv, double doub, String ar2 ){
	   double nn = arrivalTime2( arv,doub );
	   int hours = Integer.parseInt(ar2.substring(0,2));
	   int minutes = Integer.parseInt(ar2.substring(3,5));
	   int hoursmin = hours * 60;
	 	  int minutesmin = minutes;
	 	  int allmins = hoursmin + minutesmin;
	 double total = allmins /60;
	 
	 	  if (nn < total){
	 		  return true;
	 	  }else{
	 		  return false;
	 		  }
	 	 
	 	  
	   }
   public static double arrivalTime2(String arv, double doub ){
	   		double flightlengthfinal = 0;
	 	  int hours = Integer.parseInt(arv.substring(0,2));
	 	  int minutes = Integer.parseInt(arv.substring(3,5));
	 	  
	 	  int hoursmin = hours * 60;
	 	  int minutesmin = minutes;
	 	  
	 	  int allmins = hoursmin + minutesmin;
	 	  double flightlength = (doub *60) + allmins;
	 	 
	 	 flightlengthfinal = flightlength / 60;
	 	 
	 	  if (flightlengthfinal< 24){
	 		
	 		  return flightlengthfinal;
	 		  
	 	  }else{
	 		  return 0.00;
	 	  }
	 	 
	 	  
	   }
   


 
public static void viewAllFlights()
   {
      System.out.printf("\n%65s\n\n", "(Current Flight Schedule)");
      System.out.printf("%-13s", "Flight No.");
      System.out.printf("%-15s", "Departing");
      System.out.printf("%-15s", "Destination");
      System.out.printf("%-7s", "Time");
      System.out.printf("%-11s", "Date");
      System.out.printf("%8s", "Length");
      System.out.printf("%10s", "Capacity");
      System.out.printf("%11s", "Bookings");
      System.out.printf("%12s", "Status");
      System.out.printf("%9s\n", "Layover");
      
      System.out.printf("%-13s%-15s%-15s%-7s%-11s%8s%10s%11s%12s%9s\n",
            "-----------", "----------", "------------", "-----", "---------",
            "------", "--------", "--------", "---------", "-------");
  
      for (int i = 0; i < flights.length; i++)
      {
    	  if(flights[i].getFlightNo()!= null){
    	 
         flights[i].printInRow();
         System.out.println();
         System.out.println();
         
    		
    	}
    	  else{
    		  break;
    	  	  }
      }
   }     
   

   public static void openFlight()
   {
      Flight flight;
      String flightID;

      System.out.print("\nEnter id of flight to open: ");
      flightID = sc.nextLine();

      flight = getFlight(flightID);

      if (flight == null)
      {
         System.out.printf("\nError - flight %s not found!\n", flightID);
      }
      else
      {
    	  try
    	  {
         boolean result = flight.open();
         if (result == true)
         {
            System.out.printf("\nFlight %s opened for boarding.\n", flightID);
         }
         else
         {
            System.out.printf(
                  "\nError flight %s cannot be opened for boarding!\n", 
                  flightID);
         }
    	  }catch (Exception e){System.out.println(e.getMessage());}
    	
    	

      }
   }

   public static void reserveSeats()
   {
      Flight flight;
      String flightID;

      System.out.print("\nEnter id of flight to open: ");
      flightID = sc.nextLine();

      flight = getFlight(flightID);

      if (flight == null)
      {
         System.out.printf("\nError - flight %s not found!\n", flightID);
      }
      else
      {
    	  try
    	  {
         System.out.print("\nEnter number of seats to reserve: ");
         int seats = sc.nextInt();

         boolean result = flight.reserveSeats(seats);

         if (result == true)
         {
            System.out.printf("\n%d seats for flight %s reserved.\n", seats,
                  flightID);
         }
         else
         {
            System.out.printf(
                  "\nError cannot reserve %d seats for flight %s!\n",
                  seats, flightID);
         }
    	  }
    	  catch (Exception e){System.out.println(e.getMessage());  }
      }
   }

   public static void closeFlight()
   {
      Flight flight;
      String flightID;

      System.out.print("\nEnter id of flight to close: ");
      flightID = sc.nextLine();

      flight = getFlight(flightID);

      if (flight == null)
      {
         System.out.printf("\nError - flight %s not found!\n", flightID);
      }
      else
      {
       try{
         boolean result = flight.close();

         if (result == true)
         {
            System.out.printf(
                  "\nFlight \"%s\" closed for departure.\n", 
                  flightID);
         }
         else
         {
            System.out.printf(
                  "\nError - flight \"%s\" cannot be closed for departure!\n",
                  flightID);
         }}
         catch (Exception e){System.out.println(e.getMessage());}
    	
      }

      
     
   }
   
   public static void delayFlight()
   {
      Flight flight;
      String flightID;

      System.out.print("\nEnter id of flight to Delay: ");
      flightID = sc.nextLine();

      flight = getFlight(flightID);

      if (flight == null)
      {
         System.out.printf("\nError - flight %s not found!\n", flightID);
      }
      else
    	
      {
    	
         System.out.print("\nEnter delay hours: ");
         int hours = sc.nextInt();

         System.out.print("\nEnter delay minutes: ");
         int minutes = sc.nextInt();
         try{
         boolean result = flight.delay(hours, minutes);

         if (result == true)
         {
            if (flight.getStatus() == 'C')
            {
               System.out.printf(
                     "\nFlight %s has been cancelled due to delays.\n");
            }
            else
            {
               System.out.printf("\nFlight %s has been delayed until %s hours.\n",
                     flightID, flight.getFlightTime());
            }
         }
         else
         {
            System.out.printf(
                  "\nError - flight \"%s\" cannot be delayed\n!",
                  flightID);
         }

      }catch (Exception e){System.out.println(e.getMessage());}
      }
   }
   
}