package Lab2.part2;

import Lab2.part1.CourseGrade;

import java.util.ArrayList;
import java.util.List;

public class Applicant {
    private String name;
    private List<CourseGrade> grades;
    private ArrayList<Project> projects;
    private List<Job> workExperiences;


    public Applicant(String name, List<CourseGrade> grades, ArrayList<Project> projects, List<Job> workExperiences ) {
        this.name = name;
        this.grades = grades;
        this.projects = projects;
        this.workExperiences = workExperiences;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public List<Job> getWorkExperiences(){
        return workExperiences;
    }


    public String getName() {
        return name;
    }

    public List<CourseGrade> getGrades(){
        return grades;
    }

    public CourseGrade getGradeFor (String course){
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
                 return null;
        }

        return grades.get(courseIndex);
    }



}
