package com.nbsaas.boot.system.ext.domain.simple;

import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import lombok.Data;

import java.util.List;

@Data
public class MenuExtSimple extends MenuSimple {

    private Long parentId;

}
