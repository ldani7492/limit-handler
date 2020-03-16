package limithandler.app;

import limithandler.plan.Plan;
import limithandler.plan.TestPlan;
import limithandler.plan.Usage;
import limithandler.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PublicAppTest {
    
    private static final int NEW_LIMIT = 42;

    @Test
    void shouldUseDefaultPublicPlan() {
        // GIVEN
        User user = new User(Plan.FREE);
        
        // WHEN
        PublicApp app = new PublicApp(user);
        
        // THEN
        Usage actualUsage = app.getUsage();
        Plan actualPlan = actualUsage.getPlan();
        assertEquals(TestPlan.PUBLIC_DEFAULT.concurrentBuilds, actualPlan.getConcurrentBuilds());
        assertEquals(TestPlan.PUBLIC_DEFAULT.buildTime, actualPlan.getBuildTime());
        assertEquals(TestPlan.PUBLIC_DEFAULT.buildsPerMonth, actualPlan.getBuildsPerMonth());
        assertEquals(TestPlan.PUBLIC_DEFAULT.teamMembers, actualPlan.getTeamMembers());
        assertTrue(actualPlan.isModifiable());
        assertEquals(0, actualUsage.getConcurrentBuilds());
        assertEquals(0, actualUsage.getBuildTime());
        assertEquals(0, actualUsage.getBuildsPerMonth());
        assertEquals(0, actualUsage.getTeamMembers());
        assertEquals(user, app.getOwner());
        assertFalse(app.isUsesUserLimits());
    }

    @Test
    void shouldModifyConcurrentBuildsLimit() {
        // GIVEN
        User user = new User(Plan.FREE);
        PublicApp app = new PublicApp(user);
        
        // WHEN
        app.setConcurrentBuilds(NEW_LIMIT);
        
        // THEN
        assertEquals(NEW_LIMIT, app.getPlan().getConcurrentBuilds());
    }

    @Test
    void shouldModifyBuildTimeLimit() {
        // GIVEN
        User user = new User(Plan.FREE);
        PublicApp app = new PublicApp(user);
        
        // WHEN
        app.setBuildTime(NEW_LIMIT);
        
        // THEN
        assertEquals(NEW_LIMIT, app.getPlan().getBuildTime());
    }

    @Test
    void shouldModifyBuildsPerMonthLimit() {
        // GIVEN
        User user = new User(Plan.FREE);
        PublicApp app = new PublicApp(user);
        
        // WHEN
        app.setBuildsPerMonth(NEW_LIMIT);
        
        // THEN
        assertEquals(NEW_LIMIT, app.getPlan().getBuildsPerMonth());
    }

    @Test
    void shouldModifyTeamMembersLimit() {
        // GIVEN
        User user = new User(Plan.FREE);
        PublicApp app = new PublicApp(user);
        
        // WHEN
        app.setTeamMembers(NEW_LIMIT);
        
        // THEN
        assertEquals(NEW_LIMIT, app.getPlan().getTeamMembers());
    }

    @Test
    void shouldSwitchToUserPlan() {
        // GIVEN
        User user = new User(Plan.FREE);
        PublicApp app = new PublicApp(user);

        // WHEN
        app.useUserLimits();

        // THEN
        assertTrue(app.isUsesUserLimits());

    }
}
