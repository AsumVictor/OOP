package Lab2.part1;

import Lab2.part2.Applicant;
import Lab2.part2.Job;
import Lab2.part2.Project;

import java.util.List;

public class SimpleIf {
  public static final double minimumWorkRequired = 3;
  public static final double minimumWorkRequiredWeight = 15;

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   *
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    return avg > threshold;
  }

  public static boolean analyzeApplicant2(Applicant applicant, double threshold, List<String> jobKeywords, List<String> jobSkills, String jobRole){

      int roleMatchScore = SimpleLoop.matchJobRoleScore(applicant.getWorkExperiences(), jobRole);

      double minWorkExperienceScore = minWorkExpWeight(applicant.getWorkExperiences());

      double keyworkScore1 = SimpleLoop.keywordMatchScore(applicant.getWorkExperiences(), jobKeywords);
      double keyworkScore2 = SimpleLoop.keywordMatchScore(applicant.getProjects(), jobKeywords);

      double overralKeywordScore = maxAverage(keyworkScore1, keyworkScore2);

      double skillMatchScore = SimpleLoop.skillMatchScore(applicant.getWorkExperiences(), jobSkills);
      double skillMatchScore1 = SimpleLoop.skillMatchScore(applicant.getProjects(), jobSkills);









      return false;
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
      if(avg1 > avg2) return avg1;

      if (avg1 < avg2) return avg2;

      return avg1;
  }
  
  
  // MY OWN METHODS
  /**
   * Takes applicants' work experience and take mininum work experience and evaluate the weight based
   *
   * @param workEx The first applicant's average score
   * @return the higher average score
   */
  public static double minWorkExpWeight(List<Job> workEx ){
     int numberOfExperience = workEx.size();


     if(numberOfExperience >= minimumWorkRequired) return minimumWorkRequiredWeight;

     return (numberOfExperience / minimumWorkRequired) * minimumWorkRequiredWeight;

  }



}
