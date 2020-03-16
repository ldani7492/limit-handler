package limithandler.app;

import limithandler.plan.Usage;
import limithandler.user.User;

public class PrivateApp extends App {

    public PrivateApp(User owner) {
        super(owner);
    }

    @Override
    public Usage getUsage() {
        return owner.getUsage();
    }
}
