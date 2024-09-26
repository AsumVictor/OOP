package Lab2.part1;

import Lab2.part2.Job;
import Lab2.part2.Project;
import Lab2.part2.SkillsUSed;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SimpleLoop {
  private static final int jobRoleMatchWeight = 15;
  public static final DecimalFormat formatter = new DecimalFormat("#.####");
  /**
   * Computes the sum of integers between low and high (inclusive). Yes, this can
   * be done without a loop, but the point is to practice the syntax for a loop.
   * 
   * @param low
   * @param high
   * @return An integer that is the sum of numbers between low and high
   */
  public static int sum(int low, int high) {
    int sum = 0;
    for(int i = low; i <= high; i++){
      sum += i;
    }
    return sum;
  }



  // MY OWN METHODS
  /**
   * This method takes the applicants work history/experience and match if the application has done a job related to the current open job title
   *
   *
   * @param workExps Work history/experience of the applicant
   * @param JobRole The open role the company is looking for.
   * @return return an integer which is the score based on whether the applicant has had a similar role in their past years
   */

  public static int matchJobRoleScore(List<Job> workExps, String JobRole){
     for(Job workExp: workExps){
       if(workExp.getRole().equals(JobRole.toLowerCase().trim())){
         return jobRoleMatchWeight;
       }
     }

     return 0;
  }


  /**
   * It checks how the keywords in the applicants projects and work experience relate to the open job role and generate a score
   *
   * @param workExps The work Experience of the applicant
   * * @param List of open job required keywords
   * @return A double that is the score of how the application keywords relates to the role keywords
   */
  public static double keywordMatchScore(List<Job> workExps, List<String> jobKeywords){
    HashSet<String> keywords = new HashSet<>();
    keywords.addAll(jobKeywords);

    int totalKeyWords = keywords.size();


    for(Job job: workExps){

      String[] applicantJobKeyWords = job.getSummary().replace(".", "").split(" ");

      for(String applicantKeyword: applicantJobKeyWords){
              String applicantKeywordUpper = applicantKeyword.trim().toUpperCase();
             if(keywords.contains(applicantKeywordUpper)){
               keywords.remove(applicantKeywordUpper);
             }
      }

    }

    int remaindLength = keywords.size();
    int totalApplicantKeywordMatch = totalKeyWords - remaindLength;
    double applicantScore = (double) totalApplicantKeywordMatch / totalKeyWords;

    return Double.parseDouble(formatter.format(applicantScore));
  }

  public static double keywordMatchScore(ArrayList<Project> projects, List<String> jobKeywords){
    HashSet<String> keywords = new HashSet<>();
    keywords.addAll(jobKeywords);

    int totalKeyWords = keywords.size();


    for(Project project: projects){

      String[] applicantJobKeyWords = project.getSummary().replace(".", "").split(" ");

      for(String applicantKeyword: applicantJobKeyWords){
        String applicantKeywordUpper = applicantKeyword.trim().toUpperCase();
        if(keywords.contains(applicantKeywordUpper)){
          keywords.remove(applicantKeywordUpper);
        }
      }

    }

    int remaindLength = keywords.size();
    int totalApplicantKeywordMatch = totalKeyWords - remaindLength;
    double applicantScore = (double) totalApplicantKeywordMatch / totalKeyWords;

    return Double.parseDouble(formatter.format(applicantScore));
  }

  /**
   * It generates a score how based how the applicants has the required skills specified in the job. It compares the skills compared to the required skills
   *
   * @param workExperiences The work Experience of the applicant
   * @param jobSkillsReqired List of skills required for the job
   * @return A double that is the score of how the application skills relates to the role keywords
   */
  public static double skillMatchScore(List<Job> workExperiences, List<String> jobSkillsReqired){
    HashSet<String> requireSkills = new HashSet<>();
    requireSkills.addAll(jobSkillsReqired);
    int totalJobSkillsReqired = requireSkills.size();

    for(Job workeExperience: workExperiences){

      for(SkillsUSed applicantSkill: workeExperience.getSkillRequired()){
        if(requireSkills.contains(applicantSkill.getName().toUpperCase())){
          requireSkills.remove(applicantSkill.getName().toUpperCase());
        }
      }

    }

    int remaindLength = requireSkills.size();
    int totalApplicantSkillMatch = totalJobSkillsReqired - remaindLength;
    double applicantScore = (double) totalApplicantSkillMatch / totalJobSkillsReqired;

    return Double.parseDouble(formatter.format(applicantScore));

  }

  public static double skillMatchScore(ArrayList<Project> workExperiences, List<String> jobSkillsReqired){
    HashSet<String> requireSkills = new HashSet<>();
    requireSkills.addAll(jobSkillsReqired);
    int totalJobSkillsReqired = requireSkills.size();

    for(Project workeExperience: workExperiences){

      for(SkillsUSed applicantSkill: workeExperience.getSkillUsed()){
        if(requireSkills.contains(applicantSkill.getName().toUpperCase())){
          requireSkills.remove(applicantSkill.getName().toUpperCase());
        }
      }

    }

    int remaindLength = requireSkills.size();
    int totalApplicantSkillMatch = totalJobSkillsReqired - remaindLength;
    double applicantScore = (double) totalApplicantSkillMatch / totalJobSkillsReqired;

    return Double.parseDouble(formatter.format(applicantScore));

  }



}
