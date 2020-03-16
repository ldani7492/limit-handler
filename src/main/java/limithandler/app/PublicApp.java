package limithandler.app;

import limithandler.plan.Plan;
import limithandler.plan.Usage;
import limithandler.user.User;

public class PublicApp extends App {

    private Usage usage;
    private boolean usesUserLimits;

    public PublicApp(User owner) {
        super(owner);
        this.usage = new Usage(new Plan(Plan.PUBLIC_DEFAULT));
        this.usesUserLimits = false;
    }

    public void useUserLimits() {
        usage = owner.getUsage();
        usesUserLimits = true;
    }

    @Override
    public Usage getUsage() {
        return usage;
    }

    public Plan getPlan() {
        return !usesUserLimits ? usage.getPlan() : null;
    }

    public boolean isUsesUserLimits() {
        return usesUserLimits;
    }

    public void setConcurrentBuilds(int concurrentBuilds) {
        usage.getPlan().setConcurrentBuilds(concurrentBuilds);
    }

    public void setBuildTime(int buildTime) {
        usage.getPlan().setBuildTime(buildTime);
    }

    public void setBuildsPerMonth(int buildsPerMonth) {
        usage.getPlan().setBuildsPerMonth(buildsPerMonth);
    }

    public void setTeamMembers(int teamMembers) {
        usage.getPlan().setTeamMembers(teamMembers);
    }
}
