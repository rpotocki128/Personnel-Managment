
    import java.util.*;
    import java.text.DecimalFormat;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.text.SimpleDateFormat;
    
        public class PersonnelManagmentProject {
            public static void main(String[] args){	
            
                Scanner scnr = new Scanner(System.in);
                int choice = 0, success = 0, check = 0;
        
                String tempName = "0", tempID = "0", tempRank = "0", tempDepartment = "0", yn = "0";
                double tempGpa = 0.00;
                int tempCreditHours = 0, index = 0, j = 0, length = 0;
                Character ch = '0';
        
                ArrayList<Person> list = new ArrayList<Person>(100);
                Person person = new Faculty("null", "null", "null", "null");
                Faculty faculty;
                Student student;
                
                System.out.println("\t\t\tWelcome to my Personal Managment Program\n\n");
                System.out.println("\t\tChoose One of the Options:\n");
                
                do {
                    choice = menu();
                    
                    switch(choice) {
                    case 1 :
                        faculty = new Faculty("null", "null", "null", "null");
                        System.out.println("	Enter the Faculty's Info");
                        System.out.print("		Name of Faculty: ");  //Name INPUT
                            tempName = scnr.nextLine();
                            faculty.setName(tempName);
                            
                        System.out.print("		ID: ");  //ID INPUT
                        try{
                            check = 0;
                            tempID = scnr.nextLine();
                            length = tempID.length();
    
                            if (length > 7 || length < 6) throw new idException();
    
                            for (j = 0; j<length; j++) {
                                ch = tempID.charAt(j);
                                if (Character.isLetter(ch) && j < 2) {
                                    check = 10;
                                }
                                if (Character.isDigit(ch) && j > 1) {
                                    check = 10;
                                }
                                if (check != 10) throw new idException();
                            }
                            if (check == 10) {
                                faculty.setID(tempID);
                            
                                System.out.print("		Rank: ");  //Rank INPUT
                                tempRank = scnr.nextLine();
                                do {
                                    if (tempRank.equalsIgnoreCase("Professor") || tempRank.equalsIgnoreCase("Adjunct")) break;
                                    if (!tempRank.equalsIgnoreCase("Professor") || !tempRank.equalsIgnoreCase("Adjunct")) {
                                        System.out.println("		     Sorry Entered Rank (" + tempRank + ") Is Invalid");
                                        System.out.print("		Rank: ");
                                        tempRank = scnr.nextLine();
                                    }
                                    else break;
                                } while (!tempRank.equalsIgnoreCase("Professor") || !tempRank.equalsIgnoreCase("Adjunct"));
                                if(tempRank.equalsIgnoreCase("Professor")) tempRank = "Professor";
                                if(tempRank.equalsIgnoreCase("Adjunct")) tempRank = "Adjunct";
                                faculty.setRank(tempRank);
                                
                                System.out.print("		Department: ");  //Department INPUT
                                tempDepartment = scnr.nextLine();
                                do {	                    
                                    if (tempDepartment.equalsIgnoreCase("Mathematics") || tempDepartment.equalsIgnoreCase("Engineering") || tempDepartment.equalsIgnoreCase("Physics")) break;
                    
                                    if (!tempDepartment.equalsIgnoreCase("Mathematics") || !tempDepartment.equalsIgnoreCase("Engineering") || !tempDepartment.equalsIgnoreCase("Physics")) {
                                        System.out.println("		     Sorry Entered Department (" + tempDepartment + ") Is Invalid");
                                        System.out.print("		Department: ");
                                        tempDepartment = scnr.nextLine();
                                    }
                                    else break;
                                    } while (!tempDepartment.equalsIgnoreCase("Mathematics") || !tempDepartment.equalsIgnoreCase("Engineering") || !tempDepartment.equalsIgnoreCase("Physics"));
                                if(tempDepartment.equalsIgnoreCase("Mathematics")) tempDepartment = "Mathematics";
                                if(tempDepartment.equalsIgnoreCase("Engineering")) tempDepartment = "Engineering";
                                if(tempDepartment.equalsIgnoreCase("Physics")) tempDepartment = "Physics";
                                faculty.setDepartment(tempDepartment);
                            
                        list.add( faculty );	
                        System.out.println("\n	Thanks!\n\n\n");
                        }
                        }
                        catch (idException e ) {
                            System.out.println(e.toString());
                        }
                        break;
                        
                    case 2 :
                        student = new Student("null", "null", 0.00, 0);
                        System.out.println("	Enter the Student's Info");
                        System.out.print("		Name of Student: ");  //Name INPUT
                            tempName = scnr.nextLine();
                            student.setName(tempName);
                            
                        System.out.print("		ID: ");  //ID INPUT
                        try{
                            check = 0;
                            tempID = scnr.nextLine();
                            length = tempID.length();
    
                            if (length > 7 || length < 6) throw new idException();
    
                            for (j = 0; j<length; j++) {
                                ch = tempID.charAt(j);
                                if (Character.isLetter(ch) && j < 2) {
                                    check = 10;
                                }
                                if (Character.isDigit(ch) && j > 1) {
                                    check = 10;
                                }
                                if (check != 10) throw new idException();
                            }
                            if (check == 10) {
                                student.setID(tempID);
                                
                                System.out.print("		Gpa: ");  //Gpa INPUT
                                    tempGpa = scnr.nextDouble();
                                    student.setGPA(tempGpa);
                                    
                                System.out.print("		Credit Hours: ");  //Credit Hours INPUT
                                    tempCreditHours = scnr.nextInt();
                                    scnr.nextLine();
                                    student.setCreditHours(tempCreditHours);
                                    
                                list.add( student );	
                                System.out.println("\n	Thanks!\n\n\n");
                            }
                        }
                            catch (idException e ) {
                                System.out.println(e.toString());
                            }
                            catch (InputMismatchException ie){
                                System.out.println("\n	Incorrect Input!\n	Names and ID are Strings(John Doe or jo1234)\n	GPA is a Double(3.25)\n	Credit Hours are an Interger (12)\n\n");
                            }
                            break;
                        
                    case 3 :
                        success = 0;
                        System.out.print("\n      	    Enter the Student's ID: ");
                        tempID = scnr.nextLine();
                        int len=list.size();
                        for(int i=0; i<len; i++) {
                               if (list.get(i).getID().equalsIgnoreCase(tempID)) {
                                success = 1;
                                index = i;
                            }
                        } 
                        if (success != 1) System.out.println("\n      	    Sorry-Student Not Found!\n\n");
        
                        else {
                            
                            tempName = list.get(index).getName();
                            tempID = list.get(index).getID();
        
                            tempGpa = ((Student) list.get(index)).getGPA();
                            tempCreditHours = ((Student) list.get(index)).getCreditHours();
        
                            Student.tuitionInvoice(tempName, tempID, tempGpa, tempCreditHours);
                        }
        
        
                        break;
                        
        
                    case 4 :
                        success = 0;
                        System.out.print("\n      	    Enter the Faculty's ID: ");
                        tempID = scnr.nextLine();
                        int leng=list.size();
                        for(int i=0; i<leng; i++) {
                               if (list.get(i).getID().equalsIgnoreCase(tempID)) {
                                System.out.println("\n	Faculty Found:");
                                System.out.println("      	    ---------------------------------------------------------------------------");
                                System.out.println(list.get(i));
                                System.out.println("      	    ---------------------------------------------------------------------------\n\n");
                                success = 1;
                            }
                        } 
                        if (success != 1) System.out.println("\n      	    Sorry " + tempID + " doesn't exist\n\n");
                        break;
                    case 5 : 
                        System.out.println("\n\t    Would you like to create the report? (Y/N): ");
                        do {
                            yn = scnr.next();
                            if (yn.equalsIgnoreCase("y")) break;
                            if (yn.equalsIgnoreCase("n")) break;
                        }while (!yn.equalsIgnoreCase("y") || !yn.equalsIgnoreCase("n"));
                    
                        if(yn.equalsIgnoreCase("y")){
                            Date date = new Date();
                            SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/yyyy");
                            String sDate = dateForm.format(date);
                            try{
                                
                                File file = new File ("C:report.dat");
                                boolean fc = file.createNewFile();
                                if (fc) System.out.println("\n\t    Your File has been created!\n");
                                else System.out.println("\n\t    Your File failed to create or already exists!\n");
    
    
                                FileWriter myWriter = new FileWriter(file);
                                myWriter.write("\t\tReport Created on " + sDate);
                                myWriter.write("\n\t\t****************************\n\n");
                                myWriter.write("Faculty Members (Sorted by Department)\n");
                                myWriter.write("--------------------------------------\n");
    
                                //Loop to print all members sorted via department alphabetically
                                int q = 0, k = 0;
                                leng = list.size();
                                for( q=0; q<leng; q++ ) {
                                    if (list.get(q) instanceof Faculty) {
                                    tempDepartment = ((Faculty)list.get(q)).getDepartment();
                                        if(tempDepartment == "Engineering") {
                                            k++;
                                            myWriter.write(k + ". " + ((Faculty)list.get(q)).toReport());
                                        }
                                    }
                                }
                                q = 0;
                                for( q=0; q<leng; q++ ) {
                                    if (list.get(q) instanceof Faculty) {
                                    tempDepartment = ((Faculty)list.get(q)).getDepartment();
                                        if(tempDepartment == "Mathematics") {
                                            k++;
                                            myWriter.write(k + ". " + ((Faculty)list.get(q)).toReport());
                                        }
                                    }
                                }
                                q = 0;
                                for( q=0; q<leng; q++ ) {
                                    if (list.get(q) instanceof Faculty) {
                                    tempDepartment = ((Faculty)list.get(q)).getDepartment();
                                        if(tempDepartment == "Physics") {
                                            k++;
                                            myWriter.write(k + ". " + ((Faculty)list.get(q)).toReport());
                                        }
                                    }
                                }   
    
    
    
                                //Students
                                myWriter.write("\nStudents\n");
                                myWriter.write("--------\n");
                                q = 0;
                                k = 0;
                                for( q=0; q<leng; q++ ) {
                                    if (list.get(q) instanceof Student) {
                                    k++;
                                    myWriter.write(k + ". " + ((Student)list.get(q)).toReport());
                                    }
                                }
                                myWriter.flush();
                                myWriter.close();
                            }
                            catch(IOException e) {
                                System.out.println("\n\tInput Output Exception Caught\n\n\n\n");
    
    
                            }
                        }   
                        System.out.println("\n\t    Goodbye!\n\n\n\n");
                        scnr.close();
                            break;
                        default :
                            break;
                    }
                }while (choice != 5);
                
                
                
                
            }
            //END OF MAIN
            //-------------------------------------------------------------------------------------------------------
            private static int menu() {
                int option = 0;
                String str = "0";
                Scanner scan = new Scanner(System.in);
                boolean check;
                
                do {
                    System.out.println("	1 - Add a new Faculty member ");
                    System.out.println("	2 - Add a new Student");
                    System.out.println("	3 - Print the tuition invoice for a student");
                    System.out.println("	4 - Print the information of a faculty member");
                    System.out.println("	5 - Exit Program\n");
                    System.out.print("      	    Enter Your Selection:");
                    
                    try {
                        str = scan.next();
                        Integer.parseInt(str);
                        check = true;
                    }
                    catch (Exception e) {
                        check = false; 
                    }
                    if(check == true) option = Integer.parseInt(str);
                    if(option > 5 || option < 1) System.out.println("\n\n\nInvalid Entry - Please Try Again\n\n\n");
                    
                } while (option > 5 || option < 1);
                return option;
            }
            //-------------------------------------------------------------------------------------------------------
        }
        //END OF Project2 Class
        
         //---------------------------
            abstract class Person{ //Base Class
                public String name;
                public String ID;
        
                //Constructors
                public Person() {}
                public Person(String name, String ID) {}	
                
                //Getter NAME
                public String getName() {
                    return name;
                }
        
                //Setter NAME
                public void setName(String name) {
                    this.name = name;
                }
                
                //Getter ID
                public String getID() {
                    return ID;
                }
        
                //Setter ID
                public void setID(String ID) {
                    this.ID = ID;
                }
                
                //Report Output
                public String toReport() {
                    return("null");
                }
            }
        
        //---------------------------
            class Faculty extends Person{
                private String rank;
                private String department;
                
                //Default Constructor
                public Faculty() {
                    super();
                }
                //Parametized Constructors
                public Faculty(String name, String ID, String rank, String department) {
                    super(name, ID);
                    this.rank = rank;
                    this.department = department;
                }
                //Rank Getter/Setter
                //Getter rank
                public String getRank() {
                    return rank;
                }
        
                //Setter rank
                public void setRank(String rank) {
                    this.rank = rank;
                }
                //------------------------
                //Department Getter/Setter
                //Getter department
                public String getDepartment() {
                    return department;
                }
        
                //Setter department
                public void setDepartment(String department) {
                    this.department = department;	                    		
                }
    
                //Overrides
                @Override
                public String toString() {
                    return ("      	    " + name + "\n      	    " + department + " Department, " + rank);
                }
        
                @Override
                public boolean equals(Object obj) {
                if (obj == null) return false;
                if (!(obj instanceof Faculty))
                    return false;
                if (obj == this)
                    return true;
                return this.getID() == ((Faculty) obj).getID();
                }
    
                //Report Output
                @Override
                public String toReport() {
                    return (name + "\n" + "ID: " + ID + "\n" + rank + ", " + department + "\n\n" );
                }
            }
        
        //---------------------------
            class Student extends Person{
                private double gpa;
                private int creditHours;
                
                //Default Constructor
                public Student() {
                    super();
                }
                //Parametized Constructors
                public Student(String name, String ID, double gpa, int creditHours) {
                    super(name, ID);
                    this.gpa = gpa;
                    this.creditHours = creditHours;
                }
            //===============================
                
                //Getter gpa
                public double getGPA() {
                return gpa;
                }
        
                //Setter gpa
                public void setGPA(double gpa) {
                this.gpa = gpa;
                }
                
                //Getter creditHours
                public int getCreditHours() {
                return creditHours;
                }
        
                //Setter creditHours
                public void setCreditHours(int creditHours) {
                this.creditHours = creditHours;
                }	
    
                //Report Output
                @Override
                public String toReport() {
                    return (name + "\n" + "ID: " + ID + "\nGpa: " + gpa + "\nCredit Hours:  " + creditHours + "\n\n" );
                }
                
                //Overrides
                @Override
                public String toString() {
                    return (name + " " + ID + " " + gpa + " " + creditHours);
                }
        
                @Override
                public boolean equals(Object obj) {
                if (obj == null) return false;
                if (!(obj instanceof Student))
                    return false;
                if (obj == this)
                    return true;
                return this.getID() == ((Student) obj).getID();
                }
        
        
        
                //----------------------------TUTION INVOICE----------------------------
                public static void tuitionInvoice(String name, String ID, double gpa, int creditHours) {
                    
                    double totalCost = 0, discount = 0, hours = 0;
                    DecimalFormat df = new DecimalFormat("#.##");
                    
                    System.out.println("\n\n      	    Here is the Tuition Invoice for: "+ name +" :\n");
                    System.out.println("      	    ---------------------------------------------------------------------------\n");
                    System.out.println("      	    "+name+"				"+ID);
                    System.out.println("\n");
                    
                    hours = creditHours;
                    totalCost = hours * 236.45;
                    totalCost += 52.00;
                    
                    if(gpa > 3.84) {
                        discount = totalCost * 0.25;
                        totalCost -= discount;
                    }
                    
                    System.out.println("\n      	    Credit Hours: " + creditHours + "	($236.45/credit hour)");
                    System.out.println("\n      	    Fees: $52\n\n");
                    
                    System.out.println("      	    Total Payment: $" + Double.valueOf(df.format(totalCost)) + "				" + "($" + Double.valueOf(df.format(discount)) + " discount applied)");
                    System.out.println("      	    ---------------------------------------------------------------------------\n\n\n\n");
                    
                    return;
                }
                //----------------------------------------------------------------------
            }
        @SuppressWarnings("serial")
        class idException extends Exception{
    
            public String toString() {
                return("\n	Sorry Invalid id format-It has to be LetterLetterDigitDigitDigitDigit\n\n");        
            }
    
    
    
    
        }
        
        
            
            
            
            