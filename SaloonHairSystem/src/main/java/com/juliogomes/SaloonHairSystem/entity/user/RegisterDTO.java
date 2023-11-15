package com.juliogomes.SaloonHairSystem.entity.user;


public record RegisterDTO(String login, String password, UserRole role) {
}
