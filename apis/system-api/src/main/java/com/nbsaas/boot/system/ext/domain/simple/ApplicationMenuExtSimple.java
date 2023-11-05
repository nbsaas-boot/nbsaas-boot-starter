package com.nbsaas.boot.system.ext.domain.simple;

import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import lombok.Data;


@Data
public class ApplicationMenuExtSimple extends ApplicationMenuSimple {

    private Long parentId;

}
