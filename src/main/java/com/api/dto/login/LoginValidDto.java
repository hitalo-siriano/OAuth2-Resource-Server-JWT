package com.api.dto.login;

import java.util.UUID;

public record LoginValidDto(UUID id , String name,String password,String role) {

}
