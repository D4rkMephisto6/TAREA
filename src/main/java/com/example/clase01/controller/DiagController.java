package com.example.clase01.controller;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/oracle")
@RequiredArgsConstructor
class DiagController {
    private final EntityManager em;

    @GetMapping("/dbinfo")
    public Map<String,Object> dbinfo() {
        Object[] r = (Object[]) em.createNativeQuery(
                "select SYS_CONTEXT('USERENV','DB_NAME'), " +
                        "SYS_CONTEXT('USERENV','CON_NAME'), " +
                        "SYS_CONTEXT('USERENV','SERVICE_NAME'), " +
                        "SYS_CONTEXT('USERENV','CURRENT_SCHEMA') from dual"
        ).getSingleResult();

        Number n = ((Number) em.createNativeQuery(
                "select count(*) from USERLP2.TBL_LIBROS").getSingleResult());

        return Map.of(
                "db_name", r[0], "pdb_name", r[1], "service_name", r[2], "schema", r[3],
                "libros_count", n.longValue()
        );
    }
}