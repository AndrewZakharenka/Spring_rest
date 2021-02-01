package com.rest_spring_boot.converter;

import java.util.List;

public interface IConverter<S, T> {
    T convert(S s);
    S convertReverse(T t);
    List<T> convertAll(List<S> s);
}
