public class Student
{
    //Initialize all private variables.
    private String name;
    private double averageGrade;
    private static final int NUM_OF_GRADES = 5;
    private double[] grades = new double[NUM_OF_GRADES];

    
    //Student constructor 0 grades
    public Student()
    {
        name = "New Student";
        grades[0] = -1;  // Sets any subject not taken as -1
        grades[1] = -1;
        grades[2] = -1;
        grades[3] = -1;
        grades[4] = -1;
    }
    
    
    //Student constructor 0 grades
    public Student(String name)
    {
        this.name = name;
        grades[0] = -1;  // Sets any subject not taken as -1
        grades[1] = -1;
        grades[2] = -1;
        grades[3] = -1;
        grades[4] = -1;
    }


    //Student constructor 1 grades
    public Student(String name, double grade1)
    {
        this.name = name;
        grades[0] = grade1;
        grades[1] = -1;  // Sets any subject not taken as -1
        grades[2] = -1;
        grades[3] = -1;
        grades[4] = -1;
    }
    

    //Student constructor 2 grades
    public Student(String name, double grade1, double grade2)
    {
        this.name = name;
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = -1;  // Sets any subject not taken as -1
        grades[3] = -1;
        grades[4] = -1;
    }
    

    //Student constructor 3 grades
    public Student(String name, double grade1, double grade2, double grade3)
    {
        this.name = name;
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = grade3;
        grades[3] = -1;  // Sets any subject not taken as -1
        grades[4] = -1;
    }
    
    //Student constructor 4 grades
    public Student(String name, double grade1, double grade2, double grade3, double grade4)
    {
        this.name = name;
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = grade3;
        grades[3] = grade4;
        grades[4] = -1;  // Sets any subject not taken as -1
    }
    

    //Student constructor 5 grades
    public Student(String name, double grade1, double grade2, double grade3, double grade4, double grade5)
    {
        this.name = name;
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = grade3;
        grades[3] = grade4;
        grades[4] = grade5;
    }


    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
  
    public void setGrade(int idx, double grade)
    {
        if(grade >= -1 && grade <= 100)
        {
            this.grades[idx] = grade;
        }else
        {
            throw new IllegalArgumentException("Invalid entry: Grade must be between -1 and 100."); 
        }
        
    }

    //Getters
    public String getName()
    {
        return name;
    }

    public double getGrade(int idx)
    {
        if(idx < grades.length)
        {
            return grades[idx];
        }else
        {
            throw new IllegalArgumentException("There is no grade at the index provided.");
        }
    }
    
    public double getAverageGrade()
    {
        double gradeSum = 0;
        int divisor = 0;
        
        for(int i = 0; i < grades.length; i++)
        {
            if(grades[i] >= 0) //If grades[i] was a subject taken and received a grade
            {
                gradeSum += grades[i];
                divisor++;
            }
        }

        if(divisor == 0)
        {
            return -1;
        }else
        {
            this.averageGrade = gradeSum / divisor;
            return averageGrade;
        }      
        
    }


    public String toString()
    {
        System.out.println("Name: " + name); //Print Name

        System.out.print("Grades: ");
        for(int i = 0; i < grades.length; i++)
        {
            if(grades[i] >= 0) //If grades[i] was a subject taken and received a grade
            {
                System.out.print(grades[i] + " ");
            }else
            {
                System.out.print("N/A "); //Else put N/A instead of grade value
            }
            
        }

        System.out.println(); 

        if(this.averageGrade >= 0)
        {
            System.out.printf("Average Grade: %2.1f", this.getAverageGrade());
            System.out.println();
        }else
        {
            System.out.println("Average Grade: N/A");
        }
        
        System.out.println();

        return "";  
    }

}