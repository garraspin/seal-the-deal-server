package controllers;

import models.Datastore;
import play.mvc.Controller;
import play.mvc.Result;

public class GcmController extends Controller {
    public static Result register() {
        String regId = form().bindFromRequest().get("regId");
        String userId = form().bindFromRequest().get("userId");
        Datastore.register(regId, userId);
        return ok();
    }

    public static Result unregister() {
        String regId = form().bindFromRequest().get("regId");
        Datastore.unregister(regId);
        return ok();
    }

    public static Result registrated() {
        return ok(Datastore.getDevices().toString());
    }

}
