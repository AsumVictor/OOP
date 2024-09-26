package Lab2.part1;

import Lab2.part2.Applicant;
import Lab2.part2.Job;
import Lab2.part2.Project;

import java.util.List;

public class SimpleIf {
  public static final double minimumWorkRequired = 3;
  public static final double minimumWorkRequiredWeight = 15;
  public static final int keywordMatchWeight = 25;
    public static final int skillsMatchWeight = 45;


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


    /**
     * Takes an applicant's information and its information (all information). The method also accepts the job skills required, job keywords and job titile.
     * This method analyse the applicants work history and project list and generate a score based on how the applicant previous skill, the role, and project relate
     * to the job. The method return True  if the overall score generated is higher than a specific threshold.
     *
     *
     * @param applicant the applicants information
     * @param threshold The threshold applicants resume strength score
     * @param jobKeywords List of essential keywords of the job
     * @param jobSkills LIst of essential skills for the job
     * @param jobRole The title of the job role
     * @return true if the applicant's resume strength is over the threshold, and false otherwise
     */
  public static boolean analyzeApplicant2(Applicant applicant, double threshold, List<String> jobKeywords, List<String> jobSkills, String jobRole){

      int roleMatchScore = SimpleLoop.matchJobRoleScore(applicant.getWorkExperiences(), jobRole);

      double minWorkExperienceScore = minWorkExpWeight(applicant.getWorkExperiences());

      double keyworkScore1 = SimpleLoop.keywordMatchScore(applicant.getWorkExperiences(), jobKeywords);
      double keyworkScore2 = SimpleLoop.keywordMatchScore(applicant.getProjects(), jobKeywords);

      double overalKeywordScore = maxAverage(keyworkScore1, keyworkScore2) * keywordMatchWeight;

      double skillMatchScore1 = SimpleLoop.skillMatchScore(applicant.getWorkExperiences(), jobSkills);
      double skillMatchScore2 = SimpleLoop.skillMatchScore(applicant.getProjects(), jobSkills);
      double overalSkillScore = maxAverage(skillMatchScore1, skillMatchScore2) * skillsMatchWeight;

      double totalApplicantScore = roleMatchScore + minWorkExperienceScore + overalSkillScore + overalKeywordScore;

      return totalApplicantScore > threshold;
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
   * Takes applicants work experience job history and check if it is above 3
   *
   * @param workEx The applicant's job history
   * @return true if the job history is more than 2
   */
  public static double minWorkExpWeight(List<Job> workEx ){
     int numberOfExperience = workEx.size();


     if(numberOfExperience >= minimumWorkRequired) return minimumWorkRequiredWeight;

     return (numberOfExperience / minimumWorkRequired) * minimumWorkRequiredWeight;

  }



}
