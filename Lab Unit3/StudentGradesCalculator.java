public class StudentGradesCalculator 
{
    
    public static void main(String[] args) 
    {
        double classTotal = 0;
        double classAverage = 0;
        int divisor = 0;
        //Create student array
        Student studentArr[] = {
            new Student(),
            new Student("Polo Mariscal"),
            new Student("Eduardo Mariscal", 75),
            new Student("Mike Paulding", 95, 92, 84),
            new Student("Mark Stramaglia", 89, 92, 78, 100),
            new Student("Brighu Celly", 98, 97, 98, 99, 89),
        };
        
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
