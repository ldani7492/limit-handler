package limithandler.user;

import limithandler.app.App;
import limithandler.app.PrivateApp;
import limithandler.app.PublicApp;
import limithandler.plan.Plan;
import limithandler.plan.TestPlan;
import limithandler.plan.Usage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    private static Stream<Arguments> providePlansForUserCreation() {
        return Stream.of(
                Arguments.of(Plan.FREE, TestPlan.FREE),
                Arguments.of(Plan.DEVELOPER, TestPlan.DEVELOPER),
                Arguments.of(Plan.ORGANIZATION, TestPlan.ORGANIZATION)
        );
    }

    @ParameterizedTest
    @MethodSource("providePlansForUserCreation")
    void shouldCreateUserWithPlan(Plan plan, TestPlan expectedPlan) {
        // WHEN
        User user = new User(plan);

        // THEN
        Usage actualUsage = user.getUsage();
        Plan actualPlan = actualUsage.getPlan();
        assertEquals(0, actualUsage.getConcurrentBuilds());
        assertEquals(0, actualUsage.getBuildTime());
        assertEquals(0, actualUsage.getBuildsPerMonth());
        assertEquals(0, actualUsage.getTeamMembers());
        assertFalse(actualPlan.isModifiable());
        assertEquals(expectedPlan.concurrentBuilds, actualPlan.getConcurrentBuilds());
        assertEquals(expectedPlan.buildTime, actualPlan.getBuildTime());
        assertEquals(expectedPlan.buildsPerMonth, actualPlan.getBuildsPerMonth());
        assertEquals(expectedPlan.teamMembers, actualPlan.getTeamMembers());
    }

    @Test
    void shouldCreatePrivateApp() {
        // GIVEN
        User user = new User(Plan.FREE);

        // WHEN
        App app = user.createApp(false);

        // THEN
        assertTrue(app instanceof PrivateApp);
    }

    @Test
    void shouldCreatePublicApp() {
        // GIVEN
        User user = new User(Plan.FREE);

        // WHEN
        App app = user.createApp(true);

        // THEN
        assertTrue(app instanceof PublicApp);
    }
}
