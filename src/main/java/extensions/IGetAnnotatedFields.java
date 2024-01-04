package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public interface IGetAnnotatedFields {

  Set<Field> getAnnotatedFields(Class<? extends Annotation> annotation, ExtensionContext extensionContext);
}
