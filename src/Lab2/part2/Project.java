package Lab2.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project {
    private String title;
    private String summary;
    private List<SkillsUSed> skillUsed = new ArrayList();

    public Project(String title, String summary, List<SkillsUSed> skillUsed ){
        this.title = title.toLowerCase().trim();
        this.skillUsed = skillUsed;
        this.summary = summary.toLowerCase().trim();
    }

    public String getTitle(){
        return title;
    }

    public List<SkillsUSed> getSkillUsed(){
        return skillUsed;
    }

    public String getSummary(){
        return  summary;
    }

}
