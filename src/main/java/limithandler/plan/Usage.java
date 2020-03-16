package limithandler.plan;

public class Usage {

    private Plan plan;

    private int concurrentBuilds;
    private int buildTime;
    private int buildsPerMonth;
    private int teamMembers;

    public Usage(Plan plan) {
        this.plan = plan;
        this.concurrentBuilds = 0;
        this.buildTime = 0;
        this.buildsPerMonth = 0;
        this.teamMembers = 0;
    }

    public Plan getPlan() {
        return plan;
    }

    public int getConcurrentBuilds() {
        return concurrentBuilds;
    }

    public int getBuildTime() {
        return buildTime;
    }

    public int getBuildsPerMonth() {
        return buildsPerMonth;
    }

    public int getTeamMembers() {
        return teamMembers;
    }
}
