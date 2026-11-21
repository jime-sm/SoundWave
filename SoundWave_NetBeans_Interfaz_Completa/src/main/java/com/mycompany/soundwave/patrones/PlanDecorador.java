package com.mycompany.soundwave.patrones;
import com.mycompany.soundwave.PlanMusical;
/** Decorator: añade una presentación de beneficios sin cambiar el plan. */
public final class PlanDecorador implements PlanMusical {
 private final PlanMusical base;
 public PlanDecorador(PlanMusical base){this.base=base;}
 @Override public String beneficios(){return "♫  "+base.beneficios()+" · Tu música, a tu ritmo";}
}
