package skool.saas.skool.GLOBALE.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import skool.saas.skool.GLOBALE.Entity.AnneeContext;
import skool.saas.skool.GLOBALE.service.AnneeScolaireService;
import skool.saas.skool.GLOBALE.service.AnneeScolaireStateService;

@Component
public class AnneeContextInterceptor implements HandlerInterceptor {

    @Autowired
    private AnneeScolaireService anneeService;   // ⬅︎ on change d’injection

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object handler) {
        AnneeContext.set( anneeService.getAnneeActive() ); // requête SELECT active=true
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res,
                                Object handler,
                                Exception ex) {
        AnneeContext.clear();
    }

}
