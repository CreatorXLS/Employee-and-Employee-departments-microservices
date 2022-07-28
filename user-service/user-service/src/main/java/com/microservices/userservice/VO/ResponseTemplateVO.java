package com.microservices.userservice.VO;

import com.microservices.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    //Contains both User and Department objects and will be used as a return type
    private User user;
    private Department department;
}
