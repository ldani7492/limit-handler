package limithandler.app;

import limithandler.plan.Usage;
import limithandler.user.User;

public abstract class App {

    protected final User owner;

    public App(User owner) {
        this.owner = owner;
    }

    public abstract Usage getUsage();

    public User getOwner() {
        return owner;
    }
}
