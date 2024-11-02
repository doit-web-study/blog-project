package doit.blog.controller;

import java.util.List;

public record ListWrapper<T>(
        List<T> result
) {
}
