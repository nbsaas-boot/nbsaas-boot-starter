package com.nbsaas.boot.system.ext.domain.simple;

import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import lombok.Data;

@Data
public class MenuExtSimple extends MenuSimple {

    private Long parentId;

}
