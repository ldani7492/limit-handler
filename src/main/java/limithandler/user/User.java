package limithandler.user;

import limithandler.app.App;
import limithandler.app.PrivateApp;
import limithandler.app.PublicApp;
import limithandler.plan.Plan;
import limithandler.plan.Usage;

public class User {

    private final Usage usage;

    public User(Plan plan) {
        this.usage = new Usage(plan);
    }

    public App createApp(boolean isPublic) {
        return isPublic ? new PublicApp(this) : new PrivateApp(this);
    }

    public Usage getUsage() {
        return usage;
    }
}
