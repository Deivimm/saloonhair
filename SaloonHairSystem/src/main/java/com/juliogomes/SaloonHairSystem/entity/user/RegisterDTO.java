package com.juliogomes.SaloonHairSystem.entity.user;


public record RegisterDTO(String name, String login, String password, UserRole role) {
}
