package org.gs.auth.session;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class SessionManager {

    @Inject
    RoutingContext routingContext;

    public void setAttribute(String key, Object value) {
        Session session = routingContext.session();
        if (session != null) {
            session.put(key, value);
        }
    }

    public Object getAttribute(String key) {
        Session session = routingContext.session();
        return session != null ? session.get(key) : null;
    }

    public void invalidate() {
        Session session = routingContext.session();
        if (session != null) {
            session.destroy();
        }
    }
}
