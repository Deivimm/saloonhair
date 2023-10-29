package com.juliogomes.SaloonHairSystem.entity;

import com.juliogomes.SaloonHairSystem.entity.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
