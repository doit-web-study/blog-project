package doit.blog.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserIdResponse(
        @Schema(description = "유저 식별 ID", example = "1")
        Long userId
) {
}
