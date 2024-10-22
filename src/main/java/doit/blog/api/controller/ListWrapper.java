package doit.blog.api.controller;

import java.util.List;

public record ListWrapper<T>(
        List<T> result
) {
}
