package doit.blog.controller;


import java.util.List;

public record ListWrapper<T>(
        List<T> result
) {
    public static <T> ListWrapper<T> of(List<T> result) {
        return new ListWrapper<T>(result);
    }
}
