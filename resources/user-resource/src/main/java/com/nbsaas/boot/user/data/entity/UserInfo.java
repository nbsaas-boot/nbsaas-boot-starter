/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.BeanExt;
import com.nbsaas.boot.code.annotation.FormExtField;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author ada
 */

@BeanExt(items={@FormExtField(fieldName = "structureIds", parentField = "ids", parent = "structure", fieldClass = String.class)})
@org.hibernate.annotations.Table(appliesTo = "user_info",comment = "用户")
@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends AbstractUser {

    @Comment("用户状态")
    private StoreState storeState;

    @Comment("账号")
    @Column(length = 50)
    private String accountNo;

    public static UserInfo fromId(Long id) {
        UserInfo result = new UserInfo();
        result.setId(id);
        return result;
    }


}
