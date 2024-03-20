public class StudentGradesCalculator 
{
    static final int NUM_OF_SUBJECTS = 5;

    public static void main(String[] args) 
    {
        
        double classTotal = 0;
        double classAverage = 0;
        int divisor = 0;
        
        
        //Create student array
        Student studentArr[] = {
            new Student(),
            new Student(),
            new Student(),
            new Student(),
            new Student(),
            new Student(),
        };

        String[] namesArr = {"Michael Jackson", "Zika Perovic", "Polo Mariscal", "Eduardo Mariscal", "Mike Paulding", "Mark Stramaglia", "Brighu Celly"};

        //Grades
        double[][] grades = {
            
            {-1, -1, -1, -1, -1},  //Student 1
            {100, -1, -1, -1, -1}, //Student 2
            {75, 88, -1, -1, -1},  //Student 3
            {95, 92, 84, -1, -1},  //Student 4
            {89, 92, 78, 100, -1}, //Student 5
            {98, 97, 98, 99, 89}   //Student 6
        };

        
        //For loop for setting the Student info
        for(int i = 0; i < studentArr.length; i++)
        {
            //Sets student's name
            studentArr[i].setName(namesArr[i]);

            //Set student's grades
            for(int j = 0; j < NUM_OF_SUBJECTS; j++)
            {
                studentArr[i].setGrade(j, grades[i][j]);
            }
        }
        
        //Print the toString for each student
        for(int i = 0; i < studentArr.length; i++)
        {
            System.out.println(studentArr[i]);

            //Totaling up the individual averages
            if(studentArr[i].getAverageGrade() >= 0) // If they took at least one subject and received a grade
            {
                classTotal += studentArr[i].getAverageGrade();
                divisor++;
            }
            
        }

        System.out.print("Class Average Grade: ");

        //Calculate class average
        classAverage = classTotal / divisor;

        System.out.printf("%2.1f", classAverage);
    }
}
