package app.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//pravim moju anotaciju, source anotacije bi mogle bii hintovi za editore ili progamere, da se oboji podvuce itd., 
//class isto sto i source ali vidljive u gotovim klasama, runtime mozemo da dobavimo da li je nesto anotirano sa necim

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggedMethod {

}
