class Student {

    private String name;
    private int[] grades;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double getAverageGrade() {
        double total = 0;

        for (int i = 0; i < this.grades.length; i++) {
            total += this.grades[i];
        }

        return total / this.grades.length;
    }
}