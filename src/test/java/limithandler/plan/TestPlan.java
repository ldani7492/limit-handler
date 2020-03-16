package limithandler.plan;

public enum TestPlan {

    FREE(1, 10, 200, 2),
    DEVELOPER(2, 45, null, null),
    ORGANIZATION(4, 90, null, null),
    PUBLIC_DEFAULT(2, 45, null, null);

    public final Integer concurrentBuilds;
    public final Integer buildTime;
    public final Integer buildsPerMonth;
    public final Integer teamMembers;

    TestPlan(Integer concurrentBuilds, Integer buildTime, Integer buildsPerMonth, Integer teamMembers) {
        this.concurrentBuilds = concurrentBuilds;
        this.buildTime = buildTime;
        this.buildsPerMonth = buildsPerMonth;
        this.teamMembers = teamMembers;
    }
}
