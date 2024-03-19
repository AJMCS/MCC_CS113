public class main 
{
    
    public static void main(String[] args) 
    {
        double classTotal = 0;
        double classAverage = 0;
        int divisor = 0;
        //Create student array
        Student studentArr[] = new Student[6];

        //Create students using all constructors
        Student student1 = new Student();
        Student student2 = new Student("Polo Mariscal");
        Student student3 = new Student("Eduardo Mariscal", 75);
        Student student4 = new Student("Mike Paulding", 95, 92, 84);
        Student student5 = new Student("Mark Stramaglia", 89, 92, 78, 100);
        Student student6 = new Student("Brighu Celly", 98, 97, 98, 99, 89);

        //Add each student to the array
        studentArr[0] = student1;
        studentArr[1] = student2;
        studentArr[2] = student3;
        studentArr[3] = student4;
        studentArr[4] = student5;
        studentArr[5] = student6;
        
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
