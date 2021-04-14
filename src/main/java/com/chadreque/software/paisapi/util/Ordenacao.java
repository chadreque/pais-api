package com.chadreque.software.paisapi.util;

//import com.chadreque.software.paisapi.exception.ElementoNotFound;
import com.chadreque.software.paisapi.exception.ElementoNotFound;
import com.chadreque.software.paisapi.model.Pais;

import java.util.Comparator;
import java.util.List;

public class Ordenacao {

    public static void comparar(final List<Pais> paises, Comparator<Pais> comparatorBy, String orderType) {
        if (orderType == null || orderType.equalsIgnoreCase(Constante.ASC))
            paises.sort(comparatorBy);
        else if (orderType.equalsIgnoreCase(Constante.DESC))
            paises.sort(comparatorBy.reversed());
        else
            throw new ElementoNotFound();
    }
}
