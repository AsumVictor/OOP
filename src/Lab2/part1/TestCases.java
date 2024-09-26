package Lab2.part1;

import java.util.*;

import Lab2.part2.Job;
import Lab2.part2.Project;
import Lab2.part2.SkillsUSed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases {
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant1()    {
      assertTrue(SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()    {
      assertFalse(SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3()    {
      /* TO DO: Write one more valid test case. */
      assertFalse(SimpleIf.analyzeApplicant(99.03, 99.0300001));
   }

   @Test
   public void testMaxAverage1() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      /* TO DO: Write one more valid test case. */
      assertEquals(SimpleIf.maxAverage(33.3, 33.3001), 33.3001, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()    {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()    {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()    {

      /* TO DO: Write one more valid test case to make sure that
         this function is not just returning 7. */
      assertEquals(63, SimpleLoop.sum(8,13));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()    {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()    {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()   {

      /* TO DO: Add a new test case. */
      assertArrayEquals(
              new boolean[] {true, true, false, true, false, false},
              SimpleArray.applicantAcceptable(new int[] {80, 83, 67, 71, 42, 34}, 68));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()   {
      List<Integer> input =
         new LinkedList<Integer>(Arrays.asList(new Integer[] {80, 85, 89, 92, 76, 81}));
      List<Boolean> expected =
         new ArrayList<Boolean>(Arrays.asList(new Boolean[] {false, false, true, true, false, false}));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()   {
      /* TO DO: Add a new test case. */
      List<Integer> scores =
              new LinkedList<Integer>(Arrays.asList(new Integer[] {100, 45, 89, 81, 56, 53}));
      List<Boolean> expected_boolean =
              new ArrayList<Boolean>(Arrays.asList(new Boolean[] {true, false, true, true, false, false}));

      assertEquals(expected_boolean, SimpleList.applicantAcceptable(scores, 78));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85_1()   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {86, 87, 90, 82, 83, 90}));
   }

   @Test
   public void testFourOver85_3()   {
      /* TO DO: Write a valid test case where the expected result is false. */
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {45, 75, 56, 22, 77, 44, 85, 87, 85, 85, 93, 85}));

   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Mary",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Sam",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Sara",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Mary", "Sara");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2()    {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();

      courseListsByStudent.put("Victor",
              Arrays.asList(
                      new CourseGrade("CPE 111", 95),
                      new CourseGrade("CPE 211", 88),
                      new CourseGrade("CPE 305", 92),
                      new CourseGrade("CPE 330", 84)));

      courseListsByStudent.put("Eldad",
              Arrays.asList(
                      new CourseGrade("CPE 111", 78),
                      new CourseGrade("CPE 211", 79),
                      new CourseGrade("CPE 305", 81),
                      new CourseGrade("CPE 330", 75)));

      courseListsByStudent.put("Alien",
              Arrays.asList(
                      new CourseGrade("CPE 111", 99),
                      new CourseGrade("CPE 211", 84),
                      new CourseGrade("CPE 305", 96),
                      new CourseGrade("CPE 330", 97)));

      courseListsByStudent.put("Goels",
              Arrays.asList(
                      new CourseGrade("CPE 111", 85),
                      new CourseGrade("CPE 211", 90),
                      new CourseGrade("CPE 305", 87),
                      new CourseGrade("CPE 330", 82)));

      List<String> expected = Arrays.asList();

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 88)));

   }



   ////////////////////////////////////////////////////////////
   //      MY TEST FOR ADDITIONAL FUNCTIONALITY              //
   ////////////////////////////////////////////////////////////

   @Test
   public void minWorkExpWeight1(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(
                      new Job("front end Developer", "Build UI/UX interfaces and REST API integration with",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma")))
                      ),

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
                      )

              )
      );

      assertEquals(10, SimpleIf.minWorkExpWeight(workExperience));

   }

   @Test
   public void minWorkExpWeight2(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(
                      new Job("front end Developer", "Build UI/UX interfaces and REST API integration with",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma")))
                      ),

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
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

      assertEquals(15, SimpleIf.minWorkExpWeight(workExperience));

   }

   @Test
   public void testMatchJobRoleScore1(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(
                      new Job("front end Developer", "Build UI/UX interfaces and REST API integration with",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma")))
                      ),

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
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

      assertEquals(15, SimpleLoop.matchJobRoleScore(workExperience, "front end Developer"));
   }

   @Test
   public void testMatchJobRoleScore2(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
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

      assertEquals(0, SimpleLoop.matchJobRoleScore(workExperience, "Fitness Trainer"));
   }

   @Test
   public void testKeywordsMatchScore1(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(
                      new Job("front end Developer", "Build UI/UX interfaces and REST API integration with",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma")))
                      ),

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
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

      assertEquals(0.7273, SimpleLoop.keywordMatchScore(workExperience,
              new ArrayList<String>(Arrays.asList("UI/UX", "REST", "API", "TEST", "JEST", "OPTIMIZE", "TEAM", "COLLABORATE", "PAIR PROGRAMMING", "WORKLOAD", "SERVER"))
              )

      );



   }

   @Test
   public void testKeywordsMatchScore2(){
      List<Job> workExperience = new ArrayList<>(
              Arrays.asList(
                      new Job("front end Developer", "Build UI/UX interfaces and REST API integration with",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma")))
                      ),

                      new Job("front end Developer", "Write Test for React with Jest. Optimize the load time",
                              "Internship",
                              new ArrayList<>(Arrays.asList(
                                      new SkillsUSed("React"),
                                      new SkillsUSed("Javascript"),
                                      new SkillsUSed("Figma"),
                                      new SkillsUSed("Figma")))
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

      assertEquals(0.2857, SimpleLoop.keywordMatchScore(workExperience,
                      new ArrayList<String>(Arrays.asList("UI/UX","HEALTH","STABLE", "UML", "LEARN", "TEST", "HOT", "OPTIMIZE", "TEAM", "LEAD","HIRING", "PROGRAMMING", "FITNESS", "SERVER"))
              )

      );



   }

   @Test
   public void testKeywordsMatchScore3(){
       ArrayList<Project> workExperience;
       workExperience = new ArrayList<>(
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

       assertEquals(0.5, SimpleLoop.keywordMatchScore(workExperience,
                        new ArrayList<String>(Arrays.asList("PYTHON","BUILD","STABLE","REVIEW", "UML", "LEAD", "TEST","GITHUB", "TEACHING", "COLLABORATED", "OPTIMIZE", "TEAM","HIRING", "PROGRAMMING", "FITNESS", "OOP"))
                )

        );



    }

   @Test
    public void testSkillMatchScore1(){
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

       assertEquals(0.2857, SimpleLoop.skillMatchScore(workExperience,
             new ArrayList<>(Arrays.asList(
                     "JAVA",
                     "GITHUB",
                     "SPRING BOOT",
                     "LOGGING",
                     "AZURE",
                     "UML",
                     "OOP"
             ))
     ));


   }


}
