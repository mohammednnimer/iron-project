package org.gs.auth.filters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.gs.auth.session.UserSession;
import org.gs.entity.UsersTbl;
import org.gs.repository.UsersTblRepo;
import org.gs.util.JwtUtils;

@ApplicationScoped
public class FilterMethods {

    @Inject
    JwtUtils jwtUtils;

    @Inject
    UsersTblRepo userRepository;

    private final String[] PUBLIC_PATHS = {
            "/auth/login",
            "/health",
            "/hello"
    };

    public boolean isPathPublic(String path) {
        for (String publicPath : PUBLIC_PATHS) {
            if (path.contains(publicPath)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTokenValid(String jwt, boolean isPathPublic) {
        if (isPathPublic) return true;

        if (jwt == null || jwt.isEmpty()) {
            return false;
        }

        try {
             String userCode = jwtUtils.extractUserCode(jwt);

            UsersTbl user = userRepository.findByUserCode(userCode);


            if (user == null) {
                return false;
            }

            if (user.getActiveToken() == null || !user.getActiveToken().equals(jwt)) {
                return false;
            }

            UserSession.setUser(user);
            return jwtUtils.validateToken(jwt, userCode);

        } catch (Exception e) {
            return false;
        }
    }

    public void createSession(String jwt) {
        String userCode = jwtUtils.extractUserCode(jwt);
        UserSession.setUser(userRepository.findByUserCode(userCode));
    }
}
