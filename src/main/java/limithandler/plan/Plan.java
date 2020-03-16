package limithandler.plan;

public class Plan {

    public static final Plan FREE = new Plan(1, 10, 200, 2, false);
    public static final Plan DEVELOPER = new Plan(2, 45, null, null, false);
    public static final Plan ORGANIZATION = new Plan(4, 90, null, null, false);
    public static final Plan PUBLIC_DEFAULT = new Plan(2, 45, null, null, true);

    private final boolean modifiable;

    private Integer concurrentBuilds;
    private Integer buildTime;
    private Integer buildsPerMonth;
    private Integer teamMembers;

    private Plan(Integer concurrentBuilds, Integer buildTime, Integer buildsPerMonth, Integer teamMembers, boolean modifiable) {
        this.concurrentBuilds = concurrentBuilds;
        this.buildTime = buildTime;
        this.buildsPerMonth = buildsPerMonth;
        this.teamMembers = teamMembers;
        this.modifiable = modifiable;
    }

    public Plan(Plan plan) {
        this(plan.concurrentBuilds, plan.buildTime, plan.buildsPerMonth, plan.teamMembers, plan.modifiable);
    }

    public Integer getConcurrentBuilds() {
        return concurrentBuilds;
    }

    public Integer getBuildTime() {
        return buildTime;
    }

    public Integer getBuildsPerMonth() {
        return buildsPerMonth;
    }

    public Integer getTeamMembers() {
        return teamMembers;
    }

    public boolean isModifiable() {
        return modifiable;
    }

    public void setConcurrentBuilds(Integer concurrentBuilds) {
        if (modifiable) {
            this.concurrentBuilds = concurrentBuilds;
        } else {
            throw new UnsupportedOperationException("Plan is not modifiable");
        }
    }

    public void setBuildTime(Integer buildTime) {
        if (modifiable) {
            this.buildTime = buildTime;
        } else {
            throw new UnsupportedOperationException("Plan is not modifiable");
        }
    }

    public void setBuildsPerMonth(Integer buildsPerMonth) {
        if (modifiable) {
            this.buildsPerMonth = buildsPerMonth;
        } else {
            throw new UnsupportedOperationException("Plan is not modifiable");
        }
    }

    public void setTeamMembers(Integer teamMembers) {
        if (modifiable) {
            this.teamMembers = teamMembers;
        } else {
            throw new UnsupportedOperationException("Plan is not modifiable");
        }
    }
}
