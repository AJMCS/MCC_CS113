import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.*;



public class StudentTest 
{
    private static double[][] GRADES = {
        {0, 0, 0, 0, 0}, // Student 1
        {0, 0, 0, 0, 0}, // Student 2
        {0, 0, 0, 0, 0}, // Student 3
        {0, 0, 0, 0, 0}, // Student 4
        {0, 0, 0, 0, 0}, // Student 5
        {0, 0, 0, 0, 0}, // Student 6
    };

    private static String[] STUDENT_NAMES = {"Student1", "Student2", "Student3", "Student4", "Student5"};
  

    private static final Student[] STUDENT_ARR = {

         new Student(),
         new Student("Polo Mariscal"),
         new Student("Eduardo Mariscal", GRADES[2][0]),
         new Student("Mike Paulding", GRADES[3][0], GRADES[3][1], GRADES[3][2]),
         new Student("Mark Stramaglia", GRADES[4][0], GRADES[4][1], GRADES[4][2], GRADES[4][3]),
         new Student("Brighu Celly", GRADES[5][0], GRADES[5][1], GRADES[5][2], GRADES[5][3], GRADES[5][4])
    };

    private static final Student[] NO_GRADES = {
        
        new Student(),
        new Student(STUDENT_NAMES[0]),
        new Student(STUDENT_NAMES[1])
    };

    private static final Student[] ONE_GRADE = {
        
        new Student(STUDENT_NAMES[0], 0),
        new Student(STUDENT_NAMES[1], 92),
        new Student(STUDENT_NAMES[2], 100)
    };

    private static final Student[] TWO_GRADES = {
        
        new Student(STUDENT_NAMES[0], 0, 0),
        new Student(STUDENT_NAMES[1], 92, 83),
        new Student(STUDENT_NAMES[2], 100, 97)
    };

    private static final Student[] THREE_GRADES = {
        
        new Student(STUDENT_NAMES[0], 0, 0, 0),
        new Student(STUDENT_NAMES[1], 92, 83, 45),
        new Student(STUDENT_NAMES[2], 100, 97, 99)
    };

    private static final Student[] FOUR_GRADES = {
        
        new Student(STUDENT_NAMES[0], 0, 0, 0, 0),
        new Student(STUDENT_NAMES[1], 92, 83, 45, 63),
        new Student(STUDENT_NAMES[2], 100, 97, 99, 98)
    };

    private static final Student[] ALL_GRADES = {

        new Student(STUDENT_NAMES[0], 0, 0, 0, 0, 0),
        new Student(STUDENT_NAMES[1], 92, 83, 45, 63, 88),
        new Student(STUDENT_NAMES[2], 100, 97, 99, 98, 95)
    };

    @Test
    public void testStudentsWithNoGrade()
    {
        for(int i = 0; i < NO_GRADES.length; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                Assert.assertEquals(-1, NO_GRADES[i].getGrade(j),0);  
            }
        }
        
    }

    @Test
    public void studentOneGradeTest()
    {
        for(int i = 0; i < ONE_GRADE.length; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j < 1)
                {
                    Assert.assertTrue(ONE_GRADE[i].getGrade(j) >= 0 && ONE_GRADE[i].getGrade(j) <= 100); 

                }else
                {
                    Assert.assertEquals(-1, ONE_GRADE[i].getGrade(j), 0);
                }
            }
        }
    }

    @Test
    public void studentTwoGradeTest()
    {
        for(int i = 0; i < TWO_GRADES.length; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j < 2)
                {
                    Assert.assertTrue(TWO_GRADES[i].getGrade(j) >= 0 && TWO_GRADES[i].getGrade(j) <= 100);
                    
                }else
                {
                    Assert.assertEquals(-1, TWO_GRADES[i].getGrade(j), 0);
                }
            }
        }
    }

    @Test
    public void studentThreeGradeTest()
    {
        for(int i = 0; i < THREE_GRADES.length; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j < 3)
                {
                    Assert.assertTrue(THREE_GRADES[i].getGrade(j) >= 0 && THREE_GRADES[i].getGrade(j) <= 100);
                    
                }else
                {
                    Assert.assertTrue(THREE_GRADES[i].getGrade(j) < 0);
                }
            }
        }
    }

    @Test
    public void studentFourGradeTest()
    {
        for(int i = 0; i < FOUR_GRADES.length; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(j < 4)
                {
                    Assert.assertTrue(FOUR_GRADES[i].getGrade(j) >= 0 && FOUR_GRADES[i].getGrade(j) <= 100);
                    
                }else
                {
                    Assert.assertEquals(-1, FOUR_GRADES[i].getGrade(j), 0);
                }
            }
        }
    }

    @Test
    public void studentGradeTest()
    {
        for(int i = 0; i < ALL_GRADES.length; i++)
        {
            for(int j = 0; j < 5; j++)
            { 
                Assert.assertTrue(ALL_GRADES[i].getGrade(j) >= 0 && ALL_GRADES[i].getGrade(j) <= 100);
            }
        }
    }

    @Test
    public void setGradeInvalidValueTest()
    {

        Student test = new Student();

        Assert.assertThrows(IllegalArgumentException.class, () -> test.setGrade(0, -700));
        Assert.assertThrows(IllegalArgumentException.class, () -> test.setGrade(0, 3000));

        //Assert will throw for illegal edge cases
        Assert.assertThrows(IllegalArgumentException.class, () -> test.setGrade(0, -2));
        Assert.assertThrows(IllegalArgumentException.class, () -> test.setGrade(0, 101));

        
 
    }

    @Test
    public void setGradeTest()
    {
        Student test = new Student();

        
        assertDoesNotThrow(() -> test.setGrade(0, -1));
        assertDoesNotThrow(() -> test.setGrade(0, 50));
        assertDoesNotThrow(() -> test.setGrade(0, 100));
    }

    @Test
    public void setNameTest()
    {
        Student test = new Student();

        for(int i = 0; i < STUDENT_NAMES.length; i++)
        {
            test.setName("Student" + (i+1));

            Assert.assertEquals(STUDENT_NAMES[i], test.getName());
        }
    }

    @Test
    public void getAverageGradeTest()
    {

    }

    @Test
    public void getAverageGradeEmptyArrayTest()
    {

    }



}
