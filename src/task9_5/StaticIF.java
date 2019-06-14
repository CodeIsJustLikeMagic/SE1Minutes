package task9_5;

@FunctionalInterface
public interface StaticIF<T, R> {
	
	R apply(T t);

}
