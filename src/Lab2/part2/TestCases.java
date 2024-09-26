package Lab2.part2;

import Lab2.part1.CourseGrade;
import Lab2.part1.SimpleIf;
import org.junit.jupiter.api.Test;
//import part1.CourseGrade;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases {
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetName()   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades,  new ArrayList<>(), new ArrayList<>());
      assertEquals("Aakash", testApplicant.getName());
   }

   @Test
   public void testGetGrades(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS", 43)
      );
      Applicant testApplicant = new Applicant("Victor", grades,  new ArrayList<>(), new ArrayList<>());
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testGetGradeFor1(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS", 43)
      );
      Applicant testApplicant = new Applicant("Victor", grades,  new ArrayList<>(), new ArrayList<>());
      CourseGrade expected = grades.get(2);
      assertEquals(expected, testApplicant.getGradeFor("Algorithms"));
   }

   @Test
   public void testGetGradeFor2(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS GPA", 43)
      );
      Applicant testApplicant = new Applicant("Victor", grades,  new ArrayList<>(), new ArrayList<>());

      String empty = null;
      assertEquals(empty, testApplicant.getGradeFor("Leadership"));
   }

   @Test
   public void testGetProject(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS GPA", 43)
      );

      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("github"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Java")))
                      ),
                      new Job("Ashesi Peer coach", "Mentor 2+ students. Collaborate with team",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("leadership"),
                                      new SkillsUSed("mentorship"),
                                      new SkillsUSed("communication")
                              )

                              )

                      )


              )
      );

      ArrayList<Project>  projects = new ArrayList<>(
              Arrays.asList(
                      new Project("Event Archieve", "Build event with Java and OOP concept. I pushed to github private and submitted for a review",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("Java"),
                                      new SkillsUSed("OOP"),
                                      new SkillsUSed("Github"),
                                      new SkillsUSed("review"),
                                      new SkillsUSed("UML")

                              )
                              )
                      ),
                      new Project("GPA Calculator", "Build a GPA calculator with Python. I collaborated and lead a team complete this project",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("Java"),
                                      new SkillsUSed("OOP"),
                                      new SkillsUSed("Github"),
                                      new SkillsUSed("review"),
                                      new SkillsUSed("UML")

                              )
                              )
                      )
              )
      );


      Applicant testApplicant = new Applicant("Victor", grades,  projects, workExperience);

      assertEquals(projects, testApplicant.getProjects());
   }

   @Test
   public void testGetExperience(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS GPA", 43)
      );

      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("github"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Java")))
                      ),
                      new Job("Ashesi Peer coach", "Mentor 2+ students. Collaborate with team",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("leadership"),
                                      new SkillsUSed("mentorship"),
                                      new SkillsUSed("communication")
                              )

                              )

                      )


              )
      );

      ArrayList<Project>  projects = new ArrayList<>(
              Arrays.asList(
                      new Project("Event Archieve", "Build event with Java and OOP concept. I pushed to github private and submitted for a review",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("Java"),
                                      new SkillsUSed("OOP"),
                                      new SkillsUSed("Github"),
                                      new SkillsUSed("review"),
                                      new SkillsUSed("UML")

                              )
                              )
                      ),
                      new Project("GPA Calculator", "Build a GPA calculator with Python. I collaborated and lead a team complete this project",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("Java"),
                                      new SkillsUSed("OOP"),
                                      new SkillsUSed("Github"),
                                      new SkillsUSed("review"),
                                      new SkillsUSed("UML")

                              )
                              )
                      )
              )
      );


      Applicant testApplicant = new Applicant("Victor", grades,  projects, workExperience);

      assertEquals(workExperience, testApplicant.getWorkExperiences());
   }

   @Test
   public void testAnalyzeApplicant2_1(){
       List<CourseGrade> grades = Arrays.asList(
               new CourseGrade("Intro to CS", 43),
               new CourseGrade("Data Structures", 65),
               new CourseGrade("Algorithms", 64),
               new CourseGrade("Computer Organization", 75),
               new CourseGrade("Operating Systems", 84),
               new CourseGrade("Non-CS GPA", 43)
       );

       List<Job> workExperience = new ArrayList<>(
               Arrays.asList(

                       new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                               "Internship",
                               new ArrayList<>(Arrays.asList(
                                       new SkillsUSed("React"),
                                       new SkillsUSed("github"),
                                       new SkillsUSed("Figma"),
                                       new SkillsUSed("Java")))
                       ),
                       new Job("Ashesi Peer coach", "Mentor 2+ students. Collaborate with team",
                               "Internship",
                               new ArrayList<>(Arrays.asList(
                                       new SkillsUSed("leadership"),
                                       new SkillsUSed("mentorship"),
                                       new SkillsUSed("communication")
                               )

                               )

                       )


               )
       );

       ArrayList<Project>  projects = new ArrayList<>(
               Arrays.asList(
                       new Project("Event Archieve", "Build event with Java and OOP concept. I pushed to github private and submitted for a review",
                               new ArrayList<>(Arrays.asList(
                                       new SkillsUSed("Java"),
                                       new SkillsUSed("OOP"),
                                       new SkillsUSed("Github"),
                                       new SkillsUSed("review"),
                                       new SkillsUSed("UML")

                               )
                               )
                       ),
                       new Project("GPA Calculator", "Build a GPA calculator with Python. I collaborated and lead a team complete this project",
                               new ArrayList<>(Arrays.asList(
                                       new SkillsUSed("HTML"),
                                       new SkillsUSed("OOP"),
                                       new SkillsUSed("Github"),
                                       new SkillsUSed("Python"),
                                       new SkillsUSed("UML")

                               )
                               )
                       )
               )
       );


       Applicant testApplicant = new Applicant("Victor", grades,  projects, workExperience);

       // Job Description
       List<String> requiredKeywords = new ArrayList<>(Arrays.asList(
               "TEAM",
               "COLLABORATE",
               "LEAD",
               "BUILD",
               "PULL REQUEST",
               "FIGMA",
               "OOP",
               "REVIEW"
       ));

       List<String> requiredSkills = new ArrayList<>(Arrays.asList(
               "JAVA",
               "OOP",
               "GITHUB",
               "COMMUNICATION",
               "UML",
               "PYTHON"
       ));

       assertTrue(SimpleIf.analyzeApplicant2(
               testApplicant,
               70,
               requiredKeywords,
               requiredSkills,
               "front end developer"
       ));




   }

    @Test
    public void testAnalyzeApplicant2_2(){
        List<CourseGrade> grades = Arrays.asList(
                new CourseGrade("Intro to CS", 43),
                new CourseGrade("Data Structures", 65),
                new CourseGrade("Algorithms", 64),
                new CourseGrade("Computer Organization", 75),
                new CourseGrade("Operating Systems", 84),
                new CourseGrade("Non-CS GPA", 43)
        );

        List<Job> workExperience = new ArrayList<>(
                Arrays.asList(

                        new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                                "Internship",
                                new ArrayList<>(Arrays.asList(
                                        new SkillsUSed("React"),
                                        new SkillsUSed("github"),
                                        new SkillsUSed("Figma"),
                                        new SkillsUSed("Java")))
                        ),
                        new Job("Ashesi Peer coach", "Mentor 2+ students. Collaborate with team",
                                "Internship",
                                new ArrayList<>(Arrays.asList(
                                        new SkillsUSed("leadership"),
                                        new SkillsUSed("mentorship"),
                                        new SkillsUSed("communication")
                                )

                                )

                        )


                )
        );

        ArrayList<Project>  projects = new ArrayList<>(
                Arrays.asList(
                        new Project("Event Archieve", "Build event with Java and OOP concept. I pushed to github private and submitted for a review",
                                new ArrayList<>(Arrays.asList(
                                        new SkillsUSed("Java"),
                                        new SkillsUSed("OOP"),
                                        new SkillsUSed("Github"),
                                        new SkillsUSed("review"),
                                        new SkillsUSed("UML")

                                )
                                )
                        ),
                        new Project("GPA Calculator", "Build a GPA calculator with Python. I collaborated and lead a team complete this project",
                                new ArrayList<>(Arrays.asList(
                                        new SkillsUSed("HTML"),
                                        new SkillsUSed("OOP"),
                                        new SkillsUSed("Github"),
                                        new SkillsUSed("Python"),
                                        new SkillsUSed("UML")

                                )
                                )
                        )
                )
        );


        Applicant testApplicant = new Applicant("Tana", grades,  projects, workExperience);

        // Job Description
        List<String> requiredKeywords = new ArrayList<>(Arrays.asList(
                "ECONOMICS",
                "COLLABORATE",
                "LEAD",
                "BUILD",
                "PULL REQUEST",
                "NEGOTIATION",
                "LEADERSHIP",
                "REVIEW",
                "COACH",
                "MENTOR"
        ));

        List<String> requiredSkills = new ArrayList<>(Arrays.asList(
                "MICROSOFT",
                "TEACHING",
                "MATHEMATICS",
                "COMMUNICATION"
        ));

        assertFalse(SimpleIf.analyzeApplicant2(
                testApplicant,
                80,
                requiredKeywords,
                requiredSkills,
                "Economics Lecturer"
        ));




    }


   /*
   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */
   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException    {
      assertEquals(0, Applicant.class.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue(expectedMethodNames.size()+2 >= publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)       {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }


}
