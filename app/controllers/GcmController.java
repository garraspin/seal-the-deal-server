package controllers;

import com.google.common.base.Function;
import models.Datastore;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static com.google.common.collect.Lists.transform;

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
        List<String> devices = Datastore.getDevices();
        List<String> result = transform(devices, new Function<String, String>() {
            @Override
            public String apply(String regId) {

                return String.format("UserId: %s -> regId: %s", Datastore.getUserId(regId), regId);
            }
        });
        return ok(result.toString());
    }

    public static Result cleanGcm() {
        Datastore.clean();
        return ok();
    }

}
