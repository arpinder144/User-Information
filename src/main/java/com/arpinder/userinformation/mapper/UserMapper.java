package com.arpinder.userinformation.mapper;

import com.arpinder.userinformation.dto.UserDTO;
import com.arpinder.userinformation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO UserToUserDTO(User user);
    User UserDTOToUser(UserDTO userDTO);
}
