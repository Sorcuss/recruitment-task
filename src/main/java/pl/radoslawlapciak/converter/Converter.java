package pl.radoslawlapciak.converter;

public interface Converter<T1, T2> {

    T1 convertTo(T2 obj);

    T2 convertFrom(T1 obj);

}
