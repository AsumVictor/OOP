package Lab2.part2;

public class SkillsUSed {
    private String name;

    public SkillsUSed(String name){

        this.name = name.trim().toLowerCase();
    }

    public String getName(){
        return name;
    }

}
