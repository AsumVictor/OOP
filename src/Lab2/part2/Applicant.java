package Lab2.part2;

import Lab2.part1.CourseGrade;

import java.util.List;

public class Applicant {
    private String name;
    private List<CourseGrade> grades;
    public Applicant(String name, List<CourseGrade> grades) {
         this.name = name;
         this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<CourseGrade> getGrades(){
        return grades;
    }

    public IllegalArgumentException getGradeFor(String course){
        int courseIndex;

        switch (course) {
            case "Intro to CS":
                courseIndex = 0;
                break;
            case "Data Structures":
                courseIndex = 1;
                break;
            case "Algorithms":
                courseIndex = 2;
                break;
            case "Computer Organization":
                courseIndex = 3;
                break;
            case "Operating Systems":
                courseIndex = 4;
                break;
            case "Non-CS GPA":
                courseIndex = 5;
                break;
            default:
                 return new IllegalArgumentException("Course not found: " + course);
        }

        return grades.get(courseIndex);
    }


}
