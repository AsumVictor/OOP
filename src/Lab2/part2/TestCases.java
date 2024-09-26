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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
              new CourseGrade("Non-CS", 43)
      );
      Applicant testApplicant = new Applicant("Victor", grades,  new ArrayList<>(), new ArrayList<>());
      CourseGrade expected = grades.get(4);
      assertEquals(expected, testApplicant.getGradeFor("Operating Systems"));
   }

   @Test
   public void testGetGradeFor3(){
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 43),
              new CourseGrade("Data Structures", 65),
              new CourseGrade("Algorithms", 64),
              new CourseGrade("Computer Organization", 75),
              new CourseGrade("Operating Systems", 84),
              new CourseGrade("Non-CS GPA", 43)
      );
      Applicant testApplicant = new Applicant("Victor", grades, new ArrayList<>(), new ArrayList<>());
      CourseGrade expected = grades.get(5);
      assertEquals(expected, testApplicant.getGradeFor("Non-CS GPA"));
   }

   @Test
   public void testGetGradeFor4(){
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

      assertTrue(expectedMethodNames.size()+1 >= publicMethods.size(),
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
