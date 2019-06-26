package task9_5;

@FunctionalInterface
public interface StaticIF<T, G, R> {
	
	R apply(T t, G g);

}
