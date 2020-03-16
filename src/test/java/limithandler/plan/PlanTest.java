package limithandler.plan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlanTest {

    private static final int NEW_LIMIT = 42;

    private static Stream<Arguments> provideUnmodifiablePlans() {
        return Stream.of(
                Arguments.of(Plan.FREE),
                Arguments.of(Plan.DEVELOPER),
                Arguments.of(Plan.ORGANIZATION)
        );
    }

    @ParameterizedTest
    @MethodSource("provideUnmodifiablePlans")
    public void shouldNotBeModifiable(Plan plan) {
        // WHEN
        boolean isModifiable = plan.isModifiable();

        // THEN
        assertFalse(isModifiable);
    }

    @ParameterizedTest
    @MethodSource("provideUnmodifiablePlans")
    public void shouldNotModifyConcurrentBuilds(Plan plan) {
        // GIVEN
        Integer concurrentBuilds = plan.getConcurrentBuilds();

        // WHEN
        Executable executable = () -> plan.setConcurrentBuilds(NEW_LIMIT);

        // THEN
        assertThrows(UnsupportedOperationException.class, executable);
    }

    @ParameterizedTest
    @MethodSource("provideUnmodifiablePlans")
    public void shouldNotModifyBuildTime(Plan plan) {
        // GIVEN
        Integer buildTime = plan.getBuildTime();

        // WHEN
        Executable executable = () -> plan.setBuildTime(NEW_LIMIT);

        // THEN
        assertThrows(UnsupportedOperationException.class, executable);
    }

    @ParameterizedTest
    @MethodSource("provideUnmodifiablePlans")
    public void shouldNotModifyBuildsPerMonth(Plan plan) {
        // GIVEN
        Integer buildsPerMonth = plan.getBuildsPerMonth();

        // WHEN
        Executable executable = () -> plan.setBuildsPerMonth(NEW_LIMIT);

        // THEN
        assertThrows(UnsupportedOperationException.class, executable);
    }

    @ParameterizedTest
    @MethodSource("provideUnmodifiablePlans")
    public void shouldNotModifyTeamMembers(Plan plan) {
        // GIVEN
        Integer teamMembers = plan.getTeamMembers();

        // WHEN
        Executable executable = () -> plan.setTeamMembers(NEW_LIMIT);

        // THEN
        assertThrows(UnsupportedOperationException.class, executable);
    }

    @Test
    public void shouldBeModifiable() {
        // GIVEN
        Plan plan = new Plan(Plan.PUBLIC_DEFAULT);

        // WHEN
        boolean isModifiable = plan.isModifiable();

        // THEN
        assertTrue(isModifiable);
    }

    @Test
    public void shouldModifyConcurrentBuilds() {
        // GIVEN
        Plan plan = new Plan(Plan.PUBLIC_DEFAULT);

        // WHEN
        plan.setConcurrentBuilds(NEW_LIMIT);

        // THEN
        assertEquals(NEW_LIMIT, plan.getConcurrentBuilds());
    }

    @Test
    public void shouldModifyBuildTime() {
        // GIVEN
        Plan plan = new Plan(Plan.PUBLIC_DEFAULT);

        // WHEN
        plan.setBuildTime(NEW_LIMIT);

        // THEN
        assertEquals(NEW_LIMIT, plan.getBuildTime());
    }

    @Test
    public void shouldModifyBuildsPerMonth() {
        // GIVEN
        Plan plan = new Plan(Plan.PUBLIC_DEFAULT);

        // WHEN
        plan.setBuildsPerMonth(NEW_LIMIT);

        // THEN
        assertEquals(NEW_LIMIT, plan.getBuildsPerMonth());
    }

    @Test
    public void shouldModifyTeamMembers() {
        // GIVEN
        Plan plan = new Plan(Plan.PUBLIC_DEFAULT);

        // WHEN
        plan.setTeamMembers(NEW_LIMIT);

        // THEN
        assertEquals(NEW_LIMIT, plan.getTeamMembers());
    }
}
