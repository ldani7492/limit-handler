package limithandler.app;

import limithandler.plan.Plan;
import limithandler.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrivateAppTest {

    @Test
    void shouldUseOwnersUsage() {
        // GIVEN
        User user = new User(Plan.FREE);

        // WHEN
        App app = new PrivateApp(user);

        // THEN
        assertEquals(user, app.getOwner());
        assertEquals(user.getUsage(), app.getUsage());
    }
}
