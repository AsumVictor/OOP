package Lab2.part2;

import java.util.List;

public class Job {
    private String role;
    private String summary;
    private String jobType;
    private List<SkillsUSed> skillRequired;

    public Job( String role,
     String summary,
     String jobType,
     List<SkillsUSed> skillRequired){
        this.jobType = jobType;
        this.summary = summary.toLowerCase().trim();
        this.role = role.toLowerCase().trim();
        this.skillRequired = skillRequired;

    }

    public List<SkillsUSed> getSkillRequired() {
        return skillRequired;
    }

    public String getRole() {
        return role;
    }

    public String getSummary() {
        return summary;
    }

    public String getJobType() {
        return jobType;
    }
}
